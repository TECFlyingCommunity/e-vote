<template>
  <div class="candidato ">
    <v-btn class ='mx-4 mb-4 green white--text' elevation="2" small>Adicionar Candidato +</v-btn>
    
    
    <v-container fluid class='mx-1 mt-3'  v-for="project in projects" :key='project.id'>
      
      
        <v-btn class ='mb-2 mr-2' elevation="0" small>
          <v-icon>mdi-account-edit-outline</v-icon>
          </v-btn>

           <v-btn class ='mb-2 mr-2 red white--text' elevation="0" small>
          <v-icon>mdi-account-multiple-remove</v-icon>
          </v-btn>
      
      
      <v-card flat class='pa-3'>
        <v-layout row wrap class='pa-3 project'>

           <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>ID</div>
            <div> {{project.id}}</div>
          </v-flex>

          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>NOME</div>
            <div> {{project.nome}}</div>
          </v-flex>

         

         
          
          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>CATEGORIA</div>
            <div> {{project.categoria}}</div>
          </v-flex>

          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>ELEITOR</div>
            <div> {{project.eleitor}}</div>
          </v-flex>


        
          
        </v-layout>
      </v-card>
    </v-container>

    
  </div>
          
       

  
</template>


<script>
export default {
  name: "DashboardCandidato",
  data() {
    return{
      projects:[
        {id:'1',numero:'17',categoria:'corno',nome:'janielson',partido:'pedro', eleitor:'hick'},
        {id:'2',numero:'14',categoria:'corno',nome:'janielson',partido:'pedro',eleitor:'hick'},
        {id:'3',numero:'20',categoria:'corno',nome:'janielson',partido:'pedro',eleitor:'hick'},
      ]

    }
  
  }
}
</script>


<style scoped>
.project{
  border-left: 4px solid orange;
}
.candidato{
  margin-top:10px;
}
</style>
