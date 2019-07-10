(function () {
    $(function () {
        const baseUrl = base + '/content_provider_content';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        $('#exportBtn').click(function () {
            downloadTable(baseUrl, searchForm, dataTable);
        });
    });
})();