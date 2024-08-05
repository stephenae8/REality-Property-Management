<template>
  <div id="home">
    <div id="insidetext">
      <h2 id="ownh2">Discover Your New Home</h2>
      <h4>Helping Thousands Across the World Find Their Next Home!</h4>
      <span style="display: block">
        <input
          type="text"
          name=""
          id=""
          placeholder="Columbus, Ohio"
          v-model="this.UserSearch"
        />
        <button>Search</button>
      </span>
    </div>
  </div>
  <h3 id="unique">Explore Rental In Columbus, Ohio</h3>

  <div id="preview">
    <div
      style="border: 1px solid grey; border-radius: 2px"
      v-for="(one, index) in apartmentdescrption"
      :key="index"
    >
      <img
        style="border: 1px solid grey"
        class="photo"
        :src="one.photo"
        alt=""
      />

      <span
        style="
          display: flex;
          justify-content: space-around;
          align-items: center;
        "
      >
        <h5>{{ one.name }} {{ one.address }}</h5>
      </span>
    </div>
  </div>
  <div
    style="
      margin-top: 2%;
      display: flex;
      justify-content: center;
      height: 70px;
      align-items: center;
    "
  >
  <router-link :to="{name: 'home'}"> <button id="middlebutton">Click to View More</button></router-link> 
  </div>
  <hr style="width: 70%; margin-left: 17%" />

  <h6 class="afterMain main">The Best Rental Listings</h6>
  <h6 class="afterMain">Choose from Thousands of Apartments, Houses, Condos, and Townhouses for rent or own.</h6>

  <div id="total" > 
    <span class="small text" >
      <h6 style="text-align: center;margin-left: 3%;height: 50px;width: 600px;font-size: 35px; width: 50%; font-weight: bold;color: black;">Renting Made Easy</h6>
      <p style="width: 80%;margin-left: 6%; font-size: 20px; ">Browse from our thousands of real-estates properties available all over the US. Whether you're looking for an short-term stay or potential home, we have everything you need! </p>
      <router-link to="" style="margin-left: 6%;font-size: 20px;">Find Out More</router-link>

    </span>
    <span class="small image">
    </span>
  </div>
  <hr style="width: 70%; margin-left: 17%;">
  <FooterP></FooterP>

</template>

<script>
// import Navigator from '../components/Navigator.vue';
import FooterP from '../components/Footer.vue'
export default {
  data() {
    return {
      UserSearch: "",
      apartmentdescrption: [
        {
          photo:
            "https://images.adsttc.com/media/images/5be3/3a40/08a5/e549/e300/0315/newsletter/42442.jpg?1541618191",
          name: "The Tyler",
          address: "123 Maple St, 62701",
          city: "Springfield",
          state: "IL",
          zipcode: "62701",
        },
        {
          photo:
            "https://www.interiorzine.com/wp-content/uploads/2020/02/scandinavian-style-apartment-nouvel-interior-5.jpg",
          name: "The Dorian",
          address: "123 Maple St, 62701",
          city: "Springfield",
          state: "IL",
          zipcode: "62701",
        },
        {
          photo:
            "https://media.istockphoto.com/id/611895696/photo/trendy-open-floor-plan-idea.jpg?s=612x612&w=0&k=20&c=-26a1zEi33oP_Gyv48WcTTyDKTPB8gmkP7yTH7Hiczs=",
          name: "The Nellie",
          address: "123 Maple St, 62701",
          city: "Springfield",
          state: "IL",
          zipcode: "62701",
        },
        {
          photo:
            "https://interioreast.com/wp-content/uploads/2019/12/small-apartment.jpg",
          name: "The Prancer",
          address: "123 Maple St, 62701",
          city: "Springfield",
          state: "IL",
          zipcode: "62701",
        },
      ],
    };
  },

  components: {
    FooterP,
  },
};
</script>

<style scoped>
.image{
  background-image: url('https://indulge.digital/sites/default/files/styles/blog_lead/public/new-apartment-happy-african-american-family-having-fun-celebrating-moving-day-excited-brother-riding-his-sister-cardboard-box-parents-hugging-while-sitting-couch-background-2.jpg?itok=DylOc9-4');
  background-repeat: no-repeat ;
}




#total{
  height: 400px;
  display: flex;
  align-items: center;
  justify-content: center;
  

}

.text{
  background-color: rgba(128, 128, 128, 0.333);
}

.small{
  display: inline-block;
  width: 700px;
  height: 300px;
  /* margin-left: 5%; */
}


#ownh2 {
  text-align: center;
  animation: reveal 6s;
}

@keyframes reveal {
  0% {
    opacity: 0;
  }

  20% {
    opacity: 0;
  }

  80% {
    opacity: 1;
  }
  100% {
    opacity: 1;
  }
}

#bodydiv {
  border: 1px solid black;
  height: 300px;
  display: flex;
}

#first {
  width: 759px;
  height: 300px;
  background-color: burlywood;
  border: 1px solid black;
}

#second {
  background-color: blanchedalmond;
  width: 759px;
  height: 300px;
  border: 1px solid black;
}

#home {
  height: 400px;
  background-image: url("https://images.unsplash.com/photo-1507089947368-19c1da9775ae?q=80&w=2076&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
  background-position: center;
}

#insidetext {
  background-color: rgba(0, 0, 0, 0.342);

  border: 1px solid black;
  height: 400px;
}

h2 {
  margin-top: 100px;
  text-align: center;
  color: white;
  font-size: 65px;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}

h4 {
  text-align: center;
  color: white;
}

span {
  height: 100px;
  display: flex;
  justify-content: center;
  align-content: center;
}

input {
  font-size: 20px;
  text-align: center;
  margin-left: 22%;
  width: 800px;
  height: 50px;
  border-radius: 6px;
  border: 1px solid white;
}

button {
  height: 50px;
  padding: 12px;
  border-radius: 6px;
  width: 100px;
  margin-left: 20px;
  background-color: green;
  color: white;
  border: 1px solid green;
}

#unique {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  margin-top: 1%;
  text-align: center;
  font-size: 35px;
}

#preview {
  margin-top: 1%;
  display: flex;
  /* border: 1px solid black; */
  justify-content: space-around;
}

.photo {
  border: 1px solid black;
  height: 200px;
  width: 250px;
}
h5 {
  display: inline;
  width: 250px;
  text-align: center;
  /* border: 1px solid black; */
  /* border: 2px solid grey; */

  border-radius: 3px;
}

#middlebutton {
  height: 60px;
  padding: 12px;
  border-radius: 6px;
  width: 180px;
  margin-left: 20px;
  background-color: green;
  color: white;
  border: 1px solid green;
}

.afterMain{
  text-align: center;
  /* border: 1px solid black; */
  font-size: 32px;
}

.main{
  font-size: 42px;
}
</style>
