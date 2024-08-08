import axios from "axios";

export default {
    createApplication(data) {
        return axios.post('/applications/create', data);
    },
    
}