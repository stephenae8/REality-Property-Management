<template >
    <div v-if="done" class="all">
        <div class="address">
            <header id="house-number" > {{ justTest.address }} {{ justTest.city }} {{ justTest.state }} </header>
        <div class="sliderAndApplication">
            <div class="whole-slider">
                <div class="slider-container">
                    <div id="carouselExampleIndicators" class="carousel slide">
                        <div class="carousel-indicators">
                            <button v-for="(image, index) in imageSlider.imgString" :key="index" type="button"
                                data-bs-target="#carouselExampleIndicators" :data-bs-slide-to="index"
                                :class="{ 'active': index === 0 }" :aria-label="'Slide ' + (index + 1)" ></button>
                        </div>

                        <div class="carousel-inner" style="max-width: 650px; width: 100%; max-height: 433px; height: 100%;">
                            <div v-for="(image, index) in imageSlider.imgString" :key="index"
                                :class="['carousel-item', { 'active': index === 0 }]">
                                <img :src="image" class="d-block w-100" alt="...">
                                
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>

                        <div class="appForm">
                        </div>
                    </div>
                </div>
            </div>
            <form action="" class="submitApplication">
                <div class="applicationBox">
                    <div class="firstName">
                        <h1 style="font-size: medium; text-align: center;">When are you available to move in?</h1>
                        <p style="text-align: center; font-style: italic; padding-bottom: 0px;">Easily Apply by Choosing A Date Below</p>
                        <input v-model="application.moveInDate" type="date" default="2017-05-15" name="calendar"
                            placeholder=""><br /><br />
                    </div>
                    <div class="submitButton">
                        <button type="submit" style="width: 100px;" @click.prevent="submitApplication">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="priceDetails">
            <p>
                <img src="https://img.icons8.com/?size=100&id=7163&format=png&color=000000" alt="" style="width: 40px">
                PRICE: {{ justTest.rent }}

            </p>
        </div>

        <div class="propertyDetails" style="border-bottom: 1px solid black; border-top: 1px solid black;">
            
            <div class="Amenities" style="display: flex; flex-direction: row; gap: 50px; " > 
                <p> <img src="https://img.icons8.com/?size=100&id=LuG23LXvoO4t&format=png&color=000000" alt="" class="Amenity" > <h1> Bedrooms: <p style="font-weight: bold;">{{ justTest.bedrooms }}</p> </h1> </p>
                <p> <img src="https://img.icons8.com/?size=100&id=11485&format=png&color=000000" alt="" class="Amenity"> <h1>Bathrooms<p style="font-weight: bold;">{{ justTest.bathrooms }}</p>  </h1> </p>
                <p> <img src="https://img.icons8.com/?size=100&id=ZDR4vMNuubY1&format=png&color=000000" alt="" class="Amenity" ><h1> Dishwasher: <p style="font-weight: bold;">{{ justTest.dishwasher ? "Yes" : "No" }}</p> </h1> </p>    
                <p> <img src="https://img.icons8.com/?size=100&id=10013&format=png&color=000000" alt="" class="Amenity" ><h1> Air Conditioning: <p style="font-weight: bold;">{{ justTest.centralAir ? "Yes" : "No" }}</p> </h1> </p>    
                <p> <img src="https://img.icons8.com/?size=100&id=BpWRdkvhcXWs&format=png&color=000000" alt="" class="Amenity" ><h1> Laundry: <p style="font-weight: bold;">{{ justTest.laundry ? "Yes" : "No" }}</p> </h1> </p>  
                <p> <img src="https://img.icons8.com/?size=100&id=106514&format=png&color=000000" alt="" class="Amenity"><h1> Pets: <p style="font-weight: bold;">{{ justTest.petsAllowed ? "Yes" : "No" }}</p> </h1></p>    
  

            </div>


            


        </div>
        <div class="SimilarHomes">
            <div class="pets"><img src="https://img.icons8.com/?size=100&id=uNekrpFCFbqb&format=png&color=000000" alt=""
                    style="width: 50px"> More Homes</div>
        </div>
        <div class="AllCardContainer" v-if="done">
            <div class="PropertyCardContainer"  >
                <div v-for="one in justfour" :key="one.propId" >
                    <router-link style="text-decoration: none;" :to="{ name: 'property', params: { id: parseInt(one.propId) } }">
                        <different-card :OneIndividual="one"></different-card>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
import PropertyService from '../services/PropertyService.js'
import DifferentCard from '../components/DifferentCard.vue'
import ApplicationService from '../services/ApplicationService.js' 
import AmenitiesService from '../services/AmenitiesService.js'


