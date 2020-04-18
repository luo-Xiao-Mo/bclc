<template>
    <div class="container">
        <div class="content">
            <el-form ref="form" :model="form" label-width="120px" >
                <el-row>
                    <el-col :span="6" :offset="2">
                        <el-form-item label="排期编号：" prop="scheduleNo">
                            <el-input v-model="form.scheduleNo"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div>
                <el-button class="btn-class" @click.prevent= "onSearch">查询</el-button>
                <el-button class="btn-class" @click.prevent= "onReset">重置</el-button>
                <el-button class="btn-class" @click.prevent= "onExport">导出</el-button>
            </div>

            <div class="table-cls">
                <el-table :data="tableData" striped ref="formTable" border 
              :header-cell-style="$store.state.headerStyle"
              :cell-style="$store.state.cellStyle"
              style="width:100%">
                    <el-table-column label="排期编号" :resizable="false" prop="scheduleNo" ></el-table-column>
                    <el-table-column label="排期摘要" :resizable="false" prop="scheduleAbstract" ></el-table-column>
                </el-table>
            </div>

            <div>
                <span style="float: left;margin-top: 40px;font-size: x-large;">关联系统</span>
            </div>

            <div class="table-cls">
                <el-table :data="associatedSysTableData" striped ref="assFormTable" border
                :header-cell-style="$store.state.headerStyle"
                :cell-style="$store.state.cellStyle"
                style="width:100%"
                >
                    <el-table-column label="系统任务编号" :resizable="false" prop="systemTaskNo" width=""></el-table-column>
                    <el-table-column label="系统任务提要" :resizable="false" prop="systemTaskAbstract" width=""></el-table-column>
                    <el-table-column label="操作" :resizable="false" prop="operations" width=""></el-table-column>
                </el-table>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'associatedSystemDevTaskList',
    data() {
        return {
            form:{
                scheduleNo:''
            },
            tableData: [],
            associatedSysTableData: [],
        }
    },
    methods: {
        onSearch() {

        },
        onReset() {

        },
        onExport() {

        }
    }
}
</script>

<style scoped>
    .table-cls{
        margin-top: 60px;
    }
</style>