import React, { useState, useEffect } from 'react';
import { findMyPost } from '../services/LostItemService'; // Import the service function
import './ItemService.css'; 

function MyLostItemsList(props) {
  const userId = localStorage.getItem('userid')
  console.log('localstorage', userId)
  const [lostItems, setLostItems] = useState([]);

  useEffect(() => {
    async function fetchLostItems() {
      try {
        const items = await findMyPost(userId);
        setLostItems(items);
      } catch (error) {
        console.error('Error fetching lost items:', error);
      }
    }

    fetchLostItems();
  }, [userId]);

  return (
    <div className="item-list-container">
      <h2>Item List</h2>
      <div className="card-grid">
        {lostItems.map(item => (
          <div className="card" key={item.id}>
            <img src={item.itemPic} alt={item.itemName} className="card-image" />
            <div className="card-details">
              <h3>{item.itemName}</h3>
              <p><strong>Area Found:</strong> {item.areaFound}</p>
              <p><strong>Pin Code:</strong> {item.pinCode}</p>
              <p><strong>Details:</strong> {item.details || '-'}</p>
              <p><strong>User ID:</strong> {item.userId}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default MyLostItemsList;
