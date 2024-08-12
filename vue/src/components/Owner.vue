<template>
<div class="all" style="width: 100%; border: 1px solid black; height: 100%; max-width: 2300px; display: flex; flex-direction: column; margin: auto; background-color: rgba(158,158,158,.137);"> 
  <span style="display: block;  height: 6%; width: 80%; margin-top: 2%; margin-left: 10%; font-size: larger;" > 
    <h1>Hello {{ this.$store.state.user.fName }}</h1>
     </span>
<div class="container">
    <div class="top-section" style=" margin-top: 25%; margin-bottom: 25%; ">
      <div class="revenue-box" style="border: 1px solid black;">
        <h1>Revenue So Far</h1>
        <div class="money-counter">
          money money money
        </div>
      </div>
      <form @submit.prevent="addProperty" class="property-form" style="border: 1px solid black;">
        <div class="form-fields">
          <input v-model="property.city" type="text" placeholder="City" required>
          <input v-model="property.state" type="text" placeholder="State" required>
          <input v-model="property.address" type="text" placeholder="Address" required>
          <input v-model="property.zipcode" type="text" placeholder="Zipcode" required>
          <input v-model="property.rent" type="number" placeholder="Rent" required>
          <input v-model="property.bed" type="number" placeholder="Bed" required>
          <input v-model="property.bath" type="number" placeholder="Bath" required>
        </div>
        <div class="upload-box">
          <h3>Upload Property Image</h3>
          <input type="file" id="image-upload" @change="handleImageUpload">
        </div>
        <div class="submit-button">
          <button type="submit" style="border-radius: 10px; background-color: #058805ea; border-color: white; color: white;">Submit</button>
        </div>
      </form>
    </div>
    <div class="bottom-section" style=" min-width: 1560px; margin-bottom: 25%;">
      <div class="properties-box" style="border: 1px solid black;">
        <h1>Owned Properties</h1>
        <ul>
          <li v-for="(property, index) in properties" :key="index" class="property-card">
            <p><strong>City:</strong> {{ property.city }}</p>
            <p><strong>State:</strong> {{ property.state }}</p>
            <p><strong>Address:</strong> {{ property.address }}</p>
            <p><strong>Zipcode:</strong> {{ property.zipcode }}</p>
            <p><strong>Rent:</strong> ${{ property.rent }}</p>
            <p><strong>Bed:</strong> {{ property.bed }}</p>
            <p><strong>Bath:</strong> {{ property.bath }}</p>
            <img v-if="property.image" :src="property.image" alt="Property Image" class="property-image" style="max-width: 300px; width: 100%; max-height: 200px; height: 100%;"/>
          </li>
        </ul>
      </div>
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

.top-section {
  display: flex;
  flex-direction: row;
  justify-content: center;
  gap: 250px;
  margin-bottom: 20px;
}

.bottom-section {
  width: 850px;
}

.revenue-box,
.properties-box {
  place-content: center;
  min-width: 650px;
  border-radius: 16px;
  border: 1px solid rgba(126, 126, 126, 0.473);
  background-color: rgba(204, 204, 204, 0.295);
  padding: 20px;
}

.property-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-width: 650px;
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

.property-card {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 15px;
  background-color: #f9f9f9;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.property-card p {
  margin: 5px 0;
}

.property-image {
  max-width: 100%;
  height: auto;
  margin-top: 10px;
}

h3 {
  text-align: center;
}
</style>
