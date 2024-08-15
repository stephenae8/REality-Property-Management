<template>

<Owner></Owner>


  
  </template>
  
  <script>
  import Owner from '../components/Owner.vue';

  export default {
    components: {
      Owner,
    },
    methods: {
      goback(){
        this.$router.push('/')
      }
    }
  
  }
  </script>
  
  <style scoped>
  .button {
  border-radius: 10px;
  display: block;
  width: 10%;
  padding: 10px;
  background: #f11303f5;
  color: white;
}
.button:hover{
  background: gray;
}
  
  </style>