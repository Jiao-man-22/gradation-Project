<template>
  <div class="block">
    <el-carousel height="400px" >
      <el-carousel-item v-for="item in img" :key="item.id">
        <img :src="item.idView" alt="" />
      </el-carousel-item>
    </el-carousel>
      <el-input
      prefix-icon="el-icon-user-solid"
      v-model="username"
      maxlength="10"
    >
    </el-input>
    <div class="my_draw" align="right">
      <!-- 用户登陆模块<br /> -->
      <el-button type="primary" @click="dialogFormVisible = true"
        >登陆</el-button
      >
      <el-dialog title="" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" :label-width="formLabelWidth">
            <el-input
              v-model="form.password"
              autocomplete="off"
              type="password"
            ></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="userSignIn(form)">确 定</el-button>
          <el-button type="primary" @click="turnAdminPage()"
            >管理员登陆</el-button
          >
        </div>
      </el-dialog>
      <!--注册模块-->
      <el-button
        type="primary"
        @click="userFormVisible = true"
        style="margin-left: 16px"
        >注册</el-button
      >
      <el-dialog title="" :visible.sync="userFormVisible">
        <el-form :model="userForm">
          <el-form-item label="uid" :label-width="formLabelWidth">
            <el-input v-model="userForm.uid" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="userForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" :label-width="formLabelWidth">
            <el-input v-model="userForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="年龄" :label-width="formLabelWidth">
            <el-input v-model="userForm.age" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-input v-model="userForm.sex" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="生日" :label-width="formLabelWidth">
            <el-input
              v-model="userForm.birthday"
              autocomplete="off"
              type="date"
            ></el-input>
          </el-form-item>
          <el-form-item label="注册日期" :label-width="formLabelWidth">
            <el-input
              v-model="userForm.register_date"
              autocomplete="off"
              type="date"
            ></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="userFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="userInsert(userForm)"
            >确 定</el-button
          >
        </div>
      </el-dialog>
      <!--发帖模块-->
      <el-button
        type="primary"
        @click="postFormVisible = true"
        style="margin-left: 16px"
        >发帖</el-button
      >
      <el-dialog title="" :visible.sync="postFormVisible">
        <el-form :model="postForm">
          <el-form-item label="帖子ID" :label-width="formLabelWidth">
            <el-input v-model="postForm.pid" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="标题" :label-width="formLabelWidth">
            <el-input v-model="postForm.title" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="内容" :label-width="formLabelWidth">
            <el-input
              v-model="postForm.messagebody"
              autocomplete="off"
              type="textarea"
              :rows="3"
            ></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="postFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="uploadPost(postForm, username)"
            >确 定</el-button
          >
        </div>
      </el-dialog>

      <!--用户信息模块-->
      <el-button
        @click="userInfo(username)"
        type="primary"
        style="margin-left: 16px"
      >
        用户信息
      </el-button>
      <el-drawer title="用户信息" :visible.sync="drawer" :with-header="true">
        <!--内容区-->
        <div class="header_img">
          <el-row class="demo-avatar demo-basic">
            <el-col :span="12">
              <!-- <div class="sub-title">circle</div> -->
              <div class="demo-basic--circle">
                <div class="block">
                  <el-avatar :size="50" :src="circleUrl"> </el-avatar>
                </div>
                <!-- <div class="block">
          <el-avatar :size="size" :src="circleUrl"></el-avatar>
      </div> -->
              </div>
            </el-col>
          </el-row>
        </div>
        <!--用户信息数据-->
        <div>
          <el-table :data="userData" style="width: 100%">
            <el-table-column prop="name" label="姓名" width="180">
            </el-table-column>
            <el-table-column prop="uid" label="UID" width="180">
            </el-table-column>
            <el-table-column prop="roleID" label="角色"> </el-table-column>
          </el-table>
        </div>
        <!-- 展示用户所属的所有贴字-->
        <div>
          <el-table
            :data="postData"
            style="width: 100%"
            max-height="500"
          >
            <el-table-column fixed prop="post_time" label="日期" width="150">
            </el-table-column>
            <el-table-column prop="title" label="标题" width="120">
            </el-table-column>
            <el-table-column prop="pid" label="帖子ID" width="120">
            </el-table-column>
            <el-table-column prop="messagebody" label="消息体" width="300">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="120">
              <template slot-scope="scope">
                <el-button
                  @click.native.prevent="
                    deleteUserPost(scope.$index, scope.row)
                  "
                  type="text"
                  size="small"
                >
                  移除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-drawer>
    </div>
    <div class="calendar_block">
      <el-calendar v-model="value"> </el-calendar>
    </div>
    <h3>帖子论坛</h3>
    <hr />
    <!--帖子展示区-->
    <div class="post-block">
      <el-table :data="tableData" style="width: 50%">
        <el-table-column prop="post_time" label="日期" width="150">
        </el-table-column>
        <!--数据库设计缺陷，没有name-->
        <el-table-column prop="uid" label="用户ID" width="100">
        </el-table-column>
        <el-table-column prop="pid" label="帖子ID" width="100">
        </el-table-column>
        <el-table-column prop="title" label="标题" width="100">
        </el-table-column>
        <el-table-column prop="messagebody" label="帖子" width="500">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.post.block {
  /* display: inline-block; */
  width: 50%;
  height: 200px;
  background-color: #123456;
  float: left;
  margin-top: 5px;
}
.calendar_block {
  /* display: inline-block; */
  width: 50%;
  height: 200px;
  background-color: #987125;
  float: right;
}
hr {
  margin-top: -10px;
}
</style>
<script>
import axios from "axios";
export default {
  data() {
    return {
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      value: new Date(),
      dialogFormVisible: false,
      postFormVisible: false,
      userFormVisible: false,
      tableData: [],
      userData: [],
      postData: [],
      username: "",
      userId: "",
      user: {},
      //name:'',
      img: [
        { id: 0, idView: require("../assets/05.jpg") },
        { id: 1, idView: require("../assets/06.jpg") },
        { id: 2, idView: require("../assets/07.jpg") },
        { id: 3, idView: require("../assets/08.jpg") },
      ],
      form: {
        name: "",
        password: "",
      },
      postForm: {
        title: "",
        messagebody: "",
        pid: "",
      },
      userForm: {
        uid: "",
        name: "",
        password: "",
        age: "",
        sex: "",
        birthday: "",
        regsiter_date: "",
      },
      formLabelWidth: "120px",
      drawer: false,
    };
  },
  mounted: function () {
    this.getPost();
  },
  methods: {
    turnAdminPage() {
      //跳转页面
      this.dialogFormVisible = false;
      this.$router.push("/adminLoginPage");
    },
    //用户登陆
    userSignIn(form) {
      this.dialogFormVisible = false;
      axios({
        url: "/user/userLogin",
        params: {
          name: form.name,
          password: form.password,
        },
      }).then((res) => {
        if (res.data == "") {
          this.$message("登陆失败");
        } else if (res.data != "") {
          console.log(res.data);
          this.$message("登陆成功"),
            (this.username = res.data.name),
            (this.userId = res.data.uid);
          //为用户数据赋值
          //将对象放到数组中
          this.userData.push(res.data);
        }
      });
    },
    uploadPost(postForm, username) {
      this.postFormVisible = false;
      if (username == "") {
        this.$alert("请先登陆");
      } else {
        axios({
          url: "/postMessage/addPost",
          params: {
            messagebody: postForm.messagebody,
            title: postForm.title,
            pid: postForm.pid,
            uid: this.userId,
            name: this.name,
          },
        }).then((res) => {
          console.log(res);
          this.$message("发帖成功");
          this.getPost();
        });
      }
    },
    getPost() {
      axios({
        url: "/postMessage/selectPosts",
      }).then((res) => {
        //console.log(res.data)
        this.tableData = res.data;
      });
    },
    userInsert(userForm) {
      axios({
        url: "/user/userInsert",
        params: {
          uid: userForm.uid,
          name: userForm.name,
          password: userForm.password,
          age: userForm.age,
          sex: userForm.sex,
          birthday: userForm.birthday,
          register_date: userForm.register_date,
        },
      }).then((res) => {
        console.log(res);
        this.userFormVisible = false;
        this.$message("插入成功");
      });
    },
    //用户信息
    userInfo(username) {
      this.drawer = true;
      if (username == "") {
        this.$alert("请先登陆");
      } else {
        //请求用户的帖子
        this.getUserPost();
      }
    },
    //请求用户的帖子
    getUserPost() {
      axios({
        url: "/postMessage/selectPostMessagesByUid",
        params: {
          uid: this.userId,
        },
      }).then((res) => {
        console.log(res.data);
        this.postData = res.data;
      });
    },
    deleteUserPost(index, row) {
      axios({
        url: "/postMessage/deletePost",
        params: {
          pid: row.pid,
        },
      }).then((res) => {
        console.log(res);
        this.$message("删除成功");
        this.getUserPost();
      });
    },
  },
};
</script>