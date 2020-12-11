<template>
  <div>
    <div class="category-columns">
      <div>
        <h3>Size</h3>
        <div v-for="choice in size" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="customSize"
          />
        </div>
      </div>
      <div>
        <h3>Crust</h3>
        <div v-for="choice in crust" v-bind:key="choice.choiceId">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="customPizza.crust"
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
            v-model="customPizza.sauce"
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
            v-model="customPizza.regularToppings"
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
            v-model="customPizza.premiumToppings"
          />
        </div>
      </div>
      <button
          class="addToCart"
          v-on:click="
            addPizzaToCart(customPizza, customSize)
          "
        >Add to Cart</button>
      <!-- <category-column v-bind:sortedChoices="size" id="size"></category-column> -->
      <!-- <category-column
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
      ></category-column> -->
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      cart: [],
      customPizza: {
        name: 'Custom',
        crust: {},
        sauce: {},
        regularToppings: [],
        premiumToppings: []
      },
      customSize: {}
    };
  },
  props: ['choices'],
  methods: {
    addPizzaToCart(customPizza, size) {
      let orderItem = {
        pizza: customPizza,
        size: size,
      };
      this.cart.push(orderItem);
      this.$store.commit("ADD_TO_CART", orderItem);
      this.customPizza = {
        name: 'Custom',
        crust: {},
        sauce: {},
        regularToppings: [],
        premiumToppings: []
      };
      this.customSize = {};
      alert('Pizza added to cart!');
    },
  },
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