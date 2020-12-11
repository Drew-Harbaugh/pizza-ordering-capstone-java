<template>
  <div>
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
        <h3 class="price">{{ special.price }}</h3>
        <p class="description">{{ special.description }}</p>
      </div>
      <button v-on:click="deleteSpecial(special)">Delete</button>
      <button v-on:click="makeAvailable(special)">Make Available</button>
      <button v-on:click="makeUnavailable(special)">Make Unavailable</button>
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

<style scope>
.newSpecial {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "name price"
    "desc desc";
  padding-top: 15px;
  background-color: darkgray;
  border-radius: 25px;
  width: 95%;
  text-align: center;
}
.name {
  grid-area: "name";
}
.price {
  grid-area: "price";
}
.description {
  grid-area: "desc";
}
#specialBody {
  padding-left: 20px;
}
.divider {
  height: 10px;
  width: auto;
}
.unavailable {
  text-decoration: line-through;
}
</style>