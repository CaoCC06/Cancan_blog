<template>
  <div class="main-container">
    <!-- 封面 -->
    <div class="cover-screen">
      <keep-alive>
        <myNav />
      </keep-alive>
      <keep-alive>
        <myloge />
      </keep-alive>
      <keep-alive>
        <arrow />
      </keep-alive>
    </div>

    <!-- 学习板块 -->
    <div class="learning-screen">
      <div class="section-title">学习</div>
      <div class="section-content">
        <!-- 这里放置学习板块的内容 -->
        <p>这里是学习板块的内容。</p>
      </div>
    </div>

    <!-- 生活板块 -->
    <div class="life-screen">
      <div class="section-title">生活</div>
      <div class="section-content">
        <!-- 这里放置生活板块的内容 -->
        <p>这里是生活板块的内容。</p>
      </div>
    </div>
  </div>
</template>
<script setup lang="js">
  import myNav from '@/component/nav.vue';
  import myloge from '@/component/myloge.vue';
  import arrow from '@/component/arrow.vue';
</script>
<style lang="css" scoped>
  @import "@/assets/css/myIndex.css";

  .main-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    height: 300vh; /* 设置总高度为三个屏幕 */
    color: #333;
    font-family: Arial, sans-serif;
  }

  .cover-screen {
    width: 100%;
    height: 100vh; /* 封面占一个屏幕高度 */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
  }

  .learning-screen,
  .life-screen {
    width: 100%;
    height: 100vh; /* 每个屏幕占满一个视口高度 */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
  }

  .learning-screen {
    background-color: #e9ecef; /* 可以根据需要设置背景颜色 */
  }

  .life-screen {
    background-color: #dee2e6; /* 可以根据需要设置背景颜色 */
  }

  .section-title {
    font-size: 2.5rem;
    margin-bottom: 1rem;
    color: #333;
  }

  .section-content {
    font-size: 1.2rem;
    color: #666;
  }
</style>