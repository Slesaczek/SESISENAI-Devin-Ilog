import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./Details.css";

function DetailsPage() {
  const params = useParams();
  const { cep } = params;

  const [cepInfos, setCepInfos] = useState();
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState();

  useEffect(() => {
    if (cep) {
      setLoading(true);
      axios
        .get(`https://viacep.com.br/ws/${cep}/json/`)
        .then((response) => {
          // atualiza estado de informações
          setCepInfos(response.data);
        })
        .catch((e) => {
          setError(e);
        })
        .finally(() => {
          setLoading(false);
        });
    }
  }, [cep]);

  return (
    <main className="DetailsPageContainer">
      <h2>Detalhes</h2>
      <p>Informações sobre o CEP {cep}</p>
      {!loading && cepInfos && (
        <>
          <p>Localidade: {cepInfos?.localidade ?? "-"}</p>
          <p>Logradouro: {cepInfos?.logradouro ?? "-"}</p>
        </>
      )}
      {loading && <p>Carregando...</p>}
      {error && <p>Erro ao carregar: {error.message}</p>}
    </main>
  );
}

export default DetailsPage;
