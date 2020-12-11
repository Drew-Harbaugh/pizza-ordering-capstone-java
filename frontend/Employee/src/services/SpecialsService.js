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
	},

	deleteSpecial(id) {
		return http.delete(`/specials/${id}`);
	},

	updateSpecial(special) {
		return http.put(`/specials/${special.specialtyId}`, special);
	}

}