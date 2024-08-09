import axios from "axios";



export default{
    getProperty(){
        return axios.get('/property')
    },

    getPropertyByid(id){
        return axios.get(`/property/${id}`)
    }
    
}