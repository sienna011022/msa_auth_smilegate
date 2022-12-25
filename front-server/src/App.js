import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Header from "./component/Header";
import LoginPage from "./component/LoginPage";
import SignUpPage from "./component/SignUpPage";
import PrivateRoute from "./routes/PrivateRoute";

function Home() {
    return null;
}

function App() {
    return (
        <div className='App'>
            <Header/>
            <BrowserRouter>
                <Routes>
                    <Route element={<PrivateRoute/>}>

                        <Route path="/home" element={<Home/>}/>
                    </Route>

                    <Route path="/signUp" element={<SignUpPage/>}/>
                    <Route path="/login" element={<LoginPage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
