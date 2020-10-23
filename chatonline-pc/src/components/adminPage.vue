<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '3']" router>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>用户</template>
          <el-menu-item-group>
            <el-menu-item index="/userTablepage" @click="getUserList">查看用户</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-menu"></i>帖子</template>
          <el-menu-item-group>
            <el-menu-item index="/postsPage">查看帖子</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-setting"></i>设置</template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="/mainPage">退出</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <span>AdminUser</span>
      </el-header>
      <el-main>
         <!--展示路由-->
         <router-view></router-view>
      </el-main>
     
        
    </el-container>
  </el-container>
  <!--弹出对话框-->
</template>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
<script>
import axios from "axios";
export default {
  data() {
    return {
      //声明数组
      tableData: [],
      dialogFormVisible: false,
      form: {
        uid: "",
        name: "",
        password: "",
        birthday: "",
        sex: "",
        age: "",
        roleID: "",
        description: "",
        regsiter_date:"",
        last_login_time:"",
        mailbox:"",
      },
      formLabelWidth: "120px",
      search: "",
    };
  },
  //页面加载时调用该方法
  mounted: function () {
    this.getUserList();
  },
  methods: {
    getUserList() {
      axios({
        url: "/user/userSelect",
        method: "get",
      }).then((res) => {
        console.log(res.data),
          //alert('axios请求成功')
          //赋值给tableData
          (this.tableData = res.data);
      });
    },
    handleEidt() {},

    handleDelete(index, row) {
      alert("deleteUser方法被调用了");
      axios({
        url: "/user/userDelete",
        method: "post",
        params: {
          uid: row.uid,
        },
      }).then((res) => {
        console.log(res);
        //再调用一次数据请求函数
        this.getUserList();
      });
    },
    updateUser(form){
      this.dialogFormVisible = false
      alert('该方法被回调=========')
       axios({
        url: "/user/userUpdate",
        method: "post",
        params: {
        uid: form.uid,
        name: form.name,
        password:form.password,
        birthday:form.birthday,
        sex: form.sex,
        age: form.age,
        roleID: form.roleID,
        description: form.description,
        regsiter_date:form.regsiter_date,
        last_login_time:form.last_login_time,
        mailbox:form.mailbox,
        },
      }).then(res=>{
        this.$message("修改成功")
        console.log(res)
        this.getUserList()
      })
    },
  },
};
</script>