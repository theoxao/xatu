<#-- @ftlvariable name="record" type="com.jiuyue.album.dto.SectionDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td> ${record.name!''}</td>
            <td>${record.readers}</td>
            <td>${record.duration!0}</td>
            <td>${(record.fee == 1)?then('是', '否')}</td>
            <td class="text-right">${record.price!'0'}分</td>
            <td class="text-right">${record.position!'0'}</td>
            <td class="text-right">${record.status!''}</td>
            <td>${(record.createTime?datetime?string)!''}</td>
            <td>${(record.updateTime?datetime?string)!''}</td>
            <td>
                <@permitted value="album_section:update">
                    <a class="table-op-btn" data-role="edit" title="编辑" data-toggle="tooltip"><span
                                class="fa fa-edit"></span></a>
                </@permitted>
                <@permitted value="album_section:listen">
                    <a class="table-op-btn" data-role="listen" title="试听" data-toggle="tooltip"><span
                                class="fa fa-headphones"></span></a>
                </@permitted>
                <@permitted value="album_section:delete">
                    <a class="table-op-btn" data-role="delete" title="删除" data-toggle="tooltip"><span
                                class="fa fa-remove"></span></a>
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