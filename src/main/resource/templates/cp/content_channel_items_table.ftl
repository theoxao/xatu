<#-- @ftlvariable name="contentChannel" type="com.jiuyue.novel.cp.dto.ContentChannelDTO" -->
<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentChannelBookDTO" -->
<tbody>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.bookId}">
            <td><label class="match-parent"><input name="itemId" value="${record.bookId}" data-role="check"
                                                   type="checkbox"/>${record.bookId}</label></td>
            <td><#if (record.book.cover?has_content)!false><img style="width:75px;height:100px;"
                                                                src="${upload_base}/${record.book.cover}"></#if></td>
            <td><img alt="300x400封面" style="width:75px;height:100px;"
                     src="${upload_base}/cover/${bookIdFragment(record.bookId)}/${record.bookId}_300x400.jpg"></td>
            <td>${(record.book.name)!''}<#if record.name?has_content>(${record.name})</#if></td>
            <td>${(record.book.authorName)!''}</td>
            <td>${record.pushedChapterCount?c}/${(record.chapterCount == 0) ?then('-', record.chapterCount?c)}
                /${(record.book.chapterCount)!0}</td>
            <td>${(record.authorizeEnd?date?string)!''}</td>
            <td>
                <@permitted value="content_channel:update_items">
                    <a class="table-op-btn" data-role="edit" title="编辑" data-toggle="tooltip"><span
                                class="fa fa-edit"></span></a>
                </@permitted>
                <@permitted value="content_channel:update_items">
                    <a class="table-op-btn" data-role="remove" title="删除" data-toggle="tooltip"><span
                                class="fa fa-trash"></span></a>
                </@permitted>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="8" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>