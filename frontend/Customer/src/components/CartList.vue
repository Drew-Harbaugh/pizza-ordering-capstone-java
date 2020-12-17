<template>
  <div id="cart-main">
    <div id="items-in-cart-headline">
      <h1>Items in your cart:</h1>
    </div>
    <div v-show="$store.state.cart.length === 0">
      <h2>No pizzas added</h2>
    </div>
    <div id="list-items-in-cart">
      <div
        class="cart"
        v-for="orderItem in $store.state.cart"
        v-bind:key="orderItem.timeStamp"
      >
        <h3 class="name">{{ orderItem.pizza.name }}</h3>

        <!-- change to only print proper price -->
        <p>{{ orderItem.size.specialtyPrice }}</p>
        <p>{{ orderItem.size.customPrice }}</p>
        <p>{{ orderItem.pizza.price }}</p>
        <div class="regularToppings">
          <h4>Regular Toppings</h4>
          <div
            v-for="regularTopping in orderItem.pizza.regularToppings"
            v-bind:key="regularTopping.name"
          >
            <p>{{ regularTopping.name }}</p>
          </div>
        </div>
        <div class="premiumToppings">
          <h4>Premium Toppings</h4>
          <div
            v-for="premiumTopping in orderItem.pizza.premiumToppings"
            v-bind:key="premiumTopping.name"
          >
            <p>{{ premiumTopping.name }}</p>
          </div>
        </div>
        <div class="size">
          <p>{{ orderItem.size.name }}</p>
        </div>
        <div class="button" id="removeButtonDiv">
          <button id="removeButton" v-on:click="removeFromCart(orderItem)">
            Remove from Cart
          </button>
        </div>
      </div>
    </div>
    <div></div>

    <div v-if="$store.state.cart.length > 0">
      <h3 v-bind="getTotal()">Order Total: {{ total.toFixed(2) }}</h3>
    </div>

    <div v-if="$store.state.cart.length > 0">
      <form v-on:submit.prevent>
        <div>
          <label for="delivery">Delivery</label>
          <input type="radio" v-bind:value="true" v-model="delivery" />
          <label for="pickup">Pick Up</label>
          <input type="radio" v-bind:value="false" v-model="delivery" />
        </div>
        <div>
          <label for="name">Name: </label>
          <input type="text" value="name" v-model="customer.name" />
        </div>
        <div>
          <label for="phoneNumber">Phone Number: </label>
          <input
            type="text"
            value="phoneNumber"
            v-model="customer.phoneNumber"
            minlength="10"
            maxlength="11"
          />
        </div>
        <div v-if="delivery === true">
          <label for="address">Address: </label>
          <input type="text" value="address" v-model="customer.address" />
        </div>
        <div>
          <label for="creditCard">Credit Card #: </label>
          <input
            type="text"
            value="creditCard"
            v-model="customer.creditCard"
            maxlength="16"
            minlength="16"
          />
        </div>

        <div>
          <label for="creditCardExpMonth">Credit Card Exp.: </label>
          <select name="creditCardExpMonth">
            <option value="">Jan</option>
            <option value="">Feb</option>
            <option value="">Mar</option>
            <option value="">Apr</option>
            <option value="">May</option>
            <option value="">Jun</option>
            <option value="">Jul</option>
            <option value="">Aug</option>
            <option value="">Sept</option>
            <option value="">Oct</option>
            <option value="">Nov</option>
            <option value="">Dec</option>
          </select>
          <label for="creditCardExpYear"></label>
          <select name="creditCardExpYear">
            <option value="">2021</option>
            <option value="">2022</option>
            <option value="">2023</option>
            <option value="">2024</option>
            <option value="">2025</option>
            <option value="">2026</option>
            <option value="">2027</option>
            <option value="">2028</option>
            <option value="">2029</option>
            <option value="">2030</option>
          </select>
        </div>

        <div>
          <label for="creditCardCvv">Credit Card CVV: </label>
          <input type="text" minlength="3" maxlength="4" />
        </div>
        <div id="buttonDiv">
        <button id="submitButton" v-on:click="submitOrder()">Submit Order</button>
       </div>
      </form>
    </div>
  </div>
</template>


<script >
import orderService from "@/services/OrderService.js";

export default {
  data() {
    return {
      delivery: false,
      total: 0.0,
      customer: {},
    };
  },
  computed: {},
  methods: {
    removeFromCart(orderItem) {
      this.$store.commit("REMOVE_FROM_CART", orderItem);
      this.$store.commit("REMOVE_FROM_TOTAL", orderItem.size.price);
      this.getTotal();
    },
    getTotal() {
      this.total = this.$store.state.total;
      return this.total;
    },
    submitOrder() {
      if (this.checksBeforeSubmit() === true) {
        this.$store.commit("ADD_CUSTOMER_NAME", this.customer.name);
        const order = this.makeOrderObject();
        orderService
          .addNewOrder(order)
          .then((response) => {
            if (response.status === 201) {
              this.$router.push("/landing");
            }
          })
          .catch((error) => {
            console.log(error);
            alert("Order cannot be submitted");
          });
      } else {
        alert("Please complete all order fields");
      }
    },
    makeOrderObject() {
      let order = {
        status: "Pending",
        timeStamp: Date.now(),
        delivery: this.delivery,
        total: this.getTotal(),
        customer: {
          name: this.customer.name,
          phoneNumber: this.customer.phoneNumber,
          address: this.customer.address,
          creditCard: this.customer.creditCard,
        },
        cart: this.$store.state.cart,
      };
      return order;
    },
    checksBeforeSubmit() {
      if (this.customer.name === undefined) {
        return false;
      } else if (this.customer.phoneNumber === undefined) {
        return false;
      } else if (
        this.customer.address === undefined &&
        this.delivery === true
      ) {
        return false;
      } else if (this.customer.creditCard === undefined) {
        return false;
      } else {
        return true;
      }
    },
  },
};
</script>

<style scoped>
#cart-main {
  margin: 0px;
}
#items-in-cart-headline {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
#list-items-in-cart {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-content: stretch;
  justify-content: center;
}
.cart {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto auto auto auto;
  grid-template-areas:
    "name name"
    "regularToppings premiumToppings"
    "size size"
    "button button";
  padding-top: 25px;
  background-color: darkgray;
  border-radius: 25px;
  width: 40vw;
  height: 100%;
  text-align: center;
  margin: 10px 10px;
}
.name {
  grid-area: name;
}
.regularToppings {
  grid-area: regularToppings;
}
.premiumToppings {
  grid-area: premiumToppings;
}
.size {
  grid-area: size;
}
.button {
  grid-area: button;
  
}

#buttonDiv {
  margin-top: 10px;
  padding-bottom: 25px;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#removeButtonDiv{
  margin-top: 10px;
  padding-bottom: 25px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  
}

#submitButton {
  border-radius: 10px;
}

#removeButton{
  border-radius:10px;
}

#removeButton:hover{
  background-color: black;
  font-family: 'Warnes', cursive;
  color: #fff;
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fdb813, 0 0 20px #fdb813, 0 0 25px #fdb813, 0 0 30px #fdb813, 0 0 35px#fdb813;
}

#submitButton:hover {
  background-color: black;
  font-family: 'Warnes', cursive;
  color: #fff;
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fdb813, 0 0 20px #fdb813, 0 0 25px #fdb813, 0 0 30px #fdb813, 0 0 35px#fdb813;
}

</style>