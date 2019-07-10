(function () {
    $(function () {
        const baseUrl = base + '/content_provider_stat';
        const searchForm = $('.search-form');
        var cpId = "";
        const dataTable = $('#data-table');
        const today = new Date();
        const last_month = new Date(today.getTime() - 30 * 24 * 3600000);
        searchForm.find('[name="beginDate"]').val(formatDefaultDate(last_month));
        searchForm.find('[name="endDate"]').val(formatDefaultDate(today));
        searchForm.find('.input-daterange').datepicker({
            format: "yyyy-mm-dd"
        });
        const _loadTable = () => loadTable(baseUrl, function () {
            cpId = searchForm.find("[name='contentProviderId']").val();
        });
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();

        //跳转至明细时采用post提交参数
        dataTable.on('click', '[data-role="detail"]', function () {
            let date = $(this).closest('tr').attr('data-id');
            cpId = cpId === undefined ? "" : cpId;
            let form = function (date) {
                //自定义隐藏表单
                let form = document.createElement('form');
                form.action = `${baseUrl}/detail/${cpId}`;
                form.method = 'post';
                let begin = document.createElement('input');
                begin.type = 'hidden';
                begin.name = 'beginDate';
                begin.value = date;
                form.appendChild(begin);
                let end = document.createElement('input');
                end.type = 'hidden';
                end.name = 'endDate';
                end.value = date;
                form.appendChild(end);
                $(document.body).append(form);
                return form
            };
            $(form(date)).submit();
        });
        //导出
        $('#exportBtn').click(function () {
            downloadTable(baseUrl, searchForm, dataTable);
        });

        $('#monthlyStatistic').click(function () {
            $.ajax({
                url: baseUrl + "/restatistic",
                type: 'post',
                success: function (result) {
                    if (result.status === 200) {
                        Alert.success('操作成功!');
                    } else {
                        Alert.error(result.error);
                    }
                }
            });
        })
    });
})();