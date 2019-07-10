(function () {
    $(function () {
        const baseUrl = base + '/ac/publisher';
        const dataTable = $('#data-table');
        const searchForm = $('.search-form');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        _loadTable();


        //编辑记录
        // edit
        (function () {
            const panel = createEmptyModal('编辑出版商', () => {
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

            dataTable.on('click', '[data-role="edit"]', function () {
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
                        panel.find('.input-daterange').datepicker({
                            format: "yyyy-mm-dd"
                        });
                        const coverInput = panel.find('[name="avatar"]');
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

        // (function () {
        //     const panel=createEmptyModal("编辑publisher",()=>{
        //         clearFormErrors(panel.find('form'));
        //         panel.showProgress();
        //         $.ajax({
        //             url: `${baseUrl}/${panel.data("id")}`,
        //             type: 'put',
        //             data: panel.find('form').serialize(),
        //             success: function (result) {
        //                 if (result.status === 200) {
        //                     Alert.success('操作成功!');
        //                     panel.modal('hide');
        //                     _loadTable();
        //                 } else {
        //                     if (result.data !== null) {
        //                         applyFormErrors(panel.find('form'), result.data);
        //                         Alert.error("操作失败!");
        //                     } else {
        //                         Alert.error(result.error);
        //                     }
        //                 }
        //             },
        //             complete: () => panel.hideProgress()
        //         });
        //     });
        //     dataTable.on('click','.grid-opt-btn[data-role="edit"]',function () {
        //         const id = $(this).closest('tr').attr('data-id');
        //         panel.data("id", id);
        //         panel.modal({backdrop: 'static'});
        //         renderModalLoadBar(panel);
        //         $.ajax({
        //             url: `${baseUrl}/${id}/edit`,
        //             type: "get",
        //             success: function (result) {
        //                 panel.find('.modal-body').html(result);
        //
        //
        //                 const coverInput = panel.find('[name="avatar"]');
        //                 coverInput.siblings('[type="file"]').change(function () {
        //                     upload($(this), (data) => {
        //                         coverInput.val(data.key);
        //                         coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
        //                     });
        //                 });
        //
        //             }
        //         });
        //     })
        // })();


        //    新增记录
        (function () {
            const panel = createEmptyModal("新增publisher", () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/add`,
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
            $('#createBtn').click(function () {
                panel.modal({backdrop: 'static'});
                renderModalLoadBar(panel);
                $.ajax({
                    url: `${baseUrl}/add`,
                    type: "get",
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                        const coverInput = panel.find('[name="avatar"]');
                        coverInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                coverInput.val(data.key);
                                coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                            });
                        });
                    }
                });
            })
        })();


    });
})();

