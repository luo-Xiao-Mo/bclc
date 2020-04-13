import Vue from 'vue'
import Router from 'vue-router'

// 引入配置的组件
/*登录及导航*/
const login = () => import('@/components/pages/login')
const navMenu = () => import('@/components/pages/navMenu')

const headNav = () =>import('@/components/pages/head')

/** 系统相关*/
const systemInfo = () => import('@/components/system/systemInfo')
const systemInfoDetail = () => import('@/components/system/systemInfoDetail')
const systemMembershipInfoSyn = () => import('@/components/system/systemMembershipInfoSyn')
const systemTaskInfoSyn = () => import('@/components/system/systemTaskInfoSyn')
const systemTaskStateSyn = () => import('@/components/system/systemTaskStateSyn')

/** 排期相关*/ 
const scheduleInfoQueryList = () => import('@/components/schedule/scheduleInfoQueryList')
Vue.use(Router)

export default new Router({
  // mode: "history",
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: '登录',
      component: login
    },
    {
      path: '/navMenu',
      name: '导航',
      component: navMenu
    },
    {
      path: '/headNav',
      name: '顶部导航',
      component: headNav
    },
    {
      path: '/systemInfo',
      name: '系统同步信息查询列表',
      component: systemInfo
    },
    {
      path: '/systemInfoDetail',
      name: '系统同步信息查询列表详情',
      component: systemInfoDetail
    },
    {
      path: '/systemMembershipInfoSyn',
      name: '系统成员关系信息同步',
      component: systemMembershipInfoSyn
    },
    {
      path: '/systemTaskInfoSyn',
      name: '系统任务信息同步',
      component: systemTaskInfoSyn
    },
    {
      path: '/systemTaskStateSyn',
      name: '系统任务状态同步',
      component: systemTaskStateSyn
    },
    {
      path: '/scheduleInfoQueryList',
      name: '排期信息查询列表',
      component: scheduleInfoQueryList
    },
  ]
})
