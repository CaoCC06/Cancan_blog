<template>
    <div class="user-profile">
      <el-card shadow="always" class="profile-card">
        <div class="profile-header">
          <el-avatar :size="avatarSize" :src="avatarUrl" />
          <div class="profile-info">
            <h2>{{ userName }}</h2>
            <p>{{ phoneNumber }}</p>
          </div>
        </div>
        <div class="profile-details">
          <el-descriptions title="个人信息" :column="columnCount" border>
            <el-descriptions-item label="用户名">{{ userName }}</el-descriptions-item>
            <el-descriptions-item label="手机号">{{ phoneNumber }}</el-descriptions-item>
            <el-descriptions-item label="角色">{{ userRole }}</el-descriptions-item>
            <el-descriptions-item label="注册日期">{{ userRegistrationDate }}</el-descriptions-item>
          </el-descriptions>
        </div>
        <div class="profile-actions">
          <el-button type="primary" @click="editProfile">编辑资料</el-button>
          <el-button @click="changePassword">修改密码</el-button>
        </div>
      </el-card>
    </div>
  </template>
  
  <script>
  import { ref, computed, onMounted } from 'vue';
  import axios from 'axios';
  
  export default {
    setup() {
      const avatarUrl = ref('https://example.com/avatar.jpg'); // 替换为实际的头像URL
      const userName = ref('张三');
      const phoneNumber = ref('114514xxx114');
      const userRole = ref('管理员');
      const userRegistrationDate = ref('2023-01-01');
  
      const avatarSize = computed(() => {
        return window.innerWidth <= 768 ? 60 : 100;
      });
  
      const columnCount = computed(() => {
        return window.innerWidth <= 768 ? 1 : 2;
      });
  
      const isMobile = computed(() => {
        return window.innerWidth <= 768;
      });
  
      const fetchUserInfo = async () => {
        try {
          const response = await axios.get('/api/userInfo'); // 假设后端API地址为 /api/userInfo
          const userData = response.data;
          avatarUrl.value = userData.avatarUrl;
          userName.value = userData.userName;
          phoneNumber.value = userData.phoneNumber;
          userRole.value = userData.userRole;
          userRegistrationDate.value = userData.userRegistrationDate;
        } catch (error) {
          console.error('获取用户信息失败', error);
        }
      };
  
      onMounted(() => {
        fetchUserInfo();
      });
  
      const editProfile = () => {
        // 编辑资料逻辑
        console.log('编辑资料');
      };
  
      const changePassword = () => {
        // 修改密码逻辑
        console.log('修改密码');
      };
  
      return {
        avatarUrl,
        userName,
        phoneNumber,
        userRole,
        userRegistrationDate,
        avatarSize,
        columnCount,
        editProfile,
        changePassword,
      };
    },
  };
  </script>
  
  <style lang="css" scoped>
  .user-profile {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    padding: 20px; /* 添加一些内边距 */
  }
  
  .profile-card {
    width: 100%;
    max-width: 600px;
  }
  
  .profile-header {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
  }
  
  .profile-header .el-avatar {
    margin-right: 20px;
  }
  
  .profile-info h2 {
    margin: 0;
    font-size: 24px;
  }
  
  .profile-info p {
    margin: 5px 0 0;
    font-size: 16px;
    color: #666;
  }
  
  .profile-details {
    margin-bottom: 20px;
  }
  
  .profile-actions .el-button {
    margin-right: 10px;
  }
  
  /* 响应式样式 */
  @media (max-width: 768px) {
    .profile-header {
      flex-direction: column;
      align-items: flex-start;
    }
  
    .profile-header .el-avatar {
      margin-right: 0;
      margin-bottom: 10px;
    }
  
    .profile-info h2 {
      font-size: 20px;
    }
  
    .profile-info p {
      font-size: 14px;
    }
  
    .profile-actions {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
    }
  
    .profile-actions .el-button {
      margin-right: 0;
      margin-bottom: 10px;
    }
  }
  </style>