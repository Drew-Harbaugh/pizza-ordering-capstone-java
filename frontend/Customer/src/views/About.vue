<template>
  <div class="backGround">
    <header-bar id="navBar"></header-bar>

    <div class="title">
      <!-- <p>ABOUT US</p> -->
    </div>

    <h2 style="text-align: center">Our Team</h2>
    <div class="row">
      <div class="column">
        <div class="card">
          <img src="@/views/Headshots/JordanPic.jpg" alt="Jordan" style="width: 100%" />
          <div class="container">
            <h2>Jordan Jackson</h2>
            <p class="role">Developer</p>
            
            <p>jacks3jkwork@gmail.com</p>
            <div id="LinkedIn">
              <p>
                <b-Link
                  class="button"
                  href="https://www.linkedin.com/in/jack3jk/"
                  target="_blank"
                  >LinkedIn</b-Link
                >
              </p>
            </div>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="@/views/Headshots/SamPic.jpg" alt="Sam" style="width: 100%" />
          <div class="container">
            <h2>Sam Walker</h2>
            <p class="role">Developer</p>
            
            <p>walkersammarie@gmail.com</p>
            <p>
              <b-Link
                class="button"
                href="https://www.linkedin.com/in/walkersammarie/"
                target="_blank"
                >LinkedIn</b-Link
              >
            </p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="@/views/Headshots/IliaPic.jpg" alt="Ilia" style="width: 100%" />
          <div class="container">
            <h2>Ilia Smith</h2>
            <p class="role">Developer</p>
            
            <p>ilia.smith2016@gmail.com</p>
            <p>
              <b-Link
                class="button"
                href="https://www.linkedin.com/in/iliasmith/"
                target="_blank"
                >LinkedIn</b-Link
              >
            </p>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <img src="@/views/Headshots/BenPic.jpg" alt="Ben" style="width: 100%" />
          <div class="container">
            <h2>Ben Williams</h2>
            <p class="role">Developer</p>
            
            <p>benjamin.williams1020@gmail.com</p>
            <p>
              <b-Link
                class="button"
                href="https://www.linkedin.com/in/benjaminwilliams1020/"
                target="_blank"
                >LinkedIn</b-Link
              >
            </p>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <img src="@/views/Headshots/drew pic.jpg" alt="Drew" style="width: 100%" />
          <div class="container">
            <h2>Drew Harbaugh</h2>
            <p class="role">Developer</p>
            
            <p>dharbaugh2290@gmail.com</p>
            <p>
              <b-Link
                class="button"
                href="http://www.linkedin.com/in/drew-harbaugh"
                target="_blank"
                >LinkedIn</b-Link
              >
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue"

export default {
    components: {
        HeaderBar,
    },
};
</script>

<style scoped>
.background {
  background-color: lightgray;
  height: 100vh;
}

body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 20%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

h2 {
  font-size: 30px;
}

.container {
  padding: 0 16px;
}

.container::after,
.row::after {
  content: "";
  clear: both;
  display: table;
}

.role {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

</style>