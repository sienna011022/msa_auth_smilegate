import {useState} from "react";
import "./SignUpPage.css"
import axios from "axios";

export default function SignUpPage() {

    const [memberId, setMemberId] = useState("")
    const [password, setPassword] = useState("")
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [confirmPassword, setConfirmPassword] = useState("")

    const onNameHandler = (event) => {
        setName(event.currentTarget.value)
    }
    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }
    const onEmailHandler = (event) => {
        setEmail(event.currentTarget.value)
    }
    const onMemberIdHandler = (event) => {
        setMemberId(event.currentTarget.value)
    }

    const onConfirmPasswordHandler = (event) => {
        setConfirmPassword(event.currentTarget.value)
    }

    const validPassword = () => {
        return password === confirmPassword;
    }

    const signUp = () => {
        if (validPassword()) {
            axios.post("/user/signup", {
                email: email,
                name: name,
                password: password,
                memberId: memberId,
            }).then(r => {return r.json()})
        } else {
            alert("비밀번호와 비밀번호 확인은 일치해야합니다")
        }
    }

    return (
        <div className="signUpPage">
            <form>
                <div><input name="memberId" type="text" placeholder="아이디" value={memberId} onChange={onMemberIdHandler}
                            className="signUpPage__input"/></div>
                <div><input name="name" type="text" placeholder="이름" value={name} onChange={onNameHandler}
                            className="signUpPage__input"/></div>
                <div><input name="email" type="email" placeholder="이메일" value={email} onChange={onEmailHandler}
                            className="signUpPage__input"/></div>
                <div><input name="password" type="password" placeholder="비밀번호" value={password}
                            onChange={onPasswordHandler} className="signUpPage__input"/></div>
                <div><input name="confirmPassword" type="password" placeholder="비밀번호 확인" value={confirmPassword}
                            onChange={onConfirmPasswordHandler} className="signUpPage__input"/></div>
                <div>
                    <button type="submit" onClick={
                        () => {
                            signUp()
                        }}
                            className="signUpPage__button">JOIN US
                    </button>
                </div>
            </form>
        </div>
    );

}
