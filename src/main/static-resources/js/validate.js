$(function () {

    /**
     *
     * @define errorShowIn 错误信息显示位置:input 清空输入框后,在输入框中显示 ,after 在输入框之后显示 ,label 在对应标签后显示
     */
    const validateGroup = {
        number: {
            condition: "isNaN(value) || value%1 !==0 ",
            errorShowIn: "input",
            message: "请输入整数数字"
        },
        digits: {condition: "isNaN(value)", errorShowIn: "input", message: "请输入数字"},
        mobile: {
            condition: "(value.length !== 11 && value.length !== 10 && value.length !== 8) || (value.length === 11 && value.charAt(0) !== '1') || isNaN(value)",
            errorShowIn: "after",
            message: "手机号格式错误"
        },
        identityNo: {condition: "(value.length < 8 || value.length > 18)", errorShowIn: "after", message: "身份证号码格式错误"},
        qq: {condition: "!/^[1-9][0-9]{3,15}$/.test(value) || isNaN(value)", errorShowIn: "after", message: "QQ号码格式错误"},
        zipCode: {condition: "/^[0-9][0-9]{5}$/.test(value) || isNaN(value)", errorShowIn: "after", message: "邮编格式错误"},
        email: {condition: " /\w@\w*\.\w/.test(value)", errorShowIn: "after", message: "邮箱格式错误"}
    };

    (function () {
        $("input[data-validate]").on("change", function () {
            const type = $(this).attr("data-validate");
            let value = $(this).val();
            console.log(parseInt(value));
            const target = eval("validateGroup." + type);
            if (eval(target.condition)) {
                if (target.errorShowIn === "input") {
                    $(this).val("");
                    $(this).attr("placeholder", target.message);
                }
                if (target.errorShowIn === "after") {
                    $(this).closest('.form-group').append($('<p class="error"></p>').text(target.message));
                }
                if (target.errorShowIn === "label") {
                    $("label[for='" + $(this).attr("id") + "']").append($('<span class="error"></span>').text(target.message))
                }
                twinkle($(this), "twinkle", 2);
            }
        });
        $("input[data-validate]").on("input", function () {
            $(this).closest('.form-group').find(".error").remove();
        })
    })();
});

