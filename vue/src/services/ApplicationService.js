import axios from "axios";

export default{
    createApplication(){
        return axios.post('/application/create')
    },
    
}