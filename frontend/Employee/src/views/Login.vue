
<template>
  <div id="login" class="text-center">
    <div>
      <b-navbar toggleable="lg" type="dark" variant="danger">
        <div class="navBarLogo">
          <b-img
            src="https://cdn.pixabay.com/photo/2016/06/01/12/59/pizza-1428931_1280.png"
            fluid
            alt="Fluid image"
          ></b-img>
        </div>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <b-collapse id="nav-collapse" is-nav>
          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template #button-content>
                <em>User</em>
              </template>

              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>

      <form class="form-signin" @submit.prevent="login">
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
        <b-button size="sm" variant="danger" type="submit">Sign in</b-button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
.navBarLogo {
  width: 10%;
}

.h3 {
  margin: 0 auto;
  margin-left: 350px;
  color: white;
  font-size: 45px;
}

.text-center {
  background-color: lightgray;
}

.form-signin {
  margin: 0 auto;
  max-width: 400px;
}

.ml-auto {
  font-size: 20px;
  
}
</style>
