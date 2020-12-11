<template>
  <div>
    <div class="category-columns">
      <category-column v-bind:sortedChoices="size" id="size"></category-column>
      <category-column
        v-bind:sortedChoices="crust"
        id="crust"
      ></category-column>
      <category-column
        v-bind:sortedChoices="sauce"
        id="sauce"
      ></category-column>
      <category-column
        v-bind:sortedChoices="regularToppings"
        id="regularToppings"
      ></category-column>
      <category-column
        v-bind:sortedChoices="premiumToppings"
        id="premiumToppings"
      ></category-column>
    </div>
  </div>
</template>

<script>
import CategoryColumn from "@/components/CategoryColumn.vue";

export default {
  data() {
    return {
      cart: [],
    };
  },
  props: ['choices'],
  components: {
    CategoryColumn,
  },
  methods: {},
  computed: {
    size() {
      return this.choices.filter((choice) => choice.categoryId === 1);
    },
    crust() {
      return this.choices.filter((choice) => choice.categoryId === 2);
    },
    sauce() {
      return this.choices.filter((choice) => choice.categoryId === 3);
    },
    regularToppings() {
      return this.choices.filter((choice) => choice.categoryId === 4);
    },
    premiumToppings() {
      return this.choices.filter((choice) => choice.categoryId === 5);
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
    "desc ing";
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

.toppingsList {
  grid-area: "ing";
}

.divider {
  height: 10px;
  width: auto;
}
</style>