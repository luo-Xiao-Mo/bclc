<template>
    <div class="container">
        <div class="content">
            <el-form label-width="120px" ref="form" :model="form">
                <el-row>
                    <el-col :span="6" :offset="5">
                        <el-form-item label="系统任务ID：" prop="systemTaskId">
                            <el-input v-model="form.systemTaskId"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" :offset="2">
                        <el-form-item label="系统任务状态：" prop="systemTaskState">
                            <el-input v-model="form.systemTaskState"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6" :offset="5">
                        <el-form-item label="实际开发时间：" prop="actualDevTime">
                            <el-input v-model="form.actualDevTime"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" :offset="2">
                        <el-form-item label="实际完成时间：" prop="actualFinishTime">
                            <el-input v-model="form.actualFinishTime"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
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
    name: 'systemTaskStateSyn',
    data() {
        return {
            form: {

            }
        }
    },

    methods: {
        onSubmit(){

        },
        onReset(){

        },
        onReturn(){
            
        }
    }

}
</script>

<style scoped>

    .content{
        margin-top: 16%;
    }
</style>