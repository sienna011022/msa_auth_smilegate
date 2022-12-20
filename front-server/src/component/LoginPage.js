
import "./LoginPage.css"
import { useNavigate } from 'react-router';
import {setRefreshToken} from "../storage/Cookie";
import {SET_TOKEN} from "../storage/Auth";
import {useDispatch} from "react-redux";
import {loginUser} from "../api/Users";

function Login() {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    // useForm 사용을 위한 선언
    const {register, setValue, formState: {errors}, handleSubmit} = useForm();

    // submit 이후 동작할 코드
    // 백으로 유저 정보 전달
    const onValid = async ({userid, password}) => {
        // input 태그 값 비워주는 코드
        setValue("password", "");

        // 백으로부터 받은 응답
        const response = await loginUser({userid, password});

        if (response.status) {
            // 쿠키에 Refresh Token, store에 Access Token 저장
            setRefreshToken(response.json.refresh_token);
            dispatch(SET_TOKEN(response.json.access_token));

            return navigate("/");
        } else {
            console.log(response.json);
        }
    };


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
