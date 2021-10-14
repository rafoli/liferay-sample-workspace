import React, { useState, useMemo } from 'react';
import { useSamples } from '../../contexts/SampleProvider';

export default function Create() {
    const { createSample } = useSamples()
    const [sampleName, setSampleName] = useState('');

    function handleCreateSample(e) {
        e.preventDefault()
        createSample(sampleName)
        setSampleName('')
    }

    const isFormInvalid = useMemo(() => {
        const regex = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
        return (sampleName.trim().length === 0 || regex.test(sampleName))
    } ,[sampleName])
    
    return (
        <div className="form-group">
            <form onSubmit={handleCreateSample}>
                <div className="input-group">
                    <div className="input-group-item-shrink">
                        <input 
                            type="text" 
                            placeholder="Name" 
                            value={sampleName} 
                            onChange={e => setSampleName(e.target.value)} 
                            className="form-control"
                            id="input-sample-name" 
                        />
                    </div>
                    <div className="input-group-item">
                        <button disabled={isFormInvalid} className="btn btn-primary">Add</button>
                    </div>
                </div>
            </form>
        </div>
    )
}