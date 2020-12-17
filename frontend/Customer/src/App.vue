<template>
  <div id="app">
    <div id="nav">
    </div>
    <router-view />
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Rammetto+One&display=swap');

body {
  font-family: Rammetto One;
}

#nav {
  background: #dc3545;
  text-decoration: none;
  color: white;
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
