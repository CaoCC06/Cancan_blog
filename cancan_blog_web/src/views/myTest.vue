<template>
    <el-button @click="testGet">测试Get请求</el-button>
    <el-input v-model="inputGet" placeholder="Get请求返回的内容" disabled/>
    <el-button @click="testPost">测试Post请求</el-button>
    <el-input v-model="inputPost" placeholder="Post请求返回的内容" disabled/>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';

var inputGet = ref('')
var inputPost = ref('')

const testGet = () => {
    axios({
        method: 'get',
        url: '/api/test',
    })
    .then(res => {
        inputGet.value = res.data.data
        console.log(res.data.data)
    })
    .catch(error =>{
        console.log(error.response)
    })
}
const testPost = () => {
    axios({
        method: 'post',
        url: '/api/test',
        data: {
            name: 'test',
            age: 18
        }
    })
    .then(res => {
        inputPost.value = res.data.data.name +" "+ res.data.data.age
        console.log(res.data.data)
    })
    .catch(error =>{
        console.log(error.response)
    })
}
</script>