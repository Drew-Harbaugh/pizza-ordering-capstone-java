// @ts-nocheck

import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {

	getAllSpecials() {
		return http.get(`/specials`);
	},

	addNewSpecial(newSpecial) {
		return http.post(`/specials`, newSpecial);
	}

}