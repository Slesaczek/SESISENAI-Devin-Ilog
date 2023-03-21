import { useState, useEffect } from 'react';

import { apiService } from '../../services/api';

const useCourseList = () => {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchData = async (filter) => {
    setIsLoading(true);
    const paramFilter = filter ? `?name_like=${filter}` : '';
    const response = await apiService.get(`/courses${paramFilter}`);
    setError(response.error);
    setData(response.data);
    setIsLoading(false);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return {
    courses: data,
    isLoading,
    error,
    fetchData,
  };
};

export default useCourseList;
