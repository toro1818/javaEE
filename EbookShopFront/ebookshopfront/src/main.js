import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './assets/css/admin_login.css'
import './assets/css/common.css'
import './assets/css/main.css'
import element from 'element-ui'
import axios from 'axios'
Vue.config.productionTip = false
// 配置请求的根路径
axios.defaults.baseURL = 'http://127.0.0.1:80/api'
// axios.defaults.baseURL = 'http://127.0.0.1:8080/rng/'

Vue.prototype.$http = axios
Vue.use(element)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
