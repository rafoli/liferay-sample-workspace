import React from "react";
import "@testing-library/jest-dom";

import { render, fireEvent } from "@testing-library/react";

import Sample from "./index";

import { SampleContext } from "../../contexts/SampleProvider";
import { useRoles } from "../../hooks/useRoles";

jest.mock("../../hooks/useRoles");

describe("Sample component", () => {
  beforeEach(() => {
    useRoles.mockImplementation(() => ({
      isAdmin: true,
      isSignedIn: true,
      isUser: true,
    }));
  });

  it("should render a sample form component", () => {
    const sample = {
      id: 1,
      name: "Test Sample",
      editing: false,
    };

    const { getByText } = render(
      <table>
        <tbody>
          <Sample sample={sample} />
        </tbody>
      </table>
    );

    expect(getByText("Test Sample")).toBeInTheDocument();
  });

  it("should show a input when is editing a sample", () => {
    const sample = {
      id: 1,
      name: "Test Sample",
      editing: false,
    };

    function setEditingSample(id) {
      sample.editing = !sample.editing;
    }

    const { getByText } = render(
      <SampleContext.Provider
        value={{
          setEditingSample,
        }}
      >
        <table>
          <tbody>
            <Sample
              sample={{
                id: 1,
                name: "Test Sample",
                editing: false,
              }}
            />
          </tbody>
        </table>
      </SampleContext.Provider>
    );

    fireEvent.click(getByText("Edit"));

    expect(sample.editing).toBeTruthy();
  });

  it("should update a sample", () => {
    let sample = {
      id: 1,
      name: "Test Sample",
      editing: true,
    };

    const setEditingSample = jest.fn();
    const updateSample = jest.fn();

    const { getByText, container } = render(
      <SampleContext.Provider
        value={{
          setEditingSample,
          updateSample,
        }}
      >
        <table>
          <tbody>
            <Sample sample={sample} />
          </tbody>
        </table>
      </SampleContext.Provider>
    );

    const input = container.querySelector("input");
    fireEvent.change(input, { target: { value: "Updated a Sample" } });

    const btn = getByText("Save");
    fireEvent.click(btn);

    expect(setEditingSample).toBeCalled();
    expect(updateSample).toBeCalled();
  });

  it("should remove a sample", () => {
    let sample = {
      id: 1,
      name: "Test Sample",
      editing: true,
    };

    const removeSample = jest.fn();

    const { getByText } = render(
      <SampleContext.Provider
        value={{
          removeSample,
        }}
      >
        <table>
          <tbody>
            <Sample sample={sample} />
          </tbody>
        </table>
      </SampleContext.Provider>
    );

    const btn = getByText("Remove");
    fireEvent.click(btn);

    expect(removeSample).toBeCalled();
  });

  it("non logged users and non admin should not see edit and remove buttons on Sample", () => {
    useRoles.mockImplementation(() => ({
      isAdmin: false,
      isSignedIn: false,
      isUser: false,
    }));

    let sample = {
      id: 1,
      name: "Test Sample",
      editing: false,
    };

    const { container } = render(
      <table>
        <tbody>
          <Sample sample={sample} />
        </tbody>
      </table>
    );

    expect(container.querySelector("button")).toBeNull();
  });
});
