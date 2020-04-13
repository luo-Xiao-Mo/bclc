// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui';

import 'element-ui/lib/theme-chalk/index.css';

import axios from '@/api/axios'

import '@/assets/css/global.css'

import {MessageBox, Dialog, Message} from "element-ui";
Vue.use(Dialog)

Vue.use(ElementUI);

import store from '@/vuex/index'



Vue.prototype.$confirm = MessageBox.confirm
Vue.prototype.$msgbox = MessageBox
Vue.prototype.$alert = MessageBox.alert
Vue.prototype.$message = Message
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
