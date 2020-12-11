<template>
  <div id="app">
    <div id="nav">
      <div id="links">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link
        >&nbsp;|&nbsp;
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

<style scoped>
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