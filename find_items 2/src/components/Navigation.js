import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'; // Import useHistory from react-router-dom


function Navigation() {
  const [loggedIn, setLoggedIn] = useState(false);
 

  useEffect(() => {
    const id = localStorage.getItem("userid");
    if (parseInt(id) > 0) {
      setLoggedIn(true);
    }
  }, []);

  const handleLogout = () => {
    // Clear user authentication state
    setLoggedIn(false);
    // Remove user ID from local storage
    localStorage.removeItem("userid");
    // Optionally, you can redirect the user to the login page
    // history.push("/login");
    setTimeout(()=>{
      window.location.href = window.location.origin + '/login';
    }, 500)
  };

  return (
    <nav className="navbar mb10">
      <ul className="nav-links">
        <li><Link to="/">Home</Link></li>
        {loggedIn && <li><Link to="/post">Post Item</Link></li>}
        {loggedIn && <li><Link to="/items">View Items</Link></li>}
        {loggedIn && <li><Link to="/mylostitems">My Lost Items</Link></li>}
        {/* Add more links for other routes */}
      </ul>
      <div>
        {loggedIn ? (
          <button type="button" className="btn btn-primary" onClick={handleLogout} style={{ marginRight: '10px' }}>Logout</button>
        ) : (
          <React.Fragment>
            <button type="button" className="btn btn-primary" style={{ marginRight: '10px' }}><Link to="/login" style={{ color: 'white' }}>Login</Link></button>
            <button type="button" className="btn btn-primary"><Link to="/signup" style={{ color: 'white' }}>Sign Up</Link></button>
          </React.Fragment>
        )}
      </div>
    </nav>
  );
}

export default Navigation;
