<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <title>请求日志管理 - 系统管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='request_log    ' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">请求日志列表</h1>
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
                                    <label>操作者：<input name="user_id" class="form-control input-sm"
                                                      data-validate="number" placeholder="操作者编号"/></label>
                                    <label>请求URL：<input name="url" class="form-control input-sm"
                                                        placeholder="请求URL"/></label>
                                    <label>起始时间：
                                        <span class="input-daterange input-group">
                                            <input type="text" class="input-sm form-control" name="beginDate"
                                                   title="起始时间"/>
                                            <span class="input-group-addon">-</span>
                                            <input type="text" class="input-sm form-control" name="endDate"
                                                   title="结束时间"/>
                                        </span>
                                    </label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <@permitted value="request_log:clean">
                                        <button id="cleanBtn" type="button" class="btn btn-danger" title="清除三个月以前的日志"
                                                data-toggle="tooltip">清理
                                        </button>
                                    </@permitted>
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
                                        <th>请求URL</th>
                                        <th>请求方式</th>
                                        <th width="40%">请求参数</th>
                                        <th>操作者</th>
                                        <th>IP地址`</th>
                                        <th>操作时间</th>
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
<script src="${static_base}/js/sys/request_log${dev?then('', '.min')}.js"></script>
</body>
</html>