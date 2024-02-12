import React from 'react'
import { BrowserRouter } from 'react-router-dom'
import Header from './Header'
import { Route, Routes } from 'react-router-dom'
import Threads from './Threads'
import Posts from './Posts'
import StartThread from './StartThread'
import StateProvider, { useAuth } from '../state-context/StateContext'
import { Navigate } from 'react-router-dom'
import LoginComponent from './LoginComponent'

function AuthenticatedRoute({ children }) {
    const auth = useAuth();
    if (auth.isAuthenticated) {
        return (
            children
        )
    }
    return <Navigate to='/' ></Navigate>
}


export default function ThreadTalk() {
    return (
        <div>
            <StateProvider>
                <BrowserRouter>
                    <Header></Header>
                    <Routes>
                        <Route path='/' element={

                            <LoginComponent></LoginComponent>

                        } ></Route>


                        <Route path='/threads' element={
                            <AuthenticatedRoute>
                                <Threads></Threads>
                            </AuthenticatedRoute>
                        }></Route>


                        <Route path='/posts/:threadId' element={
                            <AuthenticatedRoute>
                                <Posts></Posts>
                            </AuthenticatedRoute>
                        }></Route>

                        <Route path='/startThread' element={
                            <AuthenticatedRoute>
                                <StartThread></StartThread>
                            </AuthenticatedRoute>

                        }></Route>
                    </Routes>
                </BrowserRouter>
            </StateProvider>
        </div>
    )
}
