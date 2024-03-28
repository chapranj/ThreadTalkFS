import React from 'react'
import { Navigate, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import { useAuth } from '../state-context/StateContext';

export default function LoginComponent() {

  const navigate = useNavigate();
  const auth = useAuth();

  const [username, setUsername] = useState("pranjal")

  const [password, setPassword] = useState("pass")

  const [errorMessage, setErrorMessage] = useState(false);

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleSubmit() {
    if (auth.loginMethod(username, password)) {
      setErrorMessage(false)
      navigate('/threads')
    }
    else {
      setErrorMessage(true)
    }

  }

  return (
    <div className="container">
      <h1>Login</h1>
      {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}
      <form>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">User Name:</label>
          <input type="text" className="form-control" id="username" name="username" value={username} onChange={handleUsernameChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password:</label>
          <input type="password" className="form-control" id="password" name="password" value={password} onChange={handlePasswordChange} required />
        </div>
        <button type="button" onClick={handleSubmit}  className="btn btn-primary">Login</button>
      </form>
    </div>
  );
}
