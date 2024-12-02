<template>
    <header :class="{ 'scrolled': isScrolled , 'not-scrolled': !isScrolled}" v-motion :initial="{ opacity: 0 }" :enter="{ opacity: 1 }" :duration="500">
        <input type="checkbox" id="check" name="check" v-model="ischecked"/>
        <h1 class="logo">Logo</h1>
        <nav class="nav">
            <h1 class="logo">Logo</h1>
            <div class="dividing-line"/>
            <RouterLink to="/myTest">笔记</RouterLink>
            <RouterLink to="/111">日历</RouterLink>
            <RouterLink to="/">树洞</RouterLink>
            <RouterLink to="/">工具箱</RouterLink>
        </nav>
        <div class="ls-group">
            <label for="check">
                <Icon icon="material-symbols:menu" class="menu"></Icon>
                <Icon icon="material-symbols:close" class="close-menu"/>
            </label>
        </div>
    </header>
</template>
<script setup scope>
    import { Icon } from '@iconify/vue';
    import { ref, onMounted, onUnmounted, watch } from 'vue';

    const isScrolled = ref(false);
    const isMobile = ref(false);
    const ischecked = ref(false);

    const handleScroll = () => {
        const newScrollPosition = window.scrollY;
        if (newScrollPosition != 0) {
            isScrolled.value = true;
        } else {
            isScrolled.value = false;
        }
        // console.log(newScrollPosition);
    };

    // 判断窗口大小
    const checkWindowSize = () => {
        isMobile.value = window.innerWidth <= 768;
    };

    onMounted(() => {
        checkWindowSize();
        window.addEventListener('resize', checkWindowSize);
        if (!isMobile.value) {
            window.addEventListener('scroll', handleScroll);
        }else {
            if (ischecked.value){
                isScrolled.value = true;
            }
            window.addEventListener('click', () => {
                isScrolled.value = true;
                setTimeout(() => {
                    if(!ischecked.value){
                        isScrolled.value = false;
                    }
                }, 5000);
            });
        }
    });

    onUnmounted(() => {
        window.removeEventListener('resize', checkWindowSize);
        if (!isMobile.value) {
            window.removeEventListener('scroll', handleScroll);
        }
    });

    watch(isMobile, (newVal) => {
        if (newVal) {
            window.removeEventListener('scroll', handleScroll);
        } else {
            window.addEventListener('scroll', handleScroll);
        }
    });
</script>
<style lang="css" scoped>
header{
    display:fLex;
    position: fixed;
    align-items:center;
    justify-content:space-around;
    background:rgba(0,0,0,0.2);
    backdrop-filter:blur(10px);
    height:70px;
    width: 100%;
    z-index: 10;
    top: -70px;
    transition: top 0.2s ease;
}

.scrolled{
    top: 0;
}

.not-scrolled{
    top: -70px;
}

.nav{
    display: flex;
    align-items: center;
    gap: 16px;
}

.logo{
    color: white;
}

.nav a{
    color: white;
    text-decoration: none;
    font-weight: 600;
    font-size: 18px;
    padding: 8px 16px;
    transition: 300ms;
    border-radius: 99px;
}

.nav a:hover{
    background:rgba(255,255,255,0.2);
}

.ls-group a{
    color: white;
    text-decoration: none;
    font-weight: 600;
    font-size: 18px;
}

.nav .logo , #check , .menu , .close-menu{
    display: none;
}
@media (max-width: 768px) {
    .nav {
        position:absolute;
        left: -100%;
        top: 0;
        display: flex;
        flex-direction: column;
        background: #0f172a;
        height: 100vh;
        width: 50%;
        padding: 0px 20px;
        gap: 24px;
        transition: 500ms;
        box-shadow: 10px 0px 20px rgba(0,0,0,0.2);
    }
    .nav .logo{
        margin-left: 16px;
        margin-top: 20px;
        display: block;
    }
    .dividing-line{
        background: rgba(255 ,255,255,0.2);
        width: 100%;
        height: 2px;
    }
    .ls-group{
        display: flex;
        align-items: center;
    }
    .signup{
        margin-right: 16px;
    }
    .menu ,.close-menu{
        display: block;
        font-size: 40px;
        color: wheat;
        cursor: pointer;
    }
    #check:checked ~ .ls-group .menu{
        display: none;
    }
    .close-menu{
        display: none;
    }
    #check:checked ~ .ls-group .close-menu{
        display: block;
    }
    #check:checked ~ .nav{
        left: 0;
    }
}

</style>
