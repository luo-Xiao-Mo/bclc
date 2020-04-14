<template>
  <div class="">
      <div class="formStyle">

      <el-form :model="form" ref="form" label-width="100px">
          <el-row>
              <el-col :span="7" :offset="4">
                  <el-form-item label="发起方流水号" prop="initiatorNo">
                      <el-input v-model="form.initiatorNo">

                      </el-input>
                  </el-form-item>
              </el-col>
              <el-col :span="7" :offset="2">
                  <el-form-item label="系统标识" prop="systemTag">
                      <el-input v-model="form.systemTag">

                      </el-input>
                  </el-form-item>

              </el-col>
          </el-row>
      </el-form>
      </div>

      <el-button type="primary" @click.prevent= "search">查询</el-button>
      <el-button type="primary" @click.prevent= "onReset('form')">重置</el-button>
      <el-button type="primary" @click.prevent= "handleExport">导出</el-button>

    <div class="tabStyle">
      <el-table ref="formTable"
      border striped
      :data="tableData"
      :header-cell-style="this.$store.state.headerStyle"
      :cell-style="this.$store.state.cellStyle"
      tooltip-effct="dark"
        style="width:100%"
      >
      <el-table-column prop="sysTag" label="系统标识"  :resizable="false" width="">

      </el-table-column>
      <el-table-column prop="sysNo" label="系统编号"  :resizable="false" width="">

      </el-table-column>
      <el-table-column prop="sysName" label="系统名称"  :resizable="false" width="">

      </el-table-column>
      <el-table-column prop="others" label="其他"  :resizable="false" width="">

      </el-table-column>
      <el-table-column prop="operations" label="操作"  :resizable="false" width="">

      </el-table-column>
    

      </el-table>

        <div class="pageStyle">
            <page-scale :pageObj = "pageObj" @handleSizeChange= "handleSizeChange">

            </page-scale>
        </div>
    </div>

  </div>
</template>

<script>

import pageScale from '@/components/pageSize'

export default {
    name: '',
    data () {
        return{
            form: {
                initiatorNo: '',
                systemTag: ''
            },
            tableData: [],
            pageObj: {
                pageSize: 20,
                total: 0,
                currentPage: 1,
                sizes: [20,40,60,80,100] 
            }

        }
    },
    components: {
       pageScale 
    },
    methods: {
        search(){

        },
        onReset(formName){
            this.$refs[formName].resetFields()
            this.form.initiatorNo = ''
            this.form.systemTag = ''
        },
        handleExport(){

        },
        handleSizeChange(val) {
            this.pageObj.pageSize = val
        }

    }


}
</script>

<style scoped>
    .tabStyle{
        margin-top: 60px;
    }
    .formStyle{
        margin-bottom: 40px;
    }
    .el-button--primary {
        font-family: inherit;
        color: #FFF;
        background-color: #FF0000;
        border-color: #0000;
    }
    .el-button--primary:hover{
        color: red;
        border: red solid 1px;
        background: #FFF;
    }
    .pageStyle{
        float: right;
        margin-right: 150px;
    }
</style>