import './Card.css';

export const Card = ({
  id,
  nome,
  imagem,
  descricao,
  valor,
  tempoPreparo,
  selecionado,
  onSelecionar,
}) => {
  return (
    <div
      className={`card ${selecionado ? 'card-selecionado' : ''}`}
      onClick={() => onSelecionar(id)}
    >
      <img className='img' width={298} src={imagem} alt='Imagem do produto' />

      <div className='card-info'>
        <h3 className='card-title'>{nome}</h3>

        <p className='card-description'>{descricao}</p>

        <div className='card-footer'>
          <p>{`R$ ${valor}`}</p>
          <p>{tempoPreparo}</p>
        </div>
      </div>
    </div>
  );
};
