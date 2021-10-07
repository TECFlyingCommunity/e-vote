import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const routes = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/home'
        },
        {
            path: '/home',
            name:  'Home',
            component: ()=> import('@/views/Home.vue'),
        },
        {
            path: '/dashboard',
            name:  'Dashboard',
            component: ()=> import('@/views/Dashboard.vue'),
        },
        {
            path: '/votar',
            name:  'Votar',
            component: ()=> import('@/views/Votar.vue'),
        },
        {
            path: '/login',
            name:  'Login',
            component: ()=> import('@/views/Login.vue'),
        },
        {
            path: '/graphs',
            name:  'Graphs',
            component: ()=> import('@/views/Graphs.vue'),
        },
        {
            path: '/dashboard_eleitor',
            name:  'DashboardEleitor',
            component: ()=> import('@/views/DashboardEleitor.vue'),
        },
        {
            path: '/consultar_canditado',
            name:  'ConsultarCanditado',
            component: ()=> import('@/views/ConsultarCanditado.vue'),
        },
        {
            path: '/confimar_voto',
            name:  'ConfimarVoto',
            component: ()=> import('@/views/ConfimarVoto.vue'),
        },
        {
            path: '/cadastro',
            name:  'Cadastro',
            component: ()=> import('@/views/Cadastro.vue'),
        },
    ],
});

export default routes;