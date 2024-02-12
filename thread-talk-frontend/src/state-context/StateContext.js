import React, { createContext, useContext, useEffect } from 'react'
import { useState } from 'react';


export const StateContext = createContext();
export const useAuth = () => useContext(StateContext);


export default function StateProvider({children}){

    // const[posts, setPosts] = useState([])

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);

    function login(username, password){
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
    }

    function logout(){
        setAuthenticated(false)
        setUsername(null)
    }
    
    return (
        <StateContext.Provider value = {{isAuthenticated, login, username, logout }} >
            {children}
        </StateContext.Provider>
    )

}

