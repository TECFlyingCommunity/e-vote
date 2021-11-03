import {http} from '../model/http';


export default async function(form){
    await http.post("http://localhost:8080/api/eleitor",{
        "nome":form.nome,
        "email":form.email,
        "senha":form.senha,
        "cpf":form.cpf,
        "titulo":form.titulo,
        "cidadeID":form.cidadeID,
      });
}

