<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentChannelDTO" -->
<tbody <#if pagination??>data-pagination="${toJson(pagination)?html}"</#if>>
<#if list?has_content>
    <#list list as record>
        <tr class="${record?is_even_item?then('even', '')}" data-id="${record.id}">
            <td><label class="match-parent"><input name="id" value="${record.id}" data-role="check"
                                                   type="checkbox"/>${record.id}</label></td>
            <td><a href="${base}/content_channel/${record.id}/items">${record.name!''}</a></td>
            <td>${record.clientId!''}</td>
            <td>${record.secret!''}</td>
            <td><@dictText type='StatusType' code=record.status!0/></td>
            <td>
                <ul>
                    <#if record.pushFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code class="hidden">${record.pushFunction?html}</code>推送更新函数</a>
                        </li>
                    </#if>
                    <#if record.signFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code class="hidden">${record.signFunction?html}</code>签名函数</a>
                        </li>
                    </#if>
                    <#if record.errorSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code class="hidden">${record.errorSerializeFunction?html}</code>错误信息序列化函数</a>
                        </li>
                    </#if>
                    <#if record.bookListSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code
                                        class="hidden">${record.bookListSerializeFunction?html}</code>书籍列表序列化函数</a></li>
                    </#if>
                    <#if record.bookSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code class="hidden">${record.bookSerializeFunction?html}</code>书籍信息序列化函数</a>
                        </li>
                    </#if>
                    <#if record.chapterListSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code
                                        class="hidden">${record.chapterListSerializeFunction?html}</code>章节列表序列化函数</a>
                        </li>
                    </#if>
                    <#if record.chapterSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code
                                        class="hidden">${record.chapterSerializeFunction?html}</code>章节信息序列化函数</a></li>
                    </#if>
                    <#if record.categoryListSerializeFunction?has_content>
                        <li><a tabindex="0" role="button" class="link-info" data-toggle="popover"
                               data-trigger="focus"><code
                                        class="hidden">${record.categoryListSerializeFunction?html}</code>分类列表序列化函数</a>
                        </li>
                    </#if>
                </ul>
            </td>
            <td>
                <ul>
                    <#if record.bookListSerializeFunction?has_content>
                        <li>http://cp.9yread.com/${record.id}/books?client_id=${record.clientId!''}&sign=&lt;sign&gt;
                        </li>
                        <li>http://cp.9yread.com/${record.id}/books/&lt;bookId&gt;?client_id=${record.clientId!''}&sign=&lt;sign&gt;</li>
                        <li>http://cp.9yread.com/${record.id}
                            /books/&lt;bookId&gt;/chapters?client_id=${record.clientId!''}&sign=&lt;sign&gt;
                        </li>
                        <li>http://cp.9yread.com/${record.id}
                            /books/&lt;bookId&gt;/chapters/&lt;chapterId&gt;?client_id=${record.clientId!''}&sign=&lt;sign&gt;
                        </li>
                        <#if record.categoryListSerializeFunction?has_content>
                            <li>http://cp.9yread.com/${record.id}/category_list?client_id=${record.clientId!''}&sign=&lt;sign&gt;</li>
                        </#if>
                    </#if>
                </ul>
            </td>
            <td class="pre-wrap">${record.remark!''}</td>
            <td>
                <@permitted value="content_channel:update">
                    <a class="table-op-btn" data-role="edit" title="编辑" data-toggle="tooltip"><span
                                class="fa fa-edit"></span></a>
                </@permitted>
                <@permitted value="content_channel:update_items">
                    <a class="table-op-btn" data-role="edit-items" title="编辑书籍列表" data-toggle="tooltip"><span
                                class="fa fa-clone"></span></a>
                </@permitted>
            </td>
        </tr>
    </#list>
<#else >
    <tr>
        <td colspan="9" class="text-center">暂无数据.</td>
    </tr>
</#if>
</tbody>