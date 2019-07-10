<#-- @ftlvariable name="record" type="com.jiuyue.album.dto.SectionDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_name" class="form-required">名称</label>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="章节名称"
                           value="${record.name}">
                </div>
                <div class="form-group col-sm-4">
                    <label class="form-required">是否收费</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="fee" value="0" ${(record.fee==0)?then('checked','')} >否
                        </label>
                        <label>
                            <input type="radio" name="fee" value="1" ${(record.fee==1)?then('checked','')} >是
                        </label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_readers">配音</label>
                    <input id="add_modal_readers" name="readers" class="form-control" value="${record.readers}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_audio_file">音频文件</label>
                    <input id="add_audio_file" type="file" name="file">
                </div>
            </div>
        </form>
    </div>
</div>