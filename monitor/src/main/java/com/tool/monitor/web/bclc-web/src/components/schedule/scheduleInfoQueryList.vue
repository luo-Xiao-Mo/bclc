<template>
  <div class="container">
      <div class="content">
          <el-form ref="form" :model="form" label-width="120px">
              <el-row>
                  <el-col :span="6" :offset="5">
                      <el-form-item label="排期编号" prop="scheduleNo">
                          <el-input v-model="form.scheduleNo"></el-input>
                      </el-form-item>
                  </el-col>
                  <el-col :span="6" :offset="2">
                      <el-form-item label="排期负责人编号" prop="scheduleOfficerNo">
                          <el-input v-model="form.scheduleOfficerNo"></el-input>
                      </el-form-item>
                  </el-col>
              </el-row>
              <el-row>
                  <el-col :span="6" :offset="5">
                      <el-form-item label="是否分页查询" prop="isPagingQuery"> 
                          <el-radio v-model="form.isPagingQuery" label="1">是</el-radio>
                          <el-radio v-model="form.isPagingQuery" label="0">否</el-radio>
                      </el-form-item>
                  </el-col>
              </el-row>
          </el-form>

          <div>
              <el-button class="btn-class" @click.prevent="onQuery">查询</el-button>
              <el-button class="btn-class" @click.prevent="onReset">重置</el-button>
              <el-button class="btn-class" @click.prevent="onExport">导出</el-button>
              <el-button class="btn-class" @click.prevent="onReturn">返回</el-button>
          </div>

          <div>
              <el-table :data="tableData" striped ref="formTable" border 
              :header-cell-style="$store.state.headerStyle"
              :cell-style="$store.state.cellStyle"
              style="width:100%;margin-top:1%"
              >
                <el-table-column label="排期编号" :resizable="false" prop="scheduleNo" width="110"></el-table-column>
                <el-table-column label="排期负责人编号" :resizable="false" prop="scheduleOfficerNo" width=""></el-table-column>
                <el-table-column label="排期负责人名称" :resizable="false" prop="scheduleOfficerName" width="120"></el-table-column>
                <el-table-column label="排期摘要" :resizable="false" prop="scheduleAbstract" width=""></el-table-column>
                <el-table-column label="主办系统编号" :resizable="false" prop="hostSystemNo" width=""></el-table-column>
                <el-table-column label="主办系统名称" :resizable="false" prop="hostSystemName" width=""></el-table-column>
                <el-table-column label="系统标识" :resizable="false" prop="systemTag" width=""></el-table-column>
                <el-table-column label="排期类型" :resizable="false" prop="scheduleType" width=""></el-table-column>
                <el-table-column label="当前状态" :resizable="false" prop="currentState" width=""></el-table-column>
                <el-table-column label="计划上线日期" :resizable="false" prop="scheduleLaunchDate" width=""></el-table-column>
                <el-table-column label="实际上线日期" :resizable="false" prop="actualLaunchDate" width=""></el-table-column>
              </el-table>


          </div>

          <div class="pageNum-class"> 
              <page-num v-if="tableData" :pageObj="pageObj" @handleSizeChange= "handleSizeChange" @handleCurrentChange="handleCurrentChange"></page-num>
          </div>
          <div class="pageSize-class">
              <page-size :pageObj="pageObj" @handleSizeChange= "handleSizeChange"></page-size>
          </div>
      </div>
  </div>
</template>

<script>
import pageSize from '@/components/pageSize'
import pageNum from '@/components/pageNum'
export default {
    name: 'scheduleInfoQueryList',
    data () {
        return {
            form: {
                isPagingQuery: '1'
            },
            pageObj: {
                pageSize: 20,
                total: 0,
                currentPage: 1,
                sizes: [20,40,60,80,100] 
            },
            tableData: [
                {scheduleNo:'0000',
                scheduleOfficerNo:'0001',
                scheduleOfficerName:'liuwei',
                scheduleAbstract:'xxxxx',
                hostSystemNo:'0002',
                hostSystemName:'yyyyy',
                systemTag:'zzzz',
                scheduleType:'xyxyx',
                currentState:'Good',
                scheduleLaunchDate:'2020-04-11',
                actualLaunchDate:'2020-04-12'}
            ]
        }
    },
    components:{
        pageSize,pageNum
    },
    methods: {
        onQuery(){

        },
        onReset(){
            this.$refs['form'].resetFields()
        },
        onExport(){

        },
        onReturn(){
            this.$router.push({path:'/'})
        },
        handleSizeChange(val){
            this.pageObj.pageSize = val
        },
        handleCurrentChange(){

        }
    }

}
</script>

<style>
    .content{
        margin-top: 5%;
    }
</style>