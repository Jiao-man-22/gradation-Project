import Vue from 'vue'
import VueRouter from 'vue-router'
import userTablePage from '../components/userTablePage'
import adminPage from '../components/adminPage.vue'
import adminLoginPage from '../components/adminLoginPage.vue'
import postsPage from '../components/postsPage.vue'
import mainPage  from '../components/mainPage.vue'
import commentsByPid from '../components/commentsByPid.vue'
import studyArea from '../components/studyArea.vue'
import python from '../components/python.vue'
import ios from '../components/ios.vue'
import php from '../components/php.vue'
import javaweb from '../components/javaweb.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/mainPage'
  },
  {
    path: '/adminLoginPage',
    name: 'AdminLoginPage',
    component: adminLoginPage
  },
  {
    path: '/adminPage',
    name: 'AdminPage',
    redirect: "/userTablepage",
    component: adminPage,
    children: [{
      path: "/userTablePage",
      component: userTablePage
    },
    {
      path: '/postsPage',
      //name: 'PostsPage',
      component: postsPage
    }]
  },
  // {
  //     path:"/adminPage",
  //     name:"AdminPage",
  //     component:()=>import('../components/adminPage'),
  //     children:[
  //     {path:'/userTablePage',userTablePage},
  //     {path:'/postsPage',postsPage}
  //     ]
  // },
  {
    path:'/mainPage',
    component:mainPage,
    redirect: "/studyArea",
    children:[
      { 
        path:'/studyArea',
        component:studyArea
    },
    {
        path:'/python',
        component:python
    },
    {
        path:'/ios',
        component:ios
    },
    {   path:'/javaweb',
        component:javaweb},
      {
        path:'/php',
        component:php
      }
    ]
  },
  {
    path:'/commentsByPid',
    component:commentsByPid,
  },


  // {
  //   path: '/postsPage',
  //   name: 'PostsPage',
  //   component: () => import('../components/postsPage.vue')
  // }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
