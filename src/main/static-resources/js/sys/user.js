(function () {
    $(function () {
        const DOMAIN_NAME = '用户';
        const baseUrl = base + '/sys/user';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
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

        (function () {
            const panel = createEmptyModal('关联客户端用户', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}/associate_user`,
                    data: panel.find('form').serialize(),
                    success: function (result) {
                        if (result.status === 200) {
                            _loadTable();
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
            dataTable.on('click', '.grid-opt-btn[data-role="associate_user"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                let tpl = `
                    <div>
                        <form role="form">
                            <label for="client_user_id">关联的客户端用户ID</label>                    
                            <input id="client_user_id" name="clientUserId" class="form-control"/>
                        </form>
                    </div>
                `;
                panel.find('.modal-body').html(tpl);
            });
            return panel;
        })();

        // edit roles
        (function () {
            const panel = createEmptyModal('编辑' + DOMAIN_NAME + '角色', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}/roles`,
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
            dataTable.on('click', '.grid-opt-btn[data-role="edit-roles"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/${id}/roles`,
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();

        // reset password
        dataTable.on('click', '.grid-opt-btn[data-role="reset-password"]', function () {
            const id = $(this).closest('tr').attr('data-id');
            Confirm.show('确定要将密码重置为<code>123456</code>吗？重置后及时登录帐号修改密码!', () => {
                $.ajax({
                    url: `${baseUrl}/${id}/reset_passwd`,
                    type: 'post',
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

        // add as distribution channel
        (function () {
            const panel = createEmptyModal('设为渠道', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${base}/channel`,
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
            dataTable.on('click', '.grid-opt-btn[data-role="assign-channel"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${base}/channel/add`,
                    data: {userId: id},
                    dataType: 'html',
                    type: 'get',
                    success: function (result) {
                        panel.find('.modal-body').html(result);
                    }
                })
            });
            return panel;
        })();

        // 关联CP
        (function () {
            const panel = createEmptyModal('关联CP', () => {
                clearFormErrors(panel.find('form'));
                panel.showProgress();
                $.ajax({
                    url: `${baseUrl}/${panel.data('id')}/associate_cp`,
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
            dataTable.on('click', '.grid-opt-btn[data-role="associate_cp"]', function () {
                const id = $(this).closest('tr').attr('data-id');
                panel.data('id', id);
                renderModalLoadBar(panel);
                panel.modal({backdrop: 'static'});
                $.ajax({
                    url: `${baseUrl}/${id}/associate_cp`,
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