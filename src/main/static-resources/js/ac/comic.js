(function () {
    $(function () {
        const DOMAIN_NAME = '漫画';
        const baseUrl = base + '/ac/comic';
        const searchForm = $('.search-form');

        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl, function () {
        });
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        $('#exportBtn').click(function () {
            downloadFile(baseUrl + '?_export=true&_rand=' + new Date().getMilliseconds() + '&' + searchForm.serialize());
        });

        // create
        (function () {
            const panel = createEmptyModal('创建' + DOMAIN_NAME, () => {
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
            }).addClass('inner-scroll');
            panel.on('change', '[name="summary"]', function () {
                $(this).val(normalizeDoc($(this).val()));
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
                        panel.find('[name="publicationTime"]').datetimepicker({
                            format: "YYYY-MM-DD HH:mm",
                            locale: 'zh-cn'
                        });
                        const coverInput = panel.find('[name="cover"]');
                        coverInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                coverInput.val(data.key);
                                coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                            });
                        });
                        const bannerInput = panel.find('[name="banner"]');
                        bannerInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                bannerInput.val(data.key);
                                bannerInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                            });
                        });
                        bindPicker($('[data-ui="picker"]'));
                    }
                });
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
            }).addClass('inner-scroll');
            panel.on('change', '[name="summary"]', function () {
                $(this).val(normalizeDoc($(this).val()));
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
                        panel.find('[name="publicationTime"]').datetimepicker({
                            format: "YYYY-MM-DD HH:mm",
                            locale: 'zh-cn'
                        });
                        const coverInput = panel.find('[name="cover"]');
                        coverInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                coverInput.val(data.key);
                                coverInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                            });
                        });
                        const bannerInput = panel.find('[name="banner"]');
                        bannerInput.siblings('[type="file"]').change(function () {
                            upload($(this), (data) => {
                                bannerInput.val(data.key);
                                bannerInput.siblings('[data-role="preview"]').html(`<img src="${data.url}">`);
                            });
                        });
                        bindPicker($('[data-ui="picker"]'));
                    }
                })
            });
            return panel;
        })();

        //update cache
        $("#flushCacheBtn").click(function () {
            const ids = getTableChecked(dataTable);
            Confirm.show(`确定要更新缓存吗？`, () => {
                $.ajax({
                    url: `${baseUrl}/flush_cache`,
                    type: 'POST',
                    data: {ids: ids.join(',')},
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                        } else {
                            Alert.error(result.error);
                        }
                    }
                })
            });
        });

        //remove search index
        $("#removeIndexBtn").click(function () {
            const ids = getTableChecked(dataTable);
            Confirm.show(`确定要清除选中项索引么？`, () => {
                $.ajax({
                    url: `${baseUrl}/remove_index`,
                    type: 'DELETE',
                    data: {ids: ids.join(',')},
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success('操作成功!');
                        } else {
                            Alert.error(result.error);
                        }
                    }
                })
            });
        });

    });
})();