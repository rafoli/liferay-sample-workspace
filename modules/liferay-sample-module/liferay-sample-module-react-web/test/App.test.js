import React from 'react';
import { render, screen } from '@testing-library/react';
import App from '../src/App';

test('render app', () => {
  render(<App />);
  const linkElement = screen.getByText(/Sample List/i);
  expect(linkElement).toBeInTheDocument();
});

test('render app', () => {
    render(<App />);
    screen.debug();
  });