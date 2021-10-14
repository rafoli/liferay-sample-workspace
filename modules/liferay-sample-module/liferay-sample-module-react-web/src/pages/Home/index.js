import React from "react";

import Create from "../../components/Create/index";
import SampleTable from "../../components/SampleTable/index";

const Home = () => {
  return (
    <div className="container">
      <div className="sheet">
        <div className="sheet-header">
          <h1 className="sheet-title">Samples List</h1>
        </div>
        <Create />
        <SampleTable />
      </div>
    </div>
  );
};

export default Home;
