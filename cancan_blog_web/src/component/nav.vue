<template>
    <header v-motion :initial="{ opacity: 0 }" :enter="{ opacity: 1 }" :duration="500">
        <input type="checkbox" id="check" name="check" />
        <h1 class="logo">Logo</h1>
        <nav class="nav">
            <h1 class="logo">Logo</h1>
            <div class="dividing-line"/>
            <a href="#">笔记</a>
            <a href="#">日历</a>
            <a href="#">树洞</a>
            <a href="#">工具箱</a>
        </nav>
        <div class="ls-group">
            <a class="login" href="#">Login</a>
            <a class="signup" href="#">Sign Up</a>
            <label for="check">
                <Icon icon="material-symbols:menu" class="menu"></Icon>
                <Icon icon="material-symbols:close" class="close-menu"/>
            </label>
        </div>
    </header>
</template>
<script setup scope>
    import { Icon } from '@iconify/vue';
</script>
<style lang="css" scoped>
header{
    display:fLex;
    position: fixed;
    align-items:center;
    justify-content:space-around;
    background:rgba(0,0,0,0.2);
    backdrop-filter:blur(10px);
    height:80px;
    width: 100%;
    z-index: 10;
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

.signup {
    border:rgba(255,255,255,0.5) 2px solid;
    padding: 8px 16px;
    margin-left: 16px;
    border-radius: 99px;
    transition: 300ms;
}
.signup:hover{
    background:rgba(255,255,255,0.2);
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
        margin: 10px 0px
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