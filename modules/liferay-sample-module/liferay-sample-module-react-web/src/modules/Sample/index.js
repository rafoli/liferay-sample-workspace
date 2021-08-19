/**
 * File to list all samples.
*/

import React, { useEffect, useState } from 'react';

import Create from './create'
import { useRoles } from '../../contexts/UserRolesProvider';
import SampleController from '../../core/sample/sample.controller'

export default function Samples() {
    const { isSignedIn, isAdmin } = useRoles()
    const [sampleList, setSampleList] = useState([]);

    useEffect(() => {
        getAllSamples();
    }, [isSignedIn]);

    async function getAllSamples() {
        try {
            const data = await SampleController.getAllSamples();

            setSampleList(data);
        } catch (error) {
            console.log(error);
        }
    }

    async function removeSample(sampleId) {
        try {
            const data = await SampleController.removeSample(sampleId, sampleList);

            setSampleList(data);
        } catch (error) {
            console.log(error);
        }
    }

    async function createSample({ name }) {
        try {
            const data = await SampleController.createSample(name, sampleList);

            setSampleList(data);
        } catch (error) {
            console.log(error);
        }
    }

    async function saveSample(sample, index) {
        try {
            await SampleController.saveSample(sample, index, sampleList);

            const changeSampleList = SampleController.changeSampleProperty(false, index, 'editing', sampleList);

            setSampleList(changeSampleList);
        } catch (error) {
            console.log(error)
        }
    }

    function changeSampleProperty(newValue, index, property) {
        const changeSampleList = SampleController.changeSampleProperty(newValue, index, property, sampleList);

        setSampleList(changeSampleList);
    }

    async function editSample(sampleId) {
        const changeSampleList = SampleController.editSample(sampleId, sampleList)

        setSampleList(changeSampleList)
    }

    return (
        <div className="container">
            <div className="sheet">
                <div className="sheet-header">
                    <h1 className="sheet-title">Samples List</h1>
                </div>

                <div className="sheet-section">
                    { isAdmin && <Create createSample={createSample} /> }

                    <div className="table-responsive">
                        <table className="table table-autofit show-quick-actions-on-hover table-hover table-list">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                </tr>
                            </thead>
<<<<<<< HEAD
                            <tbody id="react-portlet-table">
=======
                            <tbody>
>>>>>>> 6ceb7cd (dev: cypress isolation)
                                {sampleList.length > 0 && sampleList.map((sample, i) => (
                                    <tr key={sample.id}>
                                        <td>{sample.id}</td>
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
                                        { isAdmin &&
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
                                        }
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