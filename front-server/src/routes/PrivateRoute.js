import {Navigate, Outlet, useLocation} from "react-router";
import {CheckToken} from "../auth/CheckToken";

export default function PrivateRoute() {
    const location = useLocation();
    const { isAuth } = CheckToken(location.key);

    if (isAuth === 'Failed') {
        return (
            <Navigate to="/login" />
        )
    } else if (isAuth==='Loading') {
        return <Navigate to = "/home" />
    }

    return <Outlet />
}
