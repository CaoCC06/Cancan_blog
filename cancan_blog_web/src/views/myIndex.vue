<template>
    <keep-alive>
      <myloge />
    </keep-alive>
    <arrow />
    <div class="myIndex"></div>
</template>
<script setup lang="js">
  import myloge from '@/component/myloge.vue';
  import arrow from '@/component/arrow.vue';
</script>
<style lang="css" scoped>
  @import "../assets/css/myIndex.css";
  .myIndex{
    width: 100%;
    height: 2000px;
    z-index: -1;
  }
</style>