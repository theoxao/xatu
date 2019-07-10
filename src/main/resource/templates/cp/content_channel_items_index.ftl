<#-- @ftlvariable name="contentChannel" type="com.jiuyue.novel.cp.dto.ContentChannelDTO" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/bootstrap-datepicker/css/bootstrap-datepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <script type="application/javascript">window.channel_id = ${contentChannel.id};</script>
    <title>渠道书籍管理 - CP管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='content_channel' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <#--noinspection HtmlUnknownTarget-->
                <h1 class="page-header"><a href="${base}/content_channel/index.html">${contentChannel.name!''}</a> -
                    书籍列表</h1>
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
                                    <label>书籍编号：<input name="bookId" class="form-control input-sm"
                                                       data-validate="number" placeholder="书籍编号"/></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <@permitted value="content_channel:update_items">
                                        <button id="createBtn" type="button" class="btn btn-primary">新增</button>
                                    </@permitted>
                                    <#if contentChannel.pushFunction?has_content>
                                        <@permitted value="content_channel:update_items">
                                            <button id="pushUpdateBtn" type="button" class="btn btn-primary">推送更新
                                            </button>
                                        </@permitted>
                                    </#if>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 table-responsive">
                                <table id="data-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th><label class="match-parent"><input data-role="check-all"
                                                                               type="checkbox">#</label></th>
                                        <th>封面</th>
                                        <th>300x400封面</th>
                                        <th>书名</th>
                                        <th>作者</th>
                                        <th>已推送/发布/总章节数</th>
                                        <th>授权截止</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
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
<#include "../partial/foot.ftl">
<script src="${static_base}/vendor/bootstrap-datepicker/js/bootstrap-datepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/cp/content_channel_item${dev?then('', '.min')}.js"></script>
</body>
</html>