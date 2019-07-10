<#-- @ftlvariable name="contentProvider" type="com.jiuyue.novel.cp.dto.ContentProviderDTO" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/bootstrap-datepicker/css/bootstrap-datepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <script type="application/javascript">window.channel_id = ${contentProvider.id};</script>
    <title>CP书籍管理 - CP管理</title>
    <script>
        var cpId = ${contentProvider.id};
    </script>
</head>
<body>
<div id="wrapper">
    <@c.nav current='content_provider' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><a href="${base}/content_provider/index.html">内容提供商列表</a>
                    /${contentProvider.name!''}- 书籍列表</h3>
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
                        <form class="search-form form-inline">
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <label>原始书籍编号：<input name="originBookId" class="form-control input-sm"
                                                         data-validate="number" placeholder="书籍编号"/></label>

                                    <label>书籍编号：<input name="bookId" class="form-control input-sm"
                                                       data-validate="number" placeholder="书籍编号"/></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 table-responsive">
                                <table id="data-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>书籍原始ID</th>
                                        <th>书籍ID</th>
                                        <th>封面</th>
                                        <th>书名</th>
                                        <th>作者</th>
                                        <th>已抓取章节数</th>
                                        <th>是否完结</th>
                                        <th>最后抓取时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../partial/foot.ftl">
<script src="${static_base}/vendor/bootstrap-datepicker/js/bootstrap-datepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/cp/content_provider_items${dev?then('', '.min')}.js"></script>
</body>
</html>