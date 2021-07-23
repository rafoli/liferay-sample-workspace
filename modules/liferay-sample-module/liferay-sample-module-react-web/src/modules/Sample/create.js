/**
 * File to create a new sample.
*/

import React, { useState } from 'react';

export default function Create({ createSample }) {
    const [sampleName, setSampleName] = useState('');

    async function createNewSample(sampleName, event) {
        event.preventDefault();

        setSampleName('');
        createSample({ name: sampleName });
    }

    return (
        <div className="form-group">
            <form onSubmit={(e) => createNewSample(sampleName, e)}>
                <div className="input-group">
                    <div className="input-group-item-shrink">
                        <input 
                            type="text" 
                            placeholder="Name" 
                            value={sampleName} 
                            onChange={e => setSampleName(e.target.value)} 
                            className="form-control"
                            id="input-sample-name" />
                    </div>
                    <div className="input-group-item">
                        <button disabled={!sampleName} className="btn btn-primary" id="btn-add-sample">Add</button>
                    </div>
                </div>
            </form>
        </div>
    )
}