/**
 * File to create a new sample.
*/

import React, { useState } from 'react'

export default function Create({ createSample }) {
    const [sampleName, setSampleName] = useState('');

    async function createNewSample(sampleName, event) {
        event.preventDefault();

        setSampleName('');
        createSample({ name: sampleName });
    }

    return (
        <div className="dsd-app">
            <form onSubmit={(e) => createNewSample(sampleName, e)}>
                <input type="text" placeholder="Name" value={sampleName} onChange={e => setSampleName(e.target.value)} />
                <button disabled={!sampleName} className="dsd__btn-primary">Add</button>
                <button disabled={!sampleName} className="dsd btn-primary">Add</button>
                <button disabled={!sampleName} className="btn-primary">Add</button>
            </form>
        </div>
    )
}