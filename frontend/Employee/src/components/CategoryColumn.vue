<template>
  <div class="list">
    <h2 class="title">{{ title }}</h2>
    <div
      class="name"
      v-for="choice in sortedChoices"
      v-bind:key="choice.choiceId"
    >
      <ul>
        <li>
          <input type="checkbox" />

          {{ choice.name }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: ["sortedChoices"],
  data() {
    return {};
  },
  computed: {
    title() {
      if (this.sortedChoices.length === 0) {
        return "";
      }
      const oneChoice = this.sortedChoices[0];
      if (oneChoice.categoryId === 1) {
        return "Size";
      } else if (oneChoice.categoryId === 2) {
        return "Crust";
      } else if (oneChoice.categoryId === 3) {
        return "Sauce";
      } else if (oneChoice.categoryId === 4) {
        return "Regular Toppings";
      } else {
        return "Premium Toppings";
      }
    },
  },
  created() {},
};
</script>

<style>
/* @font-face {
  font-family: 'Pizzeria';
  src: url('@/components/PIZZARIA.ttf');
} */

/* .list {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "title name"
} */

/* The switch - the box around the slider */
/* .switch {
  position: relative;
  display: inline-block;
  width: 3.2rem;
  height: 1.15rem;
}

/* Hide default HTML checkbox */
/* .switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

/* The slider */
/* .slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: 0.4s;
  transition: 0.4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 0.85rem;
  width: 1rem;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: 0.4s;
  transition: 0.4s;
}

input:checked + .slider {
  background-color: #dc3545;
}

input:focus + .slider {
  box-shadow: 0 0 2px #dc3545;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
/* .slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
} */

li {
  list-style: none;
  font-family: Pizzeria;
  font-size: 1.2rem;
}

h2 {
  font-family: Pizzeria;
}

.title {
  grid-area: title;
}

.name {
  grid-area: name;
}
</style>