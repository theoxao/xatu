<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_name" class="form-required">名称</label>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="名称">
                </div>
                <div class="form-group col-sm-6">
                    <label for="add_modal_value" class="form-required">值</label>
                    <input id="add_modal_value" name="value" class="form-control" placeholder="值">
                    <div class="help-block">程序判断权限的标识</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_groupId" class="form-required">分组</label>
                    <select id="add_modal_groupId" class="form-control" name="groupId">
                        <@c.options groupOptions />
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_remark">备注</label>
                    <textarea id="add_modal_remark" name="remark" class="form-control" placeholder="备注"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>