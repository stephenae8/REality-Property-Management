import axios from "axios";

export default{
    getAllLeases() {
        return axios.get('/lease')
    },
    leaseById(id){
        return axios.get(`lease/user/${id}`)
    },
    createLease(data){
        return axios.post('/lease/create', data)
    }
}