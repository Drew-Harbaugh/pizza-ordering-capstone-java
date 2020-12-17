<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger">
      <div class="navigation">
        <div id="newLogo">
          <router-link v-bind:to="{ name: 'home' }">
            <img
              src="@/Extras/anotherOneBitesTheCrustLogo.png"
              id="navbarLogo"
          /></router-link>
        </div>

        <div id="title">
          <h1 class="h1 mb-3 font-weight-normal">{{ title }}</h1>
        </div>

        <div id="navLink">
          <b-nav>
            <router-link v-bind:to="{ name: 'specials' }" tag="b-nav-item"
              >Specials</router-link
            >
            <router-link v-bind:to="{ name: 'custom' }" tag="b-nav-item"
              >Custom</router-link
            >
            <router-link v-bind:to="{ name: 'cart' }" tag="b-nav-item"
              >Cart ({{ $store.state.cart.length }})</router-link
            >
          </b-nav>
        </div>
      </div>
    </b-navbar>
  </div>
</template>

<script>
export default {
  computed: {
    title() {
      return this.$route.meta.pageTitle;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Warnes&display=swap");

.navigation {
  display: grid;
  width: 100%;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "logo title nav";
}

#newLogo {
  grid-area: logo;
}

#title {
  grid-area: title;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

#navLink {
  grid-area: nav;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
}

#navbarLogo {
  height: 100px;
}

a:link {
  color: white;
}

a:visited {
  color: white;
}

h1 {
  font-family: "Warnes", cursive;
  color: #fff;
  text-shadow: 0 0 5px #000000, 0 0 10px #fff, 0 0 15px #fdb813,
    0 0 20px #fdb813, 0 0 25px #fdb813, 0 0 30px #fdb813, 0 0 35px #fdb813;
}
</style>