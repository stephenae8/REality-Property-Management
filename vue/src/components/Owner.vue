<template>
    <div class="all">
        <div class="topHalf">
            <div class="boxOne" style="background-color: rgba(204, 204, 204, 0.295);">
                <h1>Revenue So far</h1>
            </div>
            <div class="boxTwo" style="background-color: rgba(204, 204, 204, 0.295);">

                <form action="" class="addProperty">
                    <div class="applicationBox">
                        <input type="Address" placeholder="hello">
                        <input type="Address" placeholder="hello">
                        <input type="Address" placeholder="hello">
                    </div>
                    <div class="submitButton">
                        <button type="submit" style="width: 100px;">Submit</button>
                    </div>
                </form>




            </div>
        </div>
        <div class="bottomHalf">
            <div class="boxThree" style="background-color: rgba(204, 204, 204, 0.295); ">
                <h1>Owned Properties</h1>
            </div>
        </div>


    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.boxOne {
    max-width: 700px;
    width: 100%;
    padding-bottom: 400px;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);

}

.boxTwo {
    max-width: 400px;
    width: 100%;
    padding-bottom: 400px;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);
}

.boxThree {
    max-width: 1000px;
    height: 300px;
    width: 100%;
    border-radius: 16px;
    border: 1px solid rgba(126, 126, 126, 0.473);

}



.topHalf {
    max-width: 1000px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 20px;
    margin-bottom: 10px;

}

.bottomHalf {
    max-width: 1000px;
    display: flex;
    flex-direction: row;
    gap: 20px;
    justify-content: center;
    margin-bottom: 10px;



}

.all {
    align-content: center;
    padding-left: 20%;
    padding-right: 20%;
}

.addProperty{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    border: 1px solid red;
    
}



</style>