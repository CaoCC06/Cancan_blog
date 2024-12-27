<template>
  <div class="arrows-body">
    <div class="arrow" @click="scrollToArrowsBody"></div>
    <div class="arrow" @click="scrollToArrowsBody"></div>
    <div class="arrow" @click="scrollToArrowsBody"></div>
    <div class="taking"></div>
  </div>
</template>

<script setup>
  const scrollToArrowsBody = () => {
    const learningSection = document.querySelector('.learning-screen');
    if (learningSection) {
      learningSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
    } else {
      console.error('Learning section not found');
    }
  };
</script>

<style lang="css" scoped>
  .arrows-body {
    position: relative;
    top: 45vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .taking {
    position: relative;
    width: 25px;
    height: 25px;
  }

  .arrow {
    position: relative;
    width: 25px;
    height: 25px;
    border-top: 5px solid #fff;
    border-left: 5px solid #fff;
    transform: rotate(-135deg);
    animation: arrow-load 2s infinite;
    cursor: pointer;
  }

  .arrow:nth-child(1) {
    animation-delay: -0.2s;
  }

  .arrow:nth-child(2) {
    animation-delay: -0.1s;
  }

  @keyframes arrow-load {
    0% {
      opacity: 0;
      transform: rotate(-135deg) translate(15px, 15px);
    }
    50% {
      opacity: 1;
    }
    100% {
      opacity: 0;
      transform: rotate(-135deg) translate(-15px, -15px);
    }
  }
</style>