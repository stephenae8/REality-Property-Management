import axios from "axios";



export default{
    getProperty(){
        return axios.get('/property')
    },
    
}