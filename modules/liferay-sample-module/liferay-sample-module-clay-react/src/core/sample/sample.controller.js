/**
 * File with sample business rules.
*/

import SampleService from '../../services/SampleService';

class SampleController {
    constructor() {}

    async getAllSamples() {
        try {
            let { data: { items } } = await SampleService.getAllSamples();

            items = items.map(sample => {
                return { ...sample, editing: false };
            });

            return items;
        } catch (error) {
            throw new Error(error);
        }
    }

    async removeSample(sampleId, sampleList) {
        try {
            await SampleService.removeSample(sampleId);

            const newSamples = sampleList.filter(sample => sample.id !== sampleId);

            return newSamples;
        } catch (error) {
            throw new Error(error);
        }
    }

    async createSample(name, sampleList) {
        const samples = [...sampleList];

        try {
            const response = await SampleService.createSample(name);

            const newSample = { ...response.data, editing: false };

            samples.push(newSample);

            return samples;
        } catch (error) {
            throw new Error(error);
        }
    }

    async saveSample(sample) {
        try {
            const data = await SampleService.editSample(sample);

            return data;
        } catch (error) {
            throw new Error(error);
        }
    }

    changeSampleProperty(newValue, index, property, sampleList) {
        const oldSample = sampleList[index];
        const updatedSample = { ...oldSample, [property]: newValue }
        const cloneSampleList = [...sampleList];
        cloneSampleList[index] = updatedSample;

        return cloneSampleList;
    }

    editSample(sampleId, sampleList) {
        const changeSample = sampleList.map(sample => {
            if (sample.id === sampleId) {
                return { ...sample, editing: !sample.editing }
            }

            return sample
        })

        return changeSample;
    }
}

export default new SampleController(); 