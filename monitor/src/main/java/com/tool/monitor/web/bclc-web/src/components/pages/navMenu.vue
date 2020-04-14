<template>
  <el-row class="tac">
      <div class="headNav">
          <headNav></headNav>
      </div>
  <el-col :span="4">
    <el-menu
      default-active="1"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1">
        <!--<template slot="title">
          <span>首页</span>
        </template>
         <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
        </el-submenu>-->
        <span slot="title">首页</span>
      </el-menu-item> 
      <el-submenu index="2">
        <template slot="title">
            系统
        </template>
        <el-menu-item-group>
            <el-menu-item index="2-1">
                系统信息
            </el-menu-item>
            <el-menu-item index="2-2">
                系统成员关系信息
            </el-menu-item>
            <el-menu-item index="2-3">
                系统任务信息
            </el-menu-item>
            <el-menu-item index="2-4">
                系统任务状态
            </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="3" >
        <template slot="title">
            排期
        </template>
        <el-menu-item-group>
            <el-menu-item index="3-1">
                排期信息查询
            </el-menu-item>
            <el-menu-item index="3-2">
                排期关联系统任务
            </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="4">
        <template slot="title">
            岗位
        </template>
        <el-menu-item-group>
            <el-menu-item index="4-1">
                岗位人员信息查询
            </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-col>
  
</el-row>
</template>

<script>
import headNav from '@/components/pages/head'
export default {
    data () {
        return{

        }
    },
    components: {
        headNav
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style scoped>
.headNav{
    margin-top: -60px
}
 .el-submenu .el-menu-item {
  background:#6c6c6c !important;
}
</style>