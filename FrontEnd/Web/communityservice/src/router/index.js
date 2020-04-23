import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: () => import('@/views/login')
  },
  {
    path: '/register',
    component: () => import('@/views/register')
  },
  {
    path: '/member/user-center',
    component: () => import('@/views/member/user-center')
  },
  {
    path: '/news/list',
    component: () => import('@/views/news/list')
  },
  {
    path: '/activity/list',
    component: () => import('@/views/activity/list')
  },
  {
    path: '/message/list',
    component: () => import('@/views/message/list')
  },
]

const router = new VueRouter({
  routes
})

export default router
