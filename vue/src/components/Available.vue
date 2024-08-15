<template>
  <div id="main">
    <span class="header-span">
      <div id="opt">
        <div class="filter-item">
          <input
            v-model="searchTerm"
            type="text"
            no-focus
            placeholder="Search"
            class="filter-input"
          />
        </div>
        <div class="filter-item">
          <div class="dropdown">
            <button class="dropbtn">Rent</button>
            <div class="dropdown-content">
              <label
                ><input type="radio" v-model="priceup" value="" /> All</label
              >
              <label
                ><input type="radio" v-model="priceup" value="Under $1000" />
                Under $1000</label
              >
              <label
                ><input type="radio" v-model="priceup" value="$1000-$1499" />
                $1000-$1499</label
              >
              <label
                ><input type="radio" v-model="priceup" value="$1500-$1999" />
                $1500-$1999</label
              >
              <label
                ><input type="radio" v-model="priceup" value="$2000+" />
                $2000+</label
              >
            </div>
          </div>
        </div>
        <div class="filter-item">
          <div class="dropdown">
            <button class="dropbtn">Availability</button>
            <div class="dropdown-content">
              <label
                ><input type="radio" v-model="available" value="" /> All</label
              >
              <label
                ><input type="radio" v-model="available" value="Available" />
                Available</label
              >
              <label
                ><input
                  type="radio"
                  v-model="available"
                  value="Not Available"
                />
                Not Available</label
              >
            </div>
          </div>
        </div>
        <div class="filter-item">
          <div class="dropdown">
            <button class="dropbtn">Bedrooms</button>
            <div class="dropdown-content">
              <label
                ><input type="radio" v-model="bedroom" value="Bedrooms" />
                All</label
              >
              <label
                ><input type="radio" v-model="bedroom" value="2 Bedroom" /> 2
                Bedroom</label
              >
              <label
                ><input type="radio" v-model="bedroom" value="3 Bedroom" /> 3
                Bedroom</label
              >
              <label
                ><input type="radio" v-model="bedroom" value="4 Bedroom" /> 4
                Bedroom</label
              >
            </div>
          </div>
        </div>
        <div class="filter-item">
          <div class="dropdown">
            <button class="dropbtn">Bathrooms</button>
            <div class="dropdown-content">
              <label
                ><input type="radio" v-model="bathroom" value="Bathrooms" />
                All</label
              >
              <label
                ><input type="radio" v-model="bathroom" value="2 Bathroom" /> 2
                Bathroom</label
              >
              <label
                ><input type="radio" v-model="bathroom" value="3+ Bathroom" />
                3+ Bathroom</label
              >
            </div>
          </div>
        </div>
        <div class="filter-item">
          <div class="dropdown">
            <button class="dropbtn">Amenities</button>
            <div class="dropdown-content">
              <label
                ><input
                  type="checkbox"
                  value="Pets Allowed"
                  v-model="amenities"
                />
                Pets Allowed</label
              >
              <label
                ><input type="checkbox" value="Laundry" v-model="amenities" />
                Laundry</label
              >
              <label
                ><input
                  type="checkbox"
                  value="Dishwasher"
                  v-model="amenities"
                />
                Dishwasher</label
              >
              <label
                ><input
                  type="checkbox"
                  value="Air Conditioning"
                  v-model="amenities"
                />
                Air Conditioning</label
              >
            </div>
          </div>
        </div>
      </div>
    </span>
    <div id="main">
      <div id="propertyList">
        <div v-for="property in filteredProperties" :key="property.propId">
          <router-link
            :to="{ name: 'property', params: { id: property.propId } }"
          >
            <DifferentCard :one-individual="property"></DifferentCard>
          </router-link>
        </div>
      </div>
    </div>
    <div id="secondMain">
      <div
        style="margin-bottom: 2%"
        v-for="one in filterBaseOn"
        :key="one.propId"
      >
        <router-link
          style="text-decoration: none; color: rgba(0, 0, 0, 0.841)"
          :to="{ name: 'property', params: { id: one.propId } }"
        >
          <DifferentCard :-one-individual="one"></DifferentCard
        ></router-link>
      </div>
    </div>
  </div>
</template>

<script>
import PropertyService from "../services/PropertyService.js";
import DifferentCard from "./DifferentCard.vue";

