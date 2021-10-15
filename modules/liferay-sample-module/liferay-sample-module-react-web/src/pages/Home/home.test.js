import React from "react";
import '@testing-library/jest-dom';

import { render } from '@testing-library/react'

import Home from "./index";


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


describe('Home component', () =>{

    it("should render a home component", () => {
        useRoles.mockImplementation(() => ({isSignedIn: true}));
        const { getByText, container } = customRender(
            <Home/>, 
            {
                sampleList: [
                    {
                        id: 1,
                        name: 'Test',
                        editing: false
                    }
                ],
                setEditingSample: jest.fn(),
                createSample: jest.fn(),
                removeSample: jest.fn(),
                updateSample: jest.fn(),
            }
        ) 
        expect(getByText('Samples List')).toBeInTheDocument()
        expect(container.querySelector('form')).toBeInTheDocument()
    }); 
 

    it("should not render Create component when user is not logged", () => {
        useRoles.mockImplementation(() => ({
            isSignedIn: false,
        }));

        const { container } = customRender(
            <Home/>, 
            {
                sampleList: [
                    {
                        id: 1,
                        name: 'Test',
                        editing: false
                    }
                ],
                setEditingSample: jest.fn(),
                createSample: jest.fn(),
                removeSample: jest.fn(),
                updateSample: jest.fn(),
            }
        ) 

        expect(container.querySelector('form')).not.toBeInTheDocument()
    }); 

})
