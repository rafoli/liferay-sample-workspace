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
        <form onSubmit={(e) => createNewSample(sampleName, e)}>
            <input type="text" placeholder="Name" value={sampleName} onChange={e => setSampleName(e.target.value)} />
            <button disabled={!sampleName} className="btn-primary-theme">Add</button>
        </form>
    )
}