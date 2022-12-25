import {Navigate, useLocation} from "react-router";
import {CheckToken} from "../auth/CheckToken";

export default function PublicRoute({ children }) {
    const location = useLocation();
    const { isAuth } = CheckToken(location.key);

    if (isAuth === 'Success') {
        return (
            <Navigate to="/" />
        )
    } else if (isAuth==='Loading') {
        return <LoadingModal />
    }

    return children
}
