<template>
  <div class="outer_container">
    <div class="top_box">
      <h1>帖子详情页</h1>
      <span>用户名： {{$store.state.username}}</span>
    </div>

    <div >
      <ul style="list-style:none" >
      
        <!--帖子楼层-->
       
        <li class="parent_post"  @click="show_subcomment()" v-for="(post_item,index) in postList" :key="index" ><p style="font-size:20px">{{post_item.spokesman}}:{{post_item.text}}</p><span @click="sendReply(index)" style="color:blue">回复</span>&nbsp;<span style="font-size:15px;color:blue" @click="scanComment(index)">查看评论</span>
           <!--子评论-->
        <div  ref="abc" style="display:none">
          <ul style="list-style:none">
             <li v-for="(item,index) in commentList" :key="index">{{item.name}}:{{item.text}}</li>
           </ul>
        <el-input
        type="textarea"
        :rows="1"
        placeholder="请输入内容"
        v-model="commentArea">
        </el-input>
        <el-button type="primary" @click="sendComment(index)">发表</el-button>
           </div>
      </li>
          
        
      </ul>
    </div>
    <!--追加楼层-->
  <el-input
  type="textarea"
  :rows="2"
  placeholder="请输入内容"
  v-model="PostArea">
</el-input>
  <el-button type="primary" @click="sendChildrenPost()">发表你的看法</el-button>
  


  </div>
</template>
<script>
import axios from 'axios'
export default {
  
  data() {
    return {
    floor_num:'',
    PostArea:'',
    postList:[],
    commentArea:'',
    commentList:[],
    }
  },
  mounted:function(){
    this.getData()

  },
  created:function(){},
  //和date函数平级
   methods: {
     getData(){
       this.postList=this.$store.state.childrenPostData
     },
     
    show_subcomment(){
      // this.$refs.sub_comment.style.display='block', 
    },
    sendReply(index){
     this.commentList=''
    // this.hiddenLi(index)
      this.hiddenLi()
     this.$refs.abc[index].style.display='block'
      
      if(this.commentArea!=''){
        this.commentArea=''
      }

    },
    scanComment(index){
      this.hiddenLi(index)
      this.$refs.abc[index].style.display='block',
    
      this.commentList=''
      axios({
        url:'/comment/selectCommentByCip',
        params:{
            cpid:index+1
        }
      }).then(res=>{
        console.log(res.data)
        this.commentList=res.data
      }
      )
     
      
      
    },
    sendChildrenPost(){
      axios({
        url:'/ChildrenPost/insertPost',
        params:{
          text:this.PostArea,
          spokesman:this.$store.state.username,
          pid:this.$store.state.pid
        }
      }).then(res=>{
        console.log(res)
        this.$message('发帖成功')
        this.getPostData()
      })

    },
    getPostData(){
      axios({
        url:'/ChildrenPost/selectPostByPid',
        params:{
          pid:this.$store.state.pid
        }
      }).then(res=>{
        this.postList=res.data
      })
    },
    sendComment(index){
      axios({
        url:'/comment/insertComment',
        params:{
          name:this.$store.state.username,
          text:this.commentArea,
          cpid:index+1
        }
      }).then(res=>{
        console.log(res)
        this.$message("回复成功")
        this.commentArea=''
      })
    },
    hiddenLi(){
        // if(index==0){
        //   this.$refs.abc[index+1].style.display='none'  
        // }
        // if(index>0 && index<this.postList.length-1){
        //   this.$refs.abc[index+1].style.display='none'
        //   this.$refs.abc[index-1].style.display='none'
        // }
        // if(index==this.postList.length-1){
        //    this.$refs.abc[index-1].style.display='none'
        // }
        var num=this.$refs.abc.length
     
          for(var i=0;i<num;i++){
             this.$refs.abc[i].style.display='none'
          }
        
        
        // this.$refs.abc[index+1].style.display="none"
    
      
    }
   
  },
 

  
}
</script>
<style  scoped>
.outer_container{
width: 50%;
margin: 0 auto;
}
.sub_comment{
  /* display: none; */
  border: blanchedalmond 1px solid;
  list-style: none;

}

.parent_post{
  
  border:bisque 1px solid;
  margin-bottom: 10px;
  padding: 10px;
}

</style>