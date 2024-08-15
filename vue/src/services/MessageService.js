import axios from "axios";

export default{
    getMessageByUser(id){
        return axios.get(`/messages/user/${id}`)
    },
    createMessage(data) {
        return axios.post('/messages/create', data);
    },
    
}