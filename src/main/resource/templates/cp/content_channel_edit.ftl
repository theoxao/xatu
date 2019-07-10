<#-- @ftlvariable name="record" type="com.jiuyue.novel.cp.dto.ContentChannelDTO" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_name" class="form-required">渠道名称</label>
                    <input id="add_modal_name" name="name" class="form-control" placeholder="渠道名称"
                           value="${record.name!''}">
                </div>
                <div class="form-group col-sm-6">
                    <label class="form-required">状态</label>
                    <div class="radio">
                        <@c.radios dicts('StatusType') 'status' record.status?c/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="form-required">clientId</label>
                    <input id="add_modal_clientId" name="clientId" class="form-control" placeholder="clientId"
                           value="${record.clientId!''}">
                </div>
                <div class="form-group col-sm-6">
                    <label for="add_modal_secret" class="form-required">key</label>
                    <input id="add_modal_secret" name="secret" class="form-control" placeholder="密钥"
                           value="${record.secret!''}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_pushFunction">推送更新函数</label>
                    <textarea id="add_modal_pushFunction" name="pushFunction" class="form-control"
                              placeholder="推送更新函数">${(record.pushFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_signFunction">签名函数</label>
                    <textarea id="add_modal_signFunction" name="signFunction" class="form-control"
                              placeholder="签名函数">${(record.signFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_errorSerializeFunction">错误信息序列化函数</label>
                    <textarea id="add_modal_errorSerializeFunction" name="errorSerializeFunction" class="form-control"
                              placeholder="错误信息序列化函数">${(record.errorSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_bookListSerializeFunction">书籍列表序列化函数</label>
                    <textarea id="add_modal_bookListSerializeFunction" name="bookListSerializeFunction"
                              class="form-control"
                              placeholder="书籍列表序列化函数">${(record.bookListSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_bookSerializeFunction">书籍信息序列化函数</label>
                    <textarea id="add_modal_bookSerializeFunction" name="bookSerializeFunction" class="form-control"
                              placeholder="书籍信息序列化函数">${(record.bookSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_chapterListSerializeFunction">章节列表序列化函数</label>
                    <textarea id="add_modal_chapterListSerializeFunction" name="chapterListSerializeFunction"
                              class="form-control"
                              placeholder="章节列表序列化函数">${(record.chapterListSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_chapterSerializeFunction">章节信息序列化函数</label>
                    <textarea id="add_modal_chapterSerializeFunction" name="chapterSerializeFunction"
                              class="form-control"
                              placeholder="章节信息序列化函数">${(record.chapterSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_categoryListSerializeFunction">分类列表序列化函数</label>
                    <textarea id="add_modal_categoryListSerializeFunction" name="categoryListSerializeFunction"
                              class="form-control"
                              placeholder="分类列表序列化函数">${(record.categoryListSerializeFunction?html)!''}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_remark">备注</label>
                    <textarea id="add_modal_remark" name="remark" class="form-control"
                              placeholder="备注">${(record.remark?html)!''}</textarea>
                </div>
            </div>
        </form>
    </div>
</div>