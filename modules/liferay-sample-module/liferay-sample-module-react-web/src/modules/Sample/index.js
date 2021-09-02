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
            let { data: { items } } = await SampleService.getAllSamples();

            items = items.map(sample => {
                return { ...sample, editing: false }
            })

            setSampleList(items);
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

                    <div className="table-responsive">
                        <table className="table table-autofit show-quick-actions-on-hover table-hover table-list">
                            <tbody>
                                {sampleList.length > 0 && sampleList.map((sample, i) => (
                                    <tr key={sample.id}>
                                        <td>
                                            {!sample.editing && `${sample.name}`}
                                            {sample.editing &&
                                                <input 
                                                    type="text" 
                                                    value={sample.name}
                                                    className="form-control"
                                                    onChange={e => changeSampleProperty(e.target.value, i, 'name')}
                                                    id={`input-sample-edit-${i}`} />
                                            }
                                        </td>
                                        <td>
                                            <div className="row justify-content-end c-mr-2">
                                                <div className="form-group">
                                                    <div className="input-group">
                                                        <div className="input-group-item input-group-item-shrink">
                                                            <button 
                                                                onClick={sample.editing ? () => saveSample(sample, i) : () => editSample(sample.id)}
                                                                id={`btn-sample-edit-${i}`}
                                                                className="btn btn-sm btn-primary">
                                                                    {sample.editing ? 'Save' : 'Edit'}
                                                            </button>
                                                        </div>
                                                        <div className="input-group-item input-group-item-prepend">
                                                            <button 
                                                                onClick={() => removeSample(sample.id)} 
                                                                id={`remove-${i}`}
                                                                className="btn btn-sm btn-danger">
                                                                    Remove
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    )
}