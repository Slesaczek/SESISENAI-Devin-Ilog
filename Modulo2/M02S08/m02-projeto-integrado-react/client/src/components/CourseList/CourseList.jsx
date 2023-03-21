import PropTypes from 'prop-types';
import CourseCard from '../CourseCard';
import './CourseList.css';

function CourseList({ list }) {
  return (
    <ul className='courseListContainer'>
      {list.map((course) => (
        <li key={course.id}>
          <CourseCard
            imageUrl={course.imageUrl}
            name={course.name}
            category={course.category}
            description={course.description}
            duration={course.duration}
          />
        </li>
      ))}
    </ul>
  );
}

CourseList.propTypes = {
  list: PropTypes.arrayOf(
    PropTypes.shape({
      name: PropTypes.string.isRequired,
      category: PropTypes.string.isRequired,
      description: PropTypes.string.isRequired,
      duration: PropTypes.number.isRequired,
      imageUrl: PropTypes.string,
    }),
  ),
};

CourseList.defaultProps = {
  list: [],
};

export default CourseList;
