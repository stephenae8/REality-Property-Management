<template>
  <Transition name="modal">
    <div v-if="isVisible" class="modal-overlay" @click="closeModal">
      <div class="modal-content" @click.stop>
        <h2 class="modal-title">{{ title }}</h2>
        <p class="modal-body">{{ message }}</p>
        <p class="modal-body">{{ message2 }}</p>
        <p class="modal-body">{{ message3 }}</p>
        <ul>
          <li>{{ username }}</li>
          <li>{{ password }}</li>
        </ul>
        <button @click="closeModal" class="modal-close-btn">Close</button>
      </div>
    </div>
  </Transition>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  name: 'WelcomeModal',
  props: {
    title: {
      type: String,
      default: 'Navigating REality Site:'
    },
    message: {
      type: String,
      default: 'You are able to browse listed properties but must be logged in to apply for residency.'
    },
    message2: {
      type: String,
      default: 'You can create an account as a tenant or an owner. Owner accounts feature a dashboard and the option to list a property to be managed.'
    },
    message3: {
      type: String,
      default: 'The manager account has the ability to approve or deny applicants, message tenants, and manage leases and can be logged into using the following info: '
    },
    username: {
      type: String,
      default: 'Username: A2DS2'
    },
    password: {
      type: String,
      default: 'Password: password'
    }
  },
  setup(props, { emit }) {
    const isVisible = ref(false)

    const showModal = () => {
      isVisible.value = true
    }

    const closeModal = () => {
      isVisible.value = false
      emit('close')
    }

    onMounted(() => {
      showModal()
    })

    return {
      isVisible,
      closeModal
    }
  }
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  max-width: 80%;
  max-height: 80%;
  overflow-y: auto;
}

.modal-title {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.modal-body {
  margin-bottom: 1rem;
}

.modal-close-btn {
  padding: 0.5rem 1rem;
  background-color: green;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.modal-close-btn:hover {
  background-color: #2980b9;
}

.modal-enter-active,
.modal-leave-active {
  transition: opacity 0.3s ease;
}

.modal-enter-from,
.modal-leave-to {
  opacity: 0;
}
</style>
