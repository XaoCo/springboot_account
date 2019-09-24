<!--个人收支柱状图-->
var myChart1 = echarts.init(document.getElementById('demo1'));

var option1 = {
    // ----  标题 -----
    title: {
        text: '收支概览',
        x: 'center'
    },

    tooltip: {
        show: true,   // 是否显示提示框，默认为true
        trigger: 'item', // 数据项图形触发
        axisPointer: {   // 指示样式
            type: 'shadow',
            axis: 'auto'
        },
        padding: 5,
        textStyle: {   // 提示框内容的样式
            color: '#fff'
        }
    },
    gird: {
        show: false,    // 是否显示直角坐标系网格
        top: 80,  // 相对位置 top\bottom\left\right
        containLabel: false, // gird 区域是否包含坐标轴的刻度标签
        tooltip: {
            show: true,
            trigger: 'item',   // 触发类型
            textStyle: {
                color: '#666'
            }
        }
    },

    xAxis: {
        position: 'bottom',  // x轴的位置
        offset: 0, // x轴相对于默认位置的偏移
        type: 'category',
        // width:200,
        axisLine: {       // 坐标轴 轴线
            show: true,  // 是否显示
            symbol: ['none', 'arrow'],  // 是否显示轴线箭头
            symbolSize: [5, 8], // 箭头大小
            symbolOffset: [0, 5],  // 箭头位置
            // ------   线 ---------
            lineStyle: {
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisTick: {    // 坐标轴 刻度
            show: true,  // 是否显示
            inside: true,  // 是否朝内
            length: 3,     // 长度
            lineStyle: {   // 默认取轴线的样式
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisLabel: {    // 坐标轴标签
            show: true,  // 是否显示
            inside: false, // 是否朝内
            rotate: 0, // 旋转角度
            margin: 5, // 刻度标签与轴线之间的距离
            color: 'black', // 默认取轴线的颜色

        },
        data: ['收入', '支出']
    },
    yAxis: {
        show: true,  // 是否显示
        position: 'left', // y轴位置
        offset: 0, // y轴相对于默认位置的偏移
        type: 'value',  // 轴类型，默认为 ‘category’
        name: '金额',   // 轴名称
        nameLocation: 'end', // 轴名称相对位置value
        nameTextStyle: {    // 坐标轴名称样式
            color: 'black',
            padding: [5, 0, 0, 5]  // 坐标轴名称相对位置
        },
        nameGap: 15, // 坐标轴名称与轴线之间的距离
        nameRotate: 360,  // 坐标轴名字旋转

        axisLine: {    // 坐标轴 轴线
            show: true,  // 是否显示
            //  -----   箭头 -----
            symbol: ['none', 'arrow'],  // 是否显示轴线箭头
            symbolSize: [5, 8],  // 箭头大小
            symbolOffset: [0, 7], // 箭头位置

            // ----- 线 -------
            lineStyle: {
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisTick: {      // 坐标轴的刻度
            show: true,    // 是否显示
            inside: true,  // 是否朝内
            length: 3,      // 长度
            lineStyle: {
                color: 'black',  // 默认取轴线的颜色
                width: 1,
                type: 'solid'
            }
        },
        axisLabel: {      // 坐标轴的标签
            show: true,    // 是否显示
            inside: false,  // 是否朝内
            rotate: 0,     // 旋转角度
            margin: 8,     // 刻度标签与轴线之间的距离
            color: 'black',  // 默认轴线的颜色
        },
        splitLine: {    // gird 区域中的分割线
            show: true,   // 是否显示
            lineStyle: {
                color: '#666',
                width: 1,
                type: 'dashed'
            }
        },
        splitArea: {     // 网格区域
            show: false   // 是否显示，默认为false
        }
    },
    series: [{
        data: [120, 200],
        name: '销量',      // 序列名称
        type: 'bar',      // 类型
        legendHoverLink: true,  // 是否启用图列 hover 时的联动高亮
        label: {   // 图形上的文本标签
            show: false,
            position: 'insideTop', // 相对位置
            rotate: 0,  // 旋转角度
            color: '#eee'
        },
        itemStyle: {    // 图形的形状
            // color: 'red',
            // barBorderRadius: [18, 18, 0 ,0]
        },
        barWidth: 40,  // 柱形的宽度
        barCategoryGap: '5%',  // 柱形的间距
    }]
};
myChart1.setOption(option1);
//together收支柱状图
var myChart4 = echarts.init(document.getElementById('demo4'));

var option4 = {
    // ----  标题 -----
    title: {
        text: '收支概览',
        x: 'center'
    },

    tooltip: {
        show: true,   // 是否显示提示框，默认为true
        trigger: 'item', // 数据项图形触发
        axisPointer: {   // 指示样式
            type: 'shadow',
            axis: 'auto'
        },
        padding: 5,
        textStyle: {   // 提示框内容的样式
            color: '#fff'
        }
    },
    gird: {
        show: false,    // 是否显示直角坐标系网格
        top: 80,  // 相对位置 top\bottom\left\right
        containLabel: false, // gird 区域是否包含坐标轴的刻度标签
        tooltip: {
            show: true,
            trigger: 'item',   // 触发类型
            textStyle: {
                color: '#666'
            }
        }
    },

    xAxis: {
        position: 'bottom',  // x轴的位置
        offset: 0, // x轴相对于默认位置的偏移
        type: 'category',
        // width:200,
        axisLine: {       // 坐标轴 轴线
            show: true,  // 是否显示
            symbol: ['none', 'arrow'],  // 是否显示轴线箭头
            symbolSize: [5, 8], // 箭头大小
            symbolOffset: [0, 5],  // 箭头位置
            // ------   线 ---------
            lineStyle: {
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisTick: {    // 坐标轴 刻度
            show: true,  // 是否显示
            inside: true,  // 是否朝内
            length: 3,     // 长度
            lineStyle: {   // 默认取轴线的样式
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisLabel: {    // 坐标轴标签
            show: true,  // 是否显示
            inside: false, // 是否朝内
            rotate: 0, // 旋转角度
            margin: 5, // 刻度标签与轴线之间的距离
            color: 'black', // 默认取轴线的颜色

        },
        data: ['收入', '支出']
    },
    yAxis: {
        show: true,  // 是否显示
        position: 'left', // y轴位置
        offset: 0, // y轴相对于默认位置的偏移
        type: 'value',  // 轴类型，默认为 ‘category’
        name: '金额',   // 轴名称
        nameLocation: 'end', // 轴名称相对位置value
        nameTextStyle: {    // 坐标轴名称样式
            color: 'black',
            padding: [5, 0, 0, 5]  // 坐标轴名称相对位置
        },
        nameGap: 15, // 坐标轴名称与轴线之间的距离
        nameRotate: 360,  // 坐标轴名字旋转

        axisLine: {    // 坐标轴 轴线
            show: true,  // 是否显示
            //  -----   箭头 -----
            symbol: ['none', 'arrow'],  // 是否显示轴线箭头
            symbolSize: [5, 8],  // 箭头大小
            symbolOffset: [0, 7], // 箭头位置

            // ----- 线 -------
            lineStyle: {
                color: 'black',
                width: 1,
                type: 'solid'
            }
        },
        axisTick: {      // 坐标轴的刻度
            show: true,    // 是否显示
            inside: true,  // 是否朝内
            length: 3,      // 长度
            lineStyle: {
                color: 'black',  // 默认取轴线的颜色
                width: 1,
                type: 'solid'
            }
        },
        axisLabel: {      // 坐标轴的标签
            show: true,    // 是否显示
            inside: false,  // 是否朝内
            rotate: 0,     // 旋转角度
            margin: 8,     // 刻度标签与轴线之间的距离
            color: 'black',  // 默认轴线的颜色
        },
        splitLine: {    // gird 区域中的分割线
            show: true,   // 是否显示
            lineStyle: {
                color: '#666',
                width: 1,
                type: 'dashed'
            }
        },
        splitArea: {     // 网格区域
            show: false   // 是否显示，默认为false
        }
    },
    series: [{
        data: [120, 200],
        name: '销量',      // 序列名称
        type: 'bar',      // 类型
        legendHoverLink: true,  // 是否启用图列 hover 时的联动高亮
        label: {   // 图形上的文本标签
            show: false,
            position: 'insideTop', // 相对位置
            rotate: 0,  // 旋转角度
            color: '#eee'
        },
        itemStyle: {    // 图形的形状
            // color: 'red',
            // barBorderRadius: [18, 18, 0 ,0]
        },
        barWidth: 40,  // 柱形的宽度
        barCategoryGap: '5%',  // 柱形的间距
    }]
};
myChart4.setOption(option4);

//个人收入饼图

var myChart2 = echarts.init(document.getElementById('demo2'));

var option2 = {
    title: {
        text: '收入明细',
        subtext: 'Personal',
        x: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['工资', '外快', '私活']
    },
    series: [
        {
            name: '收入明细',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 335, name: '工资'},
                {value: 310, name: '外快'},
                {value: 234, name: '私活'},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart2.setOption(option2);

//个人支出饼图

var myChart3 = echarts.init(document.getElementById('demo3'));

var option3 = {
    title: {
        text: '开支明细',
        subtext: 'Personal',
        x: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['日常用品', '人情+礼物', '下馆子', '买菜', '公交打车']
    },
    series: [
        {
            name: '开支明细',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 335, name: '日常用品'},
                {value: 310, name: '人情+礼物'},
                {value: 234, name: '下馆子'},
                {value: 135, name: '买菜'},
                {value: 1548, name: '公交打车'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart3.setOption(option3);

//together收入饼图

var myChart5 = echarts.init(document.getElementById('demo5'));

var option5 = {
    title: {
        text: '收入明细',
        subtext: 'Family',
        x: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['工资', '外快', '私活']
    },
    series: [
        {
            name: '收入明细',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 335, name: '工资'},
                {value: 310, name: '外快'},
                {value: 234, name: '私活'},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart5.setOption(option5);

//together支出饼图

var myChart6 = echarts.init(document.getElementById('demo6'));

var option6 = {
    title: {
        text: '开支明细',
        subtext: 'Family',
        x: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['日常用品', '人情+礼物', '下馆子', '买菜', '公交打车']
    },
    series: [
        {
            name: '开支明细',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
                {value: 335, name: '日常用品'},
                {value: 310, name: '人情+礼物'},
                {value: 234, name: '下馆子'},
                {value: 135, name: '买菜'},
                {value: 1548, name: '公交打车'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart6.setOption(option6);

//okr编辑
function okrmodify() {
    debugger;
    $("#okr1").removeAttr("readonly")
    $("#okr2").removeAttr("readonly")
    $("#okr3").removeAttr("readonly")
    $("#okr4").removeAttr("readonly")
};
//个人信息编辑
function informationmodify() {
    debugger;
    $("#userjob").removeAttr("readonly")
};

//okr确认
function okrconfirm() {
    debugger;
    $("#okr1").attr("readonly", "readonly");
    $("#okr2").attr("readonly", "readonly");
    $("#okr3").attr("readonly", "readonly");
    $("#okr4").attr("readonly", "readonly");
};
//个人信息确认
function informationconfirm() {
    debugger;
    $("#userjob").attr("readonly", "readonly");
    $.ajax({
        url: "/user/confirmInformation",
        data: $("#personalmsgform").serialize(),
        success: function (data) {
            debugger;
            if (data== 1) {
                bootbox.alert({
                    message: '个人信息更新成功！',
                    size: 'small'
                    // callback: function () {
                    //     window.location.href = '#mdfpwdpage';
                    // },
                });
            }
        }
    })
    $("#personalmsgpage").modal("hide");

};

//okr取消

function okrcancel() {
    debugger;
    var str1 = $("#okr1").val();
    console.log("str1=" + str1)
    var str2 = $("#okr2").val();
    console.log("str2=" + str2)
    var str3 = $("#okr3").val();
    console.log("str3=" + str3)
    var str4 = $("#okr4").val();
    console.log("str4=" + str4)

    $("#okr1").attr("readonly", "readonly");
    $("#okr2").attr("readonly", "readonly");
    $("#okr3").attr("readonly", "readonly");
    $("#okr4").attr("readonly", "readonly");
}

window.onload = function () {
    goalformValidator();
    outformValidator();
    preformValidator();
    newinformValidator();
    changepwdformValidator();
    // getAllOutKind();
    // getAllInKind();
    // getAllPreKind();
    // findInformation();

}

//新目标表单清空
function newgoal() {

    document.getElementById("newgoalform").reset();
    $('#newgoalpage').on('hidden.bs.modal', function () {
        $("#newgoalform").data('bootstrapValidator').destroy();
        $('#newgoalform').data('bootstrapValidator', null);
        goalformValidator();
    });
}

//新支出表单清空
function newout() {
    $.ajax({
        url: "/kind/findAlloutKind",
        success: function (data) {
            debugger;
            console.log("AllOutKind=" + data);
            for (var i = 0; i < data.length; i++) {
                $("#outName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
            }
        }
    })
    document.getElementById("newOutform").reset();
    $('#newoutpage').on('hidden.bs.modal', function () {
        $("#newOutform").data('bootstrapValidator').destroy();
        $('#newOutform').data('bootstrapValidator', null);
        outformValidator()
    });
};

//新预留支出表单清空
function preout() {
    $.ajax({
        url: "/kind/findAllpreKind",
        success: function (data) {
            debugger;
            console.log("AllpreKind=" + data);
            for (var i = 0; i < data.length; i++) {
                $("#preOutName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
            }
        }
    })
    document.getElementById("preOutform").reset();
    $('#resoutpage').on('hidden.bs.modal', function () {
        $("#preOutform").data('bootstrapValidator').destroy();
        $('#preOutform').data('bootstrapValidator', null);
        preformValidator();
    });
}

//新收入表单清空
function newin() {
    $.ajax({
        url: "/kind/findAllinKind",
        success: function (data) {
            debugger;
            console.log("AllinKind=" + data);
            for (var i = 0; i < data.length; i++) {
                $("#inName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
            }
        }
    })
    document.getElementById("newinform").reset();
    $('#newinpage').on('hidden.bs.modal', function () {
        $("#newinform").data('bootstrapValidator').destroy();
        $('#newinform').data('bootstrapValidator', null);
        newinformValidator();
    });
}

$(function () {
    $('#endDate,#datetimepickerout,#datetimepickerpreout,#datetimepickerin').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    // $('#datetimepicker2').datetimepicker({
    //     format: 'YYYY-MM-DD hh:mm',
    //     locale: moment.locale('zh-cn')
    // });
});

//新增目标提交按钮
function addgoal() {
    $("#newgoalform").bootstrapValidator('validate');//提交验证
    if ($("#newgoalform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        $.ajax({
            url: "/goal/addGoal",
            data: $("#newgoalform").serialize(),
            success: function (data) {
                debugger;
                // $("#newgoalpage").attr("data-dismiss","model");
                // $("#newgoalpage").attr("aria-hidden","true");
                if (data == 1) {
                    bootbox.alert({
                        message: '新增目标成功,继续加油!',
                        size: 'small'
                    });
                } else {
                    bootbox.alert({
                        message: '新增目标失败,请检查!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                }
                $("#newgoalpage").modal("hide");

            }
        })
    }
};

// 新增支出提交按钮addnewout
function addnewout() {
    $("#newOutform").bootstrapValidator('validate');//提交验证
    if ($("#newOutform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        $.ajax({
            url: "/record/addoutRecord",
            data: $("#newOutform").serialize(),
            success: function (data) {
                debugger;
                if (data == 1) {
                    bootbox.alert({
                        message: '新增开支成功!',
                        size: 'small'
                    });
                } else {
                    bootbox.alert({
                        message: '新增开支失败,请检查!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                }
                $("#newoutpage").modal("hide");

            }
        })
    }
};

// 新增预留支出提交按钮
function addpreout() {
    $("#preOutform").bootstrapValidator('validate');//提交验证
    if ($("#preOutform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        $.ajax({
            url: "/record/addpreoutRecord",
            data: $("#preOutform").serialize(),
            success: function (data) {
                debugger;
                if (data == 1) {
                    bootbox.alert({
                        message: '新增预留开支成功!',
                        size: 'small'
                    });
                } else {
                    bootbox.alert({
                        message: '新增预留开支失败,请检查!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                }
                $("#resoutpage").modal("hide");

            }
        })
    }
};

// 新增收入提交按钮
function addnewin() {
    $("#newinform").bootstrapValidator('validate');//提交验证
    if ($("#newinform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        $.ajax({
            url: "/record/addinRecord",
            data: $("#newinform").serialize(),
            success: function (data) {
                debugger;
                if (data == 1) {
                    bootbox.alert({
                        message: '新增收入成功!',
                        size: 'small'
                    });
                } else {
                    bootbox.alert({
                        message: '新增收入失败,请检查!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                }
                $("#newinpage").modal("hide");

            }
        })
    }
};

// 修改密码提交按钮
function modifyPassword() {
    $("#mdfpwdform").bootstrapValidator('validate');//提交验证
    if ($("#mdfpwdform").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
        $.ajax({
            url: "/user/updpassword",
            data: $("#mdfpwdform").serialize(),
            success: function (data) {
                debugger;
                if (data == 1) {
                    bootbox.alert({
                        message: '修改密码成功!',
                        size: 'small'
                    });
                } else {
                    bootbox.alert({
                        message: '修改密码失败,请检查!',
                        size: 'small',
                        callback: function () {
                            window.location.href = '/user/indexPage';
                        },
                    });
                }
                $("#mdfpwdpage").modal("hide");

            }
        })
    }
};


function goalformValidator() {
//新增goal表单验证
    $("#newgoalform").bootstrapValidator({
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

            goalName: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'goalName必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: 'goalName长度必须在2-20之间'

                    },
                }

            },
            goalDesc: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'goalDesc必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: 'goalDesc长度必须在2-20之间'

                    },
                }

            },
            goalTotal: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '目标总计划必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: 'goalTotal长度必须在2-20之间'

                    },
                }

            },

            endDate: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '目标最终期限必须输入'

                    }

                }

            },
        }

    });
}

function outformValidator() {
//新增支出表单验证
    $("#newOutform").bootstrapValidator({
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

            outName: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'outName必须选择'

                    },

                }

            },
            outDesc: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '支出简述必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: '支出简述长度必须在2-20之间'

                    },
                }

            },
            outAccount: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '支出金额必须输入'

                    },
                    regexp: {//正则验证

                        regexp: /^[0-9_\.]+$/,

                        message: '所输入的金额不符要求'

                    },
                }

            },

            newoutdate: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '开支日期必须输入'

                    }

                }

            },
        }

    });


};

function preformValidator() {
//新增预留支出表单验证
    $("#preOutform").bootstrapValidator({
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

            preOutName: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'outName必须选择'

                    },

                }

            },
            preoutDesc: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '预留支出简述必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: '支出简述长度必须在2-20之间'

                    },
                }

            },
            preoutAccount: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '预留支出金额必须输入'

                    },
                    regexp: {//正则验证

                        regexp: /^[0-9_\.]+$/,

                        message: '所输入的金额不符要求'

                    },
                }

            },

            preoutdate: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '预留开支日期必须输入'

                    }

                }

            },
        }

    });


}

