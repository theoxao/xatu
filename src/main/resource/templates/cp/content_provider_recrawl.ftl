<#-- @ftlvariable name="contentProviders" type="java.util.List<com.jiuyue.novel.cp.dto.ContentProviderDTO>" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="contentProvider">内容提供商:</label>
                    <select class="form-control" id="contentProvider" name="cpId">
                        <#list contentProviders as record>
                            <option value="${record.id}">${record.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group col-sm-6">
                    <label for="partial">只抓取未抓取书籍</label>
                    <select class="form-control" id="partial" name="partial">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </div>

            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="edit_modal_ratio" class="form-required">书籍ID</label>
                    <input id="edit_modal_ratio" name="bookId" class="form-control" placeholder="书籍ID">
                </div>
                <div class="form-group col-sm-6">
                    <label for="edit_modal_userId" class="form-required">章节ID</label>
                    <input id="edit_modal_userId" name="chapterId" class="form-control" placeholder="章节ID">
                </div>
            </div>
        </form>
    </div>
</div>