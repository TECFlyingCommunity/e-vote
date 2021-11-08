import {http} from '../model/http';
import {URL_API} from './constantes';

export default async function(form){
    await http.post(URL_API+"api/eleitor",{
        "nome":form.nome,
        "email":form.email,
        "senha":form.senha,
        "cpf":form.cpf,
        "titulo":form.titulo,
        "cidadeID":form.cidadeID,
      });
}

