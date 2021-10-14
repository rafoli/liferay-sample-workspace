import axios from 'axios';

const api = axios.create({
    baseURL: window.SampleWorkspace.baseUrl,
    params: {
        "p_auth": window.Liferay.authToken
    },
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

export default api