/**
 * File main App.
 */

import React from 'react';

import UserRolesProvider from './contexts/UserRolesProvider'

import Samples from './modules/Sample/index';

export default function App() {
 
  return (
    <UserRolesProvider>
      <Samples />
    </UserRolesProvider>
  );
}
