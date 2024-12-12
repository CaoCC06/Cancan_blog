<template>
  <div class="not-found">
    <div class="error-container">
      <div class="error-code">404</div>
      <div class="error-message">页面未找到</div>
      <div class="description">您访问的页面不存在或已被移除。</div>
      <router-link to="/" class="back-home">返回首页</router-link>
    </div>
  </div>
</template>
<style scoped>
.not-found {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  color: #333;
  font-family: Arial, sans-serif;
}

.error-container {
  text-align: center;
  padding: 4rem;
}

.error-code {
  font-size: 8rem;
  margin-bottom: 1rem;
  color: #ff6b6b;
}

.error-message {
  font-size: 2rem;
  margin-bottom: 1rem;
  color: #333;
}

.description {
  font-size: 1.2rem;
  margin-bottom: 2rem;
  color: #666;
}

.back-home {
  font-size: 1.2rem;
  color: #fff;
  text-decoration: none;
  padding: 0.75rem 2rem;
  background-color: #ff6b6b;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.back-home:hover {
  background-color: #ff4d4d;
}
</style>