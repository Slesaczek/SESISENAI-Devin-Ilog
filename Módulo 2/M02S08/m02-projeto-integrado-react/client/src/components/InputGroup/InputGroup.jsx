import PropTypes from 'prop-types';

import './InputGroup.css';

function InputGroup({ labelText, helperText, ...props }) {
  return (
    <div className='container'>
      {labelText && (
        <label htmlFor='input' className='label'>
          {labelText}
        </label>
      )}

      <input id='input' className='input' {...props} />

      {!!helperText && <span className='error'>{helperText}</span>}
    </div>
  );
}

InputGroup.propTypes = {
  labelText: PropTypes.string,
  helperText: PropTypes.string,
};

export default InputGroup;
