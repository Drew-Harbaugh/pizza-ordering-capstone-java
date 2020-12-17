<template>
  <div id="newChoice">
    <form v-on:submit.prevent="addNewChoice">
      <div>
        <label for="choiceName">New Choice:</label>
        <input type="text" v-model="newChoice.name" />
      </div>
      <div>
        <label for="categoryName">Category:</label>
        <select v-model="newChoice.categoryId">
          <option value="1">Size</option>
          <option value="2">Crust</option>
          <option value="3">Sauce</option>
          <option value="4">Regular Toppings</option>
          <option value="5">Premium Toppings</option>
        </select>
      </div>
      <div v-if="newChoice.categoryId === '1'">
        <label for="customPrice">Custom Price: </label>
        <money v-bind="money" value="customPrice" v-model="newChoice.customPrice" style="text-align: right"></money>
      </div>
      <div v-if="newChoice.categoryId === '1'">
        <label for="specialtyPrice">Specialty Price: </label>
        <money v-bind="money" value="specialtyPrice" v-model="newChoice.specialtyPrice" style="text-align: right"></money>
      </div>
      <div>
        <button v-on:click.prevent="resetForm">Cancel</button>
        <button>Add New Choice</button>
      </div>
    </form>
  </div>
</template>

<script>
import choiceService from "@/services/ChoiceService.js";
import { Money } from "v-money";

export default {
  components: {
    Money,
  },
  data() {
    return {
      newChoice: {
        categoryId: 0,
        name: "",
        available: false,
      },
      money: {
        thousands: ",",
        prefix: "$ ",
        suffix: "",
        precision: 2,
        masked: false,
      },
    };
  },
  methods: {
    addNewChoice() {
      this.newChoice.available = true;
      choiceService
        .addNewChoice(this.newChoice)
        .then((response) => {
          if (response.status === 201) {
            this.updateChoices();
            this.resetForm();
          }
        })
        .catch((error) => {
          console.log(error.response);
          alert(error.message);
          this.updateChoices();
          this.resetForm();
        });
    },
    updateChoices() {
      choiceService.getAllChoices().then((response) => {
        this.$store.commit("SET_CHOICES", response.data);
      });
    },
    resetForm() {
      this.newChoice = {};
    },
  },
};
</script>

<style>
#newChoice {
  padding: 0px 20px 20px 20px;
}
</style>