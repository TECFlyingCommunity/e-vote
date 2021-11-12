import {http} from '../model/http';
import {URL_API} from './constantes';

export default async function(form){
    await http.post(URL_API+"api/partido",{
        "nome":form.nome,
        "numero":form.numero,
        "sigla":form.sigla,
      });
}
