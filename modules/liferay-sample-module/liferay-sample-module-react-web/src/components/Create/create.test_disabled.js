import React from "react";
import '@testing-library/jest-dom';

import { render, fireEvent, screen } from '@testing-library/react'

import Create from "./index";
import { SampleContext } from "../../contexts/SampleProvider";

describe('Unit Form test suite', () => {

    it("should render a create form component", () => {
        const { container } = render(
            <Create />
        );
    
        expect(container.querySelector('form')).toBeInTheDocument();
    });

    it('button should not be enabled when input is empty', () => {
        const { getByText } = render(
            <Create />
        )

        expect(getByText('Add')).toHaveAttribute('disabled')
    })

    it('button should not be enabled when input text invalid', () => {
        const { container, getByText } = render(
            <Create />
        )

        const input = container.querySelector('#input-sample-name');
        fireEvent.change(input,{target: {value: '  #@*-+ Test  '}})


        expect(getByText('Add')).toHaveAttribute('disabled')
    })

    it('form should reset when', () => {

        var createSample = jest.fn()

        const { container } = render(
            <SampleContext.Provider
                value={{
                    createSample
                }}
            >
                <Create />
            </SampleContext.Provider>
        )

        const input = container.querySelector('#input-sample-name');

        fireEvent.change(input,{target: {value: 'Just a Simple Test'}})
        
        fireEvent.submit(container.querySelector('form'))

        expect(createSample).toBeCalled()
        expect(input.value).toBe('')
    })
})
