/**
 * File to list all samples.
*/

import React, { useEffect, useState } from 'react';

import Create from './create'
import SampleService from '../../services/SampleService';

export default function Samples() {
    const [sampleList, setSampleList] = useState([]);

    useEffect(() => {
        getAllSamples();
    }, []);

    async function getAllSamples() {
        try {
            let { data } = await SampleService.getAllSamples();

            data = data.map(sample => {
                return { ...sample, editing: false }
            })

            setSampleList(data);
        } catch (error) {
            console.log(error);
        }
    }

    async function removeSample(sampleId) {
        try {
            await SampleService.removeSample(sampleId);

            const newSamples = sampleList.filter(sample => sample.id !== sampleId);
            setSampleList(newSamples);
        } catch (error) {
            console.log(error);
        }
    }

    async function createSample({ name }) {
        const samples = [...sampleList];

        try {
            const response = await SampleService.createSample(name);

            const newSample = { ...response.data, editing: false };

            samples.push(newSample)

            setSampleList([...samples]);
        } catch (error) {
            console.log(error);
        }
    }

    async function saveSample(sample, index) {
        try {
            await SampleService.editSample(sample)

            changeSampleProperty(false, index, 'editing')
        } catch (error) {
            console.log('erro')
        }
    }

    async function editSample(sampleId) {
        const changeSample = sampleList.map(sample => {
            if (sample.id === sampleId) {
                return { ...sample, editing: !sample.editing }
            }

            return sample
        })

        setSampleList(changeSample)
    }

    function changeSampleProperty(newValue, index, property) {
        const oldSample = sampleList[index];
        const updatedSample = { ...oldSample, [property]: newValue }
        const cloneSampleList = [...sampleList];
        cloneSampleList[index] = updatedSample;
        setSampleList(cloneSampleList);
    }

    return (
        <div className="container">
            <div className="sheet">
                <div className="sheet-header">
                    <h1 className="sheet-title">Samples List</h1>
                </div>

                <div className="sheet-section">
                    <Create createSample={createSample} />

                    <ul>
                        {sampleList.length > 0 && sampleList.map((sample, i) => (
                            <li key={sample.id}>
                                {!sample.editing && `${sample.name}`}
                                {sample.editing && 
                                <input 
                                    type="text" 
                                    value={sample.name} 
                                    onChange={e => changeSampleProperty(e.target.value, i, 'name')}
                                    id={`input-sample-edit-${i}`} />}
                                <button 
                                    onClick={sample.editing ? () => saveSample(sample, i) : () => editSample(sample.id)}
                                    id={`btn-sample-edit-${i}`}>
                                        {sample.editing ? 'Save' : 'Edit'}
                                </button>
                                <button onClick={() => removeSample(sample.id)} id={`remove-${i}`}>Remove</button>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    )
}