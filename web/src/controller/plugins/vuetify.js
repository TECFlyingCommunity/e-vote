import '@mdi/font/scss/materialdesignicons.scss';

import Vue from 'vue';
import Vuetify from 'vuetify'; 
import 'vuetify/dist/vuetify.min.js';

Vue.use(Vuetify);

export default new Vuetify({

    icons:{
        iconfont: 'mdi'
    },
});
