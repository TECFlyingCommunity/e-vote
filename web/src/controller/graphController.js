import { http } from '../model/http';

export default async function () {
    const response = await http.get("http://localhost:8080/api/voto");

    const data = response.data;

    var result = {};

    for (var i in data) {

        let nomeCandidato = data[i].candidato.eleitor.nome + ' - ' + data[i].candidato.numero;

        let quantVoto = data[i].quantVoto;

        result[nomeCandidato] = quantVoto

    }

    return result;
}
