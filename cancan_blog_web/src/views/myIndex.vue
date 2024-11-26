<template>
    <keep-alive>
      <background />
    </keep-alive>
    <keep-alive>
      <myNav />
    </keep-alive>
    <keep-alive>
      <myloge />
    </keep-alive>
    <div class="myIndex"></div>
</template>
<script setup lang="js">
  import background from '@/component/background.vue';
  import myloge from '@/component/myloge.vue';
  import myNav from '@/component/nav.vue';
</script>
<style lang="css" scoped>
  @import "../assets/css/myIndex.css";
  .myIndex{
    width: 100%;
    height: 2000px;
  }
</style>