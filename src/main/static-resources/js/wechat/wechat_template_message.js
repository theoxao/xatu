(function () {
    $(function () {
        const baseUrl = base + '/wechat/template/message';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        searchForm.find('[name="accountId"]').change(function () {
            _loadTable();
        });


        //send message
        (function () {
            const panel = createEmptyModal("编辑消息", () => {
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data("id")}/send`,
                    type: 'post',
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success(result.data);
                            panel.modal('hide');
                        } else {
                            Alert.error(result.error);
                        }
                    },
                    complete: () => panel.hideProgress()
                });
            });

            dataTable.on("click", ".table-op-btn[data-role='send']", function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data("id", id);
                panel.modal({backdrop: 'static'});
                renderModalLoadBar(panel);
                $.ajax({
                    url: `${baseUrl}/${id}/edit`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            })
        })();

        (function () {
            dataTable.on('click', '.table-op-btn[data-role="deleteTemplate"]', function () {
                Confirm.show('确定删除该模板吗？', () => {
                    Confirm.wait();
                    const id = $(this).closest('tr').attr('data-id');
                    $.ajax({
                        url: `${baseUrl}/${id}`,
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
        })();
    });
})();

