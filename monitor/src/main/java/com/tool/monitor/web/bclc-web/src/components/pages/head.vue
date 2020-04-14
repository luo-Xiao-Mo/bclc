<template>
  <div class="line">
<el-menu
  :default-active="activeIndex1"
  class=""
  mode="horizontal"
  @select="handleSelect"
  background-color="#545c64"
  text-color="#fff"
  active-text-color="#ffd04b">
          <el-menu-item index="1" style="margin-left:207px">首页</el-menu-item>
    <el-submenu index="2">
    <template slot="title">系统</template>
    <el-menu-item index="2-1">系统信息</el-menu-item>
    <el-menu-item index="2-2">系统成员关系</el-menu-item>
    <el-menu-item index="2-3">系统任务信息</el-menu-item>
    <el-menu-item index="2-3">系统任务状态</el-menu-item>
  </el-submenu>
    <el-submenu index="3">
      <template slot="title">排期</template>
      <el-menu-item index="3-1">排期信息查询</el-menu-item>
      <el-menu-item index="3-2">排期关联系统任务</el-menu-item>
    </el-submenu>
  <el-submenu index="4" >
      <template slot="title">岗位</template>
      <el-menu-item index="4-1">岗位人员信息查询</el-menu-item>
  </el-submenu>

</el-menu>
  </div>
</template>

<script>
export default {
    name: 'headNav',
    data() {
      return {
        activeIndex1: '1',
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
    }

}
</script>

<style scoped>
    .headNav{
        display: inline;
        margin-left: 207px;
    }
</style>