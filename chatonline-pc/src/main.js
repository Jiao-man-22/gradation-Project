import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//在main.js中引入 axios
import axios from 'axios'
axios.defaults.baseURL='http://localhost:8080'
//Vue 原型挂载
Vue.prototype.axios=axios
Vue.use(ElementUI)
Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')

