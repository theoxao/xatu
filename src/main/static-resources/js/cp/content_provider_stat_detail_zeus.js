(function () {
    $(function () {
        const baseUrl = base + '/content_provider_stat/detail';
        const searchForm = $('.search-form');
        const dataTable = $('#data-table');
        searchForm.find('[name="beginDate"]').val(beginDate);
        searchForm.find('[name="endDate"]').val(endDate);
        searchForm.find('.input-daterange').datepicker({
            format: "yyyy-mm-dd"
        });
        const panel = createEmptyModal("编辑", () => {
            if (panel.find("[name='date']").val() == '') {
                alert("日期不能为空");
                return;
            }
            panel.showProgress();
            $.ajax({
                url: `${baseUrl}/${panel.data("id")}/edit`,
                type: 'post',
                data: panel.find('form').serialize(),
                success: function (result) {
                    if (result.status === 200) {
                        Alert.success("操作成功，刷新后可查看");
                        panel.modal('hide');
                    } else {
                        Alert.error(result.error);
                    }
                },
                complete: () => panel.hideProgress()
            });
        });

        dataTable.on("click", ".table-op-btn[data-role='edit']", function () {
            const id = $(this).closest('tr').attr('data-id');
            panel.data("id", id);
            panel.modal({backdrop: 'static'});
            renderModalLoadBar(panel);
            let TPL = `
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                <label for="data-pick">日期</label>
                <input class="input-sm form-control" name="date" title="起始日期"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_income">分成前收入（分）</label>
                    <input id="edit_income" name="income" class="form-control"/>
                    <div class="help-block">本月收入请在<code>每月1日</code>之前修改</div>
                </div>
            </div>
        </form>
    </div>
</div>
            `;
            panel.find('.modal-body').html(TPL);
            panel.find('[name="date"]').datepicker({
                format: "yyyy-mm-dd",
                endDate: "-1d"
            });
            return panel;
        })

    });
})();