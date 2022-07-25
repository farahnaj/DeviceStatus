import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import SearchDeviceStatus from './App';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import About from "./routes/about"
import CreateDeviceStatus from './routes/create_device_status';
import Home from './routes/home';
// CSS styles for bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';

const rootElement = document.getElementById('root');

ReactDOM.render(
  <>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/search" element={<SearchDeviceStatus />} />
        <Route path="/about" element={<About />} />
        <Route path="/create" element={<CreateDeviceStatus />} />
      </Routes>
    </BrowserRouter>
  </>,
  rootElement)
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
