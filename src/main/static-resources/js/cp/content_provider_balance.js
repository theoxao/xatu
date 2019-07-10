(function () {
    $(function () {
        const baseUrl = base + '/content_provider_balance';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(baseUrl);
        searchForm.find('[name="status"]').change(function () {
            _loadTable();
        });
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();
        $('#exportBtn').click(function () {
            downloadTable(baseUrl, searchForm, dataTable);
        });
    });
})();