<#-- @ftlvariable name="categories" type="java.util.List<com.jiuyue.novel.admin.dto.CategoryDTO>" -->
<#-- @ftlvariable name="onlineBookCount" type="int" -->
<#-- @ftlvariable name="comicDetail" type="com.jiuyue.novel.admin.dto.BookDTO" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <title>有声详情 - 有声管理 - 编辑</title>
</head>
<body>
<div id="wrapper">
    <@c.nav current='book' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">有声详情</h1>
            </div>
            <#-- /.col-lg-12 -->
        </div>
        <#-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <#-- /.panel-heading -->
                    <div class="panel-body form-inline">
                        <div class="row">
                            <div class="col-sm-6">
                                <img src="${upload_base}/${albumDetail.cover?has_content?then(albumDetail.cover!'', 'cover/default.jpg')}">
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label>书名：</label>
                                        <div class="form-control-static">${albumDetail.name!''}</div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label>作者：</label>
                                        <div class="form-control-static"><a href="${base}/author/${albumDetail.id}.html"
                                                                            target="_blank">${albumDetail.authorName!''}</a>
                                        </div>
                                    </div>
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
</body>
</html>