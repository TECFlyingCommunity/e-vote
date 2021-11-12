<template>
  <div class="dashboard">
    <h1 class="ml-5">Contagem</h1>

    <v-container d-flex>
      <v-card class="mr-2" color="indigo" dark width="400px" height="250px">
        <v-card-title class="text-h5"> Candidatos</v-card-title>
        <v-card-subtitle class="white--text text-h3" align="center">
          {{ countCandidato }}
        </v-card-subtitle>
      </v-card>

      <v-card class="mr-2" color="indigo" dark width="400px" height="250px">
        <v-card-title class="text-h5"> Eleitores </v-card-title>

        <v-card-subtitle class="white--text text-h3" align="center">
          {{ countEleitor }}
        </v-card-subtitle>
      </v-card>

      <v-card class="mr-2" color="indigo" dark width="400px" height="250px">
        <v-card-title class="text-h5"> Votos </v-card-title>

        <v-card-subtitle class="white--text text-h3" align="center">
          {{ countVoto }}</v-card-subtitle
        >
      </v-card>
    </v-container>

    <v-container>
      <pie-chart :data="chartData"></pie-chart>
    </v-container>
  </div>
</template>

<script>
import {
  getCountCandidato,
  getCountEleitor,
  getCountVoto,
} from "./../../controller/dashboardController";
import data from "./../../controller/graphController";

export default {
  name: "DashboardHome",

  data() {
    return {
      countCandidato: "",
      countEleitor: "",
      countVoto: "",
    };
  },

  async created() {
    this.countCandidato = await getCountCandidato();
    this.countEleitor = await getCountEleitor();
    this.countVoto = await getCountVoto();
  },

  methods: {
    async init() {
      try {
        this.chartData = await data();
        console.log(this.chartData);
      } catch (error) {
        alert(
          error.data
            ? error.data.message
            : "Não foi possível recuperar os dados"
        );
      }
    },
  },
  beforeMount() {
    this.init();
  },
};
</script>

<style lang="stylus" scoped></style>
        
