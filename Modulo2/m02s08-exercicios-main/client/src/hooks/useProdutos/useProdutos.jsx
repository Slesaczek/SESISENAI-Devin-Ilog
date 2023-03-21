import { useEffect, useState } from 'react';
import { apiService } from '../../service/api';

export const useProdutos = () => {
  const [produtos, setProdutos] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchData = async () => {
    setIsLoading(true);

    const { data, error } = await apiService.get('/produtos');

    if (data) {
      //   const entradas = data.filter((item) => item.secao === 'Entradas');
      //   const principais = data.filter((item) => item.secao === 'Principais');
      //   const sobremesas = data.filter((item) => item.secao === 'Sobremesas');
      //   setProdutos({ entradas, principais, sobremesas });

      const produtosFormatados = data.reduce(
        (acc, item) => {
          switch (item.secao) {
            case 'Entradas':
              return { ...acc, entradas: [...acc.entradas, item] };
            case 'Principais':
              return { ...acc, principais: [...acc.principais, item] };
            case 'Sobremesas':
              return { ...acc, sobremesas: [...acc.sobremesas, item] };
            default:
              return acc;
          }
        },
        { entradas: [], principais: [], sobremesas: [] },
      );

      setProdutos(produtosFormatados);
    }

    setError(error);
    setIsLoading(false);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return { produtos, isLoading, error };
};
