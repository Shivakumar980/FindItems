import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Login() {
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  useEffect(()=>{
if(message === 'Login successful'){
    window.location.href = window.location.origin + '/items';
  }  
}, [message])
//   const [loggedIn,setLoggedIn]=useState(false)
  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://127.0.0.1:8080/rs/authenticate', { loginId, password });
      console.log(response.data); // Log the response from the server
    //   if (response.data>0){
    //     setLoggedIn(true)
    //   }
      localStorage.setItem("userid",response.data)
      
      setMessage('Login successful'); // Display a success message
    } catch (error) {
      console.error('Error logging in:', error); // Log any errors
      setMessage('Error logging in'); // Display an error message
    }
  };
//   useEffect(()=>{
//     const id=localStorage.getItem("userid")
//     if(parseInt(id)>0){
//         setLoggedIn(true)
//     }
//   },[])

  return (
    <div className='container'>
        <div className='col-md-12 col-lg-12 col-sm-12 p0' style={{display: 'flex'}}>
            <div className='col-md-4 col-lg-4 col-sm-4 p0' style={{margin: 'auto' , border: '1px solid #ddd', "border-radius": '15px', padding: '10px' }}>
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          className='form-control mb10'
          placeholder="Login ID"
          value={loginId}
          onChange={(e) => setLoginId(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          className='form-control mb10'
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit" className='btn btn-block btn-primary mb10'>Login</button>
      </form>
      {message && <p>{message}</p>} {/* Display the message */}
      </div>
      </div>
    </div>
  );
}

export default Login;
