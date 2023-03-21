import { Link, useLocation, useNavigate } from "react-router-dom";
import Button, { BUTTON_VARIANT } from "../Button";
import { useUserInfo, useSetUserInfo } from "../../hooks/useUserInfo";
import "./Navbar.css";

function Navbar() {
  const location = useLocation();
  const navigate = useNavigate();

  const setUserInfo = useSetUserInfo();
  const userInfo = useUserInfo();
  const isLoggedIn = userInfo?.name;

  const handleNavigateLogin = () => {
    navigate("/login");
  };

  const handleLogout = () => {
    setUserInfo();
    handleNavigateLogin();
  };

  return (
    <header className="navbarContainer">
      <Link to="/" className="navbarLogoBox">
        <img src="/logo.png" alt="Logo" />
        <h1>DEVinCursos</h1>
      </Link>
      {location.pathname !== "/login" && (
        <Button
          variant={BUTTON_VARIANT.PRIMARY_OUTLINED}
          onClick={isLoggedIn ? handleLogout : handleNavigateLogin}
        >
          {isLoggedIn ? "Sair" : "Entrar"}
        </Button>
      )}
    </header>
  );
}

export default Navbar;
