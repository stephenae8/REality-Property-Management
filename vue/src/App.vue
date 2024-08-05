<template>
  <div id="capstone-app">
    <div id="nav">
      <!-- <router-link  v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link  v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link> -->
      <Navigator></Navigator>
    </div>
    <router-view />
  </div>
</template>

<script>
import Navigator from './components/Navigator.vue';
export default {
  components:{
Navigator,
  }
}
</script>

<style>
html{
  scroll-behavior: smooth;
}
</style>
