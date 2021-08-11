/**
 * File to create a new sample.
*/

import React, { useState } from 'react';
import ClayForm, { ClayInput } from '@clayui/form';

export default function Create({ createSample }) {
    const [sampleName, setSampleName] = useState('');

    async function createNewSample(sampleName, event) {
        event.preventDefault();

        setSampleName('');
        createSample({ name: sampleName });
    }

    return (
        <ClayForm.FormGroup>
            <form onSubmit={(e) => createNewSample(sampleName, e)}>
                <input type="text" placeholder="Name" value={sampleName} onChange={e => setSampleName(e.target.value)} id="input-sample-name" />
                <button disabled={!sampleName} className="btn-base-app" id="btn-add-sample">Add</button>
            </form>
        </ClayForm.FormGroup>
    )
}