function newinformValidator() {
//新增预留支出表单验证
    $("#newinform").bootstrapValidator({
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

            inName: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '收入类型必须选择'

                    },

                }

            },
            inDesc: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '收入简述必须输入'

                    },
                    stringLength: {//检测长度

                        min: 2,

                        max: 20,

                        message: '支出简述长度必须在2-20之间'

                    },
                }

            },
            inAccount: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '收入金额必须输入'

                    },
                    regexp: {//正则验证

                        regexp: /^[0-9_\.]+$/,

                        message: '所输入的金额不符要求'

                    },
                }

            },

            newindate: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '收入日期必须输入'

                    }

                }

            },
        }

    });


}

function changepwdformValidator() {
//修改密码表单验证
    $("#mdfpwdform").bootstrapValidator({
        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证

        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的

        // submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面

        message: '通用的验证失败消息',//好像从来没出现过

        feedbackIcons: {//根据验证结果显示的各种图标

            valid: 'glyphicon glyphicon-ok',

            invalid: 'glyphicon glyphicon-remove',

            validating: 'glyphicon glyphicon-refresh'

        },
        fields: {

            prepwd: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '原密码不能为空'

                    }

                }

            },
            newpwd: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '新密码不能为空'

                    }
                }

            },
            newpwdconfirm: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: '请确认新密码'

                    },
                    // different: {//与指定文本框比较内容相同
                    //
                    //     field: newpwd,
                    //
                    //     message: '两次密码输入的不一样'
                    //
                    // }
                    identical: {//与指定控件内容比较是否相同，比如两次密码不一致

                            field: 'newpwd',//指定控件name

                            message: '两次密码输入的不一样'

                        }
                }

            }


        }

    });
}

