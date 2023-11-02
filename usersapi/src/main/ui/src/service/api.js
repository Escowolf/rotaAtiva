import axios from "axios";

const API = axios.create({
    baseURL: "https://rota-ativa-pads.escowolf.repl.co"
})

const token = window.localStorage.getItem('token')

if(token){
    API.defaults.headers.authorization = `Bearer ${token}`
}

export default API;