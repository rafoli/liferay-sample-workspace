import React from "react";
import '@testing-library/jest-dom';

import { render, fireEvent } from '@testing-library/react'

import Sample from "./index";

import { SampleContext } from "../../contexts/SampleProvider";
import { useRoles } from "../../hooks/useRoles";

jest.mock("../../hooks/useRoles")
 
const customRender = (ui, values) => {
  return (
    render(
        <SampleContext.Provider
            value={values}
        >
            {ui}
        </SampleContext.Provider>
    )
  )
}


describe('Sample component', () =>{

    beforeEach(() => {
        useRoles.mockImplementation(() => [true, true, true]);
    })

    it("should render a sample form component", () => {

        var sample = {
            id: 1,
            name: 'Test Sample',
            editing: false
        }
        
        const { getByText } = render(
            <Sample sample={sample}/>
        ) 

        expect(getByText('Test Sample')).toBeInTheDocument()
    });  

    it("should show a input when is editing a sample", () => {

        var sample = {
            id: 1,
            name: 'Test Sample',
            editing: false
        }

        function setEditingSample(id) {
            sample.editing = !sample.editing
        }


        const { getByText } = render(
            <SampleContext.Provider
                value={{
                    setEditingSample
                }}
            >
                <Sample sample={{
                    id: 1,
                    name: 'Test Sample',
                    editing: false
                }}/>
            </SampleContext.Provider>
        ) 

        fireEvent.click(getByText('Edit'));
               
        expect(sample.editing).toBeTruthy()
    });  

    it("should update a sample", () => {

        let sample = {
            id: 1,
            name: 'Test Sample',
            editing: true
        }

        const setEditingSample = jest.fn(); 
        const updateSample = jest.fn()
        

        const { getByText, container } = render(
            <SampleContext.Provider
                value={{
                    setEditingSample,
                    updateSample
                }}
            >
                <Sample sample={sample}/>
            </SampleContext.Provider>
        ) 

        var input = container.querySelector('input')
        fireEvent.change(input, { target: {value: 'Updated a Sample'} })
        
        var btn = getByText('Save')
        fireEvent.click(btn)

        expect(setEditingSample).toBeCalled()
        expect(updateSample).toBeCalled()
    });  

    it("should remove a sample", () => {

        let sample = {
            id: 1,
            name: 'Test Sample',
            editing: true
        }

        const removeSample = jest.fn(); 

        const { getByText, container } = render(
            <SampleContext.Provider
                value={{
                    removeSample
                }}
            >
                <Sample sample={sample}/>
            </SampleContext.Provider>
        ) 

        var btn = getByText('Remove')
        fireEvent.click(btn)

        expect(removeSample).toBeCalled()
    });  
})
