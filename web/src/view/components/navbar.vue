<template>
<nav >
    <v-app-bar
    color='grey lighten-2'
    elevation='0'
    >

    <v-app-bar-nav-icon class= 'black--text ' @click='drawer=!drawer'></v-app-bar-nav-icon>
    <span class='black--text'>
        Dashboard
    </span>

    <v-spacer>
    </v-spacer>

    <v-btn class='grey lighten-2 grey lighten-2--text' elevation='0'>
        SAIR<v-icon class='black--text'>mdi-logout</v-icon>
    </v-btn>
      
    
    </v-app-bar>

    

    <v-navigation-drawer  v-model='drawer' app class='indigo'>
       <v-list
        dense
        nav
      >
        <v-list-item class='white--text' v-for="item in items" :key="item.title" link :to='item.route'>
          <v-list-item-icon >
            <v-icon class='white--text'>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

        
    </v-navigation-drawer>

    


</nav>

    

</template>

<script>

export default {
    
    data(){
        return{
            drawer:false ,
             items: [
                { title: 'Dashboard', icon: 'mdi-view-dashboard' ,route:'/'},
                { title: 'Gerenciar candidato', icon: 'mdi-account-tie' ,route:'candidato' },
                { title: 'Gerenciar eleitor', icon: 'mdi-account-edit-outline',route:'eleitor' },
                { title: 'Gerenciar partido', icon: 'mdi-alpha-p-box-outline' ,route:'partido'},
                { title: 'resultados', icon: 'mdi-chart-sankey',route:'resultado'},

                    ],
            
            
        }
    }
    
    
}
</script>