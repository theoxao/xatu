<#-- @ftlvariable name="record" type="com.jiuyue.album.dto.AlbumDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-4">
                    <label for="add_modal_name" class="form-required">名称</label>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="书籍名称"
                           value="${record.name}">
                </div>
                <div class="form-group col-sm-4">
                    <label for="add_modal_author" class="form-required">作者</label>
                    <input id="add_modal_author" name="authorName" class="form-control" placeholder="作者名称"
                           value="${record.authorName}">
                </div>
                <div class="form-group col-sm-4">
                    <label for="add_modal_chapterCount" class="form-required">章节数</label>
                    <input id="add_modal_chapterCount" name="sectionCount" data-validate="number"
                           class="form-control text-right" value="${record.sectionCount}">
                </div>
            </div>
            <div class="row">
                <#--<div class="form-group col-sm-4">-->
                <#--<label for="add_modal_cpId" class="form-required">CP</label>-->
                <#--<select id="add_modal_cpId" name="cpId" class="form-control">-->
                <#--<@c.options cpOptions/>-->
                <#--</select>-->
                <#--</div>-->
                <#--<div class="form-group col-sm-4">-->
                <#--<label for="add_modal_originId">原始编号</label>-->
                <#--<input id="add_modal_originId" data-validate="number" name="originId" class="form-control"-->
                <#--placeholder="原始编号">-->
                <#--</div>-->
                <div class="form-group col-sm-4">
                    <label for="add_modal_channelId" class="form-required">频道</label>
                    <select id="add_modal_channelId" name="channelId" class="form-control"
                            data-value="${record.channelId!''}">
                    </select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="add_modal_categoryId" class="form-required">分类</label>
                    <select id="add_modal_categoryId" name="categoryId" class="form-control"
                            data-value="${record.categoryId!''}">
                    </select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="add_modal_subcategoryId" class="form-required">二级分类</label>
                    <select id="add_modal_subcategoryId" name="subCategoryId" class="form-control"
                            data-value="${record.subCategoryId!''}">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="add_modal_tags">标签</label>
                <input id="add_modal_tags" name="tag" class="form-control" placeholder="标签，英文逗号隔开"
                       value="<#if record.tags?has_content><#list record.tags as tag>${tag}<#if !tag?is_last>,</#if></#list></#if>">
            </div>
            <div class="row">
                <div class="form-group col-sm-4">
                    <label class="form-required">连载状态</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="serialStatus"
                                   value="0" ${(record.serialStatus==0)?then('checked','')}>连载
                        </label>
                        <label>
                            <input type="radio" name="serialStatus"
                                   value="1" ${(record.serialStatus==1)?then('checked','')}>完本
                        </label>
                    </div>
                </div>
                <div class="form-group col-sm-4">
                    <label class="form-required">收费方式</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="feeType" value="0" ${(record.feeType==0)?then('checked','')}>按章
                        </label>
                        <label>
                            <input type="radio" name="feeType" value="1" ${(record.feeType==1)?then('checked','')}>整本
                        </label>
                    </div>
                </div>
                <div class="form-group col-sm-4">
                    <label for="add_modal_price" class="form-required">单价</label>
                    <div class="input-group">
                        <input id="add_modal_price" name="price" data-validate="number" class="form-control text-right"
                               value="${record.price}">
                        <span class="input-group-addon">分</span>
                    </div>
                </div>
            </div>
            <div class="row">
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_cover">封面</label>
                    <input type="hidden" name="bookCover">
                    <input id="add_modal_cover" type="file">
                    <div data-role="preview" style="height: 200px;overflow:hidden;">
                        <#if record.bookCover?has_content><img src="${upload_base}/${record.bookCover}"></#if>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="add_modal_introduction" class="form-required">简介</label>
                <textarea id="add_modal_introduction" name="introduction" class="form-control"
                          rows="6">${record.introduction}</textarea>
            </div>
        </form>
    </div>
</div>