<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_name" class="form-required">渠道名称</label>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="渠道名称" value="">
                </div>
                <div class="form-group col-sm-6">
                    <label class="form-required">状态</label>
                    <div class="radio">
                        <@c.radios dicts('StatusType') 'status' '1'/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_clientId">clientId</label>
                    <input id="add_modal_clientId" name="clientId" class="form-control" placeholder="clientId" value="">
                    <div class="help-block">不填自动生成</div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="add_modal_secret">key</label>
                    <input id="add_modal_secret" name="secret" class="form-control" placeholder="密钥" value="">
                    <div class="help-block">不填自动生成</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="modal_is_default">使用默认配置</label>
                    <input class="form-control-inline" id="modal_is_default" type="radio" name="isDefault" checked
                           value="false">否
                    <input class="form-control-inline" id="modal_is_default" type="radio" name="isDefault" value="true">是
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_pushFunction">推送更新函数</label>
                    <textarea id="add_modal_pushFunction" name="pushFunction" class="form-control"
                              placeholder="推送更新函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_signFunction">签名函数</label>
                    <textarea id="add_modal_signFunction" name="signFunction" class="form-control"
                              placeholder="签名函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_errorSerializeFunction">错误信息序列化函数</label>
                    <textarea id="add_modal_errorSerializeFunction" name="errorSerializeFunction" class="form-control"
                              placeholder="错误信息序列化函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_bookListSerializeFunction">书籍列表序列化函数</label>
                    <textarea id="add_modal_bookListSerializeFunction" name="bookListSerializeFunction"
                              class="form-control" placeholder="书籍列表序列化函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_bookSerializeFunction">书籍信息序列化函数</label>
                    <textarea id="add_modal_bookSerializeFunction" name="bookSerializeFunction" class="form-control"
                              placeholder="书籍信息序列化函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_chapterListSerializeFunction">章节列表序列化函数</label>
                    <textarea id="add_modal_chapterListSerializeFunction" name="chapterListSerializeFunction"
                              class="form-control" placeholder="章节列表序列化函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_chapterSerializeFunction">章节信息序列化函数</label>
                    <textarea id="add_modal_chapterSerializeFunction" name="chapterSerializeFunction"
                              class="form-control" placeholder="章节信息序列化函数"></textarea>
                </div>
            </div>
            <div class="row function">
                <div class="form-group col-sm-12">
                    <label for="add_modal_categoryListSerializeFunction">分类列表序列化函数</label>
                    <textarea id="add_modal_categoryListSerializeFunction" name="categoryListSerializeFunction"
                              class="form-control" placeholder="分类列表序列化函数"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_remark">备注</label>
                    <textarea id="add_modal_remark" name="remark" class="form-control" placeholder="备注"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>