//获取开支种类
// function getAllOutKind() {
//     $.ajax({
//         url:"/kind/findAlloutKind",
//         success:function (data) {
//             debugger;
//             console.log("AllOutKind=" + data);
//             for (var i = 0; i < data.length; i++) {
//                 $("#outName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
//             }
//         }
//     })
// }
// //获取收入种类
// function getAllInKind() {
//     $.ajax({
//         url:"/kind/findAllinKind",
//         success:function (data) {
//             debugger;
//             console.log("AllinKind="+data);
//             for (var i = 0; i < data.length; i++) {
//                 $("#inName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
//             }
//         }
//     })
// }
//获取预留种类
// function getAllPreKind() {
//     $.ajax({
//         url:"/kind/findAllpreKind",
//         success:function (data) {
//             debugger;
//             console.log("AllpreKind="+data);
//             for (var i = 0; i < data.length; i++) {
//                 $("#preOutName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
//             }
//         }
//     })
// }
//获取预留种类
// function getAllPreKind() {
//     $.ajax({
//         url:"/kind/findAllpreKind",
//         success:function (data) {
//             debugger;
//             console.log("AllpreKind="+data);
//             for (var i = 0; i < data.length; i++) {
//                 $("#preOutName").append($("<option value=\"" + data[i] + "\">" + data[i] + "</option>"));
//             }
//         }
//     })
// }

