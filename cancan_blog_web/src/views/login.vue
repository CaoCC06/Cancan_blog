<template>
    <div class="login-container-full">
      <div class="login-container">
        <h2>登录</h2>
        <el-form :model="loginForm" :rules="rules" ref="loginFormRef" label-width="100px" class="demo-loginForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="loginForm.username" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(loginFormRef)">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, getCurrentInstance } from 'vue';
  import { ElMessage } from 'element-plus';
  import { useRouter } from 'vue-router';
  import { useStore } from 'vuex';
  
  const { proxy } = getCurrentInstance(); // 获取全局属性
  const router = useRouter();
  const store = useStore();
  
  const loginFormRef = ref(null);
  const loginForm = ref({
    username: '',
    password: ''
  });
  
  const rules = ref({
    username: [
      { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    password: [
      { required: true, message: '请输入密码', trigger: 'blur' }
    ]
  });
  
  const submitForm = (formEl) => {
    if (!formEl) return;
    formEl.validate((valid) => {
      if (valid) {
        login();
      } else {
        ElMessage.error('请输入正确的用户名和密码');
        return false;
      }
    });
  };
  
  const login = async () => {
    try {
      const response = await proxy.$axios.post('/api/login', {
        username: loginForm.value.username,
        password: loginForm.value.password
      });
      console.log(response);
      if (response.data.data.token) {
        store.commit('setToken', response.data.token);
        ElMessage.success('登录成功');
        router.push('/admin/console');
      } else {
        ElMessage.error('登录失败，请检查用户名和密码');
      }
    } catch (error) {
      ElMessage.error('登录失败，请检查用户名和密码');
      console.error(error);
    }
  };
  </script>
  
  <style scoped>
  /* 全屏居中 */
  .login-container-full {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  
  /* 居中显示 */
  .login-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* 阴影效果 */
    background-color: #fff; /* 表单背景颜色 */
    text-align: center;
    width: 100%;
    max-width: 400px; /* 最大宽度 */
  }
  
  h2 {
    margin-bottom: 30px;
    color: #333; /* 标题颜色 */
    font-size: 24px; /* 标题字体大小 */
    font-weight: bold; /* 标题字体加粗 */
  }
  
  .el-form-item {
    margin-bottom: 20px;
  }
  
  .el-form-item__label {
    color: #606266; /* 标签颜色 */
    font-size: 16px; /* 标签字体大小 */
  }
  
  .el-input__inner {
    border-radius: 5px; /* 输入框圆角 */
    border: 1px solid #dcdfe6; /* 输入框边框 */
    padding: 12px; /* 输入框内边距 */
    font-size: 16px; /* 输入框字体大小 */
  }
  
  .el-button {
    width: 100%;
    padding: 12px; /* 按钮内边距 */
    border-radius: 5px; /* 按钮圆角 */
    font-size: 16px; /* 按钮字体大小 */
  }
  
  .el-button--primary {
    background-color: #409EFF; /* 主按钮背景颜色 */
    border-color: #409EFF; /* 主按钮边框颜色 */
  }
  
  .el-button--primary:hover {
    background-color: #66b1ff; /* 主按钮悬停背景颜色 */
    border-color: #66b1ff; /* 主按钮悬停边框颜色 */
  }
  
  .el-button:hover {
    background-color: #f5f7fa; /* 按钮悬停背景颜色 */
    border-color: #dcdfe6; /* 按钮悬停边框颜色 */
  }
  </style>