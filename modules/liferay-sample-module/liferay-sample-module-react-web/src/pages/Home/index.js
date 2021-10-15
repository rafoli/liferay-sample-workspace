import React from "react";

import Create from "../../components/Create/index";
import SampleTable from "../../components/SampleTable/index";
import { useRoles } from "../../hooks/useRoles";

const Home = () => {

  const { isSignedIn } = useRoles()
  
  return (
    <div className="container">
      <div className="sheet">
        <div className="sheet-header">
          <h1 className="sheet-title">Samples List</h1>
        </div>
        {isSignedIn && <Create />}
        <SampleTable />
      </div>
    </div>
  );
};

export default Home;