export default {
  data() {
    return {
      allProperty: [],
      searchTerm: this.$route.query.search ? this.$route.query.search : "",
      secondSearch: this.$route.query.secondsearch ? this.$route.query.secondsearch : this.searchTerm,
      priceRange: "",
      available: "Available",
      willNumber: "",
      priceup: "",
      bedroom: "Bedrooms",
      amenities: [],
      bathroom: "Bathrooms",
    };
  },

  components: {
    DifferentCard,
  },

  methods: {
    getproperty() {
      PropertyService.getProperty().then((e) => {
        this.allProperty = e.data;
      });
    },
  },
  created() {
    this.getproperty();
  },

  computed: {
    filterBaseOn() {
      let newList = this.allProperty;
      
      if(this.secondSearch){
        console.log(newList);
        newList = newList.filter((e)=>{
          if(e.ownerId == this.$route.query.secondsearch){
            return e
          }
          console.log(this.secondSearch)

        })
      }


      // Filter by search term (city or state)
      if (this.searchTerm) {
        const lowerCaseSearchTerm = this.searchTerm.toLowerCase();
        newList = newList.filter(
          (e) =>
            e.city.toLowerCase().includes(lowerCaseSearchTerm) ||
            e.state.toLowerCase().includes(lowerCaseSearchTerm) 
        );
      }

      // Filter by availability
      if (this.available === "Available") {
        newList = newList.filter((e) => e.vacancy === true);
      } else if (this.available === "Not Available") {
        newList = newList.filter((e) => e.vacancy === false);
      }

      // Filter by bedroom count
      const bedroomOptions = {
        "1 Bedroom": 1,
        "2 Bedroom": 2,
        "3 Bedroom": 3,
        "4 Bedroom": 4,
      };
      if (this.willNumber in bedroomOptions) {
        newList = newList.filter(
          (e) => e.bedrooms === bedroomOptions[this.willNumber]
        );
      }

      // Filter by price range
      const priceRanges = {
        "Under $1000": (e) => e.rent < 1000,
        "$1000-$1499": (e) => e.rent >= 1000 && e.rent < 1500,
        "$1500-$1999": (e) => e.rent >= 1500 && e.rent < 2000,
        "$2000+": (e) => e.rent > 1999,
      };
      if (this.priceup in priceRanges) {
        newList = newList.filter(priceRanges[this.priceup]);
      }

      // Filter by bedroom count (again, if needed)
      if (this.bedroom in bedroomOptions) {
        newList = newList.filter(
          (e) => e.bedrooms === bedroomOptions[this.bedroom]
        );
      }


      // Filter by bathroom count
      const bathroomOptions = {
        "2 Bathroom": (e) => e.bathrooms >= 2 && e.bathrooms < 3,
        "3 Bathroom": (e) => e.bathrooms >= 3,
      };
      if (this.bathroom in bathroomOptions) {
        newList = newList.filter(bathroomOptions[this.bathroom]);
      }

      // Filter by amenities

      if (this.amenities.length > 0) {
        newList = newList.filter((property) => {
          console.log(property);
          return this.amenities.every((amenity) => {
            switch (amenity) {
              case "Pets Allowed":
                return property.petsAllowed;
              case "Laundry":
                return property.laundry;
              case "Dishwasher":
                return property.dishwasher;
              case "Air Conditioning":
                return property.centralAir;
              default:
                return true;
            }
          });
        });
      }

      return newList;
    },
  },
};
</script>

<style scoped>
#opt {
  border-bottom: 1px solid rgb(231, 231, 231);
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  gap: 10px;
}

.filter-item {
  flex: 1 1 auto;
  min-width: 120px;
  max-width: 200px;
  margin: 0 5px;
}

.filter-input,
.dropbtn {
  background-color: #f1f1f1;
  color: black;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 4px;
}

.filter-input {
  width: 100%;
  max-width: 200px;
}

.dropdown {
  position: relative;
  display: inline-block;
  width: 100%;
}

.dropbtn {
  cursor: pointer;
  width: 100%;
  text-align: center;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  width: 100%;
  left: 0;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
  border-radius: 4px;
}

.dropdown-content label {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content label:hover {
  background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #e9e9e9;
}

.dropdown-content input[type="radio"],
.dropdown-content input[type="checkbox"] {
  margin-right: 8px;
}

#main,
#secondMain {
  height: auto;
}

#propertyList,
#secondMain {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

#propertyList {
  padding: 20px;
}

#secondMain {
  margin: 1% 0 0 3%;
  width: 95%;
  padding: 10px;
}

#propertyList > div,
#secondMain > div {
  flex: 1 1 300px;
  max-width: 100%;
}

a {
  text-decoration: none;
  color: inherit;
}

#searchbox {
  width: 15%;
  height: 30px;
  border: 1px solid black;
  border-radius: 10px;
  margin-top: 0.5%;
  padding: 5px;
}

input:focus {
  outline: none;
}

.header-span {
  display: flex;
  height: 60px;
  align-items: center;
}

.search-input {
  width: 250px;
  border-radius: 13px;
  border: none;
  margin-left: 10%;
  margin-top: 0.1%;
}

.select-box {
  margin-left: 12px;
  margin-top: 1.5%;
  width: 100%;
  padding: 2px;
}

.dropdown:hover .dropbtn {
  background-color: rgb(114, 160, 103);
}

@media (max-width: 1200px) {
  #main-container {
    padding: 0 10px;
  }
}

@media (max-width: 992px) {
  #opt {
    flex-wrap: wrap;
  }

  .filter-item {
    flex-basis: calc(33.333% - 10px);
    margin-bottom: 10px;
  }
}

@media (max-width: 768px) {
  .filter-item {
    flex-basis: calc(50% - 10px);
  }
  
  #opt {
    justify-content: space-between;
  }
}

@media (max-width: 576px) {
  .filter-item {
    flex-basis: 100%;
  }
  
  .filter-input {
    width: 100%;
  }
  #secondMain {
    padding-top: 40px;
  }
}

</style>