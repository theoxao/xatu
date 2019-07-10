<#-- @ftlvariable name="roles" type="java.util.List<com.jiuyue.novel.common.SelectOption>" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-12">
                    <label>角色</label>
                    <div class="radio row">
                        <#list roles as role>
                            <div class="col-sm-4">
                                <label><input type="checkbox" name="roles"
                                              value="${role.optionValue!''}" ${role.optionExtra!''}> ${role.optionText!''}
                                </label>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>