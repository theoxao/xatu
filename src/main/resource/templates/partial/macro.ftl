<#-- 通用nav元素 -->
<#macro nav current>
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <#--noinspection HtmlUnknownTarget-->
            <a class="navbar-brand" href="${base}/index.html">九阅小说后台管理</a>
        </div>
        <#include "navbar_top_links.ftl"/>
        <@c.navbarMenu current=current />
    </nav>
</#macro>
<#-- 左侧菜单栏 -->
<#macro navbarMenu current>
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <#--noinspection FtlReferencesInspection-->
                <@navbarSubMenu current=current menus=statics['com.jiuyue.novel.admin.security.SecurityHolder'].getMenuList() level=1 />
            </ul>
        </div>
    </div>
</#macro>
<#-- 左侧菜单栏子菜单 -->
<#macro navbarSubMenu current menus level>
    <#list menus as menu>
        <li>
            <a <#if menu.link?has_content>href="${base + menu.link}"</#if>
               class="${(menu.value == current) ?then('active', '')}">
                <#if menu.icon?has_content><i class="${menu.icon} fa-fw"></i></#if>
                ${menu.name}
                <#if menu.children?has_content><span class="fa arrow"></span></#if>
            </a>
            <#if menu.children?has_content>
                <ul class="nav nav-level-${level+1} collapse">
                    <@navbarSubMenu current=current menus=menu.children level=level+1 />
                </ul>
            </#if>
        </li>
    </#list>
</#macro>

<#-- select表单的option -->
<#macro options list value="" >
    <#list list as record>
        <option value="${record.optionValue}" ${(record.optionValue == value)?then('selected', '')} <#if record.optionExtra?has_content>data-extra="${record.optionExtra?html}"</#if>>
            ${record.optionText}
        </option>
    </#list>
</#macro>

<#-- radio表单项 -->
<#macro radios list name value="" >
    <#list list as record>
        <label>
            <input type="radio" name="${name}"
                   value="${record.optionValue}" ${(record.optionValue == value)?then('checked', '')}
                    <#if record.optionExtra?has_content>data-extra="${record.optionExtra?html}"</#if>>${record.optionText}
        </label>
    </#list>
</#macro>