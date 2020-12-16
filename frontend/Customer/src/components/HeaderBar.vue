<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
      <div id="newLogo">
        <router-link v-bind:to="{ name: 'home' }">
          <img
            src="@/components/src/views/anotherOneBitesTheCrustLogo.png"
            class="navBarLogo"
            id="navbarLogo"
        /></router-link>
      </div>

      <div id="title">
        <h1 class="h3 mb-3 font-weight-normal">{{ title }}</h1>
      </div>

      <div>
        <b-nav id="navLink">
          <router-link v-bind:to="{ name: 'specials' }" tag="b-nav-item"
            >Specials</router-link
          >
          <router-link v-bind:to="{ name: 'custom' }" tag="b-nav-item"
            >Custom</router-link
          >
          <router-link v-bind:to="{ name: 'cart' }" tag="b-nav-item"
            >Cart</router-link
          >
        </b-nav>
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

#navbar {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "logo title nav";
}

#newLogo {
  grid-area: logo;
}

#title {
  grid-area: title;
  padding-right: 28%;
}

#navLink {
  grid-area: nav;
  display: flex;
  flex-direction: row;
  /* align-content: flex-end; */

  width: 250px;
}

#navbarLogo {
  height: auto;
  width: 60%;
}

a:link {
  color: white;
}

a:visited {
  color: white;
}

/* h1 {
  width: 27vw;
  font-family: Pizzeria;
  margin: 0 auto;
  margin-left: 35%;
  color: white;
  font-size: 30px;
  text-align: center;
  padding-right: 20%;
} */

h1 {
  font-family: "Warnes", cursive;
  color: #fff;
  text-shadow: 0 0 5px #000000, 0 0 10px #fff, 0 0 15px #fdb813,
    0 0 20px #fdb813, 0 0 25px #fdb813, 0 0 30px #fdb813, 0 0 35px #fdb813;
}
</style>