import axios from "axios";

export default{
    leaseById(id){
        return axios.get(`lease/${id}`)
    }
}