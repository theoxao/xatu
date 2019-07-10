(function () {
    $(function () {
        const DOMAIN_NAME = '内容渠道';
        const baseUrl = base + '/content_channel';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl, () => {
            dataTable.find('[data-toggle="popover"]').popover({
                container: 'body',
                trigger: 'focus',
                html: 'true',
                placement: 'top right bottom',
                template: `<div class="popover" role="tooltip"><div class="arrow"></div><div><pre class="language-json" data-role="highligh"><code class="language-groovy popover-content"></code></pre></div></div>`,
                content: function () {
                    return Prism.highlight($(this).find('code').text(), Prism.languages.groovy);
                }
            });
        });
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();

        // create
        (function () {
            const panel = createEmptyModal('新增' + DOMAIN_NAME, () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: baseUrl,
                    type: 'post',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                            _loadTable();
                        } else {
                            if (result.data !== null) {
                                applyFormErrors(panel.find('form'), result.data);
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            $('#createBtn').click(function () {
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: baseUrl + '/add',
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                        panel.find('[name=isDefault]').change(function () {
                            if ($(this).val() === "true") {
                                panel.find('.function').hide();
                            } else {
                                panel.find('.function').show();
                            }
                        })
                    }
                })
            });
            return panel;
        })();

        // edit
        (function () {
            const panel = createEmptyModal('编辑' + DOMAIN_NAME, () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}`,
                    type: 'put',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                            _loadTable();
                        } else {
                            if (result.data !== null) {
                                applyFormErrors(panel.find('form'), result.data);
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            dataTable.on('click', '.table-op-btn[data-role="edit"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/${id}/edit`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();

        // edit items
        (function () {
            const panel = createEmptyModal('编辑' + DOMAIN_NAME + '书籍', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}/items`,
                    type: 'post',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                        } else {
                            if (result.data !== null) {
                                applyFormErrors(panel.find('form'), result.data);
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            dataTable.on('click', '.table-op-btn[data-role="edit-items"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/${id}/items/edit`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                        panel.find('[name="items"]').change(function () {
                            $(this).val(formatIds($(this).val()));
                        });
                    }
                })
            });
            return panel;
        })();
    });
})();