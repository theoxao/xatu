<ul class="nav navbar-top-links navbar-right">
    <li class="dropdown">
        <a class="user-profile dropdown-toggle" data-toggle="dropdown" href="#">
            <@principal ;principal>
                <#assign _principal=principal/>
                <img src="${principal.avatar}"/>
                ${principal.displayName!''}
            </@principal>
            <#--<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>-->
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a id="editProfileBtn" class="cursor-pointer"><i class="fa fa-user fa-fw"></i> 我的资料</a>
            </li>
            <#if _principal.isEditor()>
            <li><a id="editEditorBtn" class="cursor-pointer"><i class="fa fa-address-book-o fa-fw"></i> 小编资料</a>
                </#if>
            </li>
            <li><a id="changePasswordBtn" class="cursor-pointer"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
            </li>
            <li class="divider"></li>
            <#--noinspection HtmlUnknownTarget-->
            <li><a href="${base}/logout.html"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
            </li>
        </ul>
    </li>
</ul>