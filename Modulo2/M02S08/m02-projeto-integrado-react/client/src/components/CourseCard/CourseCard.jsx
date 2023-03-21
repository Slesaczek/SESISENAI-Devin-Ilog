import PropTypes from 'prop-types';

import clockImg from '../../assets/clock.png';
import Button, { BUTTON_VARIANT } from '../Button';

import './CourseCard.css';
function CourseCard({ imageUrl, name, category, description, duration }) {
  return (
    <div className='courseCardContainer'>
      <div className='courseCardHeader'>
        {imageUrl && <img width={50} src={imageUrl} alt={`Imagem curso ${name}`} />}
        <h3>{name}</h3>
      </div>

      <div className='courseCardDuration'>
        <img src={clockImg} alt='Ícone de relógio' />
        <p>{duration}h</p>
      </div>

      <Button variant={BUTTON_VARIANT.SECONDARY_OUTLINED} onClick={() => console.log('aa')}>
        Ver detalhes
      </Button>
    </div>
  );
}

CourseCard.propTypes = {
  name: PropTypes.string.isRequired,
  category: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  duration: PropTypes.number.isRequired,
  imageUrl: PropTypes.string,
};

export default CourseCard;
