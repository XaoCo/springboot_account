// 验证码
// $.idcode.setCode();
//
// $('.container').find('input').eq(2).change(function () {
//     var IsBy = $.idcode.validateCode();
//     if (IsBy) {
//         success($(this), 2);
//     } else {
//         fail($(this), 2, '验证码输入错误');
//     }
// });

// 手机号码
// var regPhoneNum = /^[0-9]{11}$/
// $('.container').find('input').eq(4).change(function () {
//     if (regPhoneNum.test($(this).val())) {
//         success($(this), 4);
//     } else {
//         fail($(this), 4, '手机号码只能为11位数字');
//     }
// });
//
// //短信验证码
// var regMsg = /111111/;
// $('.container').find('input').eq(5).change(function () {
//     if (check[4]) {
//         if (regMsg.test($(this).val())) {
//             success($(this), 5);
//         } else {
//             fail($(this), 5, '短信验证码错误');
//         }
//     } else {
//         $('.container').find('input').eq(4).parent().parent().removeClass('has-success').addClass('has-error');
//     }
//
// });


// $('#loadingButton').click(function () {
//
//     if (check[4]) {
//         $(this).removeClass('btn-primary').addClass('disabled');
//
//         $(this).html('<span class="red">59</span> 秒后重新获取');
//         var secondObj = $('#loadingButton').find('span');
//         var secondObjVal = secondObj.text();
//
//         function secondCounter() {
//
//             var secondTimer = setTimeout(function () {
//                 secondObjVal--;
//                 secondObj.text(secondObjVal);
//                 secondCounter();
//             }, 1000);
//             if (secondObjVal == 0) {
//                 clearTimeout(secondTimer);
//                 $('#loadingButton').text('重新获取校验码');
//                 $('#loadingButton').removeClass('disabled').addClass('btn-primary');
//
//             }
//         }
//
//         secondCounter();
//     } else {
//         $('.container').find('input').eq(4).parent().parent().removeClass('has-success').addClass('has-error');
//     }
//
// })


$('#tijiao').click(function (e) {
    if (!check.every(function (value) {
            return value == true;


        }
    )) {
        e.preventDefault();
        for (key in check) {
            if (!check[key]) {
                $('.container').find('input').eq(key).parent().parent().removeClass('has-success').addClass('has-error')
            }
        }
    }
});


$('#reset').click(function () {
    $('input').slice(0, 6).parent().parent().removeClass('has-error has-success');
    $('.tips').hide();
    $('.glyphicon-ok').hide();
    $('.glyphicon-remove').hide();
    check = [false, false, false, false, false, false,];

});

function checkName1() {
    $.ajax({
        url: "/login/findByNameOrEmail",
        data: $("#loginForm").serialize(),
        success: function (data) {
            if (data == 0) {
                bootbox.alert({
                    message: '该用户/邮箱还未注册，请先进行注册或者更换用户登录！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/loginHtml';
                    },
                });
            } else if (data == 999) {
                bootbox.alert({
                    message: '数据库连接或者操作失败,请检查！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/loginHtml';
                    },
                });
            }
        }
    })
};

function findUserName() {
    $.ajax({
        url: "/login/findUserName",
        data: $("#findUserNameform").serialize(),
        success: function (data) {
            debugger;
            if (data == -2) {
                bootbox.alert({
                    message: '该邮箱还未注册，请先进行注册或者更换用户登录！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/loginHtml';
                    },
                });
            } else if (data == -1) {
                bootbox.alert({
                    message: '该邮箱暂未设置用户名,请直接用邮箱登陆!',
                    size: 'small',
                    callback: function () {
                        window.location.href = '/login/loginHtml';
                    },
                });
            }
        }
    })
}

//找回密码
function findPassword() {
    debugger;
    $("#findPwdform").bootstrapValidator('validate');//提交验证
    if ($("#findPwdform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码

        $.ajax({
            url: "/login/findPwd",
            data: $("#findPwdform").serialize(),
            success: function (data) {
                debugger;
                if (data == -1) {
                    bootbox.alert({
                        message: '密码更新失败!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });
                } else if (data == -2) {
                    bootbox.alert({
                        message: '该邮箱或者用户名还未注册过,请先进行注册!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/registerpage';
                        },
                    });
                } else {
                    bootbox.alert({
                        message: '密码重置成功,请登录!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });
                }
            }
        })
    }
}

function login() {
    $("#loginForm").bootstrapValidator('validate');//提交验证
    if ($("#loginForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        // $("#tijiao").attr("readonly", false);
        $.ajax({
            url: "/login/userLogin",
            data: $("#loginForm").serialize(),
            success: function (data) {
                if (data == -1) {
                    bootbox.alert({
                        message: '姓名或密码为空，请重新输入',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });
                } else if (data == 0) {
                    bootbox.alert({
                        message: '登录成功！',
                        size: 'small',
                        closeButton: 'false',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                } else if (data == 2) {
                    bootbox.alert({
                        message: '该用户还未注册，请先进行注册！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/registerpage';
                        },
                    });
                } else {
                    bootbox.alert({
                        message: '姓名或者密码错误，请检查后登录！',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
                        },
                    });
                }
            }
        })
    } else {
        // $("#tijiao").attr("readonly", true);
        $("#drag").empty();
        $('#drag').drag();
    }
};

window.onload = function () {
    // loginformValidator();

}

//登录验证
// function loginformValidator() {

$("#loginForm").bootstrapValidator({
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

                    message: '用户名必须输入'

                },
                stringLength: {//检测长度

                    min: 2,

                    max: 20,

                    message: '用户名长度必须在2-20之间'

                },
            }

        },
        password: {

            validators: {

                notEmpty: {//检测非空,radio也可用

                    message: '密码必须输入'

                },
                stringLength: {//检测长度

                    min: 6,

                    max: 10,

                    message: '密码长度必须在6-10之间'

                },

            }

        },

    }

});
// }


//找回密码弹出框验证
// function findPwdformValidator() {

$("#findPwdform").bootstrapValidator({
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

        email1: {

            validators: {

                notEmpty: {//检测非空,radio也可用

                    message: '邮箱/用户名必须输入'

                },
                // stringLength: {//检测长度
                //
                //     min: 2,
                //
                //     max: 10,
                //
                //     message: '用户名长度必须在2-10之间'
                //
                // },
            }

        },
        password1: {

            validators: {

                notEmpty: {//检测非空,radio也可用

                    message: '密码必须输入'

                },
                stringLength: {//检测长度

                    min: 6,

                    max: 10,

                    message: '密码长度必须在6-10之间'

                },

            }

        },

        passwordconfirm: {

            validators: {

                notEmpty: {//检测非空,radio也可用

                    message: '确认密码不能为空'

                },
                identical: {//与指定文本框比较内容相同

                    field: 'password1',

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
        // idcode: {
        //
        //     validators: {
        //
        //         notEmpty: {//检测非空,radio也可用
        //
        //             message: '验证码必须输入'
        //
        //         },
        //         different: {//与指定文本框比较内容相同
        //
        //                 field: 'idcode1',
        //
        //                 message: '验证码输入有误'
        //
        //             },
        //     }
        //
        // },
        //
        // endDate: {
        //
        //     validators: {
        //
        //         notEmpty: {//检测非空,radio也可用
        //
        //             message: '目标最终期限必须输入'
        //
        //         }
        //
        //     }
        //
        // },
    }

});

// }
function keyLogin() {
    if (event.keyCode == 13)  //回车键的键值为13
        document.getElementById("tijiao").click(); //调用登录按钮的登录事件
}
