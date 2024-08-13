<template>
  <div>
    <div id="text">
      <router-link style="display: inline-block" :to="{ name: 'home' }">
        <img src="../img/icons8-real-estate-100.png" alt="" />
      </router-link>
      <!-- <h4
        style="
          font-size: 25px;
          font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
            'Lucida Sans', Arial, sans-serif;
          color:black;
        "
      >
        A2DS2 Reality
      </h4> -->
    </div>
    <div class="allIcon" v-show="this.$store.state.token != ''">
      <a href="#" @mouseover="mouseover=true" @mouseleave="mouseover=false">
      <img style="position: relative;" class="icons" src="../img/icons8-avatar-50.png" alt="" />
      <div style="border: 1px solid black;" v-show="mouseover == true"> 
       
    
     
      </div>
    </a>

      <img class="icons" src="../img/icons8-notification-100.png" alt="" />
      <img class="icons" src="../img/icons8-favorite-100 (1).png" alt="" />
      
    </div>
    <nav>
      <router-link
     
        :to="{ name: 'logout' }"
        v-if="this.$store.state.token != ''"
        >Log Out</router-link
      >
      <router-link :to="{ name: 'Available' }"
        >Available Properties</router-link
      >
      <router-link to="#" >About Us</router-link> 
      <router-link class="portal" :to="{name: 'Tenant'}" v-show="role == 'ROLE_TENANT'"
        >Tenant Portal</router-link
      >
      <router-link class="portal" :to="{name: 'manager'}" v-show="role == 'ROLE_MANAGER'"
        >Manager Portal</router-link
      >
    </nav>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mouseover: Boolean
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
.allIcon {
  width: 200px;
  display: flex;
  justify-content: space-between;
}

.icons {
  width: 30px;
}

#main {
  border: 1px solid black;
}

#smallNav {
  width: 15%;
}

#smalldiv {
  border: 1px solid black;
  width: 200px;
  height: 30px;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

ul {
  margin-top: 17px;
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

li {
  list-style: none;
}

#text {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 90px;
  width: 200px;
}

.portal {
  display: flex;
  border-radius: 5px;
  background-color: darkgrey;
  color: white;
  padding: 10px;
  border: 1px solid darkgrey;
}

.portal:hover {
  background-color: black;
}

#image {
  width: 20px;
}

div {
  display: flex;
  background-color: white;
  justify-content: space-around;
  align-items: center;
}

nav {
  width: 30%;
  /* margin-left: 78%; */
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/* nav:nth-child() {
  padding-left: 10px;
} */



a {
  text-decoration: none;
}

h4 {
  display: flex;
}

#iconside {
  /* border: 1px solid black; */
  background-color: azure;
  border-radius: 5px;
}

#iconside:hover {
  background-color: darkgoldenrod;
}
</style>
