import { Spinner } from 'phosphor-react';
import CourseFilter from '../../components/CourseFilter';
import CourseList from '../../components/CourseList';
import useCourseList from '../../hooks/useCourseList';

import './HomePage.css';

function HomePage(){
  const {courses, error, isLoading} = useCourseList();

  return (
    <div className="homePageContainer">
    <CourseFilter/> 
    {isLoading && <Spinner width={100}/>}
    {!!error && <p>{error}</p>}
    <CourseList list={courses}/>
    </div>
  );
}

export default HomePage;
