<template>
  <div class="systemDetail" v-if="formData">
      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统标识：</label>
          <label class="content-left">{{formData.systemIdentification}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">子系统投产状态：</label>
          <label class="content-right">{{formData.subSystemProductState}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统编号：</label>
          <label class="content-left">{{formData.systemNo}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">子系统投产日期：</label>
          <label class="content-right">{{formData.subSystemProductDay}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统名称：</label>
          <label class="content-left">{{formData.systemName}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">子系统下线日期：</label>
          <label class="content-right">{{formData.subSystemOfflineDay}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统英文名称：</label>
          <label class="content-left">{{formData.systemEnglishName}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">数据中心负责处室：</label>
          <label class="content-right">{{formData.dataCenterDuty}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统重要性等级：</label>
          <label class="content-left">{{formData.systemSignificanceLevel}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">运行负责组：</label>
          <label class="content-right">{{formData.runOccupiedGroup}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统负责人：</label>
          <label class="content-left">{{formData.systemManager}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">表更时间窗口：</label>
          <label class="content-right">{{formData.updataTimeWindow}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">子系统研发机构：</label>
          <label class="content-left">{{formData.subSystemResearcher}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">基础设施类变更时间窗口：</label>
          <label class="content-right">{{formData.fundementalClassUpdateTimeWindow}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统分类：</label>
          <label class="content-left">{{formData.systemClassfication}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">应用版本类变更窗口：</label>
          <label class="content-right">{{formData.appliedVersionUpdateWindow}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统描述：</label>
          <label class="content-left">{{formData.systemDescription}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">停止服务时间窗口：</label>
          <label class="content-right">{{formData.serviceSuspendedTimeWindow}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统归属2级部：</label>
          <label class="content-left">{{formData.systemBelongSecondDep}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">同城灾备建设情况：</label>
          <label class="content-right">{{formData.inCityBackupSituation}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">合作开发厂商：</label>
          <label class="content-left">{{formData.cooperativeDevelopFirm}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">子系统运维备注：</label>
          <label class="content-right">{{formData.subSystemOperationNotes}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">系统状态：</label>
          <label class="content-left">{{formData.systemState}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">异地灾备建设情况：</label>
          <label class="content-right">{{formData.systemState}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">信息修改时间：</label>
          <label class="content-left">{{formData.infoUpdateTime}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">文档分类：</label>
          <label class="content-right">{{formData.documentClassfication}}</label>
        </el-col>
      </el-row>

      <el-row class="row-left">
        <el-col :span="4">
          <label class="label-left">创建时间：</label>
          <label class="content-left">{{formData.createTime}}</label>
        </el-col>
        <el-col :span="6" :offset="4">
          <label class="label-right">创建人：</label>
          <label class="content-right">{{formData.creator}}</label>
        </el-col>
      </el-row>
      <div class="btn-center">
        <el-button type="primary" @click.prevent="onReturn" class="btn-return">返回</el-button>
      </div>
  </div>
</template>

<script>
export default {
  name:'systemInfoDetail',
  data() {
    return {
      formData: {
        systemIdentification: 'xxx',
        subSystemProductState: 'zzz',
        systemNo:'',
        subSystemProductDay:'',
        systemName:'',
        subSystemOfflineDay:'',
        systemEnglishName:'',
        dataCenterDuty:'',
        systemSignificanceLevel:'',
        runOccupiedGroup:'',
        systemManager:'',
        updataTimeWindow:'',
        subSystemResearcher:'',
        fundementalClassUpdateTimeWindow:'',
        systemClassfication:'',
        appliedVersionUpdateWindow:'',
        systemDescription:'',
        serviceSuspendedTimeWindow:'',
        systemBelongSecondDep:'',
        inCityBackupSituation:'',
        cooperativeDevelopFirm:'',
        subSystemOperationNotes:'',
        systemState:'',
        infoUpdateTime:'',
        documentClassfication:'',
        createTime:'',
        creator:'',


      },
    }
  },

  methods: {
    onReturn(){
      this.$router.go(-1)
    }
  }
}
</script>

<style>
  .systemDetail{
      text-align: left;
      margin-top: 10%;
      line-height: 1.5;
  }
  .row-left{
    margin-left: 34%;
  }
 
  .content-left{

  }
  .label-right{

  }
  .content-right{
    
  }
  .btn-center{
    margin-top: 40px;
    text-align: center;
  }
  .el-button--primary{
    background: red;
    border-color: #FFF;
  }
  .el-button--primary:hover {
    background: red;
    /* border-color: #66b1ff; */
    color: #FFF;
    border-color: #FFF;
}
</style>