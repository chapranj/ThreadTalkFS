import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Threads() {

    const [threads, setThreads] = useState([]);


    useEffect(() => {
        axios.get(`http://localhost:8080/threads`)
            .then(
                (response) => {
                    setThreads(response.data)
                    console.log(threads)
                }
            )
            .catch(
                (error) => console.log("Error fetching!")
            )
    }, [threads]
    )


    return (
        <div className='container' >

            {threads.map(thread => (
                <div key={thread.threadId} className="card mb-3">
                    <div className="card-body">
                        <h3 className='card-title' >{thread.title}</h3>
                        <p className='card-text' >Started By: <span>{thread.username}</span></p>
                    </div>
                    <Link to={`/posts/${thread.id}`} className='btn btn-primary'>Start Talking</Link>
                </div>
            ))}

            <div>
                <Link to={'/startThread'} className="btn btn-success" >Start a New Thread</Link>
            </div>


        </div>
    )
}
