<#-- @ftlvariable name="showSign" type="boolean" -->
<#-- @ftlvariable name="showMySign" type="boolean" -->
<#-- @ftlvariable name="categories" type="java.util.List<com.jiuyue.novel.admin.dto.CategoryDTO>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/bootstrap-datepicker/css/bootstrap-datepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <title>书籍管理 - 有声小说管理 - 编辑</title>
    <script>
        window.CATEGORIES = ${toJson(categories)};
    </script>
</head>
<body>
<div id="wrapper">
    <@c.nav current='album' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">有声书籍列表</h1>
            </div>
            <#-- /.col-lg-12 -->
        </div>
        <#-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <#-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row separate">
                        </div>
                    </div>
                    <form class="search-form form-inline">
                        <div class="row separate">
                            <div class="col-sm-12">
                                <label>编号：<input name="id" class="form-control input-sm" data-validate="number"
                                                 placeholder="书籍编号"/></label>
                                <label>名称：<input name="name" class="form-control input-sm" placeholder="书籍名称"/></label>
                                <label>作者：<input name="author" class="form-control input-sm"
                                                 placeholder="作者名称"/></label>
                                <label>频道：<select name="channel" class="form-control input-sm"></select></label>

                            </div>
                        </div>
                        <div class="row separate">
                            <div class="col-sm-12">
                                <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                <@permitted value="book:add">
                                    <button id="createBtn" type="button" class="btn btn-primary">新增</button>
                                </@permitted>
                                <#--<@permitted value="book:export">-->
                                <#--<button id="exportBtn" type="button" class="btn btn-default" data-toggle="tooltip" title="导出为CSV格式文件">导出</button>-->
                                <#--</@permitted>-->
                                <#--<@permitted value="book:update">-->
                                <#--<button id="removeIndexBtn" type="button" class="btn btn-danger" data-toggle="tooltip" title="批量删除搜索索引">删除索引</button>-->
                                <#--</@permitted>-->
                                <#--<@permitted value="book:update">-->
                                <#--<button id="flushCacheBtn" type="button" class="btn btn-success" data-toggle="tooltip" title="批量刷新缓存">刷新缓存</button>-->
                                <#--</@permitted>-->
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="data-table" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th><label class="match-parent"><input data-role="check-all"
                                                                           type="checkbox">#</label></th>
                                    <th>信息</th>
                                    <th>章节数</th>
                                    <th>连载状态</th>
                                    <th>收费类型</th>
                                    <th>价格</th>
                                    <th>状态</th>
                                    <th>简介</th>
                                    <th>创建时间<code>/</code>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row page-panel">
                        <div class="col-sm-12">
                            <div class="text-right">
                                <span class="page-status" role="status" aria-live="polite"></span>
                                <ul class="pagination">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <#-- /.panel-body -->
            </div>
            <#-- /.panel -->
        </div>
        <#-- /.col-lg-12 -->
    </div>
    <#-- /.row -->
</div>
<#-- /#page-wrapper -->
</div>
<#-- /#wrapper -->
<script type="application/javascript">
</script>
<#include "../partial/foot.ftl">

<script src="${static_base}/vendor/bootstrap-datepicker/js/bootstrap-datepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/album/album${dev?then('', '.min')}.js"></script>
</body>
</html>