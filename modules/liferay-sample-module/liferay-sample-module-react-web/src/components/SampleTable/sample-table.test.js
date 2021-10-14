import React from "react";
import '@testing-library/jest-dom';

import { render } from '@testing-library/react'

import SampleTable from "./index";

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


describe('SampleTable component', () =>{

    beforeEach(() => {
        useRoles.mockImplementation(() => [true]);
    })

    it("should render a table form component", () => {

        const { container } = customRender(
            <SampleTable/>, 
            {
                sampleList: [
                    {
                        id: 1,
                        name: 'Test',
                        editing: false
                    }
                ]
            }
        ) 
        expect(container.querySelector('tbody').childNodes).toHaveLength(1)
    }); 

    it("should render a message when no samples are available", () => {

        const { getByText } = customRender(
            <SampleTable/>, 
            {
                sampleList: []
            }
        ) 
        expect(getByText('No samples available')).toBeInTheDocument()
    }); 

})
