import axios from "axios";



export default{
    getProperty(){
        return axios.get('/property')
    },

    getPropertyByid(id){
        return axios.get(`/property/${id}`)
    },

    getPropertyByOwnerId(id){
        return axios.get(`/property/owner/${id}`)
    },

    createProperty(object){
        return axios.post('/property/create', object)
    }

    
    
}