import { http } from '../model/http';
import {URL_API} from './constantes';


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

export {getCandidatoAll,getEleitorAll,getPartidoAll };