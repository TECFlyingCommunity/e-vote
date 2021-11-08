import Vue from 'vue';
import Vuex from 'vuex';
import * as typesMutation from './mutation-types';
import * as typesActions from './actions-types';
import * as storage from './storage';
import { http } from './../../model/http';
import {URL_API} from './../constantes';


Vue.use(Vuex);

export default new Vuex.Store({

    state: {
        user: {},
        token: ''
    },
    mutations: {
        [typesMutation.SET_USER](state, payload) {
            state.user = payload
        },
        [typesMutation.SET_TOKEN](state, payload) {
            state.token = payload
        }
    },
    actions: {
        async [typesActions.ActionDoLogin]({ dispatch }, payload) {

            let requestToken = await http.post(URL_API+"login", {
                "email": payload.email,
                "senha": payload.senha
            });

            const token = requestToken.headers.map.authorization[0];

            dispatch(typesActions.ActionSetToken, token);

            let requestUser = await http.get(URL_API+'api/eleitor');

            console.log(requestUser.data);

            dispatch(typesActions.ActionSetUser, requestUser.data);

        },

        [typesActions.ActionCheckToken]({ dispatch, state }) {
            if (state.token) {
                return Promise.resolve(state.token);
            }

            const token = storage.getLocalToken();

            if (!token) {
                return Promise.reject(new Error('Token Inválido'))
            }

            dispatch(typesActions.ActionSetToken, token)
            return dispatch(typesActions.ActionLoadSession)
        },

        async [typesActions.ActionLoadSession]({ dispatch }) {
            let requestUser = await http.get(URL_API+'api/eleitor');
            return new Promise( (resolve, reject) => {
                try {
                    dispatch(typesActions.ActionSetUser, requestUser.data);
                    resolve();
                } catch (err) {
                    dispatch(typesActions.ActionSignOut);
                    reject(err);
                }
            });
        },

        [typesActions.ActionSetUser]({ commit }, payload) {
            commit(typesMutation.SET_USER, payload);
        },

        [typesActions.ActionSetToken]({ commit }, payload) {
            storage.setLocalToken(payload);
            storage.setHeaderToken(payload);
            commit(typesMutation.SET_TOKEN, payload);
        },

        [typesActions.ActionSignOut]({ dispatch }) {
            storage.setHeaderToken('')
            storage.deleteLocalToken()
            dispatch(typesActions.ActionSetUser, {})
            dispatch(typesActions.ActionSetToken, '')
        }

    },
    getters: {
        hasToken: (state) => !!state.token,
    }

});