<template>
  <div id="register" class="register-container">
    <form @submit.prevent="register" class="register-form">
      <h1 class="form-title">Create Account</h1>
      <AlertMessage v-if="registrationErrors" :message="registrationErrorMsg" />
      
      <FormField label="Username" id="username" v-model="user.username" required autofocus />
      <FormField label="First Name" id="fname" v-model="user.fName" required />
      <FormField label="Last Name" id="lname" v-model="user.lName" required />
      
      <div class="form-field">
        <label for="role">Role:</label>
        <select id="role" v-model="user.role" required>
          <option value="tenant">Tenant</option>
          <option value="owner">Owner</option>
        </select>
      </div>

      <FormField label="Email" id="email" v-model="user.email" type="email" required />
      <FormField label="Phone Number" id="phone_number" v-model="user.phoneNumber" type="tel" />
      <FormField label="Password" id="password" v-model="user.password" type="password" required />
      <FormField label="Confirm Password" id="confirmPassword" v-model="user.confirmPassword" type="password" required />

      <button type="submit" class="submit-button">Create Account</button>
      <p class="login-link">
        <router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from '@/services/AuthService.js';
import AlertMessage from '@/components/AlertMessage.vue';
import FormField from '@/components/FormField.vue';

export default {
  components: {
    AlertMessage,
    FormField,
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'tenant',
        fName: '',
        lName: '',
        email: '',
        phoneNumber: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    async register() {
      this.clearErrors();
      if (this.user.password !== this.user.confirmPassword) {
        this.setRegistrationError('Password & Confirm Password do not match.');
        return;
      }
      try {
        const response = await authService.register(this.user);
        if (response.status === 201) {
          this.$router.push({
            path: '/login',
            query: { registration: 'success' },
          });
        }
      } catch (error) {
        this.handleRegistrationError(error);
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    setRegistrationError(message) {
      this.registrationErrors = true;
      this.registrationErrorMsg = message;
    },
    handleRegistrationError(error) {
      const response = error.response;
      this.setRegistrationError(
        response && response.status === 400
          ? 'Bad Request: Validation Errors'
          : 'An error occurred during registration.'
      );
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.register-form {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
}

.form-title {
  color: #333;
  margin-bottom: 1.5rem;
}

.form-field {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  color: #555;
}

input, select {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
}

.submit-button {
  width: 100%;
  padding: 0.75rem;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
}

.submit-button:hover {
  background-color: #45a049;
}

.login-link {
  text-align: center;
  margin-top: 1rem;
}

.login-link a {
  color: #4CAF50;
  text-decoration: none;
}

.login-link a:hover {
  text-decoration: underline;
}
</style>