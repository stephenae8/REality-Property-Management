import axios from "axios";

export default {
    createApplication(data) {
        return axios.post('/applications/create', data);
    },
    getApplication(data) {
        return axios.get('/applications', data);
    },
    
}