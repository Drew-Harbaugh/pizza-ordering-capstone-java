<template>
  <div>
    <div
      id="specialBody"
      v-for="special in available"
      v-bind:key="special.specialtyId"
    >
      <div class="newSpecial">
        <h2 class="name">{{ special.name }}</h2>
        <div class="regularToppingsLists">
          <h4 class="none" v-if="special.regularToppings.length === 0">
            Regular Toppings(None)
          </h4>
          <h4 v-else>Regular Toppings</h4>
          <div
            v-for="regularTopping in special.regularToppings"
            v-bind:key="regularTopping.name"
          >
            <p>{{ regularTopping.name }}</p>
          </div>
          <div class="premiumToppingsList">
          <h4 class="none" v-if="special.premiumToppings.length === 0">
            Premium Toppings(None)
          </h4>
          <h4 v-else>Premium Toppings</h4>
          <div
            v-for="premiumTopping in special.premiumToppings"
            v-bind:key="premiumTopping.name"
          >
            <p>{{ premiumTopping.name }}</p>
          </div>
          </div>
        </div>
        <p class="description">{{ special.description }}</p>
        <div class="chooseSize">
          <div v-for="size in sizes" v-bind:key="size.choiceId">
            <input
              type="radio"
              v-bind:name="'size' + special.specialtyId"
              v-bind:value="size"
              v-bind:class="{ none: !size.available }"
              v-model="selectedSizes[special.specialtyId]"
            />
            <label for="size" v-if="size.available === true"
              >{{ size.name }} - ${{ size.specialtyPrice }}</label
            >
            <label class="none" for="size" v-else
              >None {{ size.specialtyPrice }}</label
            >
          </div>
        </div>
        <div id="buttonDiv">
          <button
            class="addToCart"
            v-on:click="
              addPizzaToCart(special, selectedSizes[special.specialtyId])
            "
          >
            Add to Cart
          </button>
        </div>
      </div>
      <div class="divider"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedSizes: {},
      cart: [],
    };
  },
  props: ["specials", "choices"],
  computed: {
    sizes() {
      return this.choices.filter((choice) => choice.categoryId === 1);
    },
    available() {
      return this.specials.filter((special) => special.available === true);
    },
  },
  methods: {
    addPizzaToCart(special, size) {
      let orderItem = {
        pizza: special,
        size: {
          choiceId: size.choiceId,
          categoryId: size.categoryId,
          name: size.name,
          price: size.specialtyPrice,
        },
      };
      this.cart.push(orderItem);
      this.$store.commit("ADD_TO_CART", orderItem);
      this.$store.commit("ADD_TO_TOTAL", orderItem.size.price);
      this.selectedSizes = {};
      alert("Pizza added to cart!");
    },
  },
};
</script>

<style>
.newSpecial {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "name ring"
    "desc ping"
    "sizes sizes"
    "button button";
  padding-top: 25px;
  background-color: darkgray;
  border-radius: 25px;
  width: 95%;
  text-align: center;
}

.name {
  grid-area: "name";
}
.description {
  display: flex;
  flex-direction: column;
  align-self: center;
  grid-area: "desc";
}
.regularToppingsList {
  grid-area: "ring";
}
.premiumToppingsList{
  grid-area: "ping";
}
.chooseSize {
  grid-area: "sizes";
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
}
.addToCart {
  grid-area: "button";
}
#specialBody {
  padding-left: 20px;
}
.divider {
  height: 10px;
  width: auto;
}

.none {
  display: none;
}

#buttonDiv {
  margin-top: 10px;
  padding-bottom: 25px;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.addToCart {
  border-radius: 10px;
}

.addToCart:hover {
  background-color: black;
  font-family: "Warnes", cursive;
  color: #fff;
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6,
    0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
}
</style>