import React, { useState } from 'react';
import { signUp } from '../services/SignUpServce';

function SignUp(props) {
  const [id, setId] = useState('');
  const [name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [pincode, setPincode] = useState('');
  const [message, setMessage] = useState('');

  const handleSignUp = async (e) => {
    e.preventDefault();
    try {
      const response = await signUp({ id, name, address, userName, password, pincode });
      setMessage(response); 
      setTimeout(()=>{
        window.location.href = window.location.origin + '/login';
      }, 5000)
      // Display the response message
    } catch (error) {
      setMessage('Error signing up'); // Display an error message
    }
  };

  return (
    <div className='container'>
      <div className='col-lg-12 col-md-12 col-sm-12 col-xs-12' style={{display: 'flex', 'marginTop': '10px'}}>
        <div className='col-lg-5 col-md-5 col-sm-5 col-xs-5' style={{margin: 'auto', border: '1px solid #ddd', 'borderRadius': '10px'}}>
        {message && <p>{message}. Please wait you will be redirected to login page.</p>} {/* Display the message */}
          <h2 className='mb10'>Sign Up</h2>
          <form onSubmit={handleSignUp}>

            <input
              type="text"
              placeholder="Name"
              value={name}
              className='form-control mb10'
              onChange={(e) => setName(e.target.value)}
            />
            <input
              type="text"
              placeholder="Address"
              value={address}
              className='form-control mb10' 
              onChange={(e) => setAddress(e.target.value)}
            />
            <input
              type="text"
              placeholder="Username"
              value={userName}
              className='form-control mb10' 
              onChange={(e) => setUserName(e.target.value)}
            />
            <input
              type="password"
              placeholder="Password"
              value={password}
              className='form-control mb10' 
              onChange={(e) => setPassword(e.target.value)}
            />
            <input
              type="text"
              placeholder="Pincode"
              value={pincode}
              className='form-control mb10' 
              onChange={(e) => setPincode(e.target.value)}
            />
            <button type="submit" className='mb10 btn btn-block btn-primary'>Sign Up</button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default SignUp;
