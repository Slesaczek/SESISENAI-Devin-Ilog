import { useState } from 'react';
import { Card } from '../../components/Card';
import { useProdutos } from '../../hooks/useProdutos';
import './Produtos.css';

export const Produtos = () => {
  const { error, isLoading, produtos } = useProdutos();
  const [selecionados, setSelecionados] = useState([]);

  const isSelecionado = (id) => {
    return selecionados.some((item) => item === id);
  };

  const handleSelecionar = (id) => {
    if (isSelecionado(id)) {
      setSelecionados((prev) => prev.filter((item) => item !== id));
      return;
    }

    setSelecionados((prev) => [...prev, id]);
  };

  if (isLoading) {
    return <p>Carregando...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

  return (
    <>
      {!!produtos &&
        Object.keys(produtos).map((secao) => (
          <section key={secao} className='secao'>
            <h2 className='secao-titulo'>{secao}</h2>

            <hr />

            <div className='lista'>
              {produtos[secao].map((item) => (
                <Card
                  key={item.id}
                  id={item.id}
                  imagem={item.img}
                  nome={item.nome}
                  descricao={item.descricao}
                  valor={item.valor}
                  tempoPreparo={item.tempoPreparo}
                  selecionado={isSelecionado(item.id)}
                  onSelecionar={handleSelecionar}
                />
              ))}
            </div>
          </section>
        ))}
    </>
  );
};
