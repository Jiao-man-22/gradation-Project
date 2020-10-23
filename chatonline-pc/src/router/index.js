import Vue from 'vue'
import VueRouter from 'vue-router'
import userTablePage from '../components/userTablePage'
import adminPage from '../components/adminPage.vue'
import adminLoginPage from '../components/adminLoginPage.vue'
import postsPage from '../components/postsPage.vue'
import mainPage  from '../components/mainPage.vue'


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
    component:mainPage
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
