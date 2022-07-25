import { render, screen } from '@testing-library/react';
import SearchDeviceStatus from './App';

test('Renders text input', () => {
  render(<SearchDeviceStatus />);

  const deviceId = screen.getByPlaceholderText('Device Id');

  expect(deviceId).toBeInTheDocument();
});

test('Renders table headers', () => {
  render(<SearchDeviceStatus />);

  const id = screen.getByText('Device Id');
  const health = screen.getByText('Health');
  const message = screen.getByText('message');

  expect(id).toBeInTheDocument();
  expect(health).toBeInTheDocument();
  expect(message).toBeInTheDocument();
});

test('Renders submit button', () => {
  render(<SearchDeviceStatus />);

  const button = screen.getByText('Search')

  expect(button).toBeInTheDocument();
});

