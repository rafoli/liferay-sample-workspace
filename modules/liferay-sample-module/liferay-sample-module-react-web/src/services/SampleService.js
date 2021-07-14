/**
 * File to access damples from server.
*/
import api from '../utils/api'
class SampleService {
    getAllSamples() {
        return api.get('/o/sample-module/samples')
    }

    getSample(sampleId) {
        return api.get(`/o/sample-module/samples/${sampleId}`)
    }

    removeSample(sampleId) {
        return api.delete(`/o/sample-module/samples/${sampleId}`)
    }

    createSample(sampleName) {
        return api.post('/o/sample-module/samples', { name: sampleName })
    }

    editSample(sample) {
        return api.put(`/o/sample-module/samples/`, sample)
    }
}

export default new SampleService()