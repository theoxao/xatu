<#-- @ftlvariable name="album" type="com.jiuyue.album.dto.AlbumDTO" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partial/head.ftl">
    <link href="${static_base}/vendor/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker${dev?then('', '.min')}.css"
          rel="stylesheet" type="text/css">
    <script type="application/javascript">window.album_id = ${album.id};</script>
    <title>章节管理 - 有声读物管理 - 编辑</title>

    <style>
        .audioplayer {
            position: relative;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            widows: 10em;
            height: 35px;
            background: -webkit-gradient(linear, left top, left bottom, from(#eee), to(#ccc));
            background: -webkit-linear-gradient(top, #eee, #ccc);
            background: -moz-linear-gradient(top, #eee, #ccc);
            background: -ms-radial-gradient(top, #eee, #ccc);
            background: -o-linear-gradient(top, #eee, #ccc);
            background: linear-gradient(to bottom, #eee, #ccc);

            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, .15), 0 0 1.25em rgba(0, 0, 0, .5);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, .15), 0 0 1.25em rgba(0, 0, 0, .5);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, .15), 0 0 1.25em rgba(0, 0, 0, .5);
        }

        .audioplayer > div {
            position: absolute;
        }

        .audioplayer:not(.audioplayer-mini) .audioplayer-playpause {
            border-right: 1px solid rgba(255, 255, 255, .1);
            height: 35px;
        }

        .audioplayer-stopped .audioplayer-playpause a {
            width: 0;
            height: 0;
            border: 0.8em solid transparent;
            border-right: none;
            border-left-color: #888;
            content: '';
            position: absolute;
            margin: -0.5em 0 0 -0.25em;
            left: 1.5em;
            top: -7px;
        }

        .audioplayer-playing .audioplayer-playpause a {
            width: 18px;
            height: 18px;
            position: absolute;
            left: 1.5em;
            top: -7px;
            margin: -0.375em 0 0 -0.375em;
        }

        .audioplayer-playing .audioplayer-playpause a:before, .audioplayer-playing .audioplayer-playpause a:after {
            width: 100%;
            height: 100%;
            background-color: #888;
            content: '';
            position: absolute;
        }

        .audioplayer-bar {
        }

        .audioplayer-bar-loaded {
            background-color: #333;
            z-index: 1;
        }

        .audioplayer-bar-played {
            background: -webkit-gradient(linear, left top, right top, from(#007fd1), to(#c600ff));
            background: -webkit-linear-gradient(left, #007fd1, #c600ff);
            background: -moz-linear-gradient(left, #007fd1, #c600ff);
            background: -ms-radial-gradient(left, #007fd1, #c600ff);
            background: -o-linear-gradient(left, #007fd1, #c600ff);
            background: linear-gradient(to right, #007fd1, #c600ff);
        }

        .audioplayer-time {
            width: 4.375em;
            height: 100%;
            line-height: 2.375em;
            text-align: center;
            z-index: 2;
            top: 0;
        }

        .audioplayer-time-current {
            border-left: 1px solid rgba(0, 0, 0, .25);
            left: 3.5em;
        }

        .audioplayer-time-duration {
            border-right: 1px solid rgba(255, 255, 255, .1);
            left: 6.2em;
        }

        .audioplayer-volume {
            height: 100%;
            text-align: left;
            text-indent: -9999px;
            cursor: pointer;
            z-index: 2;
            top: 0;
            right: 0;
        }

        .audioplayer-volume-button {
            width: 0;
            height: 100%;
        }

        .audioplayer-volume-adjust {
            -webkit-border-top-left-radius: 2px;
            -webkit-border-top-right-radius: 2px;
            -moz-border-radius-topleft: 2px;
            -moz-border-radius-topright: 2px;
            border-top-left-radius: 2px;
            border-top-right-radius: 2px;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <@c.nav current='chapter' />

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <#--noinspection HtmlUnknownTarget-->
                <h1 class="page-header"><a href="${base}/album/index.html">${album.name}</a> - 章节列表</h1>
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
                                    <label>编号：<input name="sectionId" class="form-control input-sm"
                                                     data-validate="number"
                                                     placeholder="章节编号"/></label>
                                    <label>名称：<input name="name" class="form-control input-sm"
                                                     placeholder="章节名称"/></label>
                                </div>
                            </div>
                            <div class="row separate">
                                <div class="col-sm-6">
                                    <button id="searchBtn" type="submit" class="btn btn-default">查询</button>
                                    <button id="resetBtn" type="reset" class="btn btn-default">重置</button>
                                    <@permitted value="chapter:add">
                                        <button id="createBtn" type="button" class="btn btn-primary">新增</button>
                                    </@permitted>
                                    <#--<@permitted value="chapter:delete">-->
                                    <#--<button id="batchDeleteBtn" type="button" class="btn btn-default" data-toggle="tooltip" title="批量删除章节">删除</button>-->
                                    <#--</@permitted>-->
                                    <@permitted value="chapter:import">
                                        <button id="importBtn" type="button" class="btn btn-default"
                                                data-toggle="tooltip" title="单章或批量导入章节">导入
                                        </button>
                                    </@permitted>
                                </div>
                                <div class="col-sm-3 col-lg-2 audio-container"></div>
                            </div>
                            <div style="padding-bottom: 10px" class="row"></div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 table-responsive">
                                <table id="data-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th><label class="match-parent"><input data-role="check-all"
                                                                               type="checkbox">#</label></th>
                                        <th>名称</th>
                                        <th>配音</th>
                                        <th>时长</th>
                                        <th>收费</th>
                                        <th>价格</th>
                                        <th>位置</th>
                                        <th>状态</th>
                                        <th>创建时间</th>
                                        <th>更新时间</th>
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

<script src="${static_base}/js/audioplayer.js"></script>
<script src="${static_base}/vendor/moment/moment${dev?then('', '.min')}.js" type="application/javascript"></script>
<script src="${static_base}/vendor/moment/zh-cn.js" type="application/javascript"></script>
<script src="${static_base}/vendor/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker${dev?then('', '.min')}.js"
        type="application/javascript"></script>
<script src="${static_base}/js/album/section${dev?then('', '.min')}.js"></script>

<script>

</script>

</body>
</html>