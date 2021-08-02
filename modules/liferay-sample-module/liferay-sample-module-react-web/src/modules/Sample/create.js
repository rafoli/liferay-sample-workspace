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
<<<<<<< HEAD
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
=======
        <div className="dsd-app">
            <form onSubmit={(e) => createNewSample(sampleName, e)}>
                <input type="text" placeholder="Name" value={sampleName} onChange={e => setSampleName(e.target.value)} />
                <button disabled={!sampleName} className="dsd__btn-primary">Add</button>
                <button disabled={!sampleName} className="dsd btn-primary">Add</button>
                <button disabled={!sampleName} className="btn-primary">Add</button>
>>>>>>> 4dbbd57 (dev: theme with namespace)
            </form>
        </div>
    )
}