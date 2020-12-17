// @ts-nocheck

import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
});

export default {

    // getAllOrders() {
    //     return http.get(`/orders`);
    // },

    // updateOrderStatus(order) {
    //     return http.put(`/orders/${order.orderId}`, order);
    // }

}