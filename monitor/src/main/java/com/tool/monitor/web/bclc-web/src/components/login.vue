<template>
    <div>
    <b-form  @submit="login" @reset="onReset">
        <h2 style="textAlign:center; margin-top:13%; margin-bottom: 40px;">能见度工具指标监控</h2>
  <b-form-group
  label-cols="5"
  label-cols-lg="5"
  label-align-lg="right"
  label="username:"
  :model="user.username">
    <b-form-input id="username" v-model="user.username" class="col-lg-4" ></b-form-input>
  </b-form-group>
  <b-form-group
  label-cols="5"
  label-cols-lg="5"
  label="password:"
  label-align-lg="right"
  :model="user.password">
    <b-form-input id="password" v-model="user.password" class="col-lg-4" type="password"></b-form-input>
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
  import axios from 'axios'
export default {
    name:'login',
    data () {
        return {
            user:{
                username:'',
                password:''
            }

        }
    },
    methods:{
        login(evt){
          console.log(evt.preventDefault())
          // alert(JSON.stringify(this.user))
              axios.post('/login', {
                username: this.user.username,
                password: this.user.password
                // username: '张三',
                // password: '111111'
              })
                .then((response) => {
                  console.log(response)
                  if (response.data.code === 200) {
                    this.$router.push({name: 'homeLick'})
                    this.$store.commit('userLogin', this.user.username)
                    // this.$store.commit('userLogin', response.data)
                  }
                  if (response.data.code === 400){ //登录失败
                    alert(response.data.message);
                  }
                  if (response.data.code === 402){ //登录失败
                    alert(response.data.message);
                  }
                })
                .catch(function (error) {
                  console.log(error)
                  alert("网络错误，登录失败")
                })
        },
        onReset(){
            this.form.username = ''
            this.form.password =""
        }
    }
}
</script>
