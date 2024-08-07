<template>
    
    <div class="all">
        <div class="address">
            <header> {{ street }} {{ city }} {{ state }}</header>
        </div>
        <div class="sliderAndApplication">
            <div class="whole-slider">
                <div class="slider-container">
                    <div id="carouselExampleIndicators" class="carousel slide">
                        <div class="carousel-indicators">
                            <button v-for="(image, index) in imageUrls" :key="index" type="button" data-bs-target="#carouselExampleIndicators" :data-bs-slide-to="index" :class="{ 'active': index === 0 }" :aria-label="'Slide ' + (index + 1)"></button>
                        </div>

                        <div class="carousel-inner">
                            <div v-for="(image, index) in imageUrls" :key="index" :class="['carousel-item', { 'active': index === 0 }]">
                                <img :src="image" class="d-block w-100" alt="...">
                            </div>
                        </div>

                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
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
                        <p>Move In Date?</p>
                        <input type="date" default="2017-05-15" name="calendar" placeholder=""><br /><br />
                    </div>
                    <div class="submitButton">
                        <button type="submit" style="width: 100px;">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="priceDetails">
            <p>
                <img src="https://img.icons8.com/?size=100&id=7163&format=png&color=000000" alt="" style="width: 40px">  
                   PRICE: {{ rent }}                 
            </p>
        </div>

        <div class="propertyDetails">
            <p>
                <div class="bedrooms"> <img src="https://img.icons8.com/?size=100&id=561&format=png&color=000000" alt="" style="width: 50px">
                    <p> {{bed}} Bed</p>
                </div>

                <div class="bathrooms"><img src="https://img.icons8.com/?size=100&id=11485&format=png&color=000000" alt="" style="width: 50px">
                    <p> {{bath}} Bath</p>
                </div>
                <div class="pets"><img src="https://img.icons8.com/?size=100&id=106514&format=png&color=000000" alt="" style="width: 50px">
                    <p>Pets Allowed!</p>
                </div>
            </p>
        </div>
        <div class="SimilarHomes">
            <div class="pets"><img src="https://img.icons8.com/?size=100&id=uNekrpFCFbqb&format=png&color=000000" alt="" style="width: 50px"> More Homes</div>
        </div>
        <div class="AllCardContainer">
            <div class="PropertyCardContainer">
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
                <PropertyCard></PropertyCard>
            </div>
        </div>
    </div>
</template>

<script>
import PropertyCard from '../components/PropertyCard.vue'
import PropertyService from '../services/PropertyService.js'

export default {
    data() {
        return {
            hotels: [],
            imageUrls: [], 
            rent: [],
            street: [],
            city: [],
            state: [],
            bed: [],
            bath: [],


        }
    },
    created() {
        this.firstCase();
        this.fetchPrice();
        this.fetchStreet();
        this.fetchCity();
        this.fetchState();
        this.fetchBed();
        this.fetchBath();
    },
    methods: {
        firstCase() {
            PropertyService.getProperty().then((e) => {
                this.hotels = e.data;
                if (this.hotels.length > 0) {
                    this.imageUrls = this.hotels[0].imgString;
                }
            }).catch(err => console.error(err));
        },
        fetchPrice() {
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.rent = this.json[0].rent;
                }
            }).catch(err => console.error(err));
        } ,
        fetchStreet(){
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.street = this.json[0].address;
                }
            }).catch(err => console.error(err));
        },
        fetchCity(){
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.city = this.json[0].city;
                }
            }).catch(err => console.error(err));
        },
        fetchState(){
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.state = this.json[0].state;
                }
            }).catch(err => console.error(err));
        },
        fetchBed(){
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.bed = this.json[0].bedrooms;
                }
            }).catch(err => console.error(err));
        },
        fetchBath(){
            PropertyService.getProperty().then((e) => {
                this.json = e.data;
                if (this.json.length > 0){
                    this.bath = this.json[0].bathrooms;
                }
            }).catch(err => console.error(err));
        }
    },
    components: {
        PropertyCard,
    },
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
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

#carouselExampleIndicators {
    border-radius: 18px;
}

.slider-container {
    width: 100%;
    border-radius: 18px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-right: 20%;
    overflow: hidden;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: box-shadow 0.4s;
}

.priceDetails,
.propertyDetails {
    display: flex;
    font-size: 1.2em;
    color: #333;
    font-family: 'Roboto', sans-serif;
    padding: 1%;
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
    font-size: 1em;
    display: flex;
    flex-direction: row;
    gap: 25px;
    border: 1px solid #eaeaea;
    text-align: center;
    padding-bottom: 0px;
    p{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        gap: 10%;
        margin-bottom: auto;
    }
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
</style>
