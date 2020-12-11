<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
      <div class="navBarLogo" id="navbarLogo">
        <b-img
          src="@/components/src/views/anotherOneBitesTheCrustLogo.png"
          fluid
          alt="Pizza image"
        ></b-img>
      </div>
      <div id="navTitle">
        <h1 class="h3 mb-3 font-weight-normal">Main Page</h1>
      </div>
      <div>
    <b-nav id="navLink">
    <!-- <b-nav-item href="http://localhost:8080/specials">Specials</b-nav-item> -->
    <!-- <b-nav-item>Custom Pizza</b-nav-item> -->
    <router-link v-bind:to="{name: 'specials'}" tag="b-nav-item">Specials</router-link>
    <router-link v-bind:to="{name: 'custom'}" tag="b-nav-item">Custom</router-link>
    <router-link v-bind:to="{name: 'cart'}" tag="b-nav-item">Cart</router-link>
    <b-nav-item disabled>Disabled</b-nav-item>
  </b-nav>
</div>
    </b-navbar>
  </div>
</template>

<script>
export default {};
</script>

<style>

#navbar {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "logo title nav"
  ;
}

#navbarLogo {
  grid-area: "logo";
  width: 30%;
  height: auto;
}

#navTitle {
  grid-area: "title";
  
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

h1{
  width: 27vw;
  font-family: Pizzeria;
  margin: 0 auto;
  margin-left: 35%;
  color: white;
  font-size: 30px;
  text-align: center;
  padding-right: 20%;
}


</style>