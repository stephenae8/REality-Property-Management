<template>
    <div class="images">
      <div class="inside">
        <img src="/mission.png" alt="Mission Image" class="responsive-img" />
        <img src="/team.png" alt="Team Image" class="responsive-img" />
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {};
    },
  };
  </script>
  
  <style scoped>
  .images {
    display: flex;
    justify-content: center;
    padding: 20px;
    background-color: #f9f9f9; 
    min-height: 100vh;
    align-items: center;
  }
  
  .inside {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 15px;
  }
  
  .responsive-img {
    max-width: 90%;
    height: auto;
    max-height: 70vh;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transition: transform 0.3s ease, box-shadow 0.3s ease; 
  }
  
  .responsive-img:hover {
    transform: scale(1.05); 
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3); 
  }
  
  @media (max-width: 600px) {
    .inside {
      gap: 10px; 
    }
  }
  </style>
  