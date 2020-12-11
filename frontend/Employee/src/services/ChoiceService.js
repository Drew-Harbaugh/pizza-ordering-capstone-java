// @ts-nocheck

import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
});

export default {

    getAllChoices() {
        return http.get(`/choices`);
    },

    addNewChoice(choice) {
        return http.post(`/choices`, choice);
    },

    deleteChoice(id) {
        return http.delete(`/choices/${id}`);
    },

    updateChoice(choice) {
        return http.put(`/choices/${choice.choiceId}`, choice);
    }

}