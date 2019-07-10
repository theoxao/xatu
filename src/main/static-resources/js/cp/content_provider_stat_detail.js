(function () {
    $(function () {
        const baseUrl = base + '/content_provider_stat/detail/' + cpId;
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        searchForm.find('[name="beginDate"]').val(beginDate);
        searchForm.find('[name="endDate"]').val(endDate);
        searchForm.find('.input-daterange').datepicker({
            format: "yyyy-mm-dd"
        });
        bindCheckAll(dataTable);
        const _loadTable = () => {
            //更新面包屑
            let begin = searchForm.find('[name="beginDate"]').val();
            let end = searchForm.find('[name="endDate"]').val();
            let breadcrumb = $(".breadcrumb");
            let active = breadcrumb.find('.active');
            if (begin === end) {
                active[0].innerText = begin;
            } else {
                active[0].innerText = begin + '至' + end;
            }
            loadTable(baseUrl)
        };
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        $('#exportBtn').click(function () {
            downloadTable(baseUrl, searchForm, dataTable);
        });
    });
})();