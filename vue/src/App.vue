<template>
  
      <!-- <router-link  v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link  v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link> -->
      <Navigator></Navigator>
  
    <router-view :key="$route.fullPath" />
    <FooterP></FooterP>
 
</template>

<script>
import Navigator from './components/Navigator.vue';
import FooterP from './components/Footer.vue';

export default {
  components:{
    Navigator,
    FooterP
  }
}
</script>

<style>
html{
  scroll-behavior: smooth;
}
</style>
