import axios from "axios";


const baseConfig = {
    baseUrl: 'http://localhost:8081',
}


export const axiosInstance = axios.create(baseConfig);