<template>
  <keep-alive>
    <myNav />
  </keep-alive>
  <keep-alive>
    <background />
  </keep-alive>
  <RouterView />
</template>
<script setup>
  import myNav from '@/component/nav.vue';
  import background from '@/component/background.vue';
</script>