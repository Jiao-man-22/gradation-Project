<template>
  <el-table
    :data="tableData"
    style="width: 100%"
    max-height="500">
    <el-table-column
      fixed
      prop="pid"
      label="pid"
      width="150">
    </el-table-column>
    <el-table-column
      prop="uid"
      label="uid"
      width="120">
    </el-table-column>
    <el-table-column
      prop="post_time"
      label="发帖时间"
      width="120">
    </el-table-column>
    <el-table-column
      prop="title"
      label="标题"
      width="120">
    </el-table-column>
    <el-table-column
      prop="messagebody"
      label="消息体"
      width="300">
    </el-table-column>
    <el-table-column
      prop="type"
      label="类型"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, scope.row)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from 'axios'
  export default {
    mounted: function () {
    this.getPost();
  },
    methods: {
    getPost(){
      axios({
        url:'/postMessage/selectPosts'
      }).then(res=>{
        //将数据赋值给tableData
        (this.tableData = res.data);
      })
    },
    deleteRow(index, row){
      axios(
        {
          url:'/postMessage/deletePost',
          params:{
           pid:row.pid
          }
        }
      ).then(res=>{
        this.$message("删除成功")
        console.log(res)
        this.getPost();
      })
    }
    },
    data() {
      return {
        tableData: []
      }
    }
  }
</script>