import PropTypes from 'prop-types';

import { BUTTON_VARIANT } from './ButtonVariant';

import './Button.css';

function Button({ children, variant = BUTTON_VARIANT.PRIMARY, ...props }) {
  return (
    <button className={`button ${variant}`} {...props}>
      {children}
    </button>
  );
}

Button.propTypes = {
  children: PropTypes.node.isRequired,
  variant: PropTypes.oneOf([
    BUTTON_VARIANT.PRIMARY,
    BUTTON_VARIANT.PRIMARY_LINK,
    BUTTON_VARIANT.PRIMARY_OUTLINED,
    BUTTON_VARIANT.SECONDARY,
    BUTTON_VARIANT.SECONDARY_LINK,
    BUTTON_VARIANT.SECONDARY_OUTLINED,
  ]),
};

export default Button;
