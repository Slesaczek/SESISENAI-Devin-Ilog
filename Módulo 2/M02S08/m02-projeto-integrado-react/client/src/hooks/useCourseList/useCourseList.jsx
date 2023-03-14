import { useState, useEffect } from "react";

import { apiService } from '../../services/api';

const useCourseList = () => {
    const [data, setData] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setIsLoading(true);
            const response = await apiService.get('/courses');
            setError(response.error);
            setData(response.data);
            setIsLoading(false);
        };
        
        fetchData();
    }, [])
    return {
        courses: data,
        isLoading,
        error,
    };
};
export default useCourseList;


