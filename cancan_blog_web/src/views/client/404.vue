<template>
    <div class="not-found">
      <h1>404</h1>
      <p>页面未找到</p>
      <router-link to="/">返回首页</router-link>
    </div>
  </template>
  
  <script>
  export default {
    name: 'NotFound'
  }
  </script>
  
  <style scoped>
  .not-found {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    text-align: center;
    color: #343a40;
  }
  
  h1 {
    font-size: 5rem;
    margin-bottom: 1rem;
    color: #7d35dc;
  }
  
  p {
    font-size: 1.5rem;
    margin-bottom: 2rem;
    color: #6c757d;
  }
  
  a {
    font-size: 1.2rem;
    color: #007bff;
    text-decoration: none;
  }
  
  a:hover {
    text-decoration: underline;
  }
  
  @media (max-width: 768px) {
    h1 {
      font-size: 3rem;
    }
  
    p {
      font-size: 1rem;
    }
  
    a {
      font-size: 1rem;
    }
  }
  </style>
  