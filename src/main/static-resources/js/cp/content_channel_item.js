(function () {
    $(function () {
        const DOMAIN_NAME = "内容渠道书籍";
        const baseUrl = `${base}/content_channel/${channel_id}`;
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(`${baseUrl}/items`);
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
                    url: baseUrl + '/item',
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
                    url: baseUrl + '/item/add',
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                        panel.find('[name="authorizeEnd"]').datepicker({
                            format: "yyyy-mm-dd"
                        });
                        const coverInput = panel.find('[name="cover"]');
                        coverInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                                coverInput.val(data.key);
                            });
                        });
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
                    url: `${baseUrl}/item/${panel.data('id')}`,
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
                    url: `${baseUrl}/item/${id}/edit`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                        panel.find('[name="authorizeEnd"]').datepicker({
                            format: "yyyy-mm-dd"
                        });
                        const coverInput = panel.find('[name="cover"]');
                        coverInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                                coverInput.val(data.key);
                            });
                        });
                    }
                })
            });
            return panel;
        })();

        dataTable.on('click', '.table-op-btn[data-role="remove"]', function () {
            Confirm.show('确定删除吗？', () => {
                Confirm.wait();
                const id = $(this).closest('tr').attr('data-id');
                $.ajax({
                    url: `${baseUrl}/item/${id}`,
                    type: 'delete',
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            loadData();
                        } else {
                            Alert.error(result.error);
                        }
                        Confirm.dismiss();
                    },
                    complete: () => Confirm.finish()
                })
            });
        });

        // push update
        $('#pushUpdateBtn').click(function () {
            const ids = getTableChecked(dataTable);
            if (ids.length === 0) {
                Alert.warn('请选择要推送更新的书籍!');
                return;
            }
            Confirm.show(`确定要对这些章节推送更新吗？<div class="checkbox"><label class="text-danger"><input type="checkbox">同时更新之前章节内容</label></div>`, (modal) => {
                $.ajax({
                    url: `${baseUrl}/push_update`,
                    data: {ids: ids.join(','), forceUpdate: (modal.find('input').prop('checked') ? 1 : 0)},
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
    });
})();