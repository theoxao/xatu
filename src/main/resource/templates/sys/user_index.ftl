<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <title>用户管理 - 系统管理</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='user' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户列表</h1>
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
                                    <label>编号：<input name="id" class="form-control input-sm" data-validate="number"
                                                     placeholder="用户编号"/></label>
                                    <label>名称：<input name="username" class="form-control input-sm"
                                                     placeholder="用户名"/></label>
                                    <label>昵称：<input name="displayName" class="form-control input-sm" placeholder="昵称"/></label>
                                    <label>备注：<input name="remark" class="form-control input-sm"
                                                     placeholder="备注"/></label>
                                    <label>类型：<select name="type" class="form-control input-sm">
                                            <option value="">不限</option><@c.options typeOptions/></select></label>
                                    <label>状态：<select name="status" class="form-control input-sm">
                                            <option value="">不限</option><@c.options statusOptions/></select></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-12">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <@permitted value="user:add">
                                        <button id="createBtn" type="button" class="btn btn-primary">新增</button>
                                    </@permitted>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 table-responsive">
                                <table id="data-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th data-sortable="true" data-field="u_id" data-order="asc"><label
                                                    class="match-parent"><input data-role="check-all" type="checkbox">#</label>
                                        </th>
                                        <th>用户名</th>
                                        <th>昵称</th>
                                        <th>状态</th>
                                        <th>类型</th>
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

<script src="${static_base}/js/sys/user${dev?then('', '.min')}.js"></script>
</body>
</html>