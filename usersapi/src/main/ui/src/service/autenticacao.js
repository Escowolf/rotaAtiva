import API from "./api"

export const login = (credenciais) => {
    API.post('/autenticacao/login', credenciais)
}