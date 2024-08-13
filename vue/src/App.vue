<template>
  <!-- <router-link  v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link  v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link> -->
  <Navigator></Navigator>

  <router-view :key="$route.fullPath" />
  <FooterP></FooterP>
</template>

<script>
import Navigator from "./components/Navigator.vue";
import FooterP from "./components/Footer.vue";

export default {
  components: {
    Navigator,
    FooterP,
  },
};
</script>

<style>
html {
  scroll-behavior: smooth;
}
body {
  padding-top: 83px; /* Adjusted for nav bar */
}
@media (max-width: 480px) {
  body {
    padding-top: 290px;
  }
}
@media (max-width: 768px) {
  body {
    padding-top: 290px;
  }
}
</style>
