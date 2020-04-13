<template>
  <div class="container">
      <div class="content">
          <el-form ref="form" :model="form" label-width="120px" labe>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="系统任务ID：" prop="systemTaskID">
                        <el-select v-model="form.systemTaskID" clearable >
                            <el-option v-for="(item,index) in sysTaskIds" :key="index" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="系统任务摘要：" prop="systemTaskAbstract">
                        <el-input v-model="form.systemTaskAbstract"></el-input>
                    </el-form-item>
                </el-col>
                
            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="系统任务编号：" prop="systemTaskNo">
                        <el-input v-model="form.systemTaskNo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="系统任务描述：" prop="systemTaskDescription">
                        <el-input v-model="form.systemTaskDescription"></el-input>
                    </el-form-item>
                </el-col>
                
            </el-row>

            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="系统是否紧急：" prop="isTaskUrgent">
                        <el-select v-model="form.isTaskUrgent" clearable>
                            <el-option v-for="(item,index) in isTaskUrgentArr" :key="index" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="系统任务状态：" prop="systemTaskState">
                        <el-select v-model="form.systemTaskState">
                            <el-option v-for="(item,index) in systemTaskStateArr" :key="index" :value="item">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="任务负责人：" prop="taskManager">
                        <el-input v-model="form.taskManager"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="计划开发时间：" prop="scheduleDevPeriod">
                        <el-input v-model="form.scheduleDevPeriod"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="开发完成时间：" prop="developEndTime">
                        <el-input v-model="form.developEndTime"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="系统编号：" prop="systemNo">
                        <el-input v-model="form.systemNo"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="排期ID：" prop="scheduleID">
                        <el-input v-model="form.scheduleID"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="排期摘要：" prop="scheduleAbstract">
                        <el-input v-model="form.scheduleAbstract"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="排期编号：" prop="scheduleNo">
                        <el-input v-model="form.scheduleNo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="排期类型：" prop="scheduleType">
                        <el-input v-model="form.scheduleType"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="紧急上线ID：" prop="urgentOnlineId">
                        <el-input v-model="form.urgentOnlineId"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="紧急上线摘要：" prop="urgentOnlineAbstract">
                        <el-input v-model="form.urgentOnlineAbstract"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="紧急上线编号：" prop="urgentOnlineNo">
                        <el-input v-model="form.urgentOnlineNo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="紧急上线类型：" prop="urgentOnlineType">
                        <el-input v-model="form.urgentOnlineType"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="需求编号：" prop="demandNo">
                        <el-input v-model="form.demandNo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="需求名称：" prop="demandName">
                        <el-input v-model="form.demandName"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="业务需求描述：" prop="bizReqDescription">
                        <el-input v-model="form.bizReqDescription"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="操作类型：" prop="operationType">
                        <el-select v-model="form.operationType">
                            <el-option v-for="(item,index) in operationTypeArr" :key="index" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

            </el-row>
            <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="开发模式：" prop="developMode">
                        <el-select v-model="form.developMode" clearable>
                            <el-option v-for="(item,index) in developModeArr" :key="index" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <!-- <el-col :span="6" :offset="2">
                    <el-form-item label="系统任务摘要：" prop="systemTaskAbstract">
                        <el-input v-model="form.systemTaskAbstract"></el-input>
                    </el-form-item>
                </el-col> -->

            </el-row>
            <!-- <el-row>
                <el-col :span="6" :offset="5">
                    <el-form-item label="系统任务ID：" prop="systemTaskID">
                        <el-select v-model="form.systemTaskID" clearable="true">
                            <el-option v-for="(item,index) in sysTaskIds" :key="index" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="6" :offset="2">
                    <el-form-item label="系统任务摘要：" prop="systemTaskAbstract">
                        <el-input v-model="form.systemTaskAbstract"></el-input>
                    </el-form-item>
                </el-col>

            </el-row> -->
          </el-form>

            <div class="btn-position">
                <el-button class="btn-class" @click.prevent="onSubmit">
                    提交
                </el-button>
                <el-button class="btn-class" @click.prevent="onReset">
                    重置
                </el-button>
                <el-button class="btn-class" @click.prevent="onReturn">
                    返回
                </el-button>
            </div>
      </div>
  </div>
</template>

<script>
export default {
    name: 'systemTaskInfoSyn',
    data() {
        return {
            form:{
                systemTaskID: '',
                systemTaskAbstract: '',
                urgentOnlineNo:'',
            },
            sysTaskIds: ['001','002','003'],
            isTaskUrgentArr:[],
            systemTaskStateArr:[],
            operationTypeArr:[],
            developModeArr:[],



        }
    },
    methods: {
        onSubmit(){

        },
        onReset(){
            this.$refs[form].resetFields()
        },
        onReturn(){
            this.$router.push({path:'/'})
        }
    }

}
</script>

<style>
    .btn-position{
        text-align: center;
        margin-top: 40px;
    }
    .btn-class{
        font-family: inherit;
        background: red;
        color: white;
        border: #FFF;
    }
    .btn-class:hover{
        color: red;
        background: #FFF;
        border: red solid 1px;
    }
    .el-input__inner{
        height: 35px !important;
    }
</style>