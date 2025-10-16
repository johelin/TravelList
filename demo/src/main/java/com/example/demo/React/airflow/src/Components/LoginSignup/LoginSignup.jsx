import React, { useState, useEffect } from "react";
import './LoginSignup.css';
import password_icon from '../Assets/password.png';
import user_icon from '../Assets/user.png';
import question_icon from '../Assets/question.png'; 

const LoginSignup = () => {
    const [action, setAction] = useState("Sign Up");
    const [questions, setQuestions] = useState([]);

    useEffect(() => {
        const fetchSecurityQuestions = async () => {
          try {
            const res = await fetch("http://localhost:8080/user/securityQuestion");
            const data = await res.json();
            setQuestions(data);
          } catch (err) {
            console.error(err);
          }
        };
      
        fetchSecurityQuestions();
      }, []);

    return (
        <div className='container'>
            <div className='header'>
                <div className='text'>Travel made Easier</div>
                <div className='subtext'>Plan your dream vacation</div>
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
                <select>
                        <option className="inputSecurityQuestion" value="">Select a question</option>
                        {questions.map((q, index) => (
                            <option key={index} value={q}>{q.replaceAll('_', ' ')}</option>
                        ))}
                    </select>
                <div className="input">
                    <img src={question_icon} alt="" width={24} height={24}/>
                    <input type="Answer" placeholder="Answer"/>
                </div>
            </div>

            <div className="forgot-password">
                Lost Password? <span>Click Here!</span>
            </div>

            <div className="submit-container">
                <div
                    className={action === "Login" ? "submit grey" : "submit"}
                    onClick={() => setAction("Sign Up")}
                >
                    Sign Up
                </div>
                <div
                    className={action === "Sign Up" ? "submit grey" : "submit"}
                    onClick={() => setAction("Login")}
                >
                    Log In
                </div>
            </div>
        </div>
    );
};

export default LoginSignup;
