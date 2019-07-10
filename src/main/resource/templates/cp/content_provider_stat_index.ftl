<#-- @ftlvariable name="contentProviders" type="java.util.List<com.jiuyue.novel.cp.dto.ContentProviderDTO>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/bootstrap-datepicker/css/bootstrap-datepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <title>CP数据管理 - CP管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='cp_stat_manage' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">日收入统计列表</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <div class="panel-body">
                        <form class="search-form form-inline">
                            <div class="row separate">
                                <div class="col-sm-6">
                                    <#if contentProviders?has_content>
                                        <label for="contentProvider">内容提供商:</label>
                                        <select class="form-control" id="contentProvider" name="contentProviderId">
                                            <option value="">请选择</option>
                                            <#list contentProviders as record>
                                                <option value="${record.id}">${record.name}</option>
                                            </#list>
                                        </select>
                                    </#if>
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
                                    <#if contentProviders?has_content>
                                        <@permitted value='cp_stat_manage:statistic'>
                                            <button id="monthlyStatistic" type="button" class="btn btn-primary">统计月账单
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
                                        <th>日期</th>
                                        <th>分成前收入(元)</th>
                                        <th>分成比例</th>
                                        <th>分成后收入(元)</th>
                                        <th>扣除10%渠道费后收入</th>
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

<script src="${static_base}/vendor/bootstrap-datepicker/js/bootstrap-datepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/cp/content_provider_stat${dev?then('', '.min')}.js"></script>
</body>
</html>