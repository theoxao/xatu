<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/prismjs/themes/prism-okaidia.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .popover {
            max-width: 800px;
        }

        .language-groovy {
            padding: 0;
        }
    </style>
    <title>内容提供商管理 - CP管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='content_provider' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">内容提供商列表</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <div class="panel-body">
                        <form class="search-form form-inline">
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <label>名称：<input name="name" class="form-control input-sm"
                                                     placeholder="渠道名称"/></label>
                                    <label>备注：<input name="remark" class="form-control input-sm"
                                                     placeholder="备注"/></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <@permitted value="content_provider:add">
                                        <button id="createBtn" type="button" class="btn btn-primary">新增</button>
                                    </@permitted>
                                    <@permitted value="content_provider:crawl">
                                        <button id="recrawl" type="button" class="btn btn-primary">重新爬取</button>
                                        <button id="recrawlCover" type="button" class="btn btn-primary">重新爬取封面</button>
                                    </@permitted>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 table-responsive">
                                <table id="data-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th><label class="match-parent"><input data-role="check-all" type="checkbox">编号</label>
                                        </th>
                                        <th>名称</th>
                                        <th>状态</th>
                                        <th>函数</th>
                                        <th>备注</th>
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
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../partial/foot.ftl">
<script src="${static_base}/vendor/prismjs/prism.js" type="application/javascript" data-manual></script>
<script src="${static_base}/vendor/prismjs/components/prism-groovy${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/cp/content_provider${dev?then('', '.min')}.js"></script>
</body>
</html>