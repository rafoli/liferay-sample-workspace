import React, { useState } from "react";

import { useSamples } from "../../contexts/SampleProvider";
import { useRoles } from "../../hooks/useRoles";

const Samples = ({ sample }) => {
    const [name, setName] = useState(sample.name)
    const { isAdmin, isSignedIn } = useRoles()
    const { removeSample, setEditingSample, updateSample } = useSamples()

    function handleEditingSample(id) {
        if (sample.editing) {
            updateSample(sample, name)
        } 
        
        setEditingSample(id)
    }

    return (
        <tr>
            <td>{sample.id}</td>
            <td>
                {!sample.editing && `${sample.name}`}
                {sample.editing && (
                    <input 
                        type="text" 
                        value={name}
                        className="form-control"
                        onChange={e => setName(e.target.value)}
                    />
                )}
            </td>
            {
                isAdmin && isSignedIn && (
                    <td>
                        <div className="row justify-content-end c-mr-2">
                            <div className="form-group">
                                <div className="input-group">
                                    <div className="input-group-item input-group-item-shrink">
                                        <button
                                            onClick={() => handleEditingSample(sample.id)}
                                            className="btn btn-sm btn-primary"
                                        >
                                            {sample.editing ? "Save" : "Edit"}
                                        </button>
                                    </div>
                                    <div className="input-group-item input-group-item-prepend">
                                        <button
                                            onClick={() => removeSample(sample.id)}
                                            className="btn btn-sm btn-danger"
                                        >
                                            Remove
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                )
            }
        </tr>
    );
};

export default Samples;
