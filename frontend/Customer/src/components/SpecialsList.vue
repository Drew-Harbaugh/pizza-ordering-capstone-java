<template>
  <div>
    <div
      id="specialBody"
      v-for="special in specials"
      v-bind:key="special.specialtyId"
    >
      <div class="newSpecial">
        <h2 class="name">{{ special.name }}</h2>
        <h3 class="price">{{ special.price }}</h3>
        <p class="description">{{ special.description }}</p>
        <div class="toppingsLists">
          <h4>Regular Toppings</h4>
          <div
            v-for="regularTopping in special.regularToppings"
            v-bind:key="regularTopping.name"
          >
            <p>{{ regularTopping.name }}</p>
          </div>
          <h4>Premium Toppings</h4>
          <div
            v-for="premiumTopping in special.premiumToppings"
            v-bind:key="premiumTopping.name"
          >
            <p>{{ premiumTopping.name }}</p>
          </div>
        </div>
        <div class="chooseSize" v-for="size in sizes" v-bind:key="size.choiceId">
          <input type="radio" v-bind:name="'size' + special.specialtyId" v-bind:value="size" v-model="selectedSizes[special.specialtyId]">
          <label for="size">{{size.name}}</label>
          <button v-on:click="addPizzaToCart(special, size)">Add to Cart</button>
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
    cart: []
    }
  },
  props: ['specials', 'choices'], 
  computed: {
      sizes() {
      return this.choices.filter((choice) => choice.categoryId === 1);
    },
  },
  methods: {
      addPizzaToCart(special, size) {
        special.size = size;
        this.cart.push(special);
      }
    }
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