<template>
      <div class="container-lg">
        <homeHeader></homeHeader>
        <b-container>
          <div>
            <b-row>
              <b-col>
                <b-th>任务状态</b-th>
                <schedule-box></schedule-box>
              </b-col>
              <b-col>
                <b-th>系统缺陷/CICD</b-th>
                <batchart></batchart>
              </b-col>
            </b-row>
          </div>
          <div>
            <b-row>
              <b-th>排期进度</b-th>
            </b-row>
            <b-row>
              <b-table striped hover :items="items">
                <b-row></b-row>
              </b-table>
            </b-row>
          </div>
        </b-container>
      </div>


</template>
<script>
  import Header from "./header";
  import scheduleBox from "./scheduleBox";
  import batchart from "./batchart";

  export default {
    name:'rightContainer',
    components: {
      homeHeader:Header,
      scheduleBox:scheduleBox,
      batchart:batchart
    },
    data () {
      return {
        items: [
          {排期编号: 'R-2020052072498024', 系统名称: '福费廷', 负责人: '刘巍', 计划上线日期: '2020/05/20', 任务状态: '完成'},
          {排期编号: 'R-2020052072498025', 系统名称: '信用证', 负责人: '刘巍', 计划上线日期: '2020/05/20', 任务状态: '完成'},
        ]
      }
    },
    methods:{
      logout(){

      }
    }
  }
</script>
