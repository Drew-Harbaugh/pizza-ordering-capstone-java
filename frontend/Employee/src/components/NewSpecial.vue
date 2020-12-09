<template>
  <div>
    <form v-on:submit.prevent="addNewSpecial">
      <div>
        <label for="specialName">Special Name:</label>
        <input type="text" v-model="newSpecial.name" />
      </div>
      <div>
        <label for="specialDescription">Description:</label>
        <textarea
          cols="30"
          rows="10"
          v-model="newSpecial.description"
        ></textarea>
      </div>
      <div>
        <label for="price">Price:</label>
        <money
          v-bind="money"
          value="price"
          v-model="newSpecial.price"
          style="text-align: right"
        ></money>
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
import { Money } from "v-money";

export default {
  components: {
    Money,
  },
  data() {
    return {
      newSpecial: {
        regularToppings: [],
        premiumToppings: [],
      },
      money: {
        decimal: ".",
        thousands: ",",
        prefix: "$ ",
        suffix: "",
        precision: 2,
        masked: false,
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
</style>