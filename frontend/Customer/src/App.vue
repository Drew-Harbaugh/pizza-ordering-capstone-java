<template>
  <div id="app">
    <div id="nav">
    </div>
    <router-view />
  </div>
</template>

<style>
@font-face {
  font-family: 'Pizzaria';
  src: url('Extras/PIZZARIA.ttf') format('truetype');
} 

body {
  font-family: Pizzaria;
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
