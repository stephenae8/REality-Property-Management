<template>
  <div id="home">
    <div id="insidetext">
      <h2 id="ownh2">Discover Your New Home</h2>
      <h4>Find What Comforts You!</h4>
      <div id="search-container">
        <input
          type="text"
          placeholder="Search"
          v-model="UserSearch"
        />
        <button @click="moveToAvailable">Search</button>
      </div>
    </div>
  </div>
  <h3 id="unique">Explore Rentals</h3>  
  <div id="preview" v-if="done">
    <div v-for="one in justfour" :key="one.propId">
      <router-link class="property-link" :to="{name: 'property', params:{id: one.propId}}">
        <different-card :OneIndividual="one"></different-card>
      </router-link>
    </div>
  </div>
  <div class="view-more-container">
    <router-link :to="{name: 'Available'}" v-show="done"> 
      <button id="middlebutton">Click to View More</button>
    </router-link> 
  </div>
  <hr class="divider" />

  <h6 class="afterMain main">The Best Rental Listings</h6>
  <h6 class="afterMain">
    Choose from Thousands of Apartments, Houses, Condos, and Townhouses for rent
    or own.
  </h6>

  <div id="total">
    <div class="text-content">
      <h6 class="renting-made-easy">Renting Made Easy</h6>
      <p class="description">
        Browse from our thousands of real-estates properties available all over
        the US. Whether you're looking for an short-term stay or potential home,
        we have everything you need!
      </p>
      <router-link to="" class="find-out-more">Find Out More</router-link>
    </div>
    <div class="image-content"></div>
  </div>
  <hr />
</template>

<script>
// import Navigator from '../components/Navigator.vue';
import PropertyService from "../services/PropertyService.js";
import DifferentCard from "./DifferentCard.vue";
export default {
  data() {
    return {
      UserSearch: "",
      apartmentdescrption: [],
      done: false
    };
  },

  methods: {
    moveToAvailable() {
      this.$router.push({ name: "Available", query: {search: this.UserSearch}});
    },

  
    createdProp() {
      PropertyService.getProperty().then((e) => {
        this.apartmentdescrption = e.data;
        this.done = true;
      });
    },
  },

  computed: {
    justfour() {
      let fourProp = [];
      return (fourProp = [
        this.apartmentdescrption[20],
        this.apartmentdescrption[28],
        this.apartmentdescrption[12],
        this.apartmentdescrption[13],
        // this.apartmentdescrption[22],
        // this.apartmentdescrption[33],
      ]);
    },
  },

  created() {
    this.createdProp();
  },

  components: {
    DifferentCard,
  },
};
</script>

<style scoped>
/* Base styles */
body {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  margin: 0;
  padding: 0;
}

/* Responsive styles */
#home {
  height: 400px;
  background-image: url("https://images.unsplash.com/photo-1507089947368-19c1da9775ae?q=80&w=2076&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
  background-position: center;
  background-size: cover;
}

#insidetext {
  background-color: rgba(0, 0, 0, 0.342);
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
}

#ownh2 {
  color: white;
  font-size: 3rem;
  text-align: center;
  animation: reveal 6s;
  margin-bottom: 10px;
}

h4 {
  color: white;
  text-align: center;
  margin-bottom: 20px;
}

#search-container {
  display: flex;
  justify-content: center;
  width: 100%;
  max-width: 800px;
}

input {
  font-size: 1rem;
  padding: 10px;
  width: 70%;
  border-radius: 6px;
  border: 1px solid white;
}

input, input[placeholder] {
  text-align: center;
}
button {
  padding: 10px;
  border-radius: 6px;
  background-color: green;
  color: white;
  border: 1px solid green;
  cursor: pointer;
}

#unique {
  text-align: center;
  font-size: 2rem;
  margin: 20px 0;
}

#preview {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  margin: 20px 0;
}

.property-link {
  text-decoration: none;
  color: black;
}

.view-more-container {
  display: flex;
  justify-content: center;
  margin: 20px 0;
}

#middlebutton {
  padding: 15px 30px;
  font-size: 1rem;
}

.divider {
  width: 70%;
  margin: 20px auto;
}

.afterMain {
  text-align: center;
  font-size: 1.5rem;
  margin: 10px 0;
}

.main {
  font-size: 2rem;
}

#total {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 20px;
  padding: 20px;
}

.text-content, .image-content {
  flex: 1;
  min-width: 300px;
}

.renting-made-easy {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 10px;
}

.description {
  font-size: 1rem;
  margin-bottom: 10px;
}

.find-out-more {
  font-size: 1rem;
  color: #007bff;
  text-decoration: none;
}

.image-content {
  background-image: url("https://indulge.digital/sites/default/files/styles/blog_lead/public/new-apartment-happy-african-american-family-having-fun-celebrating-moving-day-excited-brother-riding-his-sister-cardboard-box-parents-hugging-while-sitting-couch-background-2.jpg?itok=DylOc9-4");
  background-repeat: no-repeat;
  background-size: cover;
  height: 300px;
}

/* Media Queries */
@media (max-width: 768px) {
  #ownh2 {
    font-size: 2rem;
  }

  input {
    width: 60%;
  }

  #unique {
    font-size: 1.5rem;
  }

  .afterMain {
    font-size: 1.2rem;
  }

  .main {
    font-size: 1.5rem;
  }

  .renting-made-easy {
    font-size: 1.5rem;
  }
}

@media (max-width: 480px) {
  #ownh2 {
    font-size: 1.5rem;
  }

  #search-container {
    flex-direction: column;
    align-items: center;
  }

  input {
    width: 100%;
    margin-bottom: 10px;
  }

  button {
    width: 100%;
  }

  #unique {
    font-size: 1.2rem;
  }

  .afterMain {
    font-size: 1rem;
  }

  .main {
    font-size: 1.2rem;
  }

  .renting-made-easy {
    font-size: 1.2rem;
  }
}

@keyframes reveal {
  0% { opacity: 0; }
  20% { opacity: 0; }
  80% { opacity: 1; }
  100% { opacity: 1; }
}
</style>