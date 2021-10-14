import React from 'react';

import SampleProvider from './contexts/SampleProvider'

import Home from './pages/Home/index'

export default function App() {
 
  return (
    <SampleProvider>
      <Home />
    </SampleProvider>
  );
}
