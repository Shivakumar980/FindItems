import axios from 'axios';

const API_URL = 'http://127.0.0.1:8080/rs'; // Replace with your server URL

export const signUp = async (user) => {
  try {
    const response = await axios.post(`${API_URL}/signup`, user);
    return response.data;
  } catch (error) {
    throw error;
  }
};
