<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_username" class="form-required">用户名</label>
                    <input id="add_modal_username" name="username" class="form-control" placeholder="用户名">
                </div>
                <div class="form-group col-sm-6">
                    <label for="add_modal_displayName" class="form-required">昵称</label>
                    <input id="add_modal_displayName" name="displayName" class="form-control" placeholder="昵称">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="add_modal_password" class="form-required">密码</label>
                    <input id="add_modal_password" name="password" class="form-control" placeholder="密码">
                </div>
                <div class="form-group col-sm-6">
                    <label class="form-required">状态</label>
                    <div class="radio">
                        <@c.radios statusOptions 'status' '1'/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_type" class="form-required">类型</label>
                    <div class="radio">
                        <@c.radios typeOptions 'type' 'admin'/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_remark">备注</label>
                    <textarea id="add_modal_remark" name="remark" class="form-control" placeholder="备注"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>