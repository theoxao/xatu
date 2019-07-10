<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentProviderDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>CP名称</label>
                    <div class="form-control-static">${record.name}</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="edit_modal_script">脚本</label>
                    <textarea id="edit_modal_script" name="script" class="form-control"
                              placeholder="脚本">${(record.script?html)!''}</textarea>
                </div>
            </div>
    </div>
</div>