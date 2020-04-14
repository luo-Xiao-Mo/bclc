<template>
  <div id="myganttChart"  style="width: 400px;height: 300px;"></div>
</template>

<script>
  import echarts from 'echarts'
  export default {
    name:'scheduleBox',

    data () {
      return {
        charts: '',
        opinion:['评审中','开发中','测试中','发版中','其他'],
        opinionData:[
          {value:335, name:'评审中'},
          {value:1548, name:'开发中'},
          {value:234, name:'测试中'},
          {value:135, name:'发版中'},
          {value:310, name:'其他'}
        ]
      }
    },
    methods:{
      drawPie(id){
        this.charts = echarts.init(document.getElementById(id))
        this.charts.setOption({
          tooltip: {
            trigger: 'item',
            formatter: '{a}<br/>{b}:{c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            x: 'left',
            data:this.opinion
          },
          series: [
            {
              name:'访问来源',
              type:'pie',
              radius:['50%','70%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center'
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '30',
                    fontWeight: 'blod'
                  }
                }
              },
              labelLine: {
                normal: {
                  show: false
                }
              },
              data:this.opinionData
            }
          ]
        })
      }
    },
    //调用
    mounted(){
      this.$nextTick(function() {
        this.drawPie('myganttChart')
      })
    }

  }

</script>

<style>

</style>
