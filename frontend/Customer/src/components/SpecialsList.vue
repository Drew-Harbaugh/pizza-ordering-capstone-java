<template>
  <div>
    <div id="specialBody" v-for="special in specials" v-bind:key="special.specialtyId">
      <div class="newSpecial">
        <h2 class="name">{{ special.name }}</h2>
        <h3 class="price">{{ special.price }}</h3>
        <p class="description">{{ special.description }}</p>
        <ul class="ingredients">
            <li>{{special.regularToppings.name}}</li>
            <li>{{special.premiumToppings.name}}</li>
        </ul>
      </div>
      <div class="divider"></div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["specials"],
};
</script>

<style scope>
.newSpecial{
  display: grid;
  grid-template-columns: 1fr 1fr; 
  grid-template-areas:
      "name price"
      "desc desc" ;
      padding-top: 15px;
      background-color: darkgray;
      border-radius: 25px;
      width: 95%;
      text-align: center;
      
}

.name{
  grid-area: "name";
}
.price{
  grid-area: "price";
  
}
.description{
  grid-area: "desc";
}

#specialBody{
  padding-left: 20px;
}

.divider{
  height: 10px;
  width: auto;
}

</style>