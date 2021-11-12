import { http } from '../model/http';
import {URL_API} from './constantes';
import store from './store';

 var candidato =  {}

 const votar= async function (idCadidato) {

    
    await http.post(URL_API+"api/voto",{
        "eleitorID": store.state.user.id,
        "candidatoID":idCadidato
    });

}


 const candidatoInfo = async function(numero){
    const response = await http.get(URL_API+"api/candidato/numero/"+numero);

    candidato =  response.data;

    console.log(candidato);

    return candidato;
}


export {candidatoInfo,votar,candidato}