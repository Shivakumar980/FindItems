import axios from 'axios';

const API_URL = 'http://127.0.0.1:8080/li'; // Adjust if your API is deployed elsewhere

export const postLostItem = async (itemDetails) => {
  try {
    console.log(itemDetails);
    const response = await axios.post(`${API_URL}/postlostitem`, itemDetails);
    return response.data;
  } catch (error) {
    console.error('Failed to post lost item:', error);
    throw error;
  }
};

export const findMyPost = async (userId) => {
  try {
    console.log(userId)
    const response = await axios.get(`${API_URL}/lostitem/${userId}`);
    return response.data;
  } catch (error) {
    console.error('Failed to find posts by user:', error);
    throw error;
  }
};

export const findAllPosts = async () => {
  try {
    const response = await axios.get(`${API_URL}/lostitem`);
    return response.data;
  } catch (error) {
    console.error('Failed to find all posts:', error);
    throw error;
  }
};
