<template>
<div class="card" >
    <a href="#" target="_blank">
<img src="https://images.adsttc.com/media/images/5be3/3a40/08a5/e549/e300/0315/newsletter/42442.jpg?1541618191" alt="Apartment image">
    </a>
    <p>The Tyler 123 Maple St, 62701asdfl kjasldf jasld;kf jas;ldf ja;sldf j;alsfj ;lasj fa s;ldkfjas;dlk fj;sldk fj;lasdj f;laksdj f;lkasdj f;lasdj f;laskdj f;lasj f;laskjf ;als fj;alsdkj f</p>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap'); 

.card {
    width: 100%;
    max-width: 350px;
    padding: 8px 8px;
    margin-bottom: 16px;
    height: 100%;
    transition: transform 0.4s, box-shadow 0.4s;
    border: 1px solid rgba(230, 221, 221, 0.555);

    img {
        max-height: 300px;
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-top-left-radius: 16px;
        border-top-right-radius: 16px;
        transition: transform 0.4s;
    }

    h3 {
        padding: 16px;
    }

    p {
        color: rgb(107, 105, 105);
        padding-top: 10px;
        transition: transform 0.4s;
        font-family: 'Roboto', sans-serif;
        font-size: small;

    }

    &:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        
        img {
            transform: scale(1.05);
        }
        
        h3 {
            color: rgb(163, 228, 159);
        }

        p {
            transform: scale(1.05);
            color: rgb(0, 0, 0);

        }
        .card{
            transform: scale(1.05);
        }
    }
    
}


</style>

