<template>
  <div class="list">
    <h2 class="title">{{ title }}</h2>
    <div
      class="name"
      v-for="choice in sortedChoices"
      v-bind:key="choice.choiceId"
    >
      <ul>
        <li v-bind:class="{ unavailable: !choice.available }">
          <input
            type="checkbox"
            v-bind:value="choice"
            
          />
          {{ choice.name }}
        </li>
      </ul>
    </div>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      customItem: [],
    };
  },  
  props: ["sortedChoices"],
  computed: {
    
    title() {
      if (this.sortedChoices.length === 0) {
        return "";
      }
      const oneChoice = this.sortedChoices[0];
      if (oneChoice.categoryId === 1) {
        return "Size";
      } else if (oneChoice.categoryId === 2) {
        return "Crust";
      } else if (oneChoice.categoryId === 3) {
        return "Sauce";
      } else if (oneChoice.categoryId === 4) {
        return "Regular Toppings";
      } else {
        return "Premium Toppings";
      }
    },
  },
  methods: {
    addCustomToCart(size,crust,sauce,regularToppings,premiumToppings){
          let customItem = {
              size: size,
              crust: crust,
              sauce: sauce,
              regularToppings: regularToppings,
              premiumToppings: premiumToppings
          }
          this.cart.push(customItem);
      },
  },
};
</script>

<style>
li {
  list-style: none;
  font-size: 1.2rem;
}
.title {
  grid-area: title;
}
.name {
  grid-area: name;
}
.unavailable {
  text-decoration: line-through;
}
</style>