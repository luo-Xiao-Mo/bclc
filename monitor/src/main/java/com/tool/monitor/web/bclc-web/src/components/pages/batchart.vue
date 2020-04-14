<template>
  <div id="batchart"  style="width: 400px;height: 300px;"></div>
</template>

<script>
  import echarts from 'echarts'
  export default {
    name:'batchart',

    data () {
      return {
        charts: '',
        // opinion:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],
        // opinionData:[
        //   ['product', 'CI覆盖率', '单元测试成功率', '总缺陷密度'],
        //   ['福费廷', 43.3, 85.8, 93.7],
        //   ['信用证', 83.1, 73.4, 55.1],
        //   ['系统1', 86.4, 65.2, 82.5],
        //   ['系统2', 72.4, 53.9, 39.1]
        // ]
      }
    },
    methods:{
      drawPie(id){
        this.charts = echarts.init(document.getElementById(id))
        this.charts.setOption({
          legend: {},
          tooltip: {},
          dataset: {
            source: [
              ['indicator', 'indicator1', 'indicator2', 'indicator3'],
              ['system1', 43.3, 85.8, 93.7],
              ['system2', 83.1, 73.4, 55.1],
              ['system3', 86.4, 65.2, 82.5],
              ['system4', 72.4, 53.9, 39.1]
            ]
          },
          xAxis: {type: 'category'},
          yAxis: {},
          // Declare several bar series, each will be mapped
          // to a column of dataset.source by default.
          series: [
            {type: 'bar'},
            {type: 'bar'},
            {type: 'bar'}
            ]
        })
      }
    },
    //调用
    mounted(){
      this.$nextTick(function() {
        this.drawPie('batchart')
      })
    }

  }

</script>

<style>

</style>
