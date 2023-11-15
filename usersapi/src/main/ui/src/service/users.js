import API from './api';

export default class UserService{

    getUserVaga(nome){
        return API.get(`/zona/buscar/?nome=${nome}`);
    }

    getUsuario(){
        return API.get("/administradores/listarTodos");
    }

    putUsuario(id, usuario){
        return API.post(`/usuario`, usuario);
    }

    // relatorioVaga

}