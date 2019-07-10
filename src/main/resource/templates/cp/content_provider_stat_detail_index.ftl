<#-- @ftlvariable name="zeus" type="boolean" -->
<#-- @ftlvariable name="cp" type="com.jiuyue.novel.cp.dto.ContentProviderDTO" -->
<#-- @ftlvariable name="beginDate" type="java.util.Date" -->
<#-- @ftlvariable name="endDate" type="java.util.Date" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/bootstrap-datepicker/css/bootstrap-datepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <title>日收入明细 - CP数据管理</title>
    <script> var beginDate = "${(beginDate?date?string)!''}";
        var endDate = "${(endDate?date?string)!''}";
        <#if cp?has_content>
        var cpId =${cp.id};
        <#else >
        var cpId = "";
        </#if>
    </script>
</head>
<body>
<div id="wrapper">
    <@c.nav current='cp_stat_manage' />

    <div id="page-wrapper">
        <div class="breadcrumbs">
            <ul class="breadcrumb">
                <li><a href="${base}/index.html">首页</a></li>
                <li><a href="${base}/content_provider_stat/index.html">CP数据管理</a></li>
                <#if cp?has_content>
                    <li>${cp.name}</li>
                </#if>

                <#if beginDate?date?string==endDate?date?string>
                    <li class="active">
                        ${(beginDate?date?string)!''}</li>

                <#else >
                    <li class="active">
                        ${(beginDate?date?string)!''} 至${(endDate?date?string)!''}</li>
                </#if>
            </ul>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <div class="panel-body">
                        <form class="search-form form-inline">
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <label>日期：</label>
                                    <div class="input-daterange input-group">
                                        <input class="input-sm form-control" name="beginDate" title="起始日期"/>
                                        <span class="input-group-addon">-</span>
                                        <input class="input-sm form-control" name="endDate" title="结束日期"/>
                                    </div>
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
                                        <th>完结状态</th>
                                        <th>分成后销售金额(元)</th>
                                        <th>扣除渠道费后金额(元)</th>
                                        <#if zeus>
                                            <th>操作</th>
                                        </#if>
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

<script src="${static_base}/vendor/bootstrap-datepicker/js/bootstrap-datepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/cp/content_provider_stat_detail${dev?then('', '.min')}.js"></script>
<#if zeus>
    <script src="${static_base}/js/cp/content_provider_stat_detail_zeus${dev?then('', '.min')}.js"></script>
</#if>
</body>
</html>