<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentChannelBookDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_chapterCount">章节数</label>
                    <input id="edit_modal_chapterCount" name="chapterCount" class="form-control" placeholder="发布章节数"
                           value="${record.chapterCount!'0'}">
                    <div class="help-block">发布到渠道的章节数，0表示所有章节</div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_authorizeEnd">授权截止日期</label>
                    <input id="edit_modal_authorizeEnd" name="authorizeEnd" class="form-control" placeholder="授权截止日期"
                           value="${(record.authorizeEnd?date?string)!''}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_name">书名</label>
                    <input id="edit_modal_name" name="name" class="form-control" placeholder="发布到渠道的书名"
                           value="${record.name!''}">
                    <div class="help-block">发布到渠道的书名，留空使用当前书名</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_introduction">简介</label>
                    <textarea id="add_modal_introduction" name="introduction" class="form-control"
                              placeholder="发布到渠道的简介">${(record.introduction?html)!''}</textarea>
                    <div class="help-block">发布到渠道的简介，留空使用当前简介</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="edit_modal_cover">300x400尺寸封面(<span class="text-error">只支持jpg格式图片</span>)</label>
                    <input type="hidden" name="cover" value="">
                    <input id="edit_modal_cover" type="file" accept="image/jpeg">
                    <div data-role="preview" style="height: 200px;overflow:hidden;"><img
                                src="${upload_base}/cover/${bookIdFragment(record.bookId)}/${record.bookId}_300x400.jpg">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>