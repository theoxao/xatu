<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <title>CP内容管理 - CP管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='cp_content_manage' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">CP接入书籍列表</h1>
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
                                    <label>书籍原始ID<input name="originId" class="form-control input-sm"
                                                        data-validate="number" placeholder="书籍原始ID"/></label>
                                    <label>书籍ID<input name="bookId" class="form-control input-sm"
                                                      data-validate="number" placeholder="书籍ID"/></label>
                                    <label>书籍名称：<input name="bookName" class="form-control input-sm"
                                                       placeholder="书籍名称"/></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <button id="exportBtn" type="button" class="btn btn-default" title="导出成CSV格式"
                                            data-toggle="tooltip">导出
                                    </button>
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
                                        <th>原始书籍编号</th>
                                        <th>书籍编号</th>
                                        <th>书籍名称</th>
                                        <th>作者名称</th>
                                        <th>分类</th>
                                        <th>上架状态</th>
                                        <th>授权起止时间</th>
                                        <th>完结状态</th>
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
<script src="${static_base}/js/cp/content_provider_content${dev?then('', '.min')}.js"></script>
</body>
</html>