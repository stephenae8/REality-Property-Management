<template >
    <div v-if="done" class="all">
        <div class="address">
            <header > {{ justTest.address }} {{ justTest.city }} {{ justTest.state }} </header>
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

        <div class="propertyDetails">
            
            <div class="Amenities" style="display: flex; flex-direction: row; gap: 50px; " > 
                <p> <img src="https://img.icons8.com/?size=100&id=LuG23LXvoO4t&format=png&color=000000" alt="" class="Amenities" > <h1> {{ justTest.bedrooms }} Bed </h1> </p>
                <p> <img src="https://img.icons8.com/?size=100&id=11485&format=png&color=000000" alt="" class="Amenities"> <h1>{{ justTest.bathrooms }} Bath </h1> </p>
                <p> <img src="https://img.icons8.com/?size=100&id=ZDR4vMNuubY1&format=png&color=000000" alt="" class="Amenities" ><h1> Dish washer: {{ amenities.dishwasher }} </h1> </p>    
                <p> <img src="https://img.icons8.com/?size=100&id=10013&format=png&color=000000" alt="" class="Amenities" ><h1> Air conditioning? {{ amenities.centralAir}} </h1> </p>    
                <p> <img src="https://img.icons8.com/?size=100&id=BpWRdkvhcXWs&format=png&color=000000" alt="" class="Amenities" ><h1> Laundry? {{ amenities.laundry }} </h1> </p>  
                <p> <img src="https://img.icons8.com/?size=100&id=106514&format=png&color=000000" alt="" class="Amenities"><h1> Pets? {{ amenities.petsAllowed }} </h1></p>    
  

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
                propId: 9020,
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
                fourProp = [this.justone[0], this.justone[1], this.justone[2], this.justone[3]]
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

.sliderAndApplication {
    display: flex;
    justify-content: space-between;
    grid-template-columns: repeat(2, .5fr);
}

.whole-slider {
    max-width: 650px;
    width: 100%;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

#carouselExampleIndicators {
    border-radius: 18px;
}

.slider-container {
    width: 100%;
    height: 100%;
    max-width: 650px;
    max-height: 600px;
    border-radius: 18px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-right: 20%;
    overflow: hidden;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: box-shadow 0.4s;
}



.priceDetails {
    margin-top: 10px;
    display: flex;
    justify-content: left;
    max-width: 18%;
    border: 1px solid #a1a1a185;
    border-radius: 16px;
    padding-bottom: 0px;
    margin-bottom: 10px;
    
}

.SimilarHomes {
    font-family: 'Roboto';
    font-size: 3em;
}

.propertyDetails {
    display: flex;
    flex-direction: row;
    gap: 25px;
    border: 1px solid #eaeaea;
    text-align: center;
    padding-bottom: 0px;

   
}

.PropertyCardContainer {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
    max-width: 1000px;
}

.AllCardContainer {
    display: flex;
}

.all {
    display: grid;
    justify-content: center;
    border: 2px solid #eaeaea;
    padding: 20px;
    border-radius: 10px;
    background-color: hsl(0, 0%, 100%);
}

.address {
    margin-left: 30px;
    font-size: 1.5em;
    font-weight: bold;
    color: #555;
}

.applicationBox {
    display: grid;
    border: 1px solid #a1a1a185;
    width: 100%;
    align-content: center;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: box-shadow 0.4s;
    background-color: #f9f9f9;
    font-family: 'Roboto', sans-serif;
    padding-left: 10%;
    padding-right: 10%;
    padding-top: 10%;
    padding-bottom: 10%;
    max-height: 200px;
}

.submitButton {
    display: flex;
    justify-content: center;
}

.applicationBox:hover {
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

input {
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 100%;
    border: 1px solid rgba(70, 70, 70, 0.233);
    text-align: left;
}

.submitApplication {
    display: flex;
    justify-content: center;
    max-width: 300px;
    width: 100%;
    height: 100%;
    font-size: small;
}

.Amenities{
    display: flex;
    justify-content: center;
    gap: 400px;
    width: 70px;
    justify-content: space-evenly;
    h1{
        font-size: 20px;

    }

    p{
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }


}

</style>
