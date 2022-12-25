import {useState} from "react";
import "./LoginPage.css"
import axios from "axios";
import {useNavigate} from "react-router";
import {useDispatch} from "react-redux";
import {setRefreshToken} from "../storage/Cookie";
import {SET_TOKEN} from "../store/Auth";

export default function LoginPage() {
    const dispatch = useDispatch();
    const [memberId, setMemberId] = useState("")
    const [password, setPassword] = useState("")

    const onMemberIdHandler = (event) => {
        setMemberId(event.currentTarget.value)
    }
    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }


    function joinHandler() {
        try {
            let data = {memberId: memberId, password: password};
            axios.post("/user/login", JSON.stringify(data), {
                headers: {
                    "Content-Type": `application/json`,
                }
            })
                .then(response => {
                    if (response.status) {
                        setRefreshToken(response.data.refresh_token);
                        dispatch(SET_TOKEN(response.data.access_token));
                    } else {
                        console.log(response.data)
                    }
                })
                .catch(ex => {
                    console.log("login requset fail : " + ex);
                })
                .finally(() => {
                    console.log("login request end")
                });
        } catch (e) {
            console.log(e);
        }


    }


    return (
        <div className="LoginPage">
            <form>
                <div><input name="memberId" type="text" placeholder="아이디" value={memberId}
                            onChange={onMemberIdHandler}
                            className="loginPage__input"/></div>
                <div><input name="password" type="password" placeholder="비밀번호" value={password}
                            onChange={onPasswordHandler} className="loginPage__input"/></div>
                <div>
                    <button type="submit" onClick={joinHandler}>className="loginPage__button">LOGIN
                    </button>
                </div>
            </form>
        </div>
    )
}

