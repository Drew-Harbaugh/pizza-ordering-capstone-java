<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="danger" id="navBar">
      <div class="navBarLogo" id="navbarLogo">
        <b-img
          src="\views\anotherOneBitesTheCrustLogo.png"
          fluid
          alt="Pizza image"
        ></b-img>
      </div>
      <div id="title">
        <h1 class="h3 mb-3 font-weight-normal">Another One Bites The Crust</h1>
      </div>
    </b-navbar>
  </div>
</template>

<script>
export default {};
</script>

<style scope>
#navbar {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "navbarLogo title"
  ;
}

#navbarLogo {
  grid-area: navbarLogo;
}

#title {
  grid-area: title;
}

#signOut {
  grid-area: signOut;
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