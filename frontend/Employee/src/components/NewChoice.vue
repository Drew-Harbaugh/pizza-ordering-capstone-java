<template>
  <div>
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
      <div>
        <button v-on:click.prevent="resetForm">Cancel</button>
        <button>Add New Choice</button>
      </div>
    </form>
  </div>
</template>

<script>
import choiceService from '@/services/ChoiceService.js';

export default {
  data() {
    return {
      newChoice: {
        categoryId: 0,
        name: "",
        available: false,
      },
    };
  },
  methods: {
    addNewChoice() {
        this.newChoice.available = true;
        choiceService.addNewChoice(this.newChoice).then(response => {
            if (response.status === 201) {
                alert('New choice successfully added!');
                this.updateChoices();
                this.resetForm();
            }
        }).catch(error => {
            console.log(error.response);
        });
    },
    updateChoices() {
        choiceService.getAllChoices().then(response => {
            this.$store.commit('SET_CHOICES', response.data);
        });
    },
    resetForm() {
          this.newChoice = {};
      }
  },
};
</script>

<style>
</style>