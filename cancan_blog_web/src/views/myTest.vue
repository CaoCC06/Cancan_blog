<template>
    <el-button @click="test">测试</el-button>
    <el-input v-model="input" placeholder="返回的内容" disabled/>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';

var input = ref('')

const test = () => {
    axios.get('/api/test')
    .then(res => {
        input.value = res.data.data
        console.log(res.data)
    })
    .catch(error =>{
        console.log(error.response)
    })
}
</script>