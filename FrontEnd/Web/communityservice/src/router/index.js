import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    component: () => import('@/views/Home')
  },
  {
    path: '/about',
    component: () => import('@/views/About')
  },
  {
    path: '/',
    component: () => import('@/views/login')
  }
]

const router = new VueRouter({
  routes
})

export default router
