<template>
    <div class="common-layout">
      <el-container>
        <!-- 侧边栏 -->
        <el-aside style="width:200px; min-height: 100vh;">
            <div class="logo"> logo</div>
            <el-menu router :defaut="$route.path">
                <el-menu-item index="/console">系统首页1</el-menu-item>
                <el-menu-item>系统首页2</el-menu-item>
                <el-sub-menu>
                    <template #title>
                        <el-icon><message /></el-icon>信息管理
                    </template>
                    <el-menu-item>用户信息</el-menu-item>
                </el-sub-menu>
            </el-menu>
        </el-aside>
        <el-container>
            <!-- 头部区域 -->
          <el-header>Header</el-header>
          <!-- 主体区域 -->
          <el-main>Main</el-main>
        </el-container>
      </el-container>
    </div>
</template>
<style lang="css" scoped>
    .logo{
        height: 60px;
        background-color: #8c939d; 
        color: white;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .el-menu{
        border: none;
        border-radius: 5%;
    }
</style>