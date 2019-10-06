

function checkName2() {
    $.ajax({
        url: "/login/findByName",
        data: $("#registerForm").serialize(),
        success: function (data) {
            if (data == -1) {
                bootbox.alert({
                    message: '该用户已经注册，请直接登录或者更换新的姓名！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/registerpage';
                    },
                });
            }
        }
    })
}

function register() {
    $("#registerForm").bootstrapValidator('validate');//提交验证
    // $('#registerForm').data('bootstrapValidator').validate();
    if ($("#registerForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        // console.log("我进来了！");
        $.ajax({
            url: "/login/userRegister",
            data: $("#registerForm").serialize(),
            // dataType: "json",
            success: function (data) {
                // console.log("我又进来了！");
                // alert(data);
                console.log("data=" + data);
                if (data == 1) {
                    bootbox.alert({
                        message: '注册成功，请完善信息',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/fullinformationpage';
                        },
                    });
                } else if (data == 0) {
                    bootbox.alert({
                        message: '注册失败，请检查！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/registerpage';
                        },
                    });
                } else {
                    bootbox.alert({
                        message: '该姓名已经注册，请直接登录！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });

                }


            }
        })
    } else {
    }
}

window.onload = function () {
    // getposition();
    registerformValidator();
}

//获取家庭地位
function getposition() {
    $.ajax({
        url: "/login/findAllPosition",
        success: function (data) {
            console.log("AllPosition=" + data);
            for (var i = 0; i < data.length; i++) {
                $("#position").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
            }
        }
    })
}

function registerformValidator() {

    $("#registerForm").bootstrapValidator({

        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证

        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的

        // submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面

        message: '通用的验证失败消息',//好像从来没出现过

        feedbackIcons: {//根据验证结果显示的各种图标

            valid: 'glyphicon glyphicon-ok',

            // invalid: 'glyphicon glyphicon-remove',

            validating: 'glyphicon glyphicon-refresh'

        },
        fields: {

            mails: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '邮箱地址必须输入'

                    },
                    regexp: {
                        regexp: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
                        message: '请输入正确的邮箱地址'
                    },
                }

            },
            code1: {



            },

            code: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '验证码不能为空'

                    },
                    identical: {//与指定文本框比较内容相同

                        field: 'code1',

                        message: '验证码输入有误'

                    },
                    // identical: {
                    //     field: 'code1',
                    //     message: 'The password and its confirm are not the same'
                    // },
                }

            },
        }

    });
}

function getIcode() {
    $.ajax({
        url: "/login/getIcode",
        data: $("#registerForm").serialize(),
        success: function (data) {
            console.log("验证码:" + data);
            $("#code1").val(data);

            console.log("code1=" + $("#code1").val())
        }
    })
}

function checkEmailAddress() {
    console.log("我进来了！！！");
    $.ajax({
        url: "/login/findByEmail",
        data: $("#registerForm").serialize(),
        success: function (data) {
            if (data == -1) {
                bootbox.alert({
                    message: '该邮箱已经注册，请直接登录或者更换邮箱注册！',
                    size: 'small',
                    // callback: function () {
                    //     window.location.href = '/login/loginHtml';
                    // },
                });
            } else if (data == 999) {
                bootbox.alert({
                    message: '数据库连接或者操作失败,请检查！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/registerpage';
                    },
                });
            }
        }
    })
}