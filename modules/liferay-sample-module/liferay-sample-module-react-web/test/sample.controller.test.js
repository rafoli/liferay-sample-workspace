import regeneratorRuntime from 'regenerator-runtime';

import SampleController from '../src/core/sample/sample.controller';

test('get all samples', async () => {
    const response = await SampleController.getAllSamples();
    expect(response[0]).toHaveProperty('id');
    expect(response[0]).toHaveProperty('name');
});

test('should create a sample', async () => {
    const sampleList = await SampleController.getAllSamples();
    const response = await SampleController.createSample('Sample test', sampleList);
    expect(response[response.length-1]).toMatchObject({ name: 'Sample test' });
})

test('should edit a sample', async () => {
    const sampleList = await SampleController.getAllSamples();
    const newSample = { ...sampleList[0], name: 'Sample edited!' };
    const { data } = await SampleController.saveSample(newSample);
    expect(data).toMatchObject({ name: 'Sample edited!' });
});