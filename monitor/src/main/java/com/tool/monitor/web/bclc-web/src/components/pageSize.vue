<template>
    <div class="pageNumSelect">
        
        <el-pagination
        @size-change= "onSizeChange"
        :page-sizes = "pageObj.sizes"
        layout="sizes"
        background
        >
      
        </el-pagination>
    </div>
</template>

<script>
export default {
    name: 'pageSize',
    props: {
           pageObj: {
                pageSize: 20,
                total: 0,
                currentPage: 1,
                sizes: [20,40,60,80,100]                 
            }
    },
    data () {
        return{
 
        }
    },
    methods: {
        onSizeChange() {
            this.$emit('handleSizeChange',val)
        },
        // onCurrentChange(){
        //     this.$emit('handleCurrentChange',val)
        // }
    }
}
</script>

<style>
.pageNumSelect{
    text-align: right;
}
</style>