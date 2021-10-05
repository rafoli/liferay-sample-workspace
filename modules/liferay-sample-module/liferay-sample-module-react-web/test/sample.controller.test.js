import regeneratorRuntime from 'regenerator-runtime';


import SampleController from '../src/core/sample/sample.controller';

const samples = {
    "items":[
       {
          "id":"1",
          "name":"teste"
       },
       {
          "id":"2",
          "name":"test"
       },
       {
          "id":"3",
          "name":"test 1"
       }
    ],
    "pageSize":3,
    "lastPage":1,
    "totalCount":3,
    "page":1
 }

test('get all samples', async () => {
    const { items } = samples;

    expect(items[0]).toHaveProperty('id');
    expect(items[0]).toHaveProperty('name');
});

test('should create a sample', async () => {
    const { items } = samples;

    const response = await SampleController.createSample('Sample test', items);
    expect(response[response.length-1]).toMatchObject({ name: 'Sample test' });
})

test('should edit a sample', async () => {
    const { items } = samples;

    const newSample = { ...items[0], name: 'Sample edited!' };
    const { data } = await SampleController.saveSample(newSample);
    expect(data).toMatchObject({ name: 'Sample edited!' });
});