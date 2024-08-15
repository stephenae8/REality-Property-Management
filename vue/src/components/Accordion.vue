<template>
    <div class="accordion">
      <button @click="toggle" :class="{ active: isOpen }">{{ title }}</button>
      <transition name="slide-fade">
        <ul v-if="isOpen" :key="title">
          <li v-for="(item, index) in content" :key="index">{{ item }}</li>
        </ul>
      </transition>
    </div>
  </template>
  
  <script>
  export default {
    props: ['title', 'content'],
    data() {
      return {
        isOpen: false
      }
    },
    methods: {
      toggle() {
        this.isOpen = !this.isOpen;
      }
    }
  }
  </script>
  
  <style scoped>
  .accordion {
    width: 100%;
  }
  
  button {
    width: 100%;
    padding: 10px;
    background-color: #333;
    color: #fff;
    border: none;
    cursor: pointer;
  }
  
  button.active {
    background-color: #555;
  }
  
  ul {
    margin-top: 10px;
    list-style-type: none;
  }
  
  li {
    padding: 5px;
    border-bottom: 1px solid #ccc;
  }
  </style>