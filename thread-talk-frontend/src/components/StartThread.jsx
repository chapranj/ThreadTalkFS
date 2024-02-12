import { useState } from "react";
import axios from "axios";
import { Navigate, useNavigate } from "react-router-dom";
import { useAuth } from "../state-context/StateContext";

export default function StartThread() {

    const [threadContent, setThreadContent] = useState('');
    const auth = useAuth();
    const navigate = useNavigate();

    function handleThreadContentChange(e) {
        setThreadContent(e.target.value);
    }

    async function addThread() {
        try {
            const response = await axios.post(`http://localhost:8080/addThread`, {
                title: threadContent,
                username: auth.username
            })
        }
        catch {
            console.log("error!")
        }
        navigate('/threads')
    }

    return (
        <div className="container mt-4">
            <form>
                <div className="mb-3">
                    <textarea
                        className="form-control"
                        id="threadContent"
                        name="threadContent"
                        rows="4"
                        placeholder="Start a thread ..."
                        value={threadContent}
                        onChange={handleThreadContentChange}
                    ></textarea>
                </div>
                <button
                    type="button"
                    className="btn btn-primary"
                    onClick={addThread}
                >
                    Add Thread
                </button>
                <p className="mt-3">
                    Your fellow employees will be able to see the thread you
                    start.
                </p>
            </form>
        </div>
    );

}