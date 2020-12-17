<template>
  <div id="app">
    <div id="nav">
      <div id="links">
        &nbsp;
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>
    </div>
    <router-view />
  </div>
</template>

<style>
@font-face {
  font-family: 'Pizzaria';
  src: url('Extra/PIZZARIA.ttf') format('truetype');
} 

body {
  font-family: Pizzaria;
}

#links{
  padding-left: 20px;
  padding-top: 5px;
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