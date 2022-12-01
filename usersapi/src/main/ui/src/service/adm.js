import API from './api';

export default class AdmService{

    login(user){
        return API.post(`/login`, user);
    }

    editar(user){
        return API.post("/administradores/editar", user)
    }

}