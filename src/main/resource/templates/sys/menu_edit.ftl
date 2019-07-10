<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.MenuDTO" -->
<#-- @ftlvariable name="parentOptions" type="java.util.List<com.jiuyue.novel.common.SelectOption>" -->
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
                    <label for="edit_modal_value">值</label>
                    <input id="edit_modal_value" name="value" class="form-control" placeholder="值"
                           value="${record.value!''}">
                    <div class="help-block">程序判断权限的标识</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_icon">图标</label>
                    <input id="edit_modal_icon" name="icon" class="form-control" placeholder="图标"
                           value="${record.icon!''}">
                    <div class="help-block">图标样式名称</div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_link">链接</label>
                    <input id="edit_modal_link" name="link" class="form-control" placeholder="链接"
                           value="${record.link!''}">
                    <div class="help-block">相对路径</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_parentId" class="form-required">父级菜单</label>
                    <select id="edit_modal_parentId" name="parentId" class="form-control">
                        <option value="" ${record.parentId?has_content?then('', 'selected')}>顶级菜单</option>
                        <@c.options list=parentOptions value=(record.parentId?c)!''/>
                    </select>
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_order">排序</label>
                    <input id="edit_modal_order" name="order" data-validate="number" class="form-control"
                           placeholder="排序" value="${record.order!0}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="form-required">状态</label>
                    <div class="radio">
                        <@c.radios statusOptions 'status' record.status?c />
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
<script src="${static_base}/js/validate${dev?then('', '.min')}.js"></script>