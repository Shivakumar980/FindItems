import React, { useEffect, useState } from 'react';
import { findAllPosts } from '../services/LostItemService';
import './ItemService.css'; 

function ItemList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    const fetchItems = async () => {
      try {
        const fetchedItems = await findAllPosts();
        setItems(fetchedItems);
      } catch (error) {
        console.error('Failed to fetch items:', error);
      }
    };

    fetchItems();
  }, []);

  return (
    <div className="item-list-container">
      <h2>Item List</h2>
      <div className="card-grid">
        {items.map(item => (
          <div className="card" key={item.id}>
            <img src={item.itemPic} alt={item.itemName} className="card-image" />
            <div className="card-details">
              <h3>{item.itemName}</h3>
              <p><strong>Area Found:</strong> {item.areaFound}</p>
              <p><strong>Pin Code:</strong> {item.pinCode}</p>
              <p><strong>Details:</strong> {item.details || '-'}</p>
              <p><strong>User ID:</strong> {item.userId}</p>
              <button className="contact-button" >Contact</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ItemList;
