/**
 * File to access damples from server.
*/
import api from '../utils/api'
class SampleService {
    getAllSamples() {
        return api.get('/samples')
    }

    removeSample(sampleId) {
        return api.delete(`/samples/${sampleId}`)
    }

    createSample(sampleName) {
        return api.post('/samples', { name: sampleName })
    }

    editSample(sample) {
        return api.put(`/samples/${sample.id}`, sample)
    }
}

export default new SampleService()