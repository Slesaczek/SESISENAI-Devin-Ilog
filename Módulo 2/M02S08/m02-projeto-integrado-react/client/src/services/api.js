import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8081',
});

const handleGet = async (endpoint) => {
  try {
    const response = await api.get(endpoint);

    return { data: response.data, error: null };
  } catch (error) {
    return { data: null, error: error.message };
  }
};

const handlePost = async (endpoint, data) => {
  try {
    const response = await api.post(endpoint, data);

    return { data: response.data, error: null };
  } catch (error) {
    return { data: null, error: error.message };
  }
};

const handlePut = async (endpoint, data) => {
  try {
    const response = await api.put(endpoint, data);

    return { data: response.data, error: null };
  } catch (error) {
    return { data: null, error: error.message };
  }
};

const handleDelete = async (endpoint) => {
  try {
    const response = await api.delete(endpoint);

    return { data: response.data, error: null };
  } catch (error) {
    return { data: null, error: error.message };
  }
};

export const apiService = {
  get: handleGet,
  post: handlePost,
  put: handlePut,
  delete: handleDelete,
};