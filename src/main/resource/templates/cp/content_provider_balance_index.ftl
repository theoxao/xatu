<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <title>CP结算管理 - CP管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='cp_balance_manage' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">CP账单列表</h1>
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
                                    <label>状态：
                                        <select name="status" class="form-control input-sm">
                                            <option value="0">未申请</option>
                                            <option value="1">申请中</option>
                                            <option value="2">已完成</option>
                                        </select>
                                    </label>
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
                                        <th>开始日期</th>
                                        <th>结束日期</th>
                                        <th>分成后收入(元)(已扣除10%渠道费)</th>
                                        <th>状态</th>
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
<script src="${static_base}/js/cp/content_provider_balance${dev?then('', '.min')}.js"></script>
</body>
</html>