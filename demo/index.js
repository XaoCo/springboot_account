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



