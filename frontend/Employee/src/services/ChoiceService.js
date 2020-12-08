// @ts-nocheck

import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {

    getAllChoices() {
        return http.get(`/choices`);
    },

    getChoicesByCategory(categoryID) {
        return http.get(`/choices/${categoryID}`);
    }

}