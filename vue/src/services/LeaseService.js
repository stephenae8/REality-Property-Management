import axios from "axios";

export default{
    getAllLeases() {
        return axios.get('/lease')
    },
    leaseById(id){
        return axios.get(`/lease/user/${id}`)
    },
    createLease(data){
        return axios.post('/lease/create', data)
    },

    leaseTotal(id){
        return axios.get(`/lease/getTotal/${id}`)
    },

    leaseVacancy(id){
        return axios.get(`/lease/vacancy/${id}`)
    },

    leaseNetProfit(id){
        return axios.get(`/lease/netprofit/${id}`)
    },

    leaseByRevenue(id){
        return axios.get(`/lease/revenue/${id}`)
    },
    updateLease(data){
        return axios.put('/lease/update', data)
    }
}