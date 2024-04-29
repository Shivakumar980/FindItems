import React, { useState } from 'react';
import { postLostItem } from '../services/LostItemService';

function PostItemForm() {
  const [itemDetails, setItemDetails] = useState({
    itemName: '',
    itemPic: '',
    areaFound: '',
    pinCode: '',
    details: '',
    userId: localStorage.getItem('userid') // You might want to set or get this differently based on your app's authentication
  });

  const handleChange = (e) => {
    setItemDetails({ ...itemDetails, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const message = await postLostItem(itemDetails);
      alert(message);
    } catch (error) {
      console.error('Failed to post item:', error);
      alert('Failed to post item');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Post Lost Item</h2>
      <form onSubmit={handleSubmit} className="card card-body">
        <div className="form-group">
          <label>Item Name:</label>
          <input
            type="text"
            name="itemName"
            value={itemDetails.itemName}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Upload Picture URL:</label>
          <input
            type="text"
            name="itemPic"
            value={itemDetails.itemPic}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Area Found:</label>
          <input
            type="text"
            name="areaFound"
            value={itemDetails.areaFound}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Pin Code:</label>
          <input
            type="text"
            name="pinCode"
            value={itemDetails.pinCode}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Details:</label>
          <textarea
            name="details"
            value={itemDetails.details}
            onChange={handleChange}
            className="form-control"
            rows="3"
          ></textarea>
        </div>
        <button type="submit" className="btn btn-primary">Post Lost Item</button>
      </form>
    </div>
  );
}

export default PostItemForm;
