<template>
  <keep-alive>
    <background />
  </keep-alive>
  <RouterView />
</template>
<script setup>
  import background from '@/component/background.vue';
</script>