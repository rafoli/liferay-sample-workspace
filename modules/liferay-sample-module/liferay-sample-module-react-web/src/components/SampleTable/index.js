import React from "react";

import { useSamples } from "../../contexts/SampleProvider";

import Sample from '../Sample/index'

export default function SampleTable() {
  const { sampleList } = useSamples();

  if (sampleList.length === 0) {
    return (
      <div className="sheet-section">
        <div className="table-responsive">
          No samples available
        </div>
      </div>
    )
  }

  return (
    <div className="sheet-section">
      <div className="table-responsive">
        <table className="table table-autofit show-quick-actions-on-hover table-hover table-list">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
            </tr>
          </thead>
          <tbody>
            {sampleList.length > 0 && sampleList.map((sample) => (<Sample key={sample.id} sample={sample} />))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
