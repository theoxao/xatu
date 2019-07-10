<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.UserDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td>${record.username!''}</td>
            <td>${record.displayName!''}</td>
            <td><@dictText type="StatusType" code=record.status/></td>
            <td><@dictText type="UserType" code=record.type/><#if record.cpName?has_content>（${record.cpName}）</#if></td>
            <td class="pre-wrap">${record.remark!''}</td>
            <td>
                <@permitted value="user:update">
                    <a class="grid-opt-btn" data-role="edit" title="编辑信息" data-toggle="tooltip">编辑信息</a>
                </@permitted>
                <@permitted value="user:update_roles">
                    <a class="grid-opt-btn" data-role="edit-roles" title="编辑角色" data-toggle="tooltip">编辑角色</a>
                </@permitted>
                <@permitted value="user:reset_password">
                    <a class="grid-opt-btn" data-role="reset-password" title="重置密码" data-toggle="tooltip">重置密码</a>
                </@permitted>
                <@permitted value="user:update">
                    <#if record.type == 'distribution_channel'||record.type == 'pay_distribution_channel'>
                        <@permitted value="distribution_channel:add">
                            <a class="grid-opt-btn" data-role="assign-channel" title="分配渠道"
                               data-toggle="tooltip">分配渠道</a>
                        </@permitted>
                    </#if>
                    <#if record.type=='admin'>
                        <a class="grid-opt-btn" data-role="associate_user" title="关联用户" data-toggle="tooltip">关联用户</a>
                    </#if>
                    <#if record.type=='content_provider'>
                        <a class="grid-opt-btn" data-role="associate_cp" title="关联CP" data-toggle="tooltip">关联CP</a>
                    </#if>
                </@permitted>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="7" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>