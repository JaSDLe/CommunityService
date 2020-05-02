import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { Lazyload } from "vant"

Vue.config.productionTip = false
Vue.config.devtools = true

Vue.use(Lazyload)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
