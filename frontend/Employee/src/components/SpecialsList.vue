<template>
  <div>
    <br>
    <div
      id="specialBody"
      v-for="special in specials"
      v-bind:key="special.specialtyId"
    >
      <div
        class="newSpecial"
        v-bind:class="{ unavailable: !special.available }"
      >
        <h2 class="name">{{ special.name }}</h2>
        <div class="toppingsLists">
          <h4 v-if="special.regularToppings.length === 0"> Regular Toppings (None) </h4>
          <h4 v-else> Regular Toppings</h4>
          
          <div
            v-for="regularTopping in special.regularToppings"
            v-bind:key="regularTopping.name"
          >
            <p v-bind:class="{ unavailable: !regularTopping.available }">{{ regularTopping.name }}</p>
            <!-- <p  v-show="!regularTopping.available"> ({{regularTopping.name}}) Out of stock </p> -->
          </div>
          <h4 v-if="special.premiumToppings.length === 0"> Premium Toppings (None) </h4>
          <h4 v-else >Premium Toppings</h4>
          
          <div
            v-for="premiumTopping in special.premiumToppings"
            v-bind:key="premiumTopping.name"
          >
            <p  v-bind:class="{ unavailable: !premiumTopping.available }">{{ premiumTopping.name }}</p>
            <!-- <p  v-show="!premiumTopping.available"> ({{premiumTopping.name}}) Out of stock </p> -->
          </div>
        </div>
        <p class="description">{{ special.description }}</p>
      </div>
      <button v-on:click="deleteSpecial(special)">Delete</button>
      <button v-if="!special.available" v-on:click="makeAvailable(special)">Make Available</button>
      <button v-else v-on:click="makeUnavailable(special)">Make Unavailable</button>
      <div class="divider"></div>
    </div>
  </div>
</template>

<script>
import specialService from "@/services/SpecialsService.js";
export default {
  props: ["specials"],
  methods: {
    deleteSpecial(special) {
      specialService
        .deleteSpecial(special.specialtyId)
        .then((response) => {
          if (response.status === 200) {
            this.updateSpecials();
          } else if (response.status === 500) {
            alert("Could not delete specialty pizza");
            this.updateSpecials();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    updateSpecials() {
      specialService.getAllSpecials().then((response) => {
        this.$store.commit("SET_SPECIALS", response.data);
      });
    },
    makeUnavailable(special) {
      if (special.available === true) {
        special.available = false;
      }
      this.updateSpecial(special);
    },
    makeAvailable(special) {
      if (special.available === false) {
        special.available = true;
      }
      this.updateSpecial(special);
    },
    updateSpecial(special) {
      specialService
        .updateSpecial(special)
        .then((response) => {
          if (response.status === 200) {
            this.updateSpecials();
          } else if (response.status === 500) {
            alert("Could not update special pizza.");
            this.updateSpecials();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
  },
};
</script>

<style scoped>
.newSpecial {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "name ."
    "desc ing";
  padding-top: 15px;
  background-color: darkgray;
  border-radius: 25px;
  width: 95%;
  text-align: center;
}
.name {
  grid-area: "name";
}
.description {
  grid-area: "desc";
}
.toppingsList {
  grid-area: "ing";
}
#specialBody {
  padding-left: 20px;
}
.divider {
  height: 10px;
  width: auto;
}
.unavailable {
  opacity: 35%;
  text-decoration: none;
}
</style>