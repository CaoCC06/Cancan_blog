<template>
    <div class="mb-6">
        <el-button @click="test">测试</el-button>
    </div>
</template>
<script setup>
import axios from 'axios';

const test = () => {
    axios.get('http://localhost:8080/test')
    .then(res => {
        console.log(res.data)
    })
    .catch(error =>{
        console.log(error.response)
    })
}
</script>