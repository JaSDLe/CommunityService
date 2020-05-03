import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { Lazyload, Toast } from "vant"

Vue.config.productionTip = false
Vue.config.devtools = true

Vue.use(Lazyload)

router.beforeEach((to, from, next) => {
  console.log('isLogin : ' + store.getters.isLogin)
  if (store.getters.isLogin) {
    next()
  } else {
    const paths = ['/', '/login', '/register']
    if (paths.includes(to.path)) {
      next()
    } else {
      Toast.fail('登录信息失效')
      next('/login')
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
