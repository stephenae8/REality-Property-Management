import axios from "axios";

export default {
    getRequestbyId(id){
        return axios.get(`/service-request/user/${id}`)
    },

    getRequestByOwnerId(id){
        return axios.get(`/service/owner-update/${id}`)
    }

    
}