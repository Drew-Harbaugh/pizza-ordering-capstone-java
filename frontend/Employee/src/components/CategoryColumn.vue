<template>
  <div>
      <h2>{{ title }}</h2>
      <div v-for="choice in sortedChoices" v-bind:key="choice.choiceId">
        <ul>
          <li>{{ choice.name }}</li>
        </ul>
      </div>
  </div>
</template>

<script>
export default {
  props: ['sortedChoices'],
  data() {
    return {
      
    }
  },
  computed: {
    title() {
      const oneChoice = this.sortedChoices[0];
      if (oneChoice.categoryId === 1) {
        return 'Size';
      } else if (oneChoice.categoryId === 2) {
        return 'Crust';
      } else if (oneChoice.categoryId === 3) {
        return 'Sauce';
      } else if (oneChoice.categoryId === 4) {
        return 'Regular Toppings';
      } else {
        return 'Premium Toppings';
      } 
    }
  },
  created() {
    
  }
}
</script>

<style>

</style>