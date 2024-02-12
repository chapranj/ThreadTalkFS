import React, { useEffect, useReducer, useState } from 'react'
import axios from 'axios'
import { useParams } from 'react-router-dom'
import { Link } from 'react-router-dom';
import { useAuth } from '../state-context/StateContext';

export default function Posts() {

    const { threadId } = useParams();
    const [posts, setPosts] = useState([])
    const [content, setContent] = useState('');
    const auth = useAuth();

    console.log("thread id: " + threadId)

    console.log("current user: " + auth.username);

    useEffect(
        () => {
            axios.get(`http://localhost:8080/view/${threadId}`)
                .then(
                    (response) => {
                        console.log(response.data)
                        setPosts(response.data)
                    }
                )
        }, [posts]

    )

    async function addPost() {
        try {
            const response = await axios.post(`http://localhost:8080/addPost?threadId=${threadId}`, {
                content: content,
                threadId: threadId,
                username: auth.username,
                date: Date.now()
            });
            setContent('')
            console.log(response.data)
        }
        catch {
            console.log("error")
        }
    }

    function handlePostContentChange(e) {
        setContent(e.target.value);
    }


    return (
        <div className='container' >
            <div className="welcome-section">
                <h2>Posts in Thread: {threadId}</h2>
            </div>

            <div className="discussion-section">
                {posts.map(post => (
                    <div key={post.postId} className="card mb-3">
                        <div className="card-body">
                            <p className='card-text' >{post.content}</p>
                            <span className='card-subtitle text-muted' >{post.username} • {post.date}</span>
                        </div>
                    </div>
                ))}
            </div>

            <form>
                <div className="mb-3">
                    <textarea className="form-control" id="postContent" name="content" rows="4" placeholder="Write your post..." value={content} onChange={handlePostContentChange}></textarea>
                </div>
                <button type="button" className="btn btn-primary" onClick={addPost}>Add Post</button>
            </form>

            <Link to="/threads" className="btn btn-secondary mt-3" >View All Threads</Link>

        </div>


    )
}
