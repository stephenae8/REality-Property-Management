<template>
    <div style="border: 1px solid black;">

        <div class="container">

            <div id="carouselExampleIndicators" class="carousel slide">

                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                </div>

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://images.adsttc.com/media/images/5be3/3a40/08a5/e549/e300/0315/newsletter/42442.jpg?1541618191"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://images.adsttc.com/media/images/5be3/3a40/08a5/e549/e300/0315/newsletter/42442.jpg?1541618191"
                            class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://images.adsttc.com/media/images/5be3/3a40/08a5/e549/e300/0315/newsletter/42442.jpg?1541618191"
                            class="d-block w-100" alt="...">
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
        <form action="" class="application">
        </form>

    </div>

    <div class="priceDetails">
        <p>            
            $1738
        </p>   
    </div>

    <div>
        <p class="propertyDetails">
           4 Bed 3 Bath
          </p>
        
    </div>
    <div class="wattupbih">
    <div id="similarlisting">
        <PropertyCard></PropertyCard>
        <PropertyCard></PropertyCard>
        <PropertyCard></PropertyCard>
    </div>
</div>
</template>

<script>
import PropertyCard from '../components/PropertyCard.vue';
export default {
    components: {
        PropertyCard
    }

}
</script>

<style scoped>
.container {
    display: flex;
    width: 600px;
    border: 1px solid black;
}

.priceDetails {
    margin-left: 25%;
    font-size: small;
    border: 1px solid black;
    width: 30%;

}

.propertyDetails {
    margin-left: 25%;
    border: 1px solid black;
    font-size: small;
    width: 30%;
    height: 5%;
    
}

#similarlisting {
    display: flex;
    justify-content: center;
    border: 1px solid black;
    width: 51%;
    
}
.wattupbih{
    display: flex;
    justify-content: center;
    border: 1px solid black;
    max-width: 100%;
}
</style>