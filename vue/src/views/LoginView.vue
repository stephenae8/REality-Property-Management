<template>
  <div class="backgroundImage" style="background-image: url('https://as1.ftcdn.net/v2/jpg/02/82/39/92/1000_F_282399227_V7C6up0mpGZm7fTJtBBSFhgbjtf0kMQ5.jpg'); background-repeat: no-repeat; background-size: cover;">
<div id="login" class="login-container" >
    <form v-on:submit.prevent="login" class="login-form">
      <h1 style="font-size: 40px; text-align: center; padding-bottom: 20px;">Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="formContainer">
      <div class="form-input-group">
        <label for="username" style="font-size: 25px;">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password" style="font-size: 25px; padding-left: 8px;">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
    </div>
      <div class="button-container" style=" display: flex; justify-content: center; padding-bottom: 10px;"> 
      <button class="button-button" type="submit" style="font-size: 20px;  align-items: center;">Sign in</button>
    </div>
      <p style="text-align: center;">
      <router-link v-bind:to="{ name: 'register' }" style="color: green; font-size: 16.5px;">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {

  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.login-container{
  display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    backdrop-filter: blur(8px);
    
    
    
}

.login-form{
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: rgb(255, 255, 255);
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 610px;
}
#login{
  height: 60vh;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
#username{
  
  
  height: 50px;
 
}
#password{
  
  width: 100%;
  max-width: 400px;
  height: 50px
}
.button-button{
  width: 100%;
  max-width: 200px;
  
    padding: 0.75rem;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 1rem;
    cursor: pointer;
    transition: background-color 0.3s;
  
}
.form-input-group{
  
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.formContainer{
  
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: auto;
  width: 400px;
  
  
}

</style>
