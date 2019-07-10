(function () {
    $(function () {
        $('#skipMobileAuthBtn').click(function () {
            Confirm.show('确定要帮作者跳过手机认证吗？', function () {
                $.ajax({
                    url: `${base}/author/${author_id}/skip_auth`,
                    type: 'post',
                    success: function (result) {
                        if (result.status === 200) {
                            Alert.success("操作成功！");
                            window.location.reload();
                        } else {
                            Alert.error(result.error);
                        }
                    }
                });
            });
        });
    });
}());