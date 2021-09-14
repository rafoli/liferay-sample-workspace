/**
 * File to configure API access.
*/
import axios from 'axios';

const api = axios.create({
    baseURL: '/o/sample-module',
    params: {
        "p_auth": window.Liferay.authToken
    },
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

export default api;