<template>
    <div> 
    <b-form  @submit="logon" @reset="onReset">
        <h2 style="textAlign:center; margin-top:13%; margin-bottom: 40px;">能见度工具指标监控</h2>
  <b-form-group 
  label-cols="5" 
  label-cols-lg="5"  
  label-align-lg="right" 
  label="username:" 
  :model="form.username">
    <b-form-input id="username" class="col-lg-4"></b-form-input>
  </b-form-group>
  <b-form-group 
  label-cols="5" 
  label-cols-lg="5" 
  label="password:" 
  label-align-lg="right" 
  :model="form.password">
    <b-form-input id="password" class="col-lg-4" type="password"></b-form-input>
  </b-form-group>
        <!-- <button type="button">login</button> -->
        <div class="row justify-content-center" style="margin-top:30px">

        <b-button variant="outline-secondary" style="margin: 0 15px" type="submit">login</b-button>
        <b-button variant="outline-secondary" style="margin: 0 15px" type="reset">reset</b-button>
        </div>
    </b-form>
    </div>
</template>
<script>
export default {
    name:'login',
    data () {
        return {
            form:{
                username:'',
                password:''
            }

        }
    },
    methods:{
        logon(){

        },
        onReset(){
            this.form.username = ''
            this.form.password =""
        }
    }
}
</script>