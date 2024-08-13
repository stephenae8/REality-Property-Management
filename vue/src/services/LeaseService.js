import axios from "axios";

export default{
    leaseById(id){
        return axios.get(`lease/user/${id}`)
    },
    createLease(data){
        return axios.post('/lease/create', data)
    }
}