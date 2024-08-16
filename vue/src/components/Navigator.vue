<template>
  <div class="navigator">
    <div class="navigator-content">
      <div class="logo">
        <router-link :to="{ name: 'home' }">
          <img src="/RE-logo.png" alt="Logo" />
        </router-link>
      </div>
      <div class="nav-items">
        <div class="allIcon" v-show="this.$store.state.token != ''">
          <div class="user-menu">
            <a href="#" @mouseover="mouseover = true" @mouseleave="mouseover = false">
              <img class="icons" src="../img/icons8-avatar-50.png" alt="Avatar" />
              <div class="dropdown" v-show="mouseover">
                <!-- Add dropdown menu items here -->
              </div>
            </a>
          </div>
          <img class="icons" src="../img/icons8-notification-100.png" alt="Notifications" />
          <img class="icons" src="../img/icons8-favorite-100 (1).png" alt="Favorites" />
        </div>
        <nav>
          <router-link class="nav-text" :to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Log Out</router-link>
          <router-link class="nav-text" :to="{ name: 'Available' }">Available Properties</router-link>
          <!-- <router-link class="nav-text" :to="{ name: 'about' }">About Us</router-link> -->
          <router-link class="portal" :to="{ name: 'login' }" v-show="this.$store.state.token == ''">Log In</router-link>
          <router-link class="portal" :to="{ name: 'Tenant'}" v-show="role == 'ROLE_TENANT'">Tenant Portal</router-link>
          <router-link class="portal" :to="{ name: 'manager'}" v-show="role == 'ROLE_MANAGER'">Manager Portal</router-link>
          <router-link class="portal" :to="{ name: 'owner'}" v-show="role == 'ROLE_OWNER'">Owner Portal</router-link>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mouseover: false
    };
  },
  computed: {
    username() {
      return this.$store.state.user.username;
    },
    role() {
      return this.$store.state.user.authorities[0].name;
    },
    id() {
      return this.$store.state.user.id;
    },
  }
};
</script>

<style scoped>
.navigator {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: white;
  z-index: 1000;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.navigator-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  max-width: 1200px;
  margin: 0 auto;
}

.logo img {
  max-width: 50px;
  height: auto;
}

.nav-items {
  display: flex;
  align-items: center;
}

.nav-text {
  padding-top: 8px;
}

.allIcon {
  display: flex;
  gap: 1rem;
  margin-right: 1rem;
}

.icons {
  width: 30px;
  height: auto;
}

nav {
  display: flex;
  gap: 1rem;
}

a {
  text-decoration: none;
  color: black;
}

.portal {
  background-color: rgb(114, 160, 103);
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 5px;
}

.portal:hover {
  background-color: green;
}

.user-menu {
  position: relative;
}

.dropdown {
  position: absolute;
  top: 100%;
  right: 0;
  background-color: white;
  border: 1px solid black;
  padding: 0.5rem;
  z-index: 10;
}

@media (max-width: 768px) {
  .navigator-content {
    flex-direction: column;
  }

  .nav-items {
    flex-direction: column;
    align-items: center;
    width: 100%;
  }

  nav {
    flex-direction: column;
    width: 100%;
    align-items: center;
  }

  .allIcon {
    margin-bottom: 1rem;
  }
}

@media (max-width: 480px) {
  .logo img {
    max-width: 40px;
  }

  .icons {
    width: 25px;
  }

  .nav-text, .portal {
    font-size: 0.9rem;
  }
}
</style>