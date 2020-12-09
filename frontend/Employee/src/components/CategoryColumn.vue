<template>
  <div class="list">
      <h2 id="title">{{ title }}</h2>
      <div v-for="choice in sortedChoices" v-bind:key="choice.choiceId">
        <ul>
          <li id="name">{{ choice.name }}</li>
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
      if (this.sortedChoices.length === 0) {
        return '';
      }
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

/* .list {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    " "
} */

#title{
    grid-area: title;
}

#name{
    grid-area: name;
}

</style>