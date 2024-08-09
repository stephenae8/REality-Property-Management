<template>
    <div class="container">
      <div class="top-section">
        <div class="revenue-box">
          <h1>Revenue So Far</h1>
          <div class="money-counter">
            money money money
          </div>
        </div>
      </div>
      <div class="bottom-section">
        <div class="properties-box">
          <h1>Owned Properties</h1>
          <ul>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import ApplicationService from '../services/ApplicationService.js' 
  export default {
    data() {
      return {
      
      };
    },
    methods:{
        oneProp() {
            PropertyService.getProperty().then((e) => {
                this.justone = e.data;
                this.done = true;
            });
        }

    }
    
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
    gap: 20px;
    margin-bottom: 20px;
  }
  
  .bottom-section {
    width: 850px;
  }
  
  .revenue-box,
  .properties-box {
    place-content: center;
    min-width: 400px;
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
    min-width: 400px;
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
  