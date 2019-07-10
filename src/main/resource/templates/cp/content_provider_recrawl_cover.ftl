<#-- @ftlvariable name="contentProviders" type="java.util.List<com.jiuyue.novel.cp.dto.ContentProviderDTO>" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="contentProvider">内容提供商:</label>
                    <select class="form-control form-inline" id="contentProvider" name="cpId">
                        <#list contentProviders as record>
                            <option value="${record.id}">${record.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group col-sm-6">
                    <label for="book_id">书籍编号</label>
                    <input type="text" name="bookId" class="form-control"/>
                </div>
            </div>
        </form>
    </div>
</div>