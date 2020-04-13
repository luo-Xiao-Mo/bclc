import axios from 'axios'


axios.defaults.withCredentials = true
var root = process.env.API


const http = options => {
    return new Promise ((resolve,reject) => {
        const defaultOptios = {}
        const newOptions = {
            ...defaultOptios,
            ...options
        };

        newOptions.header = {
            ...newOptions.header
        }

        axios({
            method: newOptions.method,
            url: newOptions.url,
            data: newOptions.data,
            headers: newOptions.headers,
            baseUrl: newOptions.baseUrl,
            responseType: newOptions.responseType
        }).then( res => {
            resolve(res)
        }).catch( (rrr) =>{

        })
    }) 
}