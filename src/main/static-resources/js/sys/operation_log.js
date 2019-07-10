(function () {
    $(function () {
        const baseUrl = base + '/sys/operation_log';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        searchForm.find('.input-daterange').datepicker({
            format: "yyyy-mm-dd"
        });
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        // clean
        $('#cleanBtn').click(function () {
            Confirm.show('确定要清除<code>三个月</code>前的日志吗？', () => {
                $.ajax({
                    url: `${baseUrl}/clean`,
                    type: 'delete',
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
    });
})();