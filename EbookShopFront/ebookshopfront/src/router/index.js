import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import Index from '../components/Index'
import BookList from '../components/BookList'
import System from '../components/System'
import AddBook from '../components/AddBook'
import ModifyBook from '../components/ModifyBook'
import Cart from '../components/Cart'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index'
  },
  {
    path: '/login1',
    name: 'Login',
    component: Login
  },
  {
    path: '/index',
    name: 'Index',
    component: Index,
    children: [
      { path: '/index/Cart', component: Cart },
      { path: '/index/BookList', component: BookList },
      { path: '/index/System', component: System },
      { path: '/index/AddBook', component: AddBook },
      { path: '/index/ModifyBook/:id', component: ModifyBook }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