export default {
    props:
    {
        OneIndividual: Object,
        id: Number,

    },

    data() {
        return {
            idProp: this.$route.params.id,
            amenities: [],
            justone: [],
            imageUrls: [],
            application: {
                moveInDate: '',
                userId: this.$store.state.user.id,
                propId: this.$route.params.id,
                appDate: "2020-11-10T10:00:00",
                appStatus: 'pending'
            },
            done: false,
            secondOne: true
        }
    },

    created() {
        this.oneProp();
        this.amenitiesData();
        },

    methods: {

    
        amenitiesData(){
            AmenitiesService.getAmenities(this.idProp).then((e) => {
                    this.amenities = e.data
            });
        },

        oneProp() {
            PropertyService.getProperty().then((e) => {
                this.justone = e.data;
                this.done = true;
            });
        },
        submitApplication() {
            ApplicationService.createApplication(this.application)
                .then( response => {
                    if (response.status == 201) {
                        alert('Your Application Has Been Submitted!')
                    }
                })
                .catch(e => alert("You must be logged in to apply!"))
                .catch(e => console.log("Error creating application"))
        },
    },


    computed: {

        trueOrFalse(){
            return this.secondOne
        },

        justfour(){
            if (this.done) {
                let fourProp = [];
                fourProp = [this.justone[0], this.justone[8], this.justone[9], this.justone[10]]
                return fourProp;
            }

            return [];
        },

        justTest() {
            if (this.done) {
                let newOne = {}
                newOne = this.justone.filter((e) => {
                    if (this.id == e.propId) {
                        return e
                    }
                })[0]
                
                return newOne;
            }

            return {};
        },
      
        imageSlider() {
            if (this.done) {
                let newTwo = {}
                newTwo = this.justone.filter((e) => {
                    if (this.id == e.propId) {
                        return e
                    }
                })[0]
                return newTwo;
            }

            

            return {};
        },

      
    },

    components: {
        DifferentCard,
    }

}



</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

.all {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid #eaeaea;
  padding: 20px;
  border-radius: 10px;
  background-color: hsl(0, 0%, 100%);
  max-width: 1200px;
  margin: 0 auto;
}

.address {
  font-size: 1.5em;
  font-weight: bold;
  color: #555;
  text-align: center;
  margin-bottom: 20px;

}

#house-number {
    padding-bottom: 20px;
}

.sliderAndApplication {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  width: 100%;
}

.whole-slider {
  flex: 1;
  min-width: 300px;
  max-width: 650px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.slider-container {
  width: 100%;
  border-radius: 18px;
  overflow: hidden;
}

.submitApplication {
  flex: 1;
  min-width: 300px;
  max-width: 400px;
}

.applicationBox {
  border: 1px solid #a1a1a185;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: #f9f9f9;
  padding: 20px;
  font-family: 'Roboto', sans-serif;
}

.applicationBox h1 {
  font-size: 1.2em;
  text-align: center;
  margin-bottom: 10px;
}

.applicationBox p {
  text-align: center;
  font-style: italic;
  margin-bottom: 20px;
}

.applicationBox input {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid rgba(70, 70, 70, 0.233);
}

.submitButton {
  display: flex;
  justify-content: center;
}

.submitButton button {
  padding: 10px 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.priceDetails {
  margin: 20px 0;
  border: 1px solid #a1a1a185;
  border-radius: 16px;
  padding: 10px;
  display: flex;
  align-items: center;
}

.priceDetails img {
  width: 40px;
  margin-right: 10px;
}

.propertyDetails {
  width: 100%;
  border-top: 1px solid black;
  border-bottom: 1px solid black;
  padding: 20px 0;
}

.Amenities {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

.Amenities p {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  width: 120px;
}

.Amenity {
  width: 50px;
  margin-bottom: 10px;
}

.Amenities h1 {
  font-size: 0.9em;
  margin: 5px 0;
}

.Amenities span {
  font-weight: bold;
}

.SimilarHomes {
  font-family: 'Roboto';
  font-size: 2em;
  margin: 20px 0;
}

.PropertyCardContainer {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
  width: 100%;
}

@media (max-width: 768px) {
  .sliderAndApplication {
    flex-direction: column;
    align-items: center;
  }

  .whole-slider, .submitApplication {
    width: 100%;
  }

  .Amenities p {
    width: 100px;
  }

  .SimilarHomes {
    font-size: 1.5em;
  }
}

@media (max-width: 480px) {
  .all {
    padding: 10px;
  }

  .address {
    font-size: 1.2em;
  }

  .Amenities {
    gap: 10px;
  }

  .Amenities p {
    width: 80px;
  }

  .Amenity {
    width: 40px;
  }

  .Amenities h1 {
    font-size: 0.8em;
  }
}
</style>