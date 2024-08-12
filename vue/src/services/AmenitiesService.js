import axios from "axios";

export default {
    getAmenities(id) {
        return axios.get(`/amenities/property/${id}`);
    },


    
}