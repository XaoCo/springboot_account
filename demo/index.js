<!--个人收支柱状图-->
var myChart1 = echarts.init(document.getElementById('demo1'));

var option1 = {
    // ----  标题 -----
    title: {
        text: '收支概览',
        // textStyle: {
        //     color: 'red'
        // },
        //位置
        // padding: [0, 0, 10, 150]
        x: 'center'
    },

    // legend: {
    //     type: 'plain',  // 图列类型，默认为 'plain'
    //     top: '5%',  // 图列相对容器的位置 top\bottom\left\right
    //     selected: {
    //         // '销量': true  // 图列选择，图形加载出来会显示选择的图列，默认为true
    //     },
    //     textStyle: {  // 图列内容样式
    //         color: '#fff',  // 字体颜色
    //         backgroundColor: 'black'  // 字体背景色
    //     },
    //     tooltip: {  // 图列提示框，默认不显示
    //         show: true,
    //         color: 'red'
    //     },
    //     data: [   // 图列内容
    //         {
    //             name: '销量',
    //             icon: 'circle',
    //             textStyle: {
    //                 color: 'red',  // 单独设置某一个图列的颜色
    //                 backgroundColor: '#fff' // 单独设置某一个图列的字体背景色
    //             }
    //         }
    //     ]
    // },
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
        // textStyle: {
        //     color: 'red'
        // },
        //位置
        // padding: [0, 0, 10, 100]
        x: 'center'
    },

    // legend: {
    //     type: 'plain',  // 图列类型，默认为 'plain'
    //     top: '5%',  // 图列相对容器的位置 top\bottom\left\right
    //     selected: {
    //         // '销量': true  // 图列选择，图形加载出来会显示选择的图列，默认为true
    //     },
    //     textStyle: {  // 图列内容样式
    //         color: '#fff',  // 字体颜色
    //         backgroundColor: 'black'  // 字体背景色
    //     },
    //     tooltip: {  // 图列提示框，默认不显示
    //         show: true,
    //         color: 'red'
    //     },
    //     data: [   // 图列内容
    //         {
    //             name: '销量',
    //             icon: 'circle',
    //             textStyle: {
    //                 color: 'red',  // 单独设置某一个图列的颜色
    //                 backgroundColor: '#fff' // 单独设置某一个图列的字体背景色
    //             }
    //         }
    //     ]
    // },
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

//okr确认
function okrconfirm() {
    debugger;
    $("#okr1").attr("readonly", "readonly");
    $("#okr2").attr("readonly", "readonly");
    $("#okr3").attr("readonly", "readonly");
    $("#okr4").attr("readonly", "readonly");
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

//新目标表单清空
function newgoal() {
    document.getElementById("newgoalform").reset();
}

//新支出表单清空
function newout() {
    document.getElementById("newOutform").reset();
};

//新预留支出表单清空
function preout() {
    document.getElementById("preOutform").reset();
}

//新预留支出表单清空
function newin() {
    document.getElementById("newinform").reset();
}

$(function () {
    $('#datetimepickergoal,#datetimepickerout,#datetimepickerpreout,#datetimepickerprein').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    // $('#datetimepicker2').datetimepicker({
    //     format: 'YYYY-MM-DD hh:mm',
    //     locale: moment.locale('zh-cn')
    // });
});

$(function () {

    $("#form-test").bootstrapValidator({

        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证

        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的

        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面

        message: '通用的验证失败消息',//好像从来没出现过

        feedbackIcons: {//根据验证结果显示的各种图标

            valid: 'glyphicon glyphicon-ok',

            invalid: 'glyphicon glyphicon-remove',

            validating: 'glyphicon glyphicon-refresh'

        },

        fields: {

            id: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'ID必须输入'

                    },
                }

            },
            name: {

                validators: {

                    notEmpty: {//检测非空,radio也可用

                        message: 'name必须输入'

                    },
                    stringLength: {//检测长度

                        min: 6,

                        max: 30,

                        message: 'name长度必须在6-30之间'

                    },
                }

            }

            // stringLength: {//检测长度
            //
            //     min: 6,
            //
            //     max: 30,
            //
            //     message: '长度必须在6-30之间'
            //
            // },
            //
            // regexp: {//正则验证
            //
            //     regexp: /^[a-zA-Z0-9_\.]+$/,
            //
            //     message: '所输入的字符不符要求'
            //
            // },
            //
            // remote: {//将内容发送至指定页面验证，返回验证结果，比如查询用户名是否存在
            //
            //     url: '指定页面',
            //
            //     message: 'The username is not available'
            //
            // },
            //
            // different: {//与指定文本框比较内容相同
            //
            //     field: '指定文本框name',
            //
            //     message: '不能与指定文本框内容相同'
            //
            // },
            //
            // emailAddress: {//验证email地址
            //
            //     message: '不是正确的email地址'
            //
            // },
            //
            // identical: {//与指定控件内容比较是否相同，比如两次密码不一致
            //
            //     field: 'confirmPassword',//指定控件name
            //
            //     message: '输入的内容不一致'
            //
            // },
            //
            // date: {//验证指定的日期格式
            //
            //     format: 'YYYY/MM/DD',
            //
            //     message: '日期格式不正确'
            //
            // },
            //
            // choice: {//check控件选择的数量
            //
            //     min: 2,
            //
            //     max: 4,
            //
            //     message: '必须选择2-4个选项'
            //
            // }


        }

    });

    $("#btn-test").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证

        $("#form-test").bootstrapValidator('validate');//提交验证

        if ($("#form-test").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码

            alert("yes");//验证成功后的操作，如ajax

        }

    });

});


