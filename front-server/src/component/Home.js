import "./SignUpPage.css"
import smileGate from "../img/smileGate.png"
export default function Header(){
    return (
        <div className="signUpBanner__color">
            <h1>성공</h1>
            <img className ="smile__box" src= {smileGate} alt = "profile"/>
        </div>
    )
}
