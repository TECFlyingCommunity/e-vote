<template>
  <v-app>
   <toolbar/>
   <v-main>
     <v-container  >
       <router-view/>
     </v-container>
   </v-main>
  </v-app>
</template>

<script>
import Toolbar from './components/Toolbar.vue';

export default {
  name: 'App',

  components: {
    Toolbar,
  },

  data: () => ({
    //
  }),
};
</script>
