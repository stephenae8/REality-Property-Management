<template>
  <div v-if="this.$store.state.user.authorities[0].name == 'ROLE_TENANT' " >
    <div v-if="this.wait">
    <div v-if="this.applicationCheck.appStatus == 'withdrawn' || this.applicationCheck.appStatus == 'pending'">
      <div style="height: 800px; width: 100%">
        <h1 style="margin-top: 10%; text-align: center">
          Application Still Pending....
        </h1>
        <span
          style="
            display: flex;
            height: 250px;
            justify-content: space-evenly;
            align-items: center;
          "
        >
          <button
            @click="withdraw"
            class="button"
            style="height: 50%; width: 33%; border: 1px solid white"
          >
            Withdraw Application
          </button>
          <button
            @click="goback"
            class="button grey"
            style="height: 50%; width: 33%; border: 1px solid white"
          >
            Go Back to Main Page
          </button>
        </span>
        <h2 style="text-align: center">
          If you haven't applied yet, click below to check our availability
        </h2>
        <span
          style="
            display: flex;
            width: 100%;
            justify-content: center;
            height: 60px;
            margin-top: 2%;
          "
        >
          <button
            @click="available"
            class="button grey"
            style="width: 12%; border: 1px solid white"
          >
            Available
          </button>
        </span>
      </div>
    </div>
    <div v-else>
      <Tenant></Tenant>
    </div>
    </div>
    <div v-else>
        <h1>Loading...</h1>
    </div>
  </div>
  <div v-else>
    <button @click="goback" class="button gray">Go Back To Home Page</button>
  </div>
</template>

<script>
import Tenant from "../components/Tenant.vue";
import ApplicationService from "../services/ApplicationService";
import axios from "axios";
export default {
  data() {
    return {
      wait: false,
      applicationCheck: {},
    };
  },

  components: {
    Tenant,
  },
  methods: {
    checkThis() {
      ApplicationService.getApplicationById(this.$store.state.user.id).then(
        (e) => {
          this.applicationCheck = e.data;
        }
      );
    },

    goback() {
      this.$router.push("/");
    },

    available() {
      this.$router.push("/available");
    },

    withdraw() {
      let change = {
        userId: this.$store.state.user.id,
        appStatus: "withdrawn",
      };
      axios.put("/applications/update", change).then((e) => {
        alert("Withdrawn");
      });
    },
  },

  created() {
    this.checkThis();
    this.wait = true;
  },
};
</script>

<style scoped>
.button {
  border-radius: 10px;
  display: block;
  width: 100%;
  padding: 10px;
  background: #f11303f5;
  color: white;
}
.button:hover {
  background-color: gray;
}

.grey {
  background: #73b680;
  color: white;
}

.grey:hover {
  color: white;
}
</style>
