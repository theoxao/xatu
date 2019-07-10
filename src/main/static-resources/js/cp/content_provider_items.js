(function () {
    $(function () {
        const baseUrl = `${base}/content_provider/${cpId}`;
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        bindCheckAll(dataTable);
        const _loadTable = () => loadTable(`${baseUrl}/items`);
        searchForm.submit(function () {
            _loadTable();
            return false;
        }).submit();

    });
})();