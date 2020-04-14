<template>
    <div class="">
        <div class="formTop">
            <el-form ref="form" :model="form" :rules="rules" label-width="120px">
                <el-row>
                    <el-col :span="6" :offset="4">
                        <el-form-item label="系统标识" prop="systemTag">
                            <!-- <el-input v-model="form.systemTag"></el-input> -->
                            <el-select v-model="form.systemTag" clearable>
                                <el-option v-for="(item,index) in sysTags" :key="index" :value="item">

                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" :offset="3">
                        <el-form-item label="cbsp成员ID" prop="cbspMemberID">
                            <el-input v-model="form.cbspMemberID"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6" :offset="4">
                        <el-form-item label="plmp成员ID" prop="plmpMemberID">
                            <el-input v-model="form.plmpMemberID"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" :offset="3">
                        <el-form-item label="plmp成员名称" prop="plmpMemberName">
                            <el-input v-model="form.plmpMemberName"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6" :offset="4">
                        <el-form-item label="plmp成员角色" prop="plmpMemberRolev">
                            <el-input v-model="form.plmpMemberRole"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" :offset="3">
                        <el-form-item label="操作类型" prop="operationType">
                            <!-- <el-input v-model="form.operationType"></el-input> -->
                            <el-select v-model="form.operationType" clearable>
                                <el-option v-for="(item,index) in operTypes" :key='index' :value="item">

                                </el-option>
                            </el-select>
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
    name: 'systemMembershipInfoSyn',
    data() {
        return {
            form:{
                systemTag:'',
                cbspMemberID:'',
                plmpMemberID:'',
                plmpMemberName:'',
                plmpMemberRole:'',
                operationType:''

            },
            rules:{

            },
            sysTags:['A001','A002','A003'],
            operTypes:['新增','修改','删除']
        }
    },
    methods:{
        onSubmit() {

        },
        onReset(){
            this.$refs['form'].resetFields()
            this.form.systemTag = ''
            this.cbspMemberID = ''
            this.plmpMemberID = ''
            this.plmpMemberName = ''
            this.plmpMemberRole = ''
            this.operationType = ''
        },
        onReturn(){
            this.$router.push({path:''})
        }
    }
}
</script>

<style scoped>
    .formTop{
        margin-top: 12%;
    }
    .btn-position{
        text-align: center;
        margin-top: 60px;
    }
    .btn-class{
        background: red;
        color: white;
        border: #FFF;
    }
</style>