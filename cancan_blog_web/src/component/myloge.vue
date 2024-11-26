<template>
  <div id="logo" >
    <div class="avatar" v-motion :initial="{ opacity: 0 }" :enter="{ opacity: 1 }" :duration="1000">
      <img src="../assets/img/avatar.png" alt="">
    </div>
    <div class="content"  v-motion :initial="{ opacity: 0 }" :enter="{ opacity: 1 }" :duration="1000">
      <h2 class="text-1">灿&nbsp;灿</h2>
      <h2 class="text-2">灿&nbsp;灿</h2>
    </div>
  </div>
</template>

<style scoped>
  #logo {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  .avatar {
    width: 9em;
    height: 9em;
    margin-bottom: 2em; /* 调整这个值来改变间距 */
  }

  img {
    border-radius: 50%;
    width: 100%;
    height: 100%;
    border: 3px #ddd solid;
    box-shadow: 0 0 10px 6px #b3bbff;
  }

  .content {
    position: relative;
    width: 100%;
  }

  .content h2 {
    font-size: 5em;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: fit-content;
  }

  .content h2:nth-child(1) {
    color: transparent;
    -webkit-text-stroke: 2px #0380f4;
  }

  .content h2:nth-child(2) {
    color: #0380f4;
    animation: animate 3s ease-in-out infinite;
  }

  @keyframes animate {
    0%,
    100% {
      clip-path: polygon(
        0% 45%,
        15% 44%,
        32% 50%,
        54% 60%,
        70% 61%,
        84% 59%,
        100% 52%,
        100% 100%,
        0% 100%
      );
    }

    50% {
      clip-path: polygon(
        0% 60%,
        16% 65%,
        34% 66%,
        51% 62%,
        67% 50%,
        84% 45%,
        100% 46%,
        100% 100%,
        0% 100%
      );
    }
  }
</style>
