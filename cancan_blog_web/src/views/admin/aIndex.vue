<template>
  <div class="common-layout">
    <el-container>
      <!-- 侧边栏 -->
      <el-aside :width="isCollapse ? '64px' : '200px'" class="sidebar">
        <div class="logo" :style="{ width: isCollapse ? '64px' : '200px' }">
          <span v-if="!isCollapse">Logo</span>
        </div>
        <el-menu
          router
          :default-active="$route.path"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          :collapse="isCollapse"
          :collapse-transition="false"
        >
          <el-menu-item index="/admin/console">
            <el-icon><HomeFilled /></el-icon>
            <template #title>控制台</template>
          </el-menu-item>
          <el-menu-item index="/admin/homepage">
            <el-icon><Document /></el-icon>
            <template #title>系统首页</template>
          </el-menu-item>
          <el-sub-menu index="/info">
            <template #title>
              <el-icon><Message /></el-icon>
              <span>信息管理</span>
            </template>
            <el-menu-item index="/info/user">
              <el-icon><User /></el-icon>
              <template #title>用户信息</template>
            </el-menu-item>
            <el-menu-item index="/info/settings">
              <el-icon><Setting /></el-icon>
              <template #title>设置</template>
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item index="/admin/userInfo">
            <el-icon><User /></el-icon>
            <template #title>个人资料</template>
          </el-menu-item>
          <el-menu-item @click="logout">
            <el-icon><SwitchButton /></el-icon>
            <template #title>退出登录</template>
          </el-menu-item>
        </el-menu>
        <div class="toggle-button" @click="toggleCollapse">
          <el-icon v-if="isCollapse"><Expand /></el-icon>
          <el-icon v-else><Fold /></el-icon>
        </div>
      </el-aside>
      <el-container>
        <!-- 头部区域 -->
        <el-header>
          <div class="header-left">
            <h1>后台管理系统</h1>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/admin/console' }">
                <el-icon><HomeFilled /></el-icon>
                控制台
              </el-breadcrumb-item>
              <el-breadcrumb-item>{{ breadcrumbTitle }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          <div class="header-right">
            <el-dropdown>
              <span class="el-dropdown-link">
                <el-avatar :size="30" :src="avatarUrl" />
                <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item icon="el-icon-user" @click="navigateToUserProfile">个人资料</el-dropdown-item>
                  <el-dropdown-item icon="el-icon-setting">设置</el-dropdown-item>
                  <el-dropdown-item icon="el-icon-switch-button" @click="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </el-header>
        <!-- 主体区域 -->
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import { HomeFilled, Document, Message, User, Setting, SwitchButton, Expand, Fold } from '@element-plus/icons-vue';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
import { ref, watch, getCurrentInstance } from 'vue';

export default {
  components: {
    HomeFilled,
    Document,
    Message,
    User,
    Setting,
    SwitchButton,
    Expand,
    Fold,
  },
  data() {
    return {
      isCollapse: false,
      avatarUrl: 'https://example.com/avatar.jpg', // 替换为实际的头像URL
    };
  },
  setup() {
    const router = useRouter();
    const store = useStore();
    const breadcrumbTitle = ref('');
    const { proxy } = getCurrentInstance(); // 获取全局属性

    // 监听路由变化以更新面包屑标题
    watch(
      () => router.currentRoute.value.path,
      (newPath) => {
        switch (newPath) {
          case '/admin/console':
            breadcrumbTitle.value = '';
            break;
          case '/admin/homepage':
            breadcrumbTitle.value = '系统首页';
            break;
          case '/info/user':
            breadcrumbTitle.value = '用户信息';
            break;
          case '/info/settings':
            breadcrumbTitle.value = '设置';
            break;
          case '/admin/userInfo':
            breadcrumbTitle.value = '个人资料';
            break;
          default:
            breadcrumbTitle.value = '未知';
        }
      },
      { immediate: true }
    );

    const logout = async () => {
      try {
        const token = store.state.token;
        if (!token) {
          throw new Error('未找到令牌');
        }
        console.log(token);
        await proxy.$axios.get('/api/userLogout', {
          headers: {
            'token': token // 使用与拦截器一致的头部名称
          }
        }).then(res => {
          console.log(res.data.data);
        });
        store.commit('clearToken');
        router.push('/');
      } catch (error) {
        console.error('退出登录失败', error);
      }
    };

    const navigateToUserProfile = () => {
      router.push('/admin/userInfo');
    };

    return {
      logout,
      breadcrumbTitle,
      navigateToUserProfile,
    };
  },
  methods: {
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
  },
};
</script>

<style lang="css" scoped>
@import "@/assets/css/aIndex.css";

.header-left {
  display: flex;
  align-items: center;
}

.header-left h1 {
  margin-right: 20px;
  font-size: 20px;
  color: #333;
}

.el-breadcrumb {
  margin-top: 10px;
  font-size: 14px;
  color: #666;
}

.el-breadcrumb .el-breadcrumb__inner {
  color: #333;
  font-weight: 400;
}

.el-breadcrumb .el-breadcrumb__inner a,
.el-breadcrumb .el-breadcrumb__inner a:hover {
  color: #409EFF;
  text-decoration: none;
}

.el-breadcrumb .el-breadcrumb__separator {
  color: #999;
}

.el-breadcrumb .el-icon {
  margin-right: 5px;
  font-size: 16px;
}
</style>