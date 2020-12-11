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
        <h1 class="h3 mb-3 font-weight-normal">Title</h1>
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
  grid-template-areas: "navbarLogo title .";
}
#navbarLogo {
  grid-area: navbarLogo;
}
#title {
  grid-area: title;
  color: white;
  display: flex;
  justify-content: center;
  padding-left: 23%;
}
.navBarLogo {
  width: 20vw;
}
</style>