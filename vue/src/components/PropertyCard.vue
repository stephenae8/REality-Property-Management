<template>
<div class="card" style="border:1px solid black">
    <a href="#" target="_blank">
<img src="https://placehold.it/150x250" alt="Apartment image">
    </a>
    <h3>apartment data</h3>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
.card {
    flex: 1 1 33%;
    width: 250px;
    max-width: 33%;
    padding: 0px 8px;
    margin-bottom: 16px;

    img {
        width: 100%;
        height: 300px;
        object-fit: cover;
        border-radius: 16px;
        box-shadow: 0px 4px 8px rgba(0,0,0,0.15);
        transition: 0.4s;
    }

    h3{
        padding: 16px;
        color: black;
        transition: 0.4s;
    }

    &:hover {
        img{
            transform: scale(1.05)
        }
        h3{
            color: rgb(163, 228, 159);
        }
    }
   




}
</style>