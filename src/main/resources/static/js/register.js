var settings = {
        e: 'idcode',
        codeType: {
            name: 'follow',
            len: 4
        }, //len是修改验证码长度的
        codeTip: '换个验证码?',
        inputID: 'idcode-btn' //验证元素的ID
    };

    var _set = {
        storeLable: 'codeval',
        store: '#ehong-code-input',
        codeval: '#ehong-code'
    }
    $.idcode = {
        getCode: function (option) {
            _commSetting(option);
            return _storeData(_set.storeLable, null);
        },
        setCode: function (option) {
            _commSetting(option);
            _setCodeStyle("#" + settings.e, settings.codeType.name, settings.codeType.len);

        },
        validateCode: function (option) {
            _commSetting(option);
            var inputV;
            if (settings.inputID) {
                inputV = $('#' + settings.inputID).val();

            } else {
                inputV = $(_set.store).val();
            }
            if (inputV.toUpperCase() == _storeData(_set.storeLable, null).toUpperCase()) { //修改的不区分大小写
                return true;
            } else {
                _setCodeStyle("#" + settings.e, settings.codeType.name, settings.codeType.len);
                return false;
            }
        }
    };

    function _commSetting(option) {
        $.extend(settings, option);
    }

    function _storeData(dataLabel, data) {
        var store = $(_set.codeval).get(0);
        if (data) {
            $.data(store, dataLabel, data);
        } else {
            return $.data(store, dataLabel);
        }
    }

    function _setCodeStyle(eid, codeType, codeLength) {
        var codeObj = _createCode(settings.codeType.name, settings.codeType.len);
        var randNum = Math.floor(Math.random() * 6);
        var htmlCode = ''
        if (!settings.inputID) {
            htmlCode = '<span><input id="ehong-code-input" type="text" maxlength="4" /></span>';
        }
        htmlCode += '<div id="ehong-code" class="ehong-idcode-val ehong-idcode-val';
        htmlCode += String(randNum);
        htmlCode += '" href="#" onblur="return false" onfocus="return false" oncontextmenu="return false" onclick="$.idcode.setCode()">' + _setStyle(codeObj) + '</div>' + '<span id="ehong-code-tip-ck" class="ehong-code-val-tip" onclick="$.idcode.setCode()">' + settings.codeTip + '</span>';
        $(eid).html(htmlCode);
        _storeData(_set.storeLable, codeObj);
    }

    function _setStyle(codeObj) {
        var fnCodeObj = new Array();
        var col = new Array('#BF0C43', '#E69A2A', '#707F02', '#18975F', '#BC3087', '#73C841', '#780320', '#90719B', '#1F72D8', '#D6A03C', '#6B486E', '#243F5F', '#16BDB5');
        var charIndex;
        for (var i = 0; i < codeObj.length; i++) {
            charIndex = Math.floor(Math.random() * col.length);
            fnCodeObj.push('<font color="' + col[charIndex] + '">' + codeObj.charAt(i) + '</font>');
        }
        return fnCodeObj.join('');
    }

    function _createCode(codeType, codeLength) {
        var codeObj;
        if (codeType == 'follow') {
            codeObj = _createCodeFollow(codeLength);
        } else if (codeType == 'calc') {
            codeObj = _createCodeCalc(codeLength);
        } else {
            codeObj = "";
        }
        return codeObj;
    }

    function _createCodeCalc(codeLength) {
        var code1, code2, codeResult;
        var selectChar = new Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        var charIndex;
        for (var i = 0; i < codeLength; i++) {
            charIndex = Math.floor(Math.random() * selectChar.length);
            code1 += selectChar[charIndex];

            charIndex = Math.floor(Math.random() * selectChar.length);
            code2 += selectChar[charIndex];
        }
        return [parseInt(code1), parseInt(code2), parseInt(code1) + parseInt(code2)];
    }

    function _createCodeFollow(codeLength) {
        var code = "";
        var selectChar = new Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

        for (var i = 0; i < codeLength; i++) {
            var charIndex = Math.floor(Math.random() * selectChar.length);
            if (charIndex % 2 == 0) {
                code += selectChar[charIndex].toLowerCase();
            } else {
                code += selectChar[charIndex];
            }
        }
        return code;
    }

    var regUsername = /^[a-zA-Z_][a-zA-Z0-9_]{4,19}$/;
    var regPasswordSpecial = /[~!@#%&=;':",./<>_\}\]\-\$\(\)\*\+\.\[\?\\\^\{\|]/;
    var regPasswordAlpha = /[a-zA-Z]/;
    var regPasswordNum = /[0-9]/;
    var regAgeNum = /[0-9]/;
    var regJob = /[a-zA-Z]/;
    var password;
    var check = [false, false, false, false, false, false];

    //校验成功函数
    function success(Obj, counter) {
        Obj.parent().parent().removeClass('has-error').addClass('has-success');
        $('.tips').eq(counter).hide();
        $('.glyphicon-ok').eq(counter).show();
        $('.glyphicon-remove').eq(counter).hide();
        check[counter] = true;

    }

    // 校验失败函数
    function fail(Obj, counter, msg) {
        Obj.parent().parent().removeClass('has-success').addClass('has-error');
        $('.glyphicon-remove').eq(counter).show();
        $('.glyphicon-ok').eq(counter).hide();
        $('.tips').eq(counter).text(msg).show();
        check[counter] = false;
    }

    // 用户名匹配
    $('.container').find('input').eq(0).change(function () {


        if (regUsername.test($(this).val())) {
            success($(this), 0);
        } else if ($(this).val().length < 5) {
            fail($(this), 0, '用户名太短，不能少于5个字符');
        } else {
            fail($(this), 0, '用户名只能为英文数字和下划线,且不能以数字开头')
        }

    });

    // 工作匹配
    $('.container').find('input').eq(1).change(function () {


        if (regJob.test($(this).val())) {
            success($(this), 1);
        } else if ($(this).val().length > 20) {
            fail($(this), 1, '不能超过20个字符');
        } else {
            fail($(this), 1, '工作只能为英文描述');
        }

    });

    // 年龄匹配
    $('.container').find('input').eq(2).change(function () {


        if (regAgeNum.test($(this).val())) {
            success($(this), 2);
        } else if (parseFloat($(this).val()) > 100 || parseFloat($(this).val()) < 18) {
            fail($(this), 2, '未成年人不能注册！');
        } else {
            fail($(this), 2, '只能为数字，不可填入其他字符！');
        }

    });


    // 密码匹配

    // 匹配字母、数字、特殊字符至少两种的函数
    function atLeastTwo(password) {
        var a = regPasswordSpecial.test(password) ? 1 : 0;
        var b = regPasswordAlpha.test(password) ? 1 : 0;
        var c = regPasswordNum.test(password) ? 1 : 0;
        return a + b + c;

    }

    $('.container').find('input').eq(3).change(function () {

        password = $(this).val();

        if ($(this).val().length < 8) {
            fail($(this), 3, '密码太短，不能少于8个字符');
        } else {


            if (atLeastTwo($(this).val()) < 2) {
                fail($(this), 3, '密码中至少包含字母、数字、特殊字符的两种')
            } else {
                success($(this), 3);
            }
        }
    });


    // 再次输入密码校验
    $('.container').find('input').eq(4).change(function () {

        if ($(this).val() == password) {
            success($(this), 4);
        } else {

            fail($(this), 4, '两次输入的密码不一致');
        }

    });


    // 验证码
    $.idcode.setCode();

    $('.container').find('input').eq(5).change(function () {
        var IsBy = $.idcode.validateCode();
        if (IsBy) {
            success($(this), 5);
        } else {
            fail($(this), 5, '验证码输入错误');
        }
    });


    $('#submit').click(function (e) {
        if (!check.every(function (value) {
            return value == true
        })) {
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
    // $("#reback").click(function () {
    //
    // })

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
        // debugger;
        // console.log("我进来了！");
        $.ajax({
            url: "/login/userRegister",
            data: $("#registerForm").serialize(),
            // dataType: "json",
            success: function (data) {
                // console.log("我又进来了！");
                // alert(data);
                console.log("data=" + data);
                debugger;
                if (data == 1) {
                    bootbox.alert({
                        message: '注册成功，请登录',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/login/loginHtml';
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
    }