<template>
  <div>
    <form v-on:submit.prevent="addNewSpecial">
      <div id="specialNameBox">
        <label for="specialName">Special Name:</label>
        <input type="text" v-model="newSpecial.name" />
      </div>
      <div id="descriptionBox">
        <label for="specialDescription">Description:</label>
        <textarea rows="4" cols="50" v-model="newSpecial.description" />
      </div>
      <div>
        <h3>Crust</h3>
        <div v-for="choice in crust" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="newSpecial.crust"
          />
        </div>
      </div>
      <div>
        <h3>Sauce</h3>
        <div v-for="choice in sauce" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="newSpecial.sauce"
          />
        </div>
      </div>
      <div>
        <h3>Regular Toppings</h3>
        <div v-for="choice in regularToppings" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="checkbox"
            v-bind:value="choice"
            v-model="newSpecial.regularToppings"
          />
        </div>
      </div>
      <div>
        <h3>Premium Toppings</h3>
        <div v-for="choice in premiumToppings" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="checkbox"
            v-bind:value="choice"
            v-model="newSpecial.premiumToppings"
          />
        </div>
      </div>
      <div>
        <button v-on:click.prevent="resetForm">Cancel</button>
        <button>Add New Specialty Pizza</button>
      </div>
    </form>
  </div>
</template>

<script>
import specialsService from "@/services/SpecialsService.js";

export default {
  components: {
  },
  data() {
    return {
      newSpecial: {
        regularToppings: [],
        premiumToppings: [],
        available: true,
      },
    };
  },
  computed: {
    crust() {
      return this.$store.state.choices.filter(
        (choice) => choice.categoryId === 2
      );
    },
    sauce() {
      return this.$store.state.choices.filter(
        (choice) => choice.categoryId === 3
      );
    },
    regularToppings() {
      return this.$store.state.choices.filter(
        (choice) => choice.categoryId === 4
      );
    },
    premiumToppings() {
      return this.$store.state.choices.filter(
        (choice) => choice.categoryId === 5
      );
    },
  },
  methods: {
    addNewSpecial() {
      specialsService
        .addNewSpecial(this.newSpecial)
        .then((response) => {
          if (response.status === 201) {
            alert("New special successfully added!");
            this.updateSpecials();
            this.resetForm();
          }
        })
        .catch((error) => {
          console.log(error.response);
          alert(error.message);
          this.updateSpecials();
          this.resetForm();
        });
    },
    resetForm() {
      this.newSpecial = {
        regularToppings: [],
        premiumToppings: [],
        available: true,
      };
      this.choiceIds = [];
    },
    updateSpecials() {
      specialsService.getAllSpecials().then((response) => {
        this.$store.commit("SET_SPECIALS", response.data);
      });
    },
  },
};
</script>

<style>

#descriptionBox label{
  display: block;
}

#descriptionBox textarea {
  display: block; 
  width: 450px;                       
}

#specialNameBox label {
  display: block;
}

#specialNameBox input {
  display: block;
  width: 450px;
}


</style>