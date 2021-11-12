import Vue from 'vue';
import Router from 'vue-router';
import beforeEach from './beforeEach';

Vue.use(Router);



const routes = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect:'/home'

        },
        {
            path: '/home',
            name:  'Home',
            component: ()=> import('@/view/pages/Home.vue'),
        },
        {
            path: '/login',
            name:  'Login',
            component: ()=> import('@/view/pages/Login.vue'),
        },
        {
            path: '/graphs',
            name:  'Graphs',
            component: ()=> import('@/view/pages/Graphs.vue'),
        },
        {
            path: '/consultar_canditado',
            name:  'ConsultarCanditado',
            component: ()=> import('@/view/pages/ConsultarCanditado.vue'),
        },
        {
            path: '/confimar_voto',
            name:  'ConfimarVoto',
            component: ()=> import('@/view/pages/ConfimarVoto.vue'),
        },
        {
            path: '/cadastro',
            name:  'Cadastro',
            component: ()=> import('@/view/pages/Cadastro.vue'),
        },
        {
            path: '/dashboard',
            name:  'Dashboard',
            component: ()=> import('@/view/pages/Dashboard.vue'),
        },
        {
            path: '/dashboard_candidato',
            name:  'DashboardCandidato',
            component: ()=> import('@/view/pages/DashboardCandidato.vue'),
        },
        {
            path: '/dashboard_eleitor',
            name:  'DashboardEleitor',
            component: ()=> import('@/view/pages/DashboardEleitor.vue'),
        },
        {
            path: '/dashboard_partido',
            name:  'DashboardPartido',
            component: ()=> import('@/view/pages/DashboardPartido.vue'),
        },
       
    ],
});

routes.beforeEach(beforeEach);

export default routes;