<template>
  <div class="container">
      <el-form :model="form" ref="form" :rules="rules" class="loginForm" label-width="100px">
          <div><span class="title">能见度工具指标监控</span></div>
          <el-row>
              <div class="formItem">
              <el-col :span="6" :offset="8">
                  <el-form-item label="用户名: " prop="username">
                      <el-input v-model="form.username" placeholder="请输入用户名">
                      </el-input>
                  </el-form-item>
              </el-col>
              </div>
          </el-row>

          <el-row>
              <el-col :span="6" :offset="8">
                  <el-form-item label="密码: " prop="password">
                      <el-input v-model="form.password" placeholder="请输入密码" type="password">

                      </el-input>
                  </el-form-item>
              </el-col>
          </el-row>
          <el-form-item></el-form-item>
      </el-form>
      <el-button class="btn-class" @click.prevent="logon">login</el-button>
      <el-button class="btn-class" @click.prevent="reset('form')">reset</el-button>
  </div>
</template>

<script>
export default {
    name:'login',
    data () {
        return{
            form:{
                username:'',
                password:''
            },
            rules: {
                username: [
                    {required: true, message: '用户名不能为空！',trigger: 'blur'}
                ],
                password:[
                    {required: true,message: '密码不能为空！',trigger: 'blur'}
                ]
            }
        }
    },
    methods:{
        logon() {

        },
        reset(formName) {
            this.$refs[formName].resetFields();
            this.form.username = ''
            this.form.password = ''
        }
    }
}
</script>

<style scoped>
    .title{
        font-size: 150%;
        display: inline-block;
        margin-top: 8%;
        margin-bottom: 30px;
    }
    .el-input__inner{
        height: 35px !important;
    }
</style>