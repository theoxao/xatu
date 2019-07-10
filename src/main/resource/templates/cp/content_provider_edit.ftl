<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentProviderDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_name" class="form-required">CP名称</label>
                    <input id="edit_modal_name" name="name" class="form-control" placeholder="CP名称"
                           value="${record.name!''}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_ratio" class="form-required">分成比例</label>
                    <input id="edit_modal_ratio" name="ratio" class="form-control" placeholder="分成比例"
                           value="${record.ratio}">
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_userId">关联用户编号</label>
                    <input id="edit_modal_userId" name="userId" class="form-control" placeholder="关联用户编号"
                           value="${((record.userId lt 1)?then('', record.userId?c))!''}">
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