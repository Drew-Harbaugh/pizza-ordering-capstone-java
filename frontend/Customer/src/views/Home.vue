<template>
  <div id="home">
    <header-bar id="navBar"></header-bar>
    <div id="heroImage">
      <div id="boxesGrid">
        <div id="homeBox1">
          <p class="neon">Grand Opening!</p>
          <p class="neon" style="font-size: 25px; color">
            For a limited time order any custom pizza with unlimited toppings
            for no additional charge!
          </p>
        </div>
        <!-- <div id="middleBoxes"> -->
        <div id="specialtyBox" class="homeBoxes">
          <h2>Specialty Pizza!</h2>
          <img
            id="pizzaImg1"
            src="@/Extras/pizza1.jpg"
            alt="Meat Lovers Pizza"
          />
          <router-link v-bind:to="{name: 'specials'}" tag="b-button">Order Now!</router-link>
          
        </div>
        <div id="customBox" class="homeBoxes">
          <h2>Custom Pizza!</h2>
          <img id="pizzaImg2" src="@/Extras/pizza2.jpg" alt="Veggie Pizza" />
          <router-link v-bind:to="{name: 'custom'}" tag="b-button">Order Now!</router-link>
        </div>
      </div>
    </div>
    <div id="bottom">
      <p>ABOUT THE PROJECT</p>
      <p>This is a pair of applications (with a shared backend) for a pizzeria. The first allows customers to order pizzas, either from a list of pre-configured options or create their own. The second enables the pizzeria employees to keep track of customer orders and update the menu of available options.</p>
      <router-link v-bind:to="{name: 'about'}" tag="b-button">Learn about the developers</router-link>
    </div>
  </div>
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";

export default {
  components: {
    HeaderBar,
  },
};
</script>

<style scoped>
.neon {
  font-size: 80px;
  text-align: center;
  font-family: "Warnes", cursive;
  color: #fff;
  text-shadow: 0 0 5px #000000, 0 0 10px #fff, 0 0 15px #fdb813, 0 0 20px #fdb813,
    0 0 25px #fdb813, 0 0 30px #fdb813, 0 0 35px #fdb813;
    /* animation: blinker 3s linear infinite; #0073e6*/
  
}
h2 {
  color: white;
}

/* #middleBoxes {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
} */

.homeBoxes {
  width: 30vw;
  height: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  border: 4px solid lightgray;
  box-sizing: border-box;
}

#boxesGrid {
  display: grid;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
    "homeBox1 homeBox1"
    "specialtyBox customBox"
    "homeBox2 homeBox2";

  row-gap: 5%;
  column-gap: 1%;
  padding-top: 25px;
  justify-content: center;
}

#homeBox1 {
  grid-area: homeBox1;

  height: 40vh;
  width: 90vw;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

#pizzaImg1 {
  width: 300px;
}

#pizzaImg2 {
  width: 300px;
  height: 155px;
}

#specialtyBox {
  grid-area: specialtyBox;
  background-color: #dc3545;
  margin-left: 85px;
  margin-bottom: -50px;
}

#customBox {
  grid-area: customBox;
  background-color: #dc3545;
  margin-left: 85px;
  margin-bottom: -50px;
}

#heroImage {
  width: 100%;
  height: 125vh;
  background-image: url("https://media.giphy.com/media/4ayiIWaq2VULC/source.gif");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
}

#bottom {
  height: auto;
  padding: 25px;
  background-color: lightgray;
  border: 2px solid #dc3545;
  box-sizing: border-box;
  text-align: center;
}

</style>
