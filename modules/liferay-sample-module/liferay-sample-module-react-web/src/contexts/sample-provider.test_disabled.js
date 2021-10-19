import React from 'react';

import '@testing-library/jest-dom';

import { render, fireEvent, waitFor } from '@testing-library/react'

import { useRoles } from '../hooks/useRoles';

import SampleProvider from './SampleProvider';

import SampleTable from '../components/SampleTable'
import Create from '../components/Create'

import api from '../api/index';

jest.mock('../api/index');
jest.mock('../hooks/useRoles');

const customRender = (ui) => render(
  <SampleProvider>
    {ui}
  </SampleProvider>
);

const original = console.error

describe('SampleProvider Component', () => {

  beforeEach(() => {
    console.error = jest.fn()
  })
  
  afterEach(() => {
    console.error = original
  })

  beforeEach(() => {
    useRoles.mockImplementation(() => (
      {
        isAdmin: true,
        isUser: true,
        isSignedIn: true
      }
    ));
  })

  it('should render Sample List with custom Context provider', async () => {
    api.get.mockResolvedValue({data:{ items: [{
      name: 'Test',
      id: 1,
    }]}});
    const {findByText} = customRender(<SampleTable />);
    await findByText(/Test/);
    expect(api.get).toBeCalledTimes(1)
  });

  it('should call the removeSample function', async () => {
    api.delete.mockResolvedValue();

    const {findByText} = customRender(<SampleTable />);

    const button = await findByText(/Remove/);

    fireEvent.click(button);

    expect(api.delete).toBeCalledTimes(1);
  })


  it('should edit the sample', async () => {
    api.get.mockResolvedValue({data:{ items: [{
      name: 'Test',
      id: 1,
    }]}});

    const { findByText, getByText } = customRender(<SampleTable />);
    
    await findByText(/Test/);

    const button = getByText(/Edit/);
    fireEvent.click(button);

    const editButton = getByText(/Save/);
    fireEvent.click(editButton);

    expect(api.get).toBeCalled()
  })


  it('should make the API throw error when Listing', async () => {
    api.get.mockResolvedValue(()=>{
      throw new Error("Error when fetching from API")
    });
    
    jest.spyOn(global.console, 'error')

    customRender(<SampleTable />);
    
    await waitFor(() => expect(console.error).toBeCalledTimes(1));
  });

  it('should make the API throw error when removing sample', async () => {
    api.get.mockResolvedValue({data:{ items: [{
      name: 'Test',
      id: 1,
    }]}});

    jest.spyOn(global.console, 'error')

    api.delete.mockImplementation(() => {
      throw new Error("Error when deleting from API")
    })

    const {findByText} = customRender(<SampleTable />);

    const button = await findByText(/Remove/);

    fireEvent.click(button);

    await waitFor(() => expect(console.error).toBeCalled());

  })

  it('should throw an error when call the sample editing state', async () => {
    api.get.mockResolvedValue({data:{ items: [{
      name: 'Test',
      id: 1,
    }]}});

    api.put.mockImplementation(() => {
      throw new Error("Error when deleting from API")
    })

    const {findByText, getByText} = customRender(<SampleTable />);
    await findByText(/Test/);
    const button = getByText(/Edit/);

    fireEvent.click(button);

    const editButton = getByText(/Save/);

    fireEvent.click(editButton);

    await waitFor(() => expect(console.error).toBeCalled());
  })


  it('should create a sample in project', () => {
      const { container } = customRender(<Create />)

      const input = container.querySelector('#input-sample-name');

      fireEvent.change(input,{target: {value: 'Just a Simple Test'}})
      
      fireEvent.submit(container.querySelector('form'))

      expect(api.post).toBeCalled()
      expect(api.get).toBeCalled()
  })

  it('should throw a error when try to create a sample', async () => {
    const { container } = customRender(<Create />)
    api.post.mockImplementation(() => {
      throw new Error("Error when deleting from API")
    })
    const input = container.querySelector('#input-sample-name');

    fireEvent.change(input,{target: {value: 'Just a Simple Test'}})
    
    fireEvent.submit(container.querySelector('form'))

    jest.spyOn(global.console, 'error')
    
    await waitFor(() => expect(console.error).toBeCalledTimes(1));
})

});
