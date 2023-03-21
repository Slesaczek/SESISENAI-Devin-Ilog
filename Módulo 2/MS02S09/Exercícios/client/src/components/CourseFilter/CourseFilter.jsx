import { useState } from 'react';
import PropTypes from 'prop-types';

import Button, { BUTTON_VARIANT } from '../Button';
import InputGroup from '../InputGroup';

import './CourseFilter.css';

function CourseFilter({ onFilter }) {
  const [filter, setFilter] = useState('');

  const handleChangeFilter = (event) => {
    setFilter(event.target.value);
  };

  const handleClickFilter = () => {
    onFilter(filter);
  };

  return (
    <div className='courseFilterContainer'>
      <InputGroup
        type='text'
        placeholder='Busque pelo nome do curso'
        labelText='Buscar'
        value={filter}
        onChange={handleChangeFilter}
      />

      <Button variant={BUTTON_VARIANT.PRIMARY_OUTLINED} onClick={handleClickFilter}>
        Buscar
      </Button>
    </div>
  );
}

CourseFilter.propTypes = {
  onFilter: PropTypes.func,
};

export default CourseFilter;
