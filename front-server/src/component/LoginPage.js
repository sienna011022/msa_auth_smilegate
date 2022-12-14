import {useState} from "react";
import "./SignUpPage.css"
import axios from "axios";

export default function LoginPage() {

    const [memberId, setMemberId] = useState("")
    const [password, setPassword] = useState("")

    const onMemberIdHandler = (event) => {
        setMemberId(event.currentTarget.value)
    }
    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }
    const login = () => {
            axios.post("/user/members/login", {
                password: password,
                memberId: memberId,
            }).then(r => console.log(r))
        }


    return (
        <div className="LoginPage">
            <form>
                <div><input name="memberId" type="text" placeholder="아이디" value={memberId} onChange={onMemberIdHandler}
                            className="signUpPage__input"/></div>
                <div><input name="password" type="password" placeholder="비밀번호" value={password}
                            onChange={onPasswordHandler} className="signUpPage__input"/></div>
                <div>
                    <button type="submit" onClick={
                        () => {
                            login()
                        }}
                            className="signUpPage__button">JOIN US
                    </button>
                </div>
            </form>
        </div>
    );



}
