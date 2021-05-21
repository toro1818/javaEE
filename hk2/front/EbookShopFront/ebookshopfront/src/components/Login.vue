<template>
  <div>
    <div class="admin_login_wrap">
      <h1>后台管理</h1>
      <div class="adming_login_border">
        <div class="admin_input">
          <form>
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
        </div>
      </div>
      <p class="admin_copyright"><a tabindex="5" href="/" target="_blank">返回首页</a> &copy; 2021 Powered by <a href="/" target="_blank">BJTU-Software</a></p>
    </div>
  </div>
</template>

<script>
import Qs from 'qs'
export default {
  data () {
    return {
      msg: '',
      loginForm: {
        username: 'admin',
        password: '123456'
      }
    }
  },
  methods: {
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
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
