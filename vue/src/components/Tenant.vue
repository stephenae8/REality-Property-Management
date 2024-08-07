<template>
    <div id="main">
        <span id="greeting">
            <h5>{{ username }}</h5>
        </span>

    </div>
</template>

<script>
export default {
    data(){
        return{
            username: this.$store.state.user
        }
    }

}
</script>

<style scoped>

#main{
    border: 1px solid black;

}
#greeting{
    border: 1;
}

</style>