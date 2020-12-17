<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger">
      <div id="navigation">
        <div class="navBarLogo">
          <img
            src="@/views/anotherOneBitesTheCrustLogo.png"
            fluid
            alt="Pizza image"
            id="logoImage"
          />
        </div>
        <div id="title">
          <h1 class="h3 mb-3 font-weight-normal">{{ title }}</h1>
        </div>
        <b-nav id="navLink">
          <router-link v-bind:to="{ name: 'specials' }" tag="b-nav-item"
             style="font-size: 15px;">Specials</router-link
          >
          <router-link v-bind:to="{ name: 'choices' }" tag="b-nav-item"
            style="font-size: 15px;" >Choices</router-link
          >
          <router-link v-bind:to="{ name: 'orders' }" tag="b-nav-item"
            style="font-size: 15px;" >Orders</router-link
          >
          <router-link v-bind:to="{ name: 'history' }" tag="b-nav-item"
            style="font-size: 15px;" >History</router-link
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

<style scope>
#navigation {
  display: grid;
  width: 100%;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "logo title nav";
}
#navbarLogo {
  grid-area: logo;
}
#navLink {
  grid-area: nav;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  width: 100%;
  margin: auto;
}
a:link {
  color: white;
}
a:visited {
  color: white;
}
#title {
  grid-area: title;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 100%;
}
#logoImage {
  height: 100px;
  width: auto;
}
</style>