import { useState, useEffect } from 'react';
import ClayLayout from '@clayui/layout';
import ClayTable from '@clayui/table';
import ClayButton from '@clayui/button';
import { ClayInput } from '@clayui/form'

import Create from './create';
import SampleService from '../../services/SampleService';
import SampleController from '../../core/sample/sample.controller';

function Samples() {
    const [sampleList, setSampleList] = useState([]);

    useEffect(() => {
        getAllSamples();
    }, []);

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
            const newSamples = await SampleController.removeSample(sampleId, sampleList);

            setSampleList(newSamples);
        } catch (error) {
            console.log(error);
        }
    }

    async function createSample({ name }) {
        try {
            const samplesList = await SampleController.createSample(name, sampleList);

            setSampleList(samplesList);
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
                return { ...sample, editing: !sample.editing };
            }

            return sample;
        })

        setSampleList(changeSample);
    }

    function changeSampleProperty(newValue, index, property) {
        const oldSample = sampleList[index];
        const updatedSample = { ...oldSample, [property]: newValue }
        const cloneSampleList = [...sampleList];
        cloneSampleList[index] = updatedSample;
        setSampleList(cloneSampleList);
    }

    return (
        <ClayLayout.ContainerFluid view>
            <h1>Samples List</h1>
            <Create createSample={createSample} />

            <ClayLayout.ContentSection className="mt-2">
                <ClayTable>
                    <ClayTable.Head>
                        <ClayTable.Row>
                            <ClayTable.Cell expanded headingCell>
                                ID
                            </ClayTable.Cell>
                            <ClayTable.Cell expanded headingCell>
                                Name
                            </ClayTable.Cell>
                            <ClayTable.Cell expanded headingCell>
                            </ClayTable.Cell>
                        </ClayTable.Row>
                    </ClayTable.Head>
                    <ClayTable.Body>
                        {sampleList.length > 0 && sampleList.map((sample, i) => (
                            <ClayTable.Row key={sample.id}>
                                <ClayTable.Cell headingTitle>{sample.id}</ClayTable.Cell>
                                <ClayTable.Cell>
                                    {!sample.editing && `${sample.name}`}
                                    {sample.editing &&
                                        <ClayInput
                                            type="text" 
                                            value={sample.name}
                                            className="form-control"
                                            onChange={e => changeSampleProperty(e.target.value, i, 'name')}
                                            id={`input-sample-edit-${i}`}
                                        />
                                    }
                                </ClayTable.Cell>
                                <ClayTable.Cell>
                                    <ClayButton.Group className="ml-5">
                                        <ClayButton 
                                            displayType="primary"
                                            onClick={sample.editing ? () => saveSample(sample, i) : () => editSample(sample.id)}
                                            id={`btn-sample-edit-${i}`}
                                            className="btn btn-sm btn-primary">
                                                {sample.editing ? 'Save' : 'Edit'}
                                        </ClayButton>
                                        <ClayButton 
                                            displayType="danger" 
                                            id={`remove-${i}`}
                                            onClick={() => removeSample(sample.id)}>
                                                Remove
                                            </ClayButton>
                                    </ClayButton.Group>
                                </ClayTable.Cell>
                            </ClayTable.Row>
                        ))}
                    </ClayTable.Body>
                </ClayTable>
            </ClayLayout.ContentSection>
        </ClayLayout.ContainerFluid>
    )
}

export default Samples;