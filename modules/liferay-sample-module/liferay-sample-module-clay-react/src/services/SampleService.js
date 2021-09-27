/**
 * File to access damples from server.
*/
import api from '../utils/api'
class SampleService {
    getAllSamples() {
        return api.get(`/samples`)
    }

    getSample(sampleId) {
        return api.get(`/samples/${sampleId}`)
    }

    removeSample(sampleId) {
        return api.delete(`/samples/${sampleId}`)
    }

    createSample(sampleName) {
        return api.post(`/samples`, { name: sampleName })
    }

    editSample(sample) {
        return api.put(`/samples/`, sample)
    }
}

export default new SampleService();