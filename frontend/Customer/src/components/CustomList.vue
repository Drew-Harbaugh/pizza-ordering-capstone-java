<template>
  <div id="customList">
    <div class="optionsSection">
      <h3>Size</h3>
      <div class="options">
        <div v-for="choice in size" v-bind:key="choice.choiceId" class="item">
          <label v-bind:for="choice.choiceId"
            >{{ choice.name }} - $ {{ choice.customPrice }}</label
          >
          <input type="radio" v-bind:value="choice" v-model="customSize" />
        </div>
      </div>
    </div>
    <div class="optionsSection">
      <h3>Crust</h3>
      <div class="options">
        <div v-for="choice in crust" v-bind:key="choice.choiceId" class="item">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="customPizza.crust"
          />
        </div>
      </div>
    </div>
    <div class="optionsSection">
      <h3>Sauce</h3>
      <div class="options">
        <div v-for="choice in sauce" v-bind:key="choice.choiceId" class="item">
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="radio"
            v-bind:value="choice"
            v-model="customPizza.sauce"
          />
        </div>
      </div>
    </div>
    <div class="optionsSection">
      <h3>Regular Toppings</h3>
      <div class="options">
        <div
          v-for="choice in regularToppings"
          v-bind:key="choice.choiceId"
          class="item"
        >
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="checkbox"
            v-bind:value="choice"
            v-model="customPizza.regularToppings"
          />
        </div>
      </div>
    </div>
    <div class="optionsSection">
      <h3>Premium Toppings</h3>
      <div class="options">
        <div
          v-for="choice in premiumToppings"
          v-bind:key="choice.choiceId"
          class="item"
        >
          <label v-bind:for="choice.choiceId">{{ choice.name }}</label>
          <input
            type="checkbox"
            v-bind:value="choice"
            v-model="customPizza.premiumToppings"
          />
        </div>
      </div>
    </div>
    <div id="buttonDiv">
      <button
        id="addToCartButton"
        v-on:click="addPizzaToCart(customPizza, customSize)">Add to Cart</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cart: [],
      customPizza: {
        name: "Custom",
        crust: {},
        sauce: {},
        regularToppings: [],
        premiumToppings: [],
      },
      customSize: {},
    };
  },
  props: ["choices"],
  methods: {
    addPizzaToCart(customPizza, size) {
      let orderItem = {
        pizza: customPizza,
        size: {
          choiceId: size.choiceId,
          categoryId: size.categoryId,
          name: size.name,
          price: size.customPrice,
        },
      };
      this.cart.push(orderItem);
      this.$store.commit("ADD_TO_CART", orderItem);
      this.$store.commit("ADD_TO_TOTAL", orderItem.size.price);
      this.customPizza = {
        name: "Custom",
        crust: {},
        sauce: {},
        regularToppings: [],
        premiumToppings: [],
      };
      this.customSize = {};
      alert("Pizza added to cart!");
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

<style>
.options {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
}

.item {
  background-color: #dc3545;
  margin: 2px;
  border-radius: 10px;
  padding: 5px 5px;
  color: white;
}

.optionsSection {
  display: flex;
  flex-direction: column;
  align-items: center;
  /* grid-area: optionsSection; */
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 2%;
}

input {
  margin-left: 8px;
}

#buttonDiv {
  margin-top: 10px;
  padding-bottom: 25px;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#addToCartButton {
  border-radius: 10px;
}

#addToCartButton:hover {
  background-color: black;
  font-family: 'Warnes', cursive;
  color: #fff;
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6, 0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
}

/* #customList {
  display: grid;
  grid-template-columns: 10% 1fr 10%;
  grid-template-areas: 
    ". optionsSection ."
  ;
} */

/* .newSpecial {
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
} */
</style>