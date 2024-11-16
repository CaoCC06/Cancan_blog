const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 7070,
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 代理目标地址
        pathRewrite: {
          '^/api': '' // 将 /api 替换为空字符串
        }
      }
    }
  }
})
