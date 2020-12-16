<template>
  <div class="allOrders">
    <h1 id="sectionTitle">Pending Orders</h1>
    <div v-for="order in pendingOrders" v-bind:key="order.orderId">
      <div class="order">
        <div class="orderStatus">
          <h2>{{ order.orderId }} -</h2>
          <h2>- {{ order.status }}</h2>
        </div>
        <div class="customer">
          <p>{{ order.customer.name }}</p>
          <p>{{ order.customer.phoneNumber }}</p>
          <p>{{ order.customer.address }}</p>
          <p v-if="order.delivery===true">Delivery</p>
          <p v-else>Pick Up</p>
        </div>
      </div>
      <div class="pizzas">
        <div id="pizza" v-for="pizzaObject in order.cart" v-bind:key="pizzaObject.pizzaId">
          <div class="pizza">
            <h2 class="pizzaName">{{ pizzaObject.pizza.name }}</h2>
            <div class="toppingsList">
              <div>
                <h4>Regular Toppings</h4>
                <p v-show="pizzaObject.pizza.regularToppings.length === 0">
                  None
                </p>
                <div
                  v-for="regularTopping in pizzaObject.pizza.regularToppings"
                  v-bind:key="regularTopping.name"
                >
                  <p>{{ regularTopping.name }}</p>
                </div>
                <h4>Premium Toppings</h4>
                <p v-show="pizzaObject.pizza.premiumToppings.length === 0">
                  None
                </p>
                <div
                  v-for="premiumTopping in pizzaObject.pizza.premiumToppings"
                  v-bind:key="premiumTopping.name"
                >
                  <p>{{ premiumTopping.name }}</p>
                </div>
              </div>
            </div>
            <div class="pizzaInfo">
              <h3>{{ pizzaObject.size.name }}</h3>
              <h3>{{ pizzaObject.pizza.crust.name }}</h3>
              <h3>{{ pizzaObject.pizza.sauce.name }}</h3>
            </div>
            <div class="statusButtons">
              <button v-on:click="markCancelled(order.orderId)">
                Cancelled
              </button>
              <button v-on:click="markReady(order.orderId)">Ready</button>
              <button v-on:click="markComplete(order.orderId)">Complete</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <h1 id="sectionTitle">Order History</h1>
    <div v-for="order in orderHistory" v-bind:key="order.orderId">
      <div class="order">
        <div class="orderStatus">
          <h2>{{ order.orderId }} -</h2>
          <h2>- {{ order.status }}</h2>
        </div>
        <div class="customer">
          <p>{{ order.customer.name }}</p>
          <p>{{ order.customer.phoneNumber }}</p>
          <p>{{ order.customer.address }}</p>
        </div>
      </div>
      <div class="pizzas">
        <div id="pizza" v-for="pizzaObject in order.cart" v-bind:key="pizzaObject.pizzaId">
          <div class="pizza">
            <h2 class="pizzaName">{{ pizzaObject.pizza.name }}</h2>
            <div class="toppingsList">
              <h4>Regular Toppings</h4>
              <div
                v-for="regularTopping in pizzaObject.pizza.regularToppings"
                v-bind:key="regularTopping.name"
              >
                <p>{{ regularTopping.name }}</p>
              </div>
              <h4>Premium Toppings</h4>
              <div
                v-for="premiumTopping in pizzaObject.pizza.premiumToppings"
                v-bind:key="premiumTopping.name"
              >
                <p>{{ premiumTopping.name }}</p>
              </div>
            </div>
            <div class="pizzaInfo">
              <h3>{{ pizzaObject.size.name }}</h3>
              <h3>{{ pizzaObject.pizza.crust.name }}</h3>
              <h3>{{ pizzaObject.pizza.sauce.name }}</h3>
            </div>
            <div class="statusButtons">
              <!-- <button v-on:click="markPending(order.orderId)">Pending</button> -->
              <button v-on:click="markCancelled(order.orderId)">
                Cancelled
              </button>
              <button v-on:click="markReady(order.orderId)">Ready</button>
              <button v-on:click="markComplete(order.orderId)">Complete</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import orderService from "@/services/OrderService.js";

export default {
  props: ["orders"],
  computed: {
    pendingOrders() {
      return this.orders.filter((order) => order.status === "Pending");
    },
    orderHistory() {
      return this.orders.filter((order) => order.status !== "Pending");
    },
  },
  methods: {
    markCancelled(orderId) {
      let order = {
        orderId: orderId,
        status: "Cancelled",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markComplete(orderId) {
      let order = {
        orderId: orderId,
        status: "Complete",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markReady(orderId) {
      let order = {
        orderId: orderId,
        status: "Ready",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    markPending(orderId) {
      let order = {
        orderId: orderId,
        status: "Pending",
      };
      orderService
        .updateOrderStatus(order)
        .then((response) => {
          if (response.status === 200) {
            this.refreshOrders();
          }
        })
        .catch((error) => {
          console.log(error.message);
        });
    },
    refreshOrders() {
      orderService.getAllOrders().then((response) => {
        this.$store.commit("SET_ORDERS", response.data);
      });
    },
  },
};
</script>

<style>
.allOrders {
  padding-left: 20px;
}
#pizza {
  padding: 15px 15px 15px 0px;
}
.pizza {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "name toppings"
    "info toppings"
    "buttons buttons";
  
  background-color: darkgray;
  border-radius: 25px;
  height: 100%;
  width: 40vw;
  text-align: center;
  border: solid #dc3545 5px;
}
.pizzaName {
  grid-area: name;
  font-size: 50px;
}
.pizzaInfo {
  grid-area: info;
  display: flex;
  flex-direction: column;
}
.toppingsList {
  grid-area: toppings;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.statusButtons {
  grid-area: buttons;
  display: flex;
  justify-content: center;
}
.orderStatus {
  display: flex;
}
.customer {
  display: flex;
  flex-direction: column;
}
.customer p {
  font-size: 23px;
  margin: 0;
}
.pizzas {
  display: flex;
  justify-content: flex-start;
}
#sectionTitle {
  padding: 10px 10px 10px 0px;
  text-decoration: underline;
}
</style>