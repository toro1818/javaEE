<template>
  <div>
    <div>
      <div class="crumb-wrap">
        <div class="crumb-list">
          <i class="icon-font"></i>
          <a href="/index">首页</a>
          <span class="crumb-step">&gt;</span>
          <a class="crumb-name" href="/index/bookList">书籍管理</a>
          <span class="crumb-step">&gt;</span><span>修改书籍</span></div>
      </div>
      <div class="result-wrap">
        <div class="result-content">
          <form id="myform" name="myform">
            <table class="insert-tab" width="100%">
              <tbody>
              <tr>
                <th><i class="require-red">*</i>书名：</th>
                <td>
                  <input v-model="bookForm.bookname" class="common-text required" id="bookname" name="bookname" size="50"  type="text">
                </td>
              </tr>
              <tr>
                <th><i class="require-red">*</i>作者：</th>
                <td><input v-model="bookForm.author" class="common-text" name="author" size="50" value="" type="text"></td>
              </tr>
              <tr>
                <th><i class="require-red">*</i>简介：</th>
                <td><textarea v-model="bookForm.intro" name="intro" class="common-textarea" id="content" cols="30" style="width: 45%;" rows="10"></textarea></td>
              </tr>
              <tr>
                <th><i class="require-red">*</i>价格：</th>
                <td><input v-model="bookForm.price" class="common-text" name="price" size="50" value="" type="text"></td>
              </tr>
              <tr>
                <th></th>
                <td>
                  <input @click="submitBtn()" class="btn btn-primary btn6 mr10" value="提交" type="button">
                  <button class="btn btn6" ><a href="/index/bookList">返回</a></button>
                </td>
              </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      bookForm: {
        bookname: '发哥经典',
        author: '周润发',
        intro: 'XXXXXXXXXX',
        price: '10.0'
      }
    }
  },
  methods: {
    async getBook () {
      const result = await this.$http.get('/books/' + this.$route.params.id,
        { headers: { Authentication: window.sessionStorage.getItem('token') } })
      console.log(result.data)
      this.bookForm = result.data
    },
    async submitBtn () {
      const result = await this.$http.put('/books', this.bookForm, { headers: { Authentication: window.sessionStorage.getItem('token') } })
      console.log(result.data)
      this.$router.push('/index/BookList')
    }
  },
  created () {
    this.getBook()
  }
}
</script>

<style scoped>

</style>
