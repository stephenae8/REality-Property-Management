<template>
    <div class="alert" role="alert">
      {{ message }}
    </div>
  </template>
  
  <script>
  export default {
    props: {
      message: {
        type: String,
        required: true
      }
    }
  }
  </script>
  
  <style scoped>
  .alert {
    background-color: #f8d7da;
    color: #721c24;
    padding: 0.75rem;
    margin-bottom: 1rem;
    border: 1px solid #f5c6cb;
    border-radius: 4px;
  }
  </style>