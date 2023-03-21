import { useUserInfoContext } from "../../UserInfoContext";
import "./Footer.css";

function Footer() {
  const [userInfo] = useUserInfoContext();

  return (
    <footer className="FooterContainer">
      <p>SiH | 2023 | {userInfo.name}</p>
    </footer>
  );
}

export default Footer;
