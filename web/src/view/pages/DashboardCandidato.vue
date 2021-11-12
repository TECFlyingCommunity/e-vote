<template>
  <div class="candidato">
    <v-btn class="mx-4 mb-4 green white--text" elevation="2" small @click="pushAddCandidato"
      >Adicionar Candidato +</v-btn
    >

    <v-container
      fluid
      class="mx-1 mt-3"
      v-for="project in projects"
      :key="project.id"
    >
      <v-btn class="mb-2 mr-2" elevation="0" small>
        <v-icon>mdi-account-edit-outline</v-icon>
      </v-btn>

      <v-btn class="mb-2 mr-2 red white--text" elevation="0" small>
        <v-icon>mdi-account-multiple-remove</v-icon>
      </v-btn>

      <v-card flat class="pa-3 grey lighten-3">
        <v-layout row wrap class="pa-3 project">
          <v-flex xs2 sm2 md2>
            <div class="caption grey--text">ID</div>
            <div>{{ project.id }}</div>
          </v-flex>

          <v-flex xs2 sm2 md2 >
            <div class="caption grey--text">NÚMERO</div>
            <div>{{ project.numero }}</div>
          </v-flex>

          <v-flex xs4 sm4 md4>
            <div class="caption grey--text">NOME</div>
            <div>{{ project.nome }}</div>
          </v-flex>

          <v-flex xs3 sm3 md3>
            <div class="caption grey--text">CATEGORIA</div>
            <div>{{ project.categoria }}</div>
          </v-flex>
        </v-layout>
      </v-card>
    </v-container>
  </div>
</template>


<script>
import { getCandidatoAll } from "./../../controller/dashboardController";

export default {
  name: "DashboardCandidato",
  data() {
    return {
      projects: [],

      candidatos: {},
    };
  },
   methods:{
    pushAddCandidato() {
      this.$router.push({ name: "addCandidato" });
    },
  },
  async created() {
    let cadidatos = await getCandidatoAll();

    cadidatos.forEach((element) => {
      const data = {
        id: element.id,
        numero: element.numero,
        categoria: element.categoria.nome,
        nome: element.eleitor.nome,
      };

      this.projects.push(data);
    });
  },
};
</script>


<style scoped>
.project {
  border-left: 4px solid orange;
}
.candidato {
  margin-top: 10px;
}
</style>
