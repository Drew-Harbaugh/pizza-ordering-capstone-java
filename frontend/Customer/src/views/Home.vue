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
            src=""
            alt="Meat Lovers Pizza"
            style="width: inherit"
          />
          <router-link v-bind:to="{name: 'specials'}" tag="b-button">Order Now!</router-link>
          
        </div>
        <div id="customBox" class="homeBoxes">
          <h2>Custom Pizza!</h2>
          <img src="" alt="Veggie Pizza" style="width: inherit" />
          <router-link v-bind:to="{name: 'custom'}" tag="b-button">Order Now!</router-link>
        </div>
      </div>
    </div>
    <div id="bottom">
      <p>ABOUT US AND THE PROJECT</p>
      <p>Bacon ipsum dolor amet ham hock tri-tip sirloin pig venison sausage chicken pork pancetta cow corned beef. Leberkas pastrami kevin turducken cow tenderloin, ball tip ground round pork tail buffalo. Boudin strip steak porchetta beef, picanha t-bone ham hock pastrami rump tongue. Bresaola cow shankle t-bone ball tip landjaeger, short loin pastrami salami chuck ham hock strip steak.</p>
      <p>Connect with the developers on LinkedIn</p>
      <div id=LinkedIn>
        <div><b-Link class="linkedInLink" href="https://www.linkedin.com/in/walkersammarie/" target="_blank">Sam Walker</b-Link></div>
        <div><b-Link class="linkedInLink" href="https://www.linkedin.com/in/jack3jk/" target="_blank">Jordan Jackson</b-Link></div>
        <div><b-Link class="linkedInLink" href="https://www.linkedin.com/in/iliasmith/" target="_blank">Ilia Smith</b-Link></div>
        <div><b-Link class="linkedInLink" href="http://www.linkedin.com/in/drew-harbaugh" target="_blank">Drew Harbaugh</b-Link></div>
        <div><b-Link class="linkedInLink" href="https://www.linkedin.com/in/benjaminwilliams1020/" target="_blank">Ben Williams</b-Link></div>
      </div>
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
  font-family: Pizzeria;
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
  padding-top: 25px;
  padding-bottom: 25px;
  background-color: lightgray;
  border: 2px solid #dc3545;
  box-sizing: border-box;
  text-align: center;
}

#LinkedIn {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
p {
  font-family: Pizzeria;
}

.linkedInLink {
  color: black;
  font-family: Pizzeria;
}
.linkedInLink:hover {
  text-decoration: none;
  font-weight: bold;
}
</style>
