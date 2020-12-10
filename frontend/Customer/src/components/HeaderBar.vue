<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
      <div class="navBarLogo" id="navbarLogo">
        <b-img
          src="src\components\src\views\anotherOneBitesTheCrustLogo.png"
          fluid
          alt="Pizza image"
        ></b-img>
      </div>
      <div id="navTitle">
        <h1 class="h3 mb-3 font-weight-normal">Another One Bites The Crust</h1>
      </div>
      <div>
  <b-nav id="navLink">
    <b-nav-item>Link</b-nav-item>
    <b-nav-item>Link</b-nav-item>
    <b-nav-item>Link</b-nav-item>
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
  width: 60%;
  height: auto;
}

#navTitle {
  grid-area: "title";
  
}

#navLink {
  grid-area: "nav";
  
}

a:link {
  color: white;
}

a:visited {
  color: white;
}

h1{
  width: 15vw;
  font-family: Pizzeria;
}

.navBarLogo {
  width: 60%;
  height: auto;
}

.h3 {
  margin: 0 auto;
  margin-left: 35%;
  color: white;
  font-size: 30px;
  text-align: center;
  padding-right: 20%;
}
</style>