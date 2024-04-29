import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import ItemList from './components/ItemList';
import PostItemForm from './components/PostItemForm';
import MyLostItemsList from './components/MyLostItemsList'
import Navigation from './components/Navigation';
import Home from './components/Home';
import SignUp from './components/SignUp';
import Login from './components/Login';
import {createBrowserHistory} from 'history';

function App() {
  const history = createBrowserHistory()
  return (
    <Router history={history}>
       <Navigation/>
      <Routes>
          <Route exact path="/signup" element={<SignUp history={history}/>} />
          <Route exact path="/login" element={<Login/>} />
          <Route exact path="/" element={<Home/>}/>
          <Route exact path="/post" element={<PostItemForm/>} />
          <Route exact path="/items" element={<ItemList/>} />
          <Route exact path="/mylostitems" element={<MyLostItemsList/>} />
      </Routes>
    </Router>
  );
}

export default App;
