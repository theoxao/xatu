<#-- @ftlvariable name="zeus" type="boolean" -->
<#-- @ftlvariable name="record" type="com.jiuyue.novel.admin.dto.ContentProviderBookDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.cpId}/${record.book.id}">
            <td><label class="match-parent"><input name="id" value="${record.originId}" data-role="check"
                                                   type="checkbox"/></label>
            </td>
            <td>${record.originId}</td>
            <td>${record.book.id}</td>
            <td>${record.book.name!''}</td>
            <td>${record.book.authorName!''}</td>
            <td>${record.book.categoryName!''}</td>
            <td data-value="${record.book.serialStatus?c}">${(record.book.serialStatus == 1)?then('完本', '连载')}</td>
            <td>${(record.totalSaleAmount/100.0)?string('0.00')!0}</td>
            <td>${(record.totalSaleAmount/100.0*0.9)?string('0.00')!0}</td>
            <#if zeus>
                <td><a class="table-op-btn" data-role="edit" title="编辑" data-toggle="tooltip"><span
                                class="fa fa-edit"></span></a></td>
            </#if>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="9" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>


