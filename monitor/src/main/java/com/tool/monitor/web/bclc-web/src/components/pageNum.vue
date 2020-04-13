<template>
  <div>
      <el-pagination
      @sizie-change= "onSizeChange"
      @current-change= "onCurrentChange"
      :current-page= "pageObj.currentPage"
      :page-size= "pageObj.pageSize"
      :total= "pageObj.total"
      layout="prev,pager,next,slot,jumper"
      background
      style="max-width:400px;margin-left:60%"
      >
          <span class="el-pagination-total" >共{{pageCount+1}}页</span>
      </el-pagination>

      <el-pagination
      @sizie-change= "onSizeChange"
      @current-change= "onCurrentChange"
      :current-page= "pageObj.currentPage"
      :page-size= "pageObj.pageSize"
      :total= "pageObj.total"
      layout="slot"
      background
      >
          <el-button class="el-jump-btn" style="float:right;margin-top:-33px;display:inline">确定</el-button>
      </el-pagination>
  </div>
</template>

<script>
export default {
    name: 'pages',
    props:{
            pageObj: {
                pageSize: 20,
                total: 0,
                currentPage: 1,
                sizes: [20,40,60,80,100] 
            }
    },
    data() {
        return{

        }
    },
    computed: {
        pageCount() {
            return Math.ceil(this.pageObj.total/this.pageObj.pageSize)
        }
    },
    methods: {
        onSizeChange() {
            this.$emit('handleSizeChange',val)
        },
        onCurrentChange(){
            this.$emit('handleCurrentChange',val)
        }
    }
}
</script>

<style scoped>
.el-jump-btn{
    background:red;
    color:white;
    border: white solid 1px;
}
.el-pagination .is-background{
    max-width: 400px;
    margin-left: 60%;
}
</style>