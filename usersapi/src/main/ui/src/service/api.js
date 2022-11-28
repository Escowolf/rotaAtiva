import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:3001"
})

const token = window.localStorage.getItem('token')

if(token){
    API.defaults.headers.authorization = `Bearer ${token}`
}

export default API;