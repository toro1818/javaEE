<template>
  <div>
    <div class="topbar-wrap white">
      <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
          <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
          <ul class="navbar-list clearfix">
            <li><a class="on" href="/index">首页</a></li>
            <li><a href="/" target="_blank">网站首页</a></li>
          </ul>
        </div>
        <div class="top-info-wrap">
          <ul class="top-info-list clearfix">
<!--            <li><a href="#">管理员</a></li>-->
<!--            <li><a href="#">修改密码</a></li>-->
            <li><a href="/user/logout">退出</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container clearfix">
      <div class="sidebar-wrap">
        <div class="sidebar-title">
          <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
          <ul class="sidebar-list">
            <li>
              <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
              <ul class="sub-menu">
                <li><a href="/index/bookList"><i class="icon-font">&#xe008;</i>书籍管理</a></li>
                <!--                        <li><a href="bookList.html"><i class="icon-font">&#xe005;</i>文章管理</a></li>-->
              </ul>
            </li>
            <li>
              <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
              <ul class="sub-menu">
<!--                <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>-->
<!--                <li><a href="system.html"><i class="icon-font">&#xe037;</i>用户管理</a></li>-->
              </ul>
            </li>
          </ul>
        </div>
      </div>
      <!--/sidebar-->
      <div class="main-wrap">
        <router-view></router-view>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  data () {
    return {
      msg: '456'
    }
  }
}
</script>

<style scoped>

</style>
