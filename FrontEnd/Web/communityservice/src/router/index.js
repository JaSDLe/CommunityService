import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('@/views/index')
  },
  {
    path: '/login',
    component: () => import('@/views/member/login')
  },
  {
    path: '/register',
    component: () => import('@/views/member/register')
  },
  /**
   * member
   * 会员模块
   */
  {
    path: '/member/user-center',
    component: () => import('@/views/member/user-center')
  },
  {
    path: '/member/account-detail',
    component: () => import('@/views/member/user-center/detail')
  },
  /**
   * news
   * 新闻公告模块
   */
  {
    path: '/news/list',
    component: () => import('@/views/news/list')
  },
  {
    path: '/news/detail',
    component: () => import('@/views/news/detail')
  },
  {
    path: '/news/create',
    component: () => import('@/views/news/create')
  },
  {
    path: '/notice/create',
    component: () => import('@/views/news/notice/create')
  },
  {
    path: '/notice/detail',
    component: () => import('@/views/news/notice/detail')
  },
  /**
   * activity
   * 动态模块
   */
  {
    path: '/activity/list',
    component: () => import('@/views/activity/list')
  },
  {
    path: '/activity/create',
    component: () => import('@/views/activity/create')
  },
  {
    path: '/activity/detail',
    component: () => import('@/views/activity/detail')
  },
  /**
   * message
   * 私信模块
   */
  {
    path: '/message/list',
    component: () => import('@/views/message/list')
  },
  {
    path: '/message/detail',
    component: () => import('@/views/message/detail')
  },
  /**
   * community
   * 社区模块
   */
  {
    path: '/community/list',
    component: () => import('@/views/community/list')
  },
  {
    path: '/community/detail',
    component: () => import('@/views/community/detail')
  },
  {
    path: '/community/create',
    component: () => import('@/views/community/create')
  },
]

const router = new VueRouter({
  routes
})

export default router
