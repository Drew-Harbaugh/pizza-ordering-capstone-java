<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
      <div class="navBarLogo" id="navbarLogo">
        <b-img
          src="@/views/anotherOneBitesTheCrustLogo.png"
          fluid
          alt="Pizza image"
        ></b-img>
      </div>
      <div id="title">
        <h1 class="h3 mb-3 font-weight-normal">{{title}}</h1>
      </div>
      <div>
        <b-nav id="navLink">
          <router-link v-bind:to="{name: 'specials'}" tag="b-nav-item">Specials</router-link>
          <router-link v-bind:to="{name: 'choices'}" tag="b-nav-item">Choices</router-link>
          <router-link v-bind:to="{name: 'orders'}" tag="b-nav-item">Orders</router-link>
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
    }
  }
};
</script>

<style scope>
#navbar {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "navbarLogo title .";
}
#navbarLogo {
  grid-area: navbarLogo;
}
#navLink {
  grid-area: "nav";
  display: flex;
  flex-direction: row;
  align-content: flex-end;
  padding-left: 400px;
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
  /* padding-left: 23%; */
}
.navBarLogo {
  width: 20vw;
}
</style>