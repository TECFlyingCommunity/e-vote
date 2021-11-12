<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="4">
        <v-card>
          <!-- <v-card-text class="text-center pa-7">
            <v-file-input
              show-size
              label="Imagem do candidato" >
              </v-file-input>
            <p>Nome: {{ dtext }}</p>
            <p>Numero: {{ ntext }}</p>
            <h6 class="subtitle-2 font-weight-light">Verifique os dados antes de enviar</h6>
          </v-card-text> -->
        </v-card>
      </v-col>
      <v-col cols="12" lg="8">
        <v-card>
          <v-card-text>
            <h3
              class="title blue-grey--text text--darken-2 font-weight-regular"
            >
              Cadastro de Candidato
            </h3>
            <h6 class="subtitle-2 font-weight-light">
              Adicione os atributos de acordo co o campo
            </h6>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>
            <v-text-field
              type="number"
              v-model="form.partidoID"
              label="Id do Eleitor"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
              type="number"
              v-model="form.categoriaID"
              label="Id da Categoria"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
              type="number"
              v-model="form.eleitorID"
              label="Id da partido"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
              type="number"
              v-model="form.numero"
              label="Numero Oficial do candidato"
              filled
              background-color="transparent"
            ></v-text-field>

            <v-btn class="text-capitalize mt-5 element-0" color="success"
              >Cadastrar</v-btn
            >
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import cadastrar from "./../../controller/candidatoController";
export default {
  name: "Candidatos",

  data: () => ({
    form: {
      numero: 0,
      categoriaID: 0,
      eleitorID: 0,
      partidoID: 0,
    },
    show1: false,
    rules: {
      required: (value) => !!value || "Obrigatorio.",
      min: (v) => v.length >= 8 || "Min 8 caracteres",
      emailMatch: () => "Email ou senha incorretos",
    },
    items: ["NV", "NA", "NR", "NL"],
  }),
  components: {},
  methods: {
    async submit() {
      try {
        await cadastrar(this.form);
        this.$router.push({ name: "DashboardPartido" });
      } catch (error) {
        alert(
          error.data ? error.data.message : "Não foi possível fazer o cadastro"
        );
      }
    },
  },
};
</script>
