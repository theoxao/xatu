<#-- @ftlvariable name="nextPosition" type="String" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_name" class="form-required">名称</label>
                    <input type="hidden" name="duration" value="0"/>
                    <input type="hidden" name="position" value="${nextPosition}"/>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="章节名称"
                           value="第${nextPosition}章 ">
                </div>
                <div class="form-group col-sm-4">
                    <label class="form-required">是否收费</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="fee" value="0">否
                        </label>
                        <label>
                            <input type="radio" name="fee" value="1" checked>是
                        </label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_readers">配音</label>
                    <input id="add_modal_readers" name="readers" class="form-control" placeholder="多个以“/”分割"/>
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