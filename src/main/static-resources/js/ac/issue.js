(function () {
    $(function () {
        const DOMAIN_NAME = '话';
        const baseUrl = base + '/ac/comic/' + comic_id + '/issue';
        const searchForm = $('.search-form');

        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl, () => {
        });
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();

        searchForm.on('change', ':input', function () {
            searchForm.submit();
        });

        //import
        (function () {
            const panel = createEmptyModal("批量导入漫画", () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/import`,
                    type: 'post',
                    data: new FormData(panel.find('form')[0]),
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            panel.modal('hide');
                            _loadTable();
                        } else {
                            Alert.error("操作失败!");

                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });
            $('#importBtn').click(function () {
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/import`,
                    type: 'get',
                    dataType: 'html',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                });
                return panel;
            });
        })();

        // delete single
        dataTable.on('click', '[data-role="delete"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            Confirm.show(`确定要删除该话吗？`, () => {
                $.ajax({
                    url: `${baseUrl}/${id}`,
                    type: 'DELETE',
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

        // delete batch
        $('#batchDeleteBtn').click(function () {
            const ids = getTableChecked(dataTable);
            if (ids.length === 0) {
                Alert.warn('请选择要删除的记录!');
                return;
            }
            Confirm.show(`确定要删除这些话吗？`, () => {
                $.ajax({
                    url: `${baseUrl}/batch_delete`,
                    data: {ids: ids.join(',')},
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

        //update page count
        $("#updatePageCount").click(function () {
            const ids = getTableChecked(dataTable);
            Confirm.show('确定吗？', () => {
                Confirm.wait();
                $.ajax({
                    url: `${baseUrl}/update_count`,
                    type: 'post',
                    data: {issueIds: ids.join(',')},
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            _loadTable();
                        } else {
                            Alert.error(result.error);
                        }
                        Confirm.dismiss();
                    },
                    complete: () => Confirm.finish()
                })
            });
        });

        // cancel publish task
        dataTable.on('click', '[data-role="cancel-task"]', function () {
            Confirm.show('确定取消吗？', () => {
                Confirm.wait();
                const id = $(this).closest('tr').attr('data-id');
                $.ajax({
                    url: `${baseUrl}/${id}/cancel_task`,
                    type: 'delete',
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                            _loadTable();
                        } else {
                            Alert.error(result.error);
                        }
                        Confirm.dismiss();
                    },
                    complete: () => Confirm.finish()
                })
            });
        });

        // cancel publish task
        dataTable.on('click', '[data-role="retry-task"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            $.ajax({
                url: `${baseUrl}/${id}/retry_task`,
                type: 'post',
                success: function (result) {
                    if (result.status === 200) {
                        Alert.success('操作成功!');
                        _loadTable();
                    } else {
                        Alert.error(result.error);
                    }
                }
            });
        });
    });
})();