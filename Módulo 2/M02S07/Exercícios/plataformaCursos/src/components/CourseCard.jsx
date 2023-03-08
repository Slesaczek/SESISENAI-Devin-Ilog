import PropTypes from "prop-types";
import "./CourseCard.css";

import clockImg from "../assets/clock.png";

function CourseCard({ imageUrl, name, category, description, duration }) {
  return (
    <div className="courseCardContainer">
      <div className="courseCardHeader">
        {imageUrl && <img src={imageUrl} alt={`Imagem curso ${name}`} />}
        <h3>{name}</h3>
      </div>
      <div className="courseCardDuration">
        <img src={clockImg} alt="Ícone de relógio" />
        <p>{duration}h</p>
      </div>
      <button className="courseCardActionButton">Ver detalhes</button>
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
