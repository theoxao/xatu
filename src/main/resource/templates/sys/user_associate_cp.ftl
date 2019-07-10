<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.model.User" -->
<#-- @ftlvariable name="contentProviders" type="java.util.List<com.jiuyue.novel.cp.model.ContentProvider>" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label>用户</label>
                    <div class="form-control-static">${record.displayName!''}</div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_cpId" class="form-required">关联CP</label>
                    <select id="edit_modal_cpId" name="cpId" class="form-control">
                        <option>无</option>
                        <#list contentProviders as contentProvider>
                            <option value="${contentProvider.id}" ${((record.id == contentProvider.userId)!false)?then('selected', '')}>${contentProvider.name!''}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </form>
    </div>
</div>