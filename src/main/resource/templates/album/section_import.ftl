<#-- @ftlvariable name="position" type="int" -->
<div class="row">
    <div class="col-lg-12">
        <form id="split-form" role="form">
            <div class="row">
                <div class="form-group col-sm-4">
                    <label for="import_modal_position" class="form-required">起始位置</label>
                    <input id="import_modal_position" name="position" value="${position}" class="form-control"
                           placeholder="起始位置">
                    <p class="help-block">位置对应章节已存在时将更新内容，不存时将新增章节</p>
                </div>
                <div class="form-group col-sm-4">
                    <label for="import_modal_firstFeeIndex" class="form-required">起始收费章节序号</label>
                    <input id="import_modal_firstFeeIndex" name="firstFeeIndex" value="1" class="form-control"
                           placeholder="起始收费章节序号">
                    <p class="help-block">本批导入章节起始收费章节序号，1表示分章后的第一章，0表示全部免费</p>
                </div>
                <div class="form-group col-sm-4">
                    <label for="import_modal_encoding" class="form-required">文件格式</label>
                    <select id="import_modal_encoding" name="format" class="form-control">
                        <option value="mp3">mp3</option>
                    </select>
                    <p class="help-block">暂时只支持<code>mp3</code>格式</p>
                </div>
            </div>
            <div class="form-group">
                <label for="import_modal_file" class="form-required">文件</label>
                <input id="import_modal_file" type="file" name="file">
                <p class="help-block">
                    如果是章节文件压缩包，压缩包内的文件格式<code>章节序号</code>-<code>章节名称</code>.<code>mp3</code>，压缩包必须以<code>.zip</code>为后缀
                </p>
            </div>
        </form>
    </div>
</div>