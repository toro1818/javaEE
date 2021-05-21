<template>
  <div>
    <div class="container clearfix">
      <!--/sidebar-->
      <div>
        <div class="crumb-wrap">
          <div class="crumb-list"><i class="icon-font"></i><a href="/index">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">书籍管理</span></div>
        </div>
        <div class="search-wrap">
          <div class="search-content">
            <form action="#" method="post">
              <table class="search-tab">
                <tr>
<!--                  <th width="120">选择分类:</th>-->
<!--                  <td>-->
<!--                    <select name="search-sort" >-->
<!--                      <option value="">全部</option>-->
<!--                      <option value="1">武侠小说</option>-->
<!--                      <option value="2">言情小说</option>-->
<!--                      <option value="3">玄幻小说</option>-->
<!--                      <option value="4">恐怖小说</option>-->
<!--                    </select>-->
<!--                  </td>-->
                  <th width="70">关键字:</th>
                  <td><input v-model="searchKey" class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                  <td><input @click="searchBtn" class="btn btn-primary btn2" name="sub" value="查询" type="button"></td>
                </tr>
              </table>
            </form>
          </div>
        </div>
        <div class="result-wrap">
          <form name="myform" id="myform" method="post">
            <div class="result-title">
              <div class="result-list">
                <a href="/index/AddBook"><i class="icon-font"></i>*新增书籍</a>
                <!--                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>-->
                <!--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
              </div>
            </div>
            <div class="result-content">
              <table class="result-tab" width="100%">
                <tr>
                  <th>ID</th>
                  <th>书名</th>
                  <th>作者</th>
                  <th style="width: 500px">内容简介</th>
                  <th>价格</th>
                  <th>操作</th>
                </tr>
                <tr v-for="(book,index) in this.bookList" :key="index">
                  <td>{{book.id}}</td>
                  <td>{{book.bookname}}</td>
                  <td>{{book.author}}</td>
                  <td>
                    <div  style="width: 400px;height: 50px;overflow: hidden;white-space:nowrap;text-overflow:ellipsis;">
                      {{book.intro}}
                    </div>
                  </td>
                  <td>{{book.price}}</td>
                  <td>
                    <a class="link-update margin-right" :href="'/index/ModifyBook/'+book.id">修改</a>
                    <a class="link-del pointer" @click="deleteBook(book.id)">删除</a>
                  </td>
                </tr>
              </table>
              <div class="list-page" text="${count}+'条 1/1 页'"> </div>
            </div>
          </form>
        </div>
      </div>
      <!--/main-->
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      searchKey: '',
      bookList: [
      ]
    }
  },
  methods: {
    async getBookList () {
      const result = await this.$http.get('/books', { headers: { Authentication: window.sessionStorage.getItem('token') } })
      console.log(result.data)
      this.bookList = result.data
    },
    async deleteBook (id) {
      const result = await this.$http.delete('/books/' + id, { headers: { Authentication: window.sessionStorage.getItem('token') } })
      console.log(result.data)
      await this.getBookList()
    },
    async searchBtn () {
      if (this.searchKey === '') {
        this.getBookList()
      } else {
        const result = await this.$http.get('/books/searchResult/' + this.searchKey, { headers: { Authentication: window.sessionStorage.getItem('token') } })
        console.log(result.data)
        this.bookList = result.data
      }
    }

  },
  created () {
    this.getBookList()
  }

}
</script>

<style scoped>
  .margin-right{
    margin-right: 10px;
  }
  .pointer {
    cursor: pointer;
  }
</style>
