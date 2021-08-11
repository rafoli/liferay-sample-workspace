
import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter as Router } from'react-router-dom'

// Imports the @clayui/css package CSS
// import "@clayui/css/lib/css/atlas.css";

import App from './App';

/**
 * This is the main entry point of the portlet.
 *
 * See https://tinyurl.com/js-ext-portlet-entry-point for the most recent 
 * information on the signature of this function.
 *
 * @param  {Object} params a hash with values of interest to the portlet
 * @return {void}
 */
export default function main({portletNamespace, contextPath, portletElementId, configuration}) {
    
    ReactDOM.render(
        <Router>
            <App 
                portletNamespace={portletNamespace} 
                contextPath={contextPath}
                portletElementId={portletElementId}
                
                configuration={configuration}
                
            />
        </Router>, 
        document.getElementById(portletElementId)
    );
    
}