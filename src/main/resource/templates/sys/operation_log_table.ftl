<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.OperationLogDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td>${record.domain!''}</td>
            <td><@dictText type='com.jiuyue.novel.admin.logging.OpLogAction' code=record.action!'' /></td>
            <td>${record.targets!''}</td>
            <td>${record.operatorName!''}</td>
            <td class="pre-wrap">${(record.gmtCreate?datetime?string)!''}</td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="6" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>