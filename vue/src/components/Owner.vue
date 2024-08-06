<template>
    <div class="container">
      <div class="top-section">
        <div class="revenue-box">
          <h1>Revenue So Far</h1>
          <div class="money-counter">
            money money money
          </div>
        </div>
        <form @submit.prevent="addProperty" class="property-form">
          <div class="form-fields">
            <input v-model="property.city" type="text" placeholder="City">
            <input v-model="property.state" type="text" placeholder="State">
            <input v-model="property.address" type="text" placeholder="Address">
            <input v-model="property.zipcode" type="text" placeholder="Zipcode">
            <input v-model="property.rent" type="number" placeholder="Rent">
            <input v-model="property.bed" type="number" placeholder="Bed">
            <input v-model="property.bath" type="number" placeholder="Bath">
          </div>
          <div class="upload-box">
            <h3>Upload Property Image</h3>
            <input type="file" id="image-upload" @change="handleImageUpload">
          </div>
          <div class="submit-button">
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
      <div class="bottom-section">
        <div class="properties-box">
          <h1>Owned Properties</h1>
          <ul>
            <li v-for="(property, index) in properties" :key="index">
              <p><strong>City:</strong> {{ property.city }}</p>
              <p><strong>State:</strong> {{ property.state }}</p>
              <p><strong>Address:</strong> {{ property.address }}</p>
              <p><strong>Zipcode:</strong> {{ property.zipcode }}</p>
              <p><strong>Rent:</strong> {{ property.rent }}</p>
              <p><strong>Bed:</strong> {{ property.bed }}</p>
              <p><strong>Bath:</strong> {{ property.bath }}</p>
              <img v-if="property.image" :src="property.image" alt="Property Image" />
            </li>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        property: {
          city: '',
          state: '',
          address: '',
          zipcode: '',
          rent: '',
          bed: '',
          bath: '',
          image: null,
        },
        properties: [],
      };
    },
    methods: {
      addProperty() {
        this.properties.push({ ...this.property });
        this.resetForm();
      },
      resetForm() {
        this.property = {
          city: '',
          state: '',
          address: '',
          zipcode: '',
          rent: '',
          bed: '',
          bath: '',
          image: null,
        };
        document.getElementById('image-upload').value = null;
      },
      handleImageUpload(event) {
        const file = event.target.files[0];
        if (file) {
          const reader = new FileReader();
          reader.onload = (e) => {
            this.property.image = e.target.result;
          };
          reader.readAsDataURL(file);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');
  
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: 'Roboto', sans-serif;
    padding: 0 20%;
  }
  
  .top-section,
  .bottom-section {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 20px;
    margin-bottom: 20px;
  }
  
  .revenue-box,
  .properties-box {
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
  }
  
  .property-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 400px;
    width: 100%;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
    background-color: rgba(204, 204, 204, 0.295);
    padding: 20px;
  }
  
  .form-fields {
    display: flex;
    flex-direction: column;
    gap: 10px;
    width: 100%;
  }
  
  .upload-box {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 10px;
    width: 100%;
  }
  
  .submit-button {
    margin-top: 10px;
  }
  
  h3 {
    text-align: center;
  }
  </style>
  