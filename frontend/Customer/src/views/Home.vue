<template>
  <div id="home">
    <header-bar id="navBar"></header-bar>
    <div id="heroImage">
      <div id="boxesGrid">
        <div id="homeBox1">
          <p class="neon">A whole lot of text</p>
          <p class="neon" style="font-size: 15px; color">
            For a limited time order any custom pizza with unlimited toppings
            for no additional charge!
          </p>
        </div>
        <!-- <div id="middleBoxes"> -->
        <div id="specialtyBox" class="homeBoxes">
          <h2>Specialty Pizza!</h2>
          <img
            src="https://lh3.googleusercontent.com/proxy/0Uj108Dw9ugpM1n3xF2AcUaw4uUZpqY5cdcXAfFzxwqRc7UAtZkp2TgI_SRAw7B2YZ8qRNLPeOY_A5YnmYdiusLW1NlsGTmHXDZSeDrgbc9SXR6vVEdEXhI"
            alt="Meat Lovers Pizza"
            style="width: inherit"
          />
          <b-button>Order Now!</b-button>
        </div>
        <div id="customBox" class="homeBoxes">
          <h2>Custom Pizza!</h2>
          <img src="" alt="Veggie Pizza" style="width: inherit" />
          <b-button>Order Now!</b-button>
        </div>
      </div>
    </div>
    <div id="bottom">
      <p>ABOUT US AND THE PROJECT</p>
      <p>Bacon ipsum dolor amet ham hock tri-tip sirloin pig venison sausage chicken pork pancetta cow corned beef. Leberkas pastrami kevin turducken cow tenderloin, ball tip ground round pork tail buffalo. Boudin strip steak porchetta beef, picanha t-bone ham hock pastrami rump tongue. Bresaola cow shankle t-bone ball tip landjaeger, short loin pastrami salami chuck ham hock strip steak.</p>
      <p>LinkedIn Tags</p>
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
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6,
    0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
}
h2 {
  font-family: Pizzeria;
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
}

#customBox {
  grid-area: customBox;
  background-color: #dc3545;
  margin-left: 85px;
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
</style>
