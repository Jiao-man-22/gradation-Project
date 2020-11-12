<template>
    <div class="outer_container">
        <h1>php课程帖子</h1>
    <div class="post-block">
      <el-table :data="tableData"  size="medium">
        <el-table-column prop="post_time" label="日期" width="150">
        </el-table-column>
        <!--数据库设计缺陷，没有name-->
        <el-table-column prop="uid" label="用户ID" width="100">
        </el-table-column>
        <el-table-column prop="pid" label="帖子ID" width="100">
        </el-table-column>
        <el-table-column prop="title" label="标题" width="100">
        </el-table-column>
     
        <el-table-column prop="course" label="课程" width="150"></el-table-column>
        <el-table-column label="查看">
           <button @click="lookPost(pid)">查看</button>
       </el-table-column>
      </el-table>
    </div>
    </div>
</template>
<style scoped>
    .outer_container{
        width: 100%;
    }
</style>
<style scoped>
  .outer_container{
    width: 100%;
  }
</style>
<script>
import axios from 'axios'
export default {
  data() {
    return {
      tableData:[]
      
      
    }
  },
  mounted:function() {
    this.getData();
    
  },
  methods: {
    lookPost(Pid){
      this.$router.push('/commentsByPid');
      console.log(Pid)
      
    },
    getData(){
      axios({
        url:'/postMessage/selectPostByCourse',
        params:{ 
          course:"php"
        }
      }).then(res=>{
        this.tableData=res.data
      })
    }
  },
  
}
</script>