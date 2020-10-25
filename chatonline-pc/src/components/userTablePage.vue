<template>
        <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))">
          <el-table-column prop="register_date" label="注册日期" width="200">
          </el-table-column>
          <el-table-column prop="uid" label="uid" width="120">
          </el-table-column>
          <el-table-column prop="name" label="姓名" width="120">
          </el-table-column>
          <el-table-column prop="password" label="密码" width="120">
          </el-table-column>
          <el-table-column prop="age" label="年龄" width="120">
          </el-table-column>
          <el-table-column prop="roleID" label="角色" width="120">
          </el-table-column>
          <el-table-column align="right">
            <template slot="header" slot-scope="">
              <el-input
                v-model="search"
                size="mini"
                placeholder="输入关键字搜索"
              />
            </template>
            <template slot-scope="scope">
              <el-button size="mini" @click="dialogFormVisible = true">Edit</el-button>
              <el-dialog title="" :visible.sync="dialogFormVisible">
                <el-form :model="form">
                  <el-form-item label="请输入更改的uid" :label-width="formLabelWidth">
                    <el-input v-model="form.uid" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="名字" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="密码" :label-width="formLabelWidth">
                    <el-input v-model="form.password" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="生日" :label-width="formLabelWidth">
                    <el-input v-model="form.birthday" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="性别" :label-width="formLabelWidth">
                    <el-input v-model="form.sex" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="年龄" :label-width="formLabelWidth">
                    <el-input v-model="form.age" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="角色" :label-width="formLabelWidth">
                    <el-input v-model="form.roleID" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="描述" :label-width="formLabelWidth">
                    <el-input v-model="form.description" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="注册时间" :label-width="formLabelWidth">
                    <el-input v-model="form.register_date" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="最后登陆" :label-width="formLabelWidth">
                    <el-input v-model="form.last_login_time" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="电子邮件" :label-width="formLabelWidth">
                    <el-input v-model="form.mainbox" autocomplete="off"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="dialogFormVisible = false"
                    >取 消</el-button>
                  <el-button type="primary" @click="updateUser(form)"
                    >确 定</el-button>
                </div>
              </el-dialog>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >Delete</el-button>
            </template>
          </el-table-column>
        </el-table> 
</template>
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
    getPost(){
      axios({
        url:'/postMessage/selectPosts'
      }).then(res=>{
        //将数据赋值给tableData
        (this.tableData = res.data);
      })
    }

  },
};
</script>