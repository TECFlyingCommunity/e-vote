import {http} from '../model/http';
import {URL_API} from './constantes';

export default async function(form){
    await http.post(URL_API+"api/candidato",{
        "numero":form.numero,
        "categoriaID":form.categoriaID,
        "eleitorID":form.eleitorID,
        "partidoID":form.partidoID,
      });
}
