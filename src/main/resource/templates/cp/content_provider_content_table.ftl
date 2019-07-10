<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.ContentProviderBookDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.cpId}/${record.originId}">
            <td><label class="match-parent"><input name="id" value="${record.originId}" data-role="check"
                                                   type="checkbox"/></label>
            </td>
            <td>${record.originId}</td>
            <#if record.book??>
                <td>${record.book.id}</td>
                <td>${record.book.name!''}</td>
                <td>${record.book.authorName!''}</td>
                <td>${record.book.categoryName!''}</td>
                <td data-value="${record.book.status?c}"><@dictText type="AuditStatusType" code=record.book.status/></td>
                <td>${(record.book.authorizeBegin?date?string)!''}--${(record.book.authorizeEnd?date?string)!''}</td>
                <td data-value="${record.book.serialStatus?c}">${(record.book.serialStatus == 1)?then('完本', '连载')}</td>
            <#else>
                <td>-</td>
                <td>[书籍缺失]</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
            </#if>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="9" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>