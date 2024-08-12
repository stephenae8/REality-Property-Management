<template>
    <div class="form-field">
      <label :for="id">{{ label }}</label>
      <input
        :id="id"
        :type="type"
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
        v-bind="$attrs"
      >
    </div>
  </template>
  
  <script>
  export default {
    props: {
      label: {
        type: String,
        required: true
      },
      id: {
        type: String,
        required: true
      },
      modelValue: {
        type: [String, Number],
        default: ''
      },
      type: {
        type: String,
        default: 'text'
      }
    },
    emits: ['update:modelValue']
  }
  </script>
  
  <style scoped>
  .form-field {
    margin-bottom: 1rem;
  }
  
  label {
    display: block;
    margin-bottom: 0.5rem;
    color: #555;
  }
  
  input {
    width: 100%;
    padding: 0.5rem;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 1rem;
  }
  </style>