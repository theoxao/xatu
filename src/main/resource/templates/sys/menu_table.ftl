<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.MenuDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td>${record.name!''}</td>
            <td>${record.value!''}</td>
            <td><#if record.icon?has_content><span title="${record.icon!''}" class="${record.icon!''}"></span></#if>
            </td>
            <td>${record.link!''}</td>
            <td>${record.parentName!''}</td>
            <td>${record.order!''}</td>
            <td class="pre-wrap">${record.remark!''}</td>
            <td>
                <@permitted value="menu:update">
                    <a class="table-op-btn" data-role="edit" title="编辑" data-toggle="tooltip"><span
                                class="fa fa-edit"></span></a>
                </@permitted>
                <@permitted value="menu:delete">
                    <a class="table-op-btn" data-role="delete" title="删除" data-toggle="tooltip"><span
                                class="fa fa-remove"></span></a>
                </@permitted>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="6" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>