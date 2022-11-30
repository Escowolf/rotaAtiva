import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:8080"
})

const token = window.localStorage.getItem('token')

if(token){
    API.defaults.headers.authorization = `Bearer ${token}`
}

export default API;