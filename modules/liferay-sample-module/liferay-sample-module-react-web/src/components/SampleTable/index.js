import React from "react";

import { useSamples } from "../../contexts/SampleProvider";

import Sample from '../Sample/index'

export default function SampleTable() {
  const { sampleList } = useSamples();

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
            {sampleList.length > 0 && sampleList.map((sample, index) => (<Sample  key={sample.id} sample={sample} index={index} />))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
