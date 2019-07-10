<#-- @ftlvariable name="contentProviders" type="java.util.List<com.jiuyue.novel.cp.model.ContentProvider>" -->
<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.UserDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>用户名</label>
                    <div class="form-control-static">${record.username!''}</div>
                </div>
                <div class="form-group col-sm-6">
                    <label>昵称</label>
                    <div class="form-control-static">${record.displayName}</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="form-required">状态</label>
                    <div class="radio">
                        <@c.radios statusOptions 'status' record.status?c/>
                    </div>
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