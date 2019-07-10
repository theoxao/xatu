<#-- @ftlvariable name="items" type="String" -->
<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentChannelDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-12">
                    <label class="form-required">渠道名称</label>
                    <div class="form-control-static">${record.name!''}</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_items">书籍ID列表，英文逗号隔开</label>
                    <textarea id="add_modal_items" name="items" class="form-control">${items}</textarea>
                    <div class="help-block text-error">删除书籍ID会将书籍推送状态一并删除</div>
                </div>
            </div>
        </form>
    </div>
</div>