<template>
  <div id="main">
    <div id="opt">
      <div id="searchbox">
        <input v-model="searchTerm" type="text" placeholder="Columbus, OH">
        <img src="../img/socialMediaHandle/search.png" alt="">
      </div>
      <div class="filter-box">
        <select v-model="priceup">
          <option value="">Price</option>
          <option>$950</option>
          <option>$1100</option>
          <option>$1300</option>
          <option>$1300+</option>
        </select>
      </div>
      <div class="filter-box">
        <select v-model="available">
          <option value="">Available</option>
          <option>Available</option>
          <option>Not Available</option>
        </select>
      </div>
      <div class="filter-box">
        <select v-model="bedroom">
          <option>Bedroom</option>
          <option>2 Bedroom</option>
          <option>3 Bedroom</option>
          <option>4 Bedroom</option>
        </select>
      </div>
      <div class="filter-box">
        <select v-model="bathroom">
          <option value="">Bathroom</option>
          <option>1 Bathroom</option>
          <option>2 Bathroom</option>
          <option>3 Bathroom</option>
        </select>
      </div>
      <div class="filter-box">
        <select v-model="amenities">
          <option value="">Amenities</option>
          <option>Pets Allowed</option>
          <option>In-Unit Washer & Dryer</option>
        </select>
      </div>
    </div>

    <div id="secondMain">
      <div v-for="one in filterBaseOn" :key="one.propId">
        <router-link :to="{ name: 'property', params: { id: one.propId } }">
          <DifferentCard :one-individual="one"></DifferentCard>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService.js';
import DifferentCard from './DifferentCard.vue';

export default {
  components: {
    DifferentCard
  },

  data() {
    return {
      allProperty: [],
      searchTerm: this.$route.query.search ? this.$route.query.search : '',
      available: 'Available',
      priceup: '',
      bedroom: 'Bedroom',
      bathroom: '',
      amenities: '',
    }
  },

  methods: {
    getproperty() {
      PropertyService.getProperty().then((e) => {
        this.allProperty = e.data
      })
    }
  },

  created() {
    this.getproperty()
  },

  computed: {
    filterBaseOn() {
      return this.allProperty.filter(e => {
        // Search filter
        if (this.searchTerm && !e.city.toLowerCase().includes(this.searchTerm.toLowerCase()) && 
            !e.state.toLowerCase().includes(this.searchTerm.toLowerCase())) {
          return false;
        }

        // Availability filter
        if (this.available === "Available" && !e.vacancy) return false;
        if (this.available === "Not Available" && e.vacancy) return false;

        // Price filter
        if (this.priceup) {
          const price = parseInt(this.priceup.replace('$', '').replace('+', ''));
          if (this.priceup.includes('+')) {
            if (e.rent <= price) return false;
          } else {
            if (e.rent < price - 100 || e.rent >= price + 100) return false;
          }
        }

        // Bedroom filter
        if (this.bedroom !== 'Bedroom') {
          const bedroomCount = parseInt(this.bedroom);
          if (e.bedrooms !== bedroomCount) return false;
        }

        // Bathroom filter
        if (this.bathroom) {
          const bathroomCount = parseInt(this.bathroom);
          if (e.bathrooms !== bathroomCount) return false;
        }

        // Amenities filter
        if (this.amenities === "Pets Allowed" && !e.petsAllowed) return false;
        if (this.amenities === "In-Unit Washer & Dryer" && !e.inUnitLaundry) return false;

        return true;
      });
    }
  }
}
</script>

<style scoped>
#main {
  height: auto;
}

#opt {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60px;
  border: 1px solid black;
}

#searchbox {
  display: flex;
  align-items: center;
  border: 1px solid black;
  border-radius: 13px;
  padding: 5px;
  margin-right: 10px;
}

#searchbox input {
  width: 250px;
  border: none;
  outline: none;
}

#searchbox img {
  height: 20px;
  width: 20px;
  margin-left: 5px;
}

.filter-box {
  margin: 0 5px;
}

.filter-box select {
  width: 100px;
  padding: 5px;
  border: 1px solid black;
  border-radius: 7px;
}

#secondMain {
  margin-top: 1%;
  width: 95%;
  margin-left: 3%;
  padding: 10px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  border: 1px solid black;
}

a {
  text-decoration: none;
  color: rgba(0, 0, 0, 0.841);
}
</style>