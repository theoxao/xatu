(function () {
    $(function () {
        const baseUrl = base + '/album/' + album_id + "/section";
        const dataTable = $('#data-table');
        const searchForm = $('.search-form');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        _loadTable();


        //试听
        dataTable.on("click", '.table-op-btn[data-role="listen"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            $.ajax({
                url: `${baseUrl}/${id}/listen`,
                type: 'get',
                success: function (res) {
                    let url = res.data.audioUrl;
                    let cont = $(".audio-container");
                    let thePlayer = $('.audioplayer');
                    thePlayer.trigger("ended");
                    //thePlayer.removeClass( 'audioplayer-playing' ).addClass( 'audioplayer-stopped' );
                    cont.html(`<audio id="audio-player"  controls><source src="${url}" /></audio>`);
                    $('audio').audioPlayer({
                        strPlay: '',
                        strPause: ''
                    });
                }
            })
        });

        //删除单条记录
        dataTable.on("click", '.table-op-btn[data-role="delete"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            Confirm.show("确定删除该书籍?", function () {
                $.ajax({
                    url: baseUrl + `/${id}`,
                    type: "delete",
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

        //编辑记录
        (function () {
            const panel = createEmptyModal("编辑章节", () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data("id")}/edit`,
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
                panel.data("id", id);
                panel.modal({backdrop: 'static'});
                renderModalLoadBar(panel);
                $.ajax({
                    url: `${baseUrl}/${id}/edit`,
                    type: "get",
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                });
            })
        })();

        //    新增记录
        (function () {
            const panel = createEmptyModal("新增章节", () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/add`,
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
                    }
                });
            })
        })();


        // import
        (function () {
            const panel = createEmptyModal('导入章节', () => {
                panel.showProgress();
                clearFormErrors(panel.find('form'));
                $.ajax({
                    url: baseUrl + '/import',
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
                            if (result.data !== null) {
                                applyFormErrors(panel.find('form'), result.data);
                                Alert.error("操作失败!");
                            } else {
                                Alert.error(result.error);
                            }
                        }
                    },
                    complete: panel.hideProgress()
                });
            });
            $('#importBtn').click(function () {
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: baseUrl + '/import',
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
        })();

    });
})();

