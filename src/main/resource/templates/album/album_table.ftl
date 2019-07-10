<#-- @ftlvariable name="record" type="com.jiuyue.album.dto.AlbumDTO" -->
<#assign colspan=14/>
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('', 'odd')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td>
                <div style="height: 100px;">
                    <img style="width:75px;height:100px;float:left;"
                         src="${upload_base}/${record.bookCover?has_content?then(record.bookCover!'', 'cover/default.jpg')}"/>
                    <p style="padding-left: 80px;"><label>书名：</label>${record.name!''}</p>
                    <p style="padding-left: 80px;"><label>作者：</label><#if record.authorId?has_content><a
                        href="${base}/author/${record.authorId}.html">${record.authorName!''}</a><#else><span
                                class="secondary-text">匿名</span></#if></p>
                </div>
            </td>
            <td class="text-right">${record.sectionCount!0}</td>
            <td data-value="${record.serialStatus?c}">${(record.serialStatus == 1)?then('完本', '连载')}</td>
            <td><@dictText type="FeeType" code=record.feeType/></td>
            <td class="text-right">
                <#if (record.price>100)>
                    ${record.price/100}元
                <#else>
                    ${record.price!'0'}分
                </#if>

            </td>
            <td data-value="${record.status?c}"><@dictText type="AuditStatusType" code=record.status/></td>
            <td style="width: 20%;text-overflow: ellipsis">${record.introduction}</td>
            <td>${(record.createTime?datetime?string)!''}<code>-</code>${(record.updateTime?datetime?string)!''}</td>
            <td style="width:20%">
                <@permitted value="book:update">
                    <a class="grid-opt-btn cursor-pointer" data-role="edit" title="修改信息" data-toggle="tooltip">修改信息</a>
                </@permitted>
                <@permitted value="chapter:read">
                    <a class="grid-opt-btn cursor-pointer" href="${base}/album/${record.id}/section.html" title="查看章节列表"
                       data-toggle="tooltip">查看章节</a>
                </@permitted>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="12" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>