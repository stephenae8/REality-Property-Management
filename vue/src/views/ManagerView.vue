<template>
  <div v-if="this.$store.state.user.authorities[0].name == 'ROLE_MANAGER'">
    <Manager></Manager>
  </div>
  <div v-else>
    <div style="height: 700px; display: flex; justify-content: center;align-items: center;">
    <button @click="goback" class="button gray">Go Back To Home Page</button>
    </div>

  </div>
  </template>
  
  <script>
  import Manager from '../components/Manager.vue';
  // import Manager from '../components/ManagerBackupp.vue';

  export default {
    components: {
      Manager,
    },

    methods:{
      goback(){
        this.$router.push('/')
      }
    }
  
  }
  </script>
  
  <style scoped>
  .button{
    border-radius: 10px;
  display: block;
  width: 20%;
  padding: 10px;
  background: #f11303f5;
  color: white;
  }

  .button:hover{
    background: gray;
  }
  
  </style>