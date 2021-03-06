import React, {
    useState,
    useContext,
    useEffect,
    createContext
} from "react";

import api from '../api/index'

export const SampleContext = createContext({})

const SampleProvider = ({ children }) => {
    const [sampleList, setSampleList] = useState([]);

    async function findAll() {
        try {
            let { data: { items } } = await api.get(`/samples`)

            items = items.map(sample => {
                return { ...sample, editing: false };
            });
            
            setSampleList(items)
        } catch (error) {
            console.error('error on findAll' + error)
        }
    }

    async function removeSample(sampleId) {
        try {
            await api.delete(`/samples/${sampleId}`)

            const newSamples = sampleList.filter(sample => sample.id !== sampleId);

            setSampleList(newSamples)
        } catch (error) {
            console.error('error on removeSample' + error)
        }
    }

    async function createSample(name) {
        try {
            await api.post(`/samples`, { name })

            findAll()
        } catch (error) {
            console.error('error on createSample' + error)
        }
    }

    async function updateSample(sample, name) {
        try {
            await api.put(`/samples/${sample.id}`, {name})

            findAll()
        } catch (error) {
            console.error('error on saveSample' + error)
        }
    }

    function setEditingSample(id) {
        const allSamples = sampleList.map(sample => {
            if (sample.id === id)
                sample.editing = !sample.editing
            
            return sample
        })

        setSampleList(allSamples)
    }

    useEffect(() => {
        findAll()
    } ,[])


    return (
        <SampleContext.Provider
            value={{
                setEditingSample,
                sampleList,
                createSample,
                removeSample,
                updateSample
            }}
        >
            {children}
        </SampleContext.Provider>
    )
}

export default SampleProvider;

export const useSamples = () => useContext(SampleContext)