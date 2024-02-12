import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../state-context/StateContext';

export default function Header() {

  const auth = useAuth()

  function logout() {
    auth.logout()
  }


  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark py-3">
      <div className="container">
        <Link className="navbar-brand fs-4" to="/threads">Thread-Talk</Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <Link className="nav-link fs-5" to="/threads">Home</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link fs-5" to="/logout">Logout</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
