<template>
    <div class="container">
        <div class="content">
            <div class="table-cls">
                <el-table :data="tableData" striped ref="formTable" border 
              :header-cell-style="$store.state.headerStyle"
              :cell-style="$store.state.cellStyle"
              style="width:100%">
                    <el-table-column label="开发任务号" :resizable="false" prop="developTaskNo" width=""></el-table-column>
                    <el-table-column label="开发任务负责人" :resizable="false" prop="developOfficer" width=""></el-table-column>
                    <el-table-column label="计划开发开始时间" :resizable="false" prop="scheduleDevStartDate" width=""></el-table-column>
                    <el-table-column label="计划开发完成时间" :resizable="false" prop="scheduleDevEndDate" width=""></el-table-column>
                    <el-table-column label="实际开发时间" :resizable="false" prop="actualDevDate" width=""></el-table-column>
                    <el-table-column label="实际结束时间" :resizable="false" prop="actualEndDate" width=""></el-table-column>
                    <el-table-column label="实际任务状态id" :resizable="false" prop="actualTaskStateId" width=""></el-table-column>
                    <el-table-column label="实际任务状态名称" :resizable="false" prop="actualTaskStateName" width=""></el-table-column>
                </el-table>
            </div>

            <div class="btn-position">
                <el-button class="btn-class" @click.prevent="onReturn">返回</el-button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'associatedSystemDevTaskListDetail',
    data () {
        return {
            tableData: [],
        }
    },
    methods: {
        onReturn() {
            
        }
    }

}
</script>

<style>

</style>