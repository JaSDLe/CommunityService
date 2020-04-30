import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/member/user-center'
  },
  {
    path: '/login',
    component: () => import('@/views/login')
  },
  {
    path: '/register',
    component: () => import('@/views/register')
  },
  // member
  {
    path: '/member/user-center',
    component: () => import('@/views/member/user-center')
  },
  {
    path: '/member/account-detail',
    component: () => import('@/views/member/user-center/detail')
  },
  // news
  {
    path: '/news/list',
    component: () => import('@/views/news/list')
  },
  // activity
  {
    path: '/activity/list',
    component: () => import('@/views/activity/list')
  },
  // message
  {
    path: '/message/list',
    component: () => import('@/views/message/list')
  },
  // community
  {
    path: '/community/list',
    component: () => import('@/views/community/list')
  },
  {
    path: '/community/detail',
    component: () => import('@/views/community/detail')
  },
]

const router = new VueRouter({
  routes
})

export default router
