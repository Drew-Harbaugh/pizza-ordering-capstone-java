<template>
  <div id="app">
    <div id="nav">
      <div id="links">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    </div>
    </div>
    <router-view />
    <div id="appBody">

    </div>
  </div>
</template>

<style scoped>
#appBody {
  width: 100vw;
  height: 100vh;
  background-image: url("https://media.giphy.com/media/4ayiIWaq2VULC/source.gif");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;

}

#nav {
  background: #dc3545;
  text-decoration: none;
  color: white;
}

#name {
  background: #dc3545;
  color: white;
  text-align: left;
}

a:link {
  color: white;
}

a:visited {
  color: white;
}

#app {
  background-color: lightgray;
}

</style>
