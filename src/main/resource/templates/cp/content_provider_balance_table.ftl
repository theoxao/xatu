<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.UserMonthlyAccountDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}">
            <td>${(record.beginDate?date?string)!''}</td>
            <td>${(record.endDate?date?string)!''}</td>
            <td>${(record.amount/100.00*0.90)?string("0.00")}</td>
            <td><#if record.status==0>未申请
                <#elseif  record.status==1>申请中
                <#else >完成
                </#if></td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="9" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>