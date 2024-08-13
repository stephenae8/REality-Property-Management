<template>
  <div id="main">
    <div id="filters">
      <input v-model="searchTerm" type="text" placeholder="Search by city or state" id="searchbox">
      
      <select v-model="priceRange">
        <option value="">Price Range</option>
        <option value="0-1000">$0 - $1000</option>
        <option value="1001-1500">$1001 - $1500</option>
        <option value="1501-2000">$1501 - $2000</option>
        <option value="2001+">$2001+</option>
      </select>
      
      <select v-model="availability">
        <option value="true">Available</option>
        <option value="false">Unavailable</option>
        <option value="">All</option>
      </select>
      
      <select v-model="bedroomCount">
        <option value="">Bedrooms</option>
        <option value="1">1 Bedroom</option>
        <option value="2">2 Bedrooms</option>
        <option value="3">3 Bedrooms</option>
        <option value="4+">4+ Bedrooms</option>
      </select>
      
      <select v-model="bathroomCount">
        <option value="">Bathrooms</option>
        <option value="1">1 Bathroom</option>
        <option value="2">2 Bathrooms</option>
        <option value="3">3 Bathrooms</option>
        <option value="4+">4+ Bathrooms</option>
      </select>
      
      <div id="amenities">
        <label>
          <input type="checkbox" v-model="amenities" value="petsAllowed"> Pets Allowed
        </label>
        <label>
          <input type="checkbox" v-model="amenities" value="inUnitWasherDryer"> In-Unit Washer & Dryer
        </label>
        <label>
          <input type="checkbox" v-model="amenities" value="inUnitWasherDryer"> In-Unit Washer & Dryer
        </label>
        <label>
          <input type="checkbox" v-model="amenities" value="inUnitWasherDryer"> In-Unit Washer & Dryer
        </label>
      </div>
    </div>

    <div id="propertyList">
      <div v-for="property in filteredProperties" :key="property.propId">
        <router-link :to="{ name: 'property', params: { id: property.propId } }">
          <DifferentCard :one-individual="property"></DifferentCard>
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
      allProperties: [],
      searchTerm: '',
      priceRange: '',
      availability: 'true',
      bedroomCount: '',
      bathroomCount: '',
      amenities: []
    }
  },
  
  methods: {
    getProperties() {
      PropertyService.getProperty().then((response) => {
        this.allProperties = response.data
      })
    }
  },
  
  created() {
    this.getProperties()
  },
  
  computed: {
    filteredProperties() {
      return this.allProperty.filter(property => {
        // Search filter
        if (this.searchTerm && !property.city.toLowerCase().includes(this.searchTerm.toLowerCase()) && 
            !property.state.toLowerCase().includes(this.searchTerm.toLowerCase())) {
          return false;
        }
        
        // Price range filter
        if (this.priceRange) {
          const [min, max] = this.priceRange.split('-').map(Number);
          if (max && (property.rent < min || property.rent > max)) return false;
          if (!max && property.rent < min) return false;
        }
        
        // Availability filter
        if (this.availability !== '' && property.vacancy.toString() !== this.availability) return false;
        
        // Bedroom count filter
        if (this.bedroomCount) {
          if (this.bedroomCount === '4+' && property.bedrooms < 4) return false;
          if (this.bedroomCount !== '4+' && property.bedrooms !== parseInt(this.bedroomCount)) return false;
        }
        
        // Bathroom count filter
        if (this.bathroomCount) {
          if (this.bathroomCount === '4+' && property.bathrooms < 4) return false;
          if (this.bathroomCount !== '4+' && property.bathrooms !== parseInt(this.bathroomCount)) return false;
        }
        
        // Amenities filter
        if (this.amenities.includes('petsAllowed') && !property.petsAllowed) return false;
        if (this.amenities.includes('inUnitWasherDryer') && !property.inUnitWasherDryer) return false;
        
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

#filters {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border-bottom: 1px solid #ccc;
}

#searchbox {
  width: 200px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

select {
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

#amenities {
  display: flex;
  gap: 10px;
}

#propertyList {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  padding: 20px;
}

a {
  text-decoration: none;
  color: inherit;
}
</style>