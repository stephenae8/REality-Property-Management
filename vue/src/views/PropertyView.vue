<template>
    <Property :id="number" ></Property>
  </template>
  
  <script>
  import Property from '../components/Property.vue';
  import Navigator from '../components/Navigator.vue';
  export default {
    
    components: {
      Property,
      Navigator
    },
   

    data(){
      return{
        number: parseInt(this.$route.params.id)
      }
    }
  
  }
  </script>
  
  <style>
  
  </style>