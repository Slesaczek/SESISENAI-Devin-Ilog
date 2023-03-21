import Button, { BUTTON_VARIANT } from '../Button';
import InputGroup from '../InputGroup';

import './CourseFilter.css';

function CourseFilter() {
  return (
    <div className='courseFilterContainer'>
      <InputGroup type='text' placeholder='Busque pelo nome do curso' labelText='Buscar' />

      <Button variant={BUTTON_VARIANT.PRIMARY_OUTLINED}>Buscar</Button>
    </div>
  );
}

export default CourseFilter;
