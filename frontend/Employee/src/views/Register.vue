<template>
  <div id="register" class="text-center">
    <Header></Header>
    <form class="form-register" @submit.prevent="register">
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <b-button size="sm" variant="danger" type="submit"
        >Create Account</b-button
      >
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import Header from "@/components/Header.vue";

export default {
  name: "register",
  components: {
    Header,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
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
#register {
  height: 100vh;
}
.form-register {
  margin: 0 auto;
  max-width: 50%;
}
</style>
