import Vue from 'vue'
import Vuex from 'vuex'
import login from './model/loginapi'
import compose from './model/composeapi'
import inbox from './model/inboxapi'
import sent from './model/sentapi'
import profile from './model/profile'


Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    login,
    compose,
    inbox,
    sent,
    profile
  
  }
})
