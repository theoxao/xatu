<#-- @ftlvariable name="list" type="java.util.List<com.jiuyue.novel.admin.dto.ContentProviderBookDTO>" -->
<tbody>
<#if list?has_content>
    <#list list as record>
        <#if record.book?has_content>
            <tr class="${record?is_even_item?then('even', '')}" data-id="${record.originId}">
                <td><label class="match-parent"><input name="itemId" value="${record.originId}" data-role="check"
                                                       type="checkbox"/>${record.originId}</label></td>
                <td>${record.book.id!''}</td>
                <td><#if (record.book.cover?has_content)!false><img style="width:75px;height:100px;"
                                                                    src="${upload_base}/${record.book.cover}"></#if>
                </td>
                <td><a href="${base}/">${(record.book.name)!''}</a></td>
                <td>${(record.book.authorName)!''}</td>
                <td>${record.book.chapterCount!''}</td>
                <td>${(record.serialStatus==1)?string('是','否')}</td>
                <td>${(record.lastCrawlTime?datetime?string)!''}</td>
            </tr>
        </#if>
    </#list>
<#else >
    <tr>
        <td colspan="8" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>