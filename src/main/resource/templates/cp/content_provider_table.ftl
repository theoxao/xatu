<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentProviderDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td><a href="${base}/content_provider/${record.id}/items">${record.name!''}</a></td>
            <td><@dictText type='StatusType' code=record.status!0/></td>
            <td>
                <a tabindex="0" role="button" class="link-info" data-toggle="popover" data-trigger="focus"><code
                            class="hidden">${record.script!?html}</code>推送更新函数</a>
            </td>
            <td class="pre-wrap">${record.remark!''}</td>
            <td>
                <@permitted value="content_provider:update">
                    <a class="grid-opt-btn cursor-pointer" data-role="edit" title="编辑信息" data-toggle="tooltip">编辑信息</a>
                </@permitted>
                <@permitted value="content_provider:update">
                    <a class="grid-opt-btn cursor-pointer" data-role="edit_script" title="编辑脚本" data-toggle="tooltip">编辑脚本</a>
                </@permitted>
                <@permitted value="content_provider:update">
                    <a class="grid-opt-btn cursor-pointer" data-role="toggle_status"
                       data-title="${((record.status == 1)!false)?then('禁用爬虫', '启用爬虫')}" data-toggle="tooltip"
                       data-value="${record.status!0}">${((record.status == 1)!false)?then('禁用爬虫', '启用爬虫')}</a>
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