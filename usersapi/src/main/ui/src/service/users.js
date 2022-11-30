import API from './api';

export default class UserService{

    getUser(){
        return API.get("/user");
    }

    getUsuario(){
        return API.get("/administradores/listarTodos");
    }

    putUsuario(id, usuario){
        return API.put(`/usuario/${id}`, usuario);
    }

}