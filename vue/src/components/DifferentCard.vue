<template>
    <div v-if="done" :class="{ not: OneIndividual.vacancy, card: !OneIndividual.vacancy }">
      <div class="card-image">
        <img :src="OneIndividual.imgString[2] ? OneIndividual.imgString[2] : OneIndividual.imgString[0]" alt="Apartment image">
      </div>
      <div class="card-content">
        <h6 class="address">{{OneIndividual.address}}</h6>
        <h6 class="city-state">{{OneIndividual.city}}, {{ OneIndividual.state }} {{ OneIndividual.zipCode }}</h6>
        <h6 class="rent">${{ OneIndividual.rent }}</h6>
        <p class="availability" :class="{ available: OneIndividual.vacancy, unavailable: !OneIndividual.vacancy }">
          {{ OneIndividual.vacancy ? 'Available' : 'Not Available' }}
        </p>
      </div>
    </div>
  </template>
  
  <script>
  import PropertyService from '../services/PropertyService';
  
  export default {
    props: {
      OneIndividual: Object
    },
    data() {
      return {
        done: false,
        property: [],
        change: this.OneIndividual.vacant,
        status: String
      }
    },
    methods: {
      propertyCreate() {
        PropertyService.getProperty().then((e) => {
          this.property = e.data;
          this.done = true;
        })
      }
    },
    created() {
      this.propertyCreate()
    }
  }
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');
  
  .card, .not {
    width: 100%;
    max-width: 350px;
    aspect-ratio: 4 / 3;
    display: flex;
    flex-direction: column;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s, box-shadow 0.3s;
    font-family: 'Roboto', sans-serif;
  }
  
  .card {
    border: 1px solid rgba(206, 42, 56, 0.3);
  }
  
  .not {
    border: 1px solid rgba(60, 161, 46, 0.3);
  }
  
  .card-image {
    height: 60%;
    overflow: hidden;
  }
  
  .card-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.3s;
  }
  
  .card-content {
    height: 40%;
    padding: 12px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  
  h6 {
    margin: 0;
    line-height: 1.2;
  }
  
  .address {
    font-size: 16px;
    font-weight: 500;
  }
  
  .city-state {
    font-size: 14px;
    color: #666;
  }
  
  .rent {
    font-size: 18px;
    font-weight: 700;
    color: #333;
  }
  
  .availability {
    font-size: 14px;
    font-weight: 500;
    text-align: center;
    padding: 4px 8px;
    border-radius: 4px;
    margin-top: 8px;
  }
  
  .available {
    background-color: rgba(60, 161, 46, 0.1);
    color: rgb(45, 131, 28);
  }
  
  .unavailable {
    background-color: rgba(206, 42, 56, 0.1);
    color: rgba(187, 58, 58, 0.897);
  }
  
  .card:hover, .not:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 12px rgba(0, 0, 0, 0.15);
  }
  
  .card:hover .card-image img, .not:hover .card-image img {
    transform: scale(1.05);
  }
  </style>