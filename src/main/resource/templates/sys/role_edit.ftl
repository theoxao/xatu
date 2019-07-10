<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.RoleDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_name" class="form-required">名称</label>
                    <input id="edit_modal_name" name="name" class="form-control" placeholder="名称"
                           value="${record.name!''}">
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_value" class="form-required">值</label>
                    <input id="edit_modal_value" name="value" class="form-control" placeholder="值"
                           value="${record.value!''}">
                    <div class="help-block">程序判断权限的标识</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="edit_modal_remark">备注</label>
                    <textarea id="edit_modal_remark" name="remark" class="form-control"
                              placeholder="备注">${(record.remark?html)!''}</textarea>
                </div>
            </div>
        </form>
    </div>
</div>