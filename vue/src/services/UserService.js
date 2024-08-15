import axios from "axios";

export default {
    getUsers() {
        return axios.get('/users')
    },
    getUserByUserId(id) {
        return axios.get(`/users/${id}`)
    },
    getUserByUsername(username) {
        return axios.get(`/users/${username}`)
    }
}