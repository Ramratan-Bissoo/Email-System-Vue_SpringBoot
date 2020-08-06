import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Compose from '../views/Compose.vue'
import Inbox from '../views/inbox.vue'
import Sent from '../views/Sent'
import Profile from '../views/Profile'




Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    
    children:[
      {
        path: '/',
        name: 'Profile',
        component:Profile,
        meta: { requiresAuth: true }

      },
      {
        path: '/compose',
        name: 'Compose',
        component:Compose,
        meta: { requiresAuth: true },
        
      },
      {
        path: '/inbox',
        name: 'Inbox',
        component:Inbox,
        meta: { requiresAuth: true },
        
      },
     
      {
        path: '/sent',
        name: 'Sent',
        component:Sent,
        meta: { requiresAuth: true },
        
      },
      {
        path: '/profile',
        name: 'Profile',
        component:Profile,
        meta: { requiresAuth: true },
        
      }



    ]
  },
  
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../audocomponet/login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to,from,next)=>{
  const data =sessionStorage.getItem("Email");
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (data) {
       next();
    } else {
      next({ path: '/login' });
    }
  }
  else{
    next();
  }
  
})

export default router
