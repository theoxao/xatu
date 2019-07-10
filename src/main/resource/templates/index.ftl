<#-- @ftlvariable name="loginHistoryList" type="java.util.List<com.jiuyue.novel.admin.dto.OperationLogDTO>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "partial/head.ftl">
    <title>管理后台</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='home' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">首页</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">


                <div class="panel panel-default">
                    <div class="panel-heading">
                        最近登录
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>时间</th>
                                    <th>IP</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list loginHistoryList as record>
                                    <tr>
                                        <td>${record.gmtCreate?datetime?string}</td>
                                        <td>${record.ip!''}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "partial/foot.ftl">
<script src="${static_base}/vendor/chartjs/Chart${dev?then('', '.min')}.js"></script>
<script src="${static_base}/vendor/md5/md5${dev?then('', '.min')}.js"></script>
</body>
</html>