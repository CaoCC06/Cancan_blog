<template>
    <keep-alive>
      <myNav />
    </keep-alive>
    <keep-alive>
      <myloge />
    </keep-alive>
    <arrow />
    <div class="myIndex"></div>
</template>
<script setup lang="js">
  import myNav from '@/component/nav.vue';
  import myloge from '@/component/myloge.vue';
  import arrow from '@/component/arrow.vue';
</script>
<style lang="css" scoped>
  @import "@/assets/css/myIndex.css";
  .myIndex{
    width: 100%;
    height: 2000px;
    z-index: -1;
  }
</style>