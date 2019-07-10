<!DOCTYPE html>
<html lang="en">
<head>
    <#include "partial/head.ftl">
    <title>登录</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">登录</h3>
                </div>
                <div class="panel-body">
                    <#--noinspection HtmlUnknownTarget-->
                    <form role="form" action="${base}/login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="username" autofocus="autofocus"/>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" value=""/>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="true"/>记住登录状态
                                </label>
                            </div>
                            <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${static_base}/vendor/jquery/jquery${dev?then('', '.min')}.js"></script>
<script src="${static_base}/vendor/bootstrap/js/bootstrap${dev?then('', '.min')}.js"></script>

<script type="application/javascript">
    <#--noinspection ES6ConvertVarToLetConst-->
    var defaultWelcomeUrl = '${base}/index.html';
    $(function () {
        var form = $('form');
        form.submit(function (event) {
            event.preventDefault();
            form.find('.error').remove();
            $.post($(this).attr('action'), $(this).serialize(), function (result) {
                if (result.status === 200) {
                    <#--noinspection JSUnresolvedVariable-->
                    window.location = result.data.redirectUrl || defaultWelcomeUrl;
                    return;
                }
                form.find('fieldset').prepend('<div class="error">' + result.error + '</div>');
            });
            return false;
        });
    });
</script>

</body>

</html>