//获取个人信息
function findInformation() {
    // $("#userjob").attr("readonly", "readonly");
    $("#userjob").removeAttr("readonly");
    document.getElementById("personalmsgform").reset();
    $.ajax({
        url: "/user/findInformation",
        success: function (data) {
            debugger;
            console.log("基本信息=" + data);
            $("#username").attr("value", data.name);
            $("#mdfpwdsername").attr("value", data.name);
            $("#userjob").attr("value", data.job);
            $("#userjob").attr("readonly", "readonly");
            $("#userposition").append($("<option value=\"" + data.position + "\">" + data.position + "</option>"));

        }
    })
}

//修改密码原密码输入正确与否反馈
function checkPrePwd() {
    $.ajax({
        url: "/user/findInformation",
        success: function (data) {
            debugger;
            console.log("基本信息=" + data);
            // $("#mdfpwdsername").attr("value",data.name);
            var pwd = $("#prepwd").val();
            if (data.password != pwd) {
                bootbox.alert({
                    message: '原始密码输入错误！',
                    size: 'small',
                    callback: function () {
                        window.location.href = '#mdfpwdpage';
                    },
                });
            }
        }
    })
}
//回显用户名
function showInformation() {
    document.getElementById("mdfpwdform").reset();
    $('#mdfpwdpage').on('hidden.bs.modal', function () {
        $("#mdfpwdform").data('bootstrapValidator').destroy();
        $('#mdfpwdform').data('bootstrapValidator', null);
        changepwdformValidator();
    });
    $.ajax({
        url: "/user/findInformation",
        success: function (data) {
            debugger;
            console.log("基本信息=" + data);
            $("#mdfpwdsername").attr("value",data.name);

        }

    })
}
