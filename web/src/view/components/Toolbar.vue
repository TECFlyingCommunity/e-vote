<template>
  <div>
    <nav>
      <v-app-bar color="white accent-4" elevation="1" height="70" light>
        <v-app-bar-nav-icon
          class="black--text"
          @click="drawer = !drawer"
          v-if="isAdm"
        ></v-app-bar-nav-icon>

        <v-toolbar-title>E-vote</v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn text href="/"> Inicio </v-btn>

        <v-btn text href="/graphs"> Estatistica </v-btn>

        <v-btn text href="/home#sobre"> Sobre </v-btn>

        <v-btn text href="/home#contato"> Contato </v-btn>

        <v-btn text @click="signOut()"> Sair </v-btn>
      </v-app-bar>

      <v-navigation-drawer v-model="drawer" app class="indigo" v-if="isAdm">
        <v-list dense nav>
          <v-list-item class="white--text" @click="pushDashboard">
            <v-list-item-icon>
              <v-icon class="white--text">mdi-view-dashboard</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Dashboard</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item class="white--text" @click="pushDashboardCandidato">
            <v-list-item-icon>
              <v-icon class="white--text">mdi-account-tie</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Gerenciar candidato</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item class="white--text" @click="pushDashboardEleitor">
            <v-list-item-icon>
              <v-icon class="white--text">mdi-account-edit-outline</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Gerenciar eleitor</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item class="white--text" @click="pushDashboardPartido">
            <v-list-item-icon>
              <v-icon class="white--text">mdi-alpha-p-box-outline</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Gerenciar partido</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          
          <v-list-item class="white--text" @click="drawer = !drawer">
            <v-list-item-icon>
              <v-icon class="white--text">mdi-logout</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Fechar Menu</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </nav>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "Toolbar",
  methods: {
    ...mapActions(["ActionSignOut"]),

    signOut: function () {
      this.ActionSignOut();
      this.$router.push({ name: "Login" });
    },

    pushDashboard() {
      this.$router.push({ name: "Dashboard" });
    },
    pushDashboardCandidato() {
      this.$router.push({ name: "DashboardCandidato" });
    },
    pushDashboardEleitor() {
      this.$router.push({ name: "DashboardEleitor" });
    },
    pushDashboardPartido() {
      this.$router.push({ name: "DashboardPartido" });
    },
  },
  computed: {
    ...mapState({
      isAdm(state) {
        if (typeof state.user.perfis == "object") {
          return state.user.perfis.includes("ADMIN");
        }
        return false;
      },
    }),
  },

  data() {
    return {
      drawer: false,
    };
  },
};
</script>