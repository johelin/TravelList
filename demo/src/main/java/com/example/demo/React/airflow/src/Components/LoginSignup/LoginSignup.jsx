import React, { useState } from "react";
import './LoginSignup.css';
import password_icon from '../Assets/password.png'
import user_icon from '../Assets/user.png'
import question_icon from '../Assets/question.png' 

const LoginSignup = () => {
    const [action,setAction] = useState("Sign Up");
    return (
        <div className = 'container'>

        <div className = 'header'>
        <div className = 'text'> Sign Up</div>
        <div className="underline"></div>
        </div>


        <div className="inputs">
        <div className="input">
            <img src={user_icon} alt="" width={24} height={24}/>
            <input type="text" placeholder="username"/>
        </div>
        <div className="input">
            <img src={password_icon} alt="" width={24} height={24}/>
            <input type="password" placeholder="password"/>
        </div>
        <div className="input">
            <img src={question_icon} alt="" width={24} height={24}/>
            <input type="question" placeholder="question"/>
        </div>
        
        </div>
        <div className="forgot-password">
            Lost Password? <span>Click Here!</span>
        </div>
        <div className="submit-container">
            <div className={action ==="Login"? "submit grey" :"submit"} onClick={() =>{setAction("Sign up")}}>Sign Up</div>
            <div className={action ==="Sign Up"? "submit grey" :"submit"}  onClick={() =>{setAction("Login")}}>Log In</div>
            
            </div></div>
    )
}

export default LoginSignup

