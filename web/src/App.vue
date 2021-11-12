<template>
  <v-app >
   <toolbar/>
   <v-main >
     <v-container>
       <router-view/>
     </v-container>
   </v-main>
  </v-app>
</template>

<script>
import Toolbar from './view/components/Toolbar.vue';
import store from './controller/store';

try {
  store.dispatch('ActionCheckToken');
} catch (error) {
  console.log(error);
}


export default {
  name: 'App',

  components: {
    Toolbar,
  },

  data: () => ({
    //
  }),

  methods:{
  }
};
</script>
