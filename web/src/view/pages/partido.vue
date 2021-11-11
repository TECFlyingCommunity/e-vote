<template>
  <div class="partido ">
    <v-btn class ='mx-4 mb-4 mt-2 green white--text' elevation="2" small>Adicionar Partido +</v-btn>
    
    
    <v-container fluid class='mx-1 mt-3'  v-for="data in datas" :key='data.id'>
      
      
        <v-btn class ='mb-2 mr-2' elevation="0" small>
          <v-icon>mdi-account-edit-outline</v-icon>
          </v-btn>

           <v-btn class ='mb-2 mr-2 red white--text' elevation="0" small>
          <v-icon>mdi-account-multiple-remove</v-icon>
          </v-btn>
      
      
      <v-card flat class='pa-3'>
        <v-layout row wrap class='pa-3 data'>

           <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>ID</div>
            <div> {{data.id}}</div>
          </v-flex>

          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>NOME</div>
            <div> {{data.nome}}</div>
          </v-flex>
          
          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>NUMERO</div>
            <div> {{data.numero}}</div>
          </v-flex>

          <v-flex xs6 sm4 md3>
            <div class='caption grey--text'>SIGLA</div>
            <div> {{data.sigla}}</div>
          </v-flex>


        
          
        </v-layout>
      </v-card>
    </v-container>

    
  </div>
          
       

  
</template>


<script>
export default {
  data() {
    return{
      datas:[
        {id:'1',nome:'17',numero:'corno',sigla:'janielson'},
        {id:'1',nome:'17',numero:'corno',sigla:'janielson'},
        {id:'1',nome:'17',numero:'corno',sigla:'janielson'},
        
      ]

    }
  
  }
}
</script>


<style scoped>
.data{
  border-left: 4px solid orange;
}
.candidato{
  margin-top:10px;
}
</style>
