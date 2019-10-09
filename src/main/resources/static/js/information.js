function checkName() {
    $.ajax({
        url: "/login/findByName",
        data: $("#informationForm").serialize(),
        success: function (data) {
            if (data == -1) {
                bootbox.alert({
                    message: '该昵称已经注册，请更换新的昵称！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/fullinformationpage';
                    },
                });
            }
        }
    })
}

function confirmok() {
    $('#informationForm').on('hidden.bs.modal', function () {
        $("#informationForm").data('bootstrapValidator').destroy();
        $('#informationForm').data('bootstrapValidator', null);
        informationFormValidator();
    });

    $("#informationForm").bootstrapValidator('validate');//提交验证
    // $('#registerForm').data('bootstrapValidator').validate();
    if ($("#informationForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        // console.log("我进来了！");
        $.ajax({
            url: "/login/allinformation",
            data: $("#informationForm").serialize(),
            // dataType: "json",
            success: function (data) {
                // console.log("我又进来了！");
                // alert(data);
                console.log("data=" + data);
                if (data == 1) {
                    bootbox.alert({
                        message: '完善信息成功,请登录',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });
                } else if (data == -1) {
                    bootbox.alert({
                        message: '该网页已过期,请重新注册！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/registerpage';
                        },
                    });

                } else {
                    bootbox.alert({
                        message: '完善信息失败,请检查！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/fullinformationpage';
                        },
                    });
                }


            }
        })
    } else {
        // document.getElementById("informationForm").reset();
        // window.location.href = '/login/fullinformationpage';
    }
}

window.onload = function () {
    getposition();
    informationFormValidator();
    getemail_session();
}

//获取position
function getposition() {
    $.ajax({
        url: "/login/findAllPosition",
        success: function (data) {
            console.log("AllPosition=" + data);
            for (var i = 0; i < data.length; i++) {
                $("#userstatus").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
            }
        }
    })
}

//获取session
function getemail_session() {
    $.ajax({
        url: "/login/getemail_session",
        success: function (data) {
            debugger;
            console.log("AllPosition=" + data);
            if (data == -1) {
                bootbox.alert({
                    message: '该网页已过期,请重新加载！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/registerpage';
                    },
                });

            }

        }
    })
}

function informationFormValidator() {

    $("#informationForm").bootstrapValidator({

        live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证

        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的

        // submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面

        message: '通用的验证失败消息',//好像从来没出现过

        feedbackIcons: {//根据验证结果显示的各种图标

            valid: 'glyphicon glyphicon-ok',

            invalid: 'glyphicon glyphicon-remove',

            validating: 'glyphicon glyphicon-refresh'

        },
        fields: {

            username: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '昵称必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 10,

                        message: '昵称长度必须在2-10之间'

                    },
                }

            },
            password: {
                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '密码不能为空'

                    },
                    stringLength: {//检测长度

                        min: 6,

                        max: 10,

                        message: '密码长度必须在6-10之间'

                    },


                },
            },

            passwordconfirm: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '确认密码不能为空'

                    },
                    identical: {//与指定文本框比较内容相同

                        field: 'password',

                        message: '两次密码输入不一样'

                    },
                    stringLength: {//检测长度

                        min: 6,

                        max: 10,

                        message: '密码长度必须在6-10之间'

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

// function getIcode() {
//     $.ajax({
//         url: "/login/getIcode",
//         data: $("#registerForm").serialize(),
//         success: function (data) {
//             console.log("验证码:" + data);
//             $("#code1").val(data);
//
//             console.log("code1=" + $("#code1").val())
//         }
//     })
// }
//
// function checkEmailAddress() {
//     console.log("我进来了！！！");
//     $.ajax({
//         url: "/login/findByEmail",
//         data: $("#registerForm").serialize(),
//         success: function (data) {
//             if (data == -1) {
//                 bootbox.alert({
//                     message: '该邮箱已经注册，请直接登录或者更换邮箱注册！',
//                     size: 'small',
//                     // callback: function () {
//                     //     window.location.href = '/login/loginHtml';
//                     // },
//                 });
//             } else if (data == 999) {
//                 bootbox.alert({
//                     message: '数据库连接或者操作失败,请检查！',
//                     size: 'small',
//                     callback: function () {
//                         window.location.href = '/login/registerpage';
//                     },
//                 });
//             }
//         }
//     })
// }