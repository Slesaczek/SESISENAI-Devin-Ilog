import svg404 from "../../assets/404.svg";
import "./NotFoundPage.css";

function NotFoundPage() {
  return (
    <div className="notFoundPageContainer">
      <img src={svg404} alt="404" />
      <h2>Página não encontrada</h2>
    </div>
  );
}

export default NotFoundPage;
