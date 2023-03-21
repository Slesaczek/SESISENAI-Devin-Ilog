import { useState } from "react";
import { Link } from "react-router-dom";
import { useSetUserInfo } from "../../UserInfoContext";

import "./Home.css";

function HomePage() {
  const setUserInfo = useSetUserInfo();
  const [inputValue, setInputValue] = useState("");

  const handleInputChange = (event) => {
    const value = event.target.value;
    setInputValue(value);
  };

  const handleChangeName = () => {
    setUserInfo({ name: inputValue });
    setInputValue("");
  };

  return (
    <main className="HomePageContainer">
      <h2>Página inicial</h2>
      <ul>
        <li>
          <Link to="/details/88034001">CEP: 88034-001</Link>
        </li>
        <li>
          <Link to="/details/01001000">CEP: 01001-000</Link>
        </li>
      </ul>
      <input
        type="text"
        placeholder="Digite seu nome"
        value={inputValue}
        onChange={handleInputChange}
      />
      <button onClick={handleChangeName}>Trocar nome</button>
    </main>
  );
}

export default HomePage;
