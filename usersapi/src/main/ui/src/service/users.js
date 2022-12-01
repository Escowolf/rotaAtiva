import API from './api';

export default class UserService{

    getUserVaga(nome){
        return API.get(`/usuario/relatorioVaga/?nome=${nome}`);
    }

    getUsuario(){
        return API.get("/administradores/listarTodos");
    }

    putUsuario(id, usuario){
        return API.post(`/usuario`, usuario);
    }

    // relatorioVaga

}