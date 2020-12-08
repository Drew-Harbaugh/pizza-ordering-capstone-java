<template>
  <div class="category-columns">
      <category-column v-bind:sortedChoices="size"></category-column>
      <category-column v-bind:sortedChoices="crust"></category-column>
      <category-column v-bind:sortedChoices="sauce"></category-column>
      <category-column v-bind:sortedChoices="regularToppings"></category-column>
      <category-column v-bind:sortedChoices="premiumToppings"></category-column>
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
  display: flex;
  justify-content: space-around;
}
</style>