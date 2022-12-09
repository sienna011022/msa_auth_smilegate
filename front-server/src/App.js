
import React from 'react'
import SignUpPage from "./component/SignUpPage"
import { BrowserRouter, Route , Routes } from 'react-router-dom';
import Header from "./component/Header";

function App() {
    return (
        <div className='App'>
            <Header/>
            <BrowserRouter>
                <Routes>
                    <Route path="/signUp" element={<SignUpPage />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
