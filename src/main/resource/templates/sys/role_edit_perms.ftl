<#-- @ftlvariable name="perms" type="java.util.Map<String,java.util.List<com.jiuyue.novel.common.SelectOption>>" -->
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-12">
                    <label>权限</label>
                    <div class="radio row">
                        <#list perms?keys as group>
                            <div class="col-sm-12">${group}</div>
                            <#list perms[group] as perm>
                                <div class="col-sm-4">
                                    <label><input type="checkbox" name="perms"
                                                  value="${perm.optionValue!''}" ${perm.optionExtra!''}> ${perm.optionText!''}
                                    </label>
                                </div>
                            </#list>
                        </#list>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>