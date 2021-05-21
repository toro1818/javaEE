<template>
  <div>
    <div class="admin_login_wrap">
      <h1>后台管理</h1>
      <div class="adming_login_border">
        <div class="admin_input">
          <!-- 登录 -->
          <form v-show="isLogin">
            <ul class="admin_items">
              <li>
                <label for="user">用户名：</label>
                <input type="text" name="username" v-model="loginForm.username" id="user" size="33" class="admin_input_style" />
              </li>
              <li>
                <label for="pwd">密码：</label>
                <input type="password" name="password" v-model="loginForm.password" id="pwd" size="33" class="admin_input_style" />
              </li>
              <li>
                <input type="button" @click="loginBtn" tabindex="3" value="提交" class="btn btn-primary" />
              </li>
              <p style="color: red" >{{msg}}</p>
            </ul>
          </form>
          <!-- 注册 -->
          <form v-show="!isLogin">
            <ul class="admin_items">
              <li>
                <label for="user">用户名：</label>
                <input type="text" name="username" v-model="registerForm.username"  size="33" class="admin_input_style" />
              </li>
              <li>
                <label for="pwd">密码：</label>
                <input type="password" v-model="registerForm.password"  size="33" class="admin_input_style" />
              </li>
              <li>
                <label for="pwd">再次输入密码：</label>
                <input type="password"  v-model="registerForm.password2"  size="33" class="admin_input_style" />
              </li>
              <li>
                <input type="button" @click="registerBtn" tabindex="3" value="提交" class="btn btn-primary" />
              </li>
              <p style="color: red" >{{msg}}</p>
            </ul>
          </form>
        </div>
      </div>
      <p @click="this.switchBtn" class="admin_copyright"><a  tabindex="5" target="_blank">{{this.isLogin ==true ? this.switch='立即注册':this.switch='立即登录'}}</a> BJTU-Software</p>
    </div>
  </div>
</template>

<script>
import Qs from 'qs'
export default {
  data () {
    return {
      switch: '立即注册',
      isLogin: true,
      msg: '',
      loginForm: {
        username: 'admin',
        password: '123456'
      },
      registerForm: {
        username: 'admin',
        password: '123456',
        password2: '123456'
      }
    }
  },
  methods: {
    switchBtn () {
      this.isLogin = !this.isLogin
    },
    async loginBtn () {
      const result = await this.$http.post('/login', Qs.stringify({
        username: this.loginForm.username,
        password: this.loginForm.password
      }))
      if (result.status === 200) {
        if (result.data.code === 200) {
          window.sessionStorage.setItem('token', result.headers.token)
          console.log(result)
          this.msg = result.data.msg
          await this.$router.push('/index')
        } else {
          this.msg = result.data.msg
        }
      }
    },
    async registerBtn () {
      const result = await this.$http.post('/register', this.registerForm)
      if (result.status === 200) {
        if (result.data.code === 200) {
          console.log(result.data)
          this.msg = result.data.msg
          this.isLogin = true
        } else {
          this.msg = result.data.msg
        }
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
