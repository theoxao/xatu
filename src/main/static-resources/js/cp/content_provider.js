(function () {
    $(function () {
        const DOMAIN_NAME = '内容提供商';
        const baseUrl = base + '/content_provider';
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
            dataTable.on('click', '.grid-opt-btn[data-role="edit"]', function () {
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


        // edit script
        (function () {
            const panel = createEmptyModal('编辑脚本', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}/update_script`,
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
            dataTable.on('click', '.grid-opt-btn[data-role="edit_script"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/${id}/edit_script`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();

        // toggle status
        dataTable.on('click', '[data-role="toggle_status"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            const value = parseInt($(this).attr('data-value'));
            Confirm.show(`确定要${$(this).attr('data-title')}吗？`, () => {
                $.ajax({
                    url: `${baseUrl}/${id}/toggle_status`,
                    data: {status: 1 - value},
                    type: 'POST',
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            _loadTable();
                        } else {
                            Alert.error(result.error);
                        }
                    }
                })
            });
        });

        // recrawl
        (function () {
            const panel = createEmptyModal('重新爬取指定章节', () => {
                panel.showProgress();
                $.ajax({
                    url: baseUrl + '/recrawl',
                    type: 'post',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                        } else {
                            if (result.data !== null) {
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            $('#recrawl').click(function () {
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: baseUrl + '/recrawl',
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();
        //重新获取封面
        (function () {
            const panel = createEmptyModal('重新爬取指定章节', () => {
                panel.showProgress();
                $.ajax({
                    url: baseUrl + '/recrawl_cover',
                    type: 'post',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                        } else {
                            if (result.data !== null) {
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            $('#recrawlCover').click(function () {
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: baseUrl + '/recrawl_cover',
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();
    });
})();