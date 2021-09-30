import { useState } from 'react';
import ClayLayout from '@clayui/layout';
import ClayForm, { ClayInput } from '@clayui/form';
import ClayButton from '@clayui/button';

function Create({ createSample }) {
    const [sampleName, setSampleName] = useState('');

    async function createNewSample(sampleName, event) {
        event.preventDefault();

        setSampleName('');
        createSample({ name: sampleName });
    }

    return (
        <ClayLayout.ContentSection>
            <ClayForm onSubmit={(e) => createNewSample(sampleName, e)}>
                <ClayInput.Group>
                    <ClayInput.GroupItem>
                        <ClayInput 
                            id="input-name-sample"
                            placeholder="Name"
                            type="text"
                            onChange={e => setSampleName(e.target.value)}
                            value={sampleName}
                        />
                    </ClayInput.GroupItem>
                    <ClayInput.GroupItem append shrink>
                        <ClayButton 
                            displayType="primary" 
                            type="submit"
                            disabled={!sampleName}>
                                Add
                        </ClayButton>
                    </ClayInput.GroupItem>
                </ClayInput.Group>
            </ClayForm>
        </ClayLayout.ContentSection>
    )
}

export default Create;