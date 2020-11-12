import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
export default new Vuex.Store({
    state: {
        uid:'',
        username:'',
        pid:'',
        childrenPostData:[]
    },
    mutations: {
        changValue(state,sb){
            state.uid=sb.uid,
            state.username=sb.username

        },
        addPid(state,playload){
            state.pid=playload.pid
        },
        addData(state,sb){
            state.childrenPostData=sb.data
        }
    }
  })