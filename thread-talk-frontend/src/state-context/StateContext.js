import React, { createContext, useContext, useEffect } from 'react'
import { useState } from 'react';
import axios from 'axios';


export const StateContext = createContext();
export const useAuth = () => useContext(StateContext);


export default function StateProvider({ children }) {

    // const[posts, setPosts] = useState([])

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);




    async function loginMethod(username, password) {
        if(username === "pranjal" && password === "pass"){
            setAuthenticated(true);
            setUsername(username);
            return true;
        }
        else{
            setAuthenticated(false)
            setUsername(null)
            return false
        }

        // try {
        //     const response = await axios.post(`http://localhost:8080/authenticate`, {
        //         username,
        //         password
        //     });

        //     const role = response.data.role;
        //     console.log("Role: " + role);
        // }
        // catch (error) {
        //     console.log(error);
        //     // Handle authentication error
        //     setAuthenticated(false);
        //     setUsername(null);
        //     return false;
        // }
    }

    function logout() {
        setAuthenticated(false)
        setUsername(null)
    }

    return (
        <StateContext.Provider value={{ isAuthenticated, loginMethod, username, logout }} >
            {children}
        </StateContext.Provider>
    )



}
