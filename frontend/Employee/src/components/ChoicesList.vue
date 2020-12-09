<template>
  <div class="category-columns">
      <category-column v-bind:sortedChoices="size" id="size"></category-column>
      <category-column v-bind:sortedChoices="crust" id="crust"></category-column>
      <category-column v-bind:sortedChoices="sauce" id="sauce"></category-column>
      <category-column v-bind:sortedChoices="regularToppings" id="regularToppings"></category-column>
      <category-column v-bind:sortedChoices="premiumToppings" id="premiumToppings"></category-column>
  </div>
</template>

<script>
import categoryColumn from '@/components/CategoryColumn.vue';

export default {
    components: {
        categoryColumn
    },
    props: ['choices'],
    computed: {
        size() {
            return this.choices.filter(choice => choice.categoryId === 1);
        },
        crust() {
            return this.choices.filter(choice => choice.categoryId === 2);
        },
        sauce() {
            return this.choices.filter(choice => choice.categoryId === 3);
        },
        regularToppings() {
            return this.choices.filter(choice => choice.categoryId === 4);
        },
        premiumToppings() {
            return this.choices.filter(choice => choice.categoryId === 5);
        }
    }
}
</script>

<style>


.category-columns {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "size ."
    "crust ."
    "sauce ."
    "reg ."
    "prem .";
}

#size{
    grid-area: size;
}

#crust{
    grid-area: crust;
}

#sauce{
    grid-area: sauce;
}

#regularToppings{
    grid-area: reg;
}

#premiumToppings{
    grid-area: prem;
}
</style>