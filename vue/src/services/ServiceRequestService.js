import axios from "axios";

export default {
    getServiceRequest(data) {
        return axios.get('/service-request', data);
    },

    updateServiceRequest(data) {
        return axios.put('/service-request/update', data);
    },
    
}