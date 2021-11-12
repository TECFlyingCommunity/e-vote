import { http } from '../model/http';
import {URL_API} from './constantes';


const getCountCandidato= async  function(){

    const response = await http.get(URL_API+"api/candidato/count");

    const data = response.data;

    console.log("getCountCandidato"+ data);

    return data;
};



const getCountEleitor= async  function(){

    const response = await http.get(URL_API+"api/eleitor/count");

    const data = response.data;

    console.log("getCountEleitor"+ data);

    return data;
};

const getCountVoto= async  function(){

    const response = await http.get(URL_API+"api/voto/count");

    const data = response.data;

    console.log("getCountVoto"+ data);

    return data;
};





const getCandidatoAll = async function(){
    const response = await http.get(URL_API+"api/candidato");

    const data = response.data;

    console.log("getCandidatoAll"+ data);

    return data;
};

const getEleitorAll = async function(){
    const response = await http.get(URL_API+"api/eleitor/all");

    const data = response.data;

    console.log("getEleitorAll"+ data);

    return data;
};


const getPartidoAll = async function(){
    const response = await http.get(URL_API+"api/partido");

    const data = response.data;

    console.log("getPartidoAll"+ data);

    return data;
};

export {getCandidatoAll,getEleitorAll,getPartidoAll,getCountCandidato,getCountEleitor,getCountVoto };