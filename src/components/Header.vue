<!-- Header.vue -->
<template>
    <div class="aa">
    <el-header style="height: 60px; display: flex; align-items: center; box-shadow: 2px 0 6px rgba(0, 21, 41, .35);">
            <!-- 侧边栏展开收缩！！collapseIcon：点击侧边栏图标样式  handleCollapse：绑定了图标点击事件（脚本）  还有图标大小为30px-->
            <i :class="collapseIcon" @click="handleCollapse" style="font-size: 30px"></i>
            <!-- 绑定字体距离图标的距离、还有点击图标跳转的路由 -->
            <el-breadcrumb separator="/" style="margin-left: 20px">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/' }">每日销售情况</el-breadcrumb-item>
            </el-breadcrumb>
                  <!--点击收缩栏时候的头部弹性布局，justify-content：推向右边 。align-items：内容居中 -->
            <div style="flex: 1; display: flex; justify-content: flex-end; align-items: center">
              <!-- placement="bottom"：按钮触发下方弹出  cursor: pointer：鼠标放到这里变成一个手指-->
              <el-dropdown placement="bottom">
                <div style="display: flex; align-items: center; cursor: pointer">
                  <!-- 图标的设置和宽度 -->
                  <img :src="require('@/assets/images/vegetable.png')" style="width: 30px;" alt="">
                  <span>管理员</span>
                </div>
                <!-- 顶部的触碰显示下来信息 -->
                <el-dropdown-menu slot="dropdown">
                    <router-link to="/person" style="text-decoration: none">
                    <el-dropdown-item>个人信息</el-dropdown-item>
                    </router-link>
                    <router-link to="/change-password" style="text-decoration: none">
                    <el-dropdown-item>修改密码</el-dropdown-item>
                    </router-link>
                    <el-dropdown-item @click="handleLogout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
          </el-header>
        </div>
  </template>
   
  <script>
  export default {
    name: 'Header',
    props: {
      collapseIcon: String,
      handleCollapse: Function
      // 其他需要的 props
    }
    // 其他逻辑和方法
  };
  </script>
   
  <style>
   
  </style>