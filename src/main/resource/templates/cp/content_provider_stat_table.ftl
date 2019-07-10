<#-- @ftlvariable name="list" type="java.util.List<com.jiuyue.common.utils.Triple<java.util.Date,java.lang.Long,java.lang.Double>>" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${(record.a?date?string)!''}">
            <td>${(record.a?date?string)!''}</td>
            <td>${(record.b/100.0)?string('0.00')!0}</td>
            <td>${record.c?string.percent}</td>
            <td>${((record.b*record.c)?floor)/100.0}</td>
            <td>${((record.b*record.c*0.90)?floor)/100.0}</td>
            <td>
                <a data-role="detail" href="#">查看明细</a>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="9" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>