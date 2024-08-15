import axios from "axios";

export default {
    createApplication(data) {
        return axios.post('/applications/create', data);
    },
    getApplication(data) {
        return axios.get('/applications', data);
    },
    updateApplication(data) {
        return axios.put('/applications/update', data);
    },
    getApplicationById(id){
        return axios.get(`/applications/user/${id}`)
    },

    getAppNew(id){
        return axios.get(`/applications/newfeed/${id}`)
    }
    
}