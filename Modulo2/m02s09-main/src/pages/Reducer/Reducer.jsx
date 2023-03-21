import { useReducer, useState } from "react";
import "./Reducer.css";

// valor inicial do useReducer
const contadorInitial = 0;

// função redutora do useReducer
function reducerContador(state, action) {
  console.log({ state, action });

  switch (action.type) {
    case "zera":
      return 0;

    case "incrementa":
      return state + 1;

    case "decrementa":
      return state - 1;

    case "define":
      return action.payload.value;

    default:
      return state;
  }
}

function ReducerPage() {
  // inicializando um useReducer
  const [contador, dispatchContador] = useReducer(
    reducerContador,
    contadorInitial
  );

  return (
    <main className="ReducerPageContainer">
      <h2>Exemplo useReducer</h2>
      <div>
        <p>
          Valor contador: <span style={{ fontSize: 50 }}>{contador}</span>
        </p>
        <button onClick={() => dispatchContador({ type: "zera" })}>0</button>
        <button onClick={() => dispatchContador({ type: "incrementa" })}>
          +
        </button>
        <button onClick={() => dispatchContador({ type: "decrementa" })}>
          -
        </button>
        <button
          onClick={() =>
            dispatchContador({ type: "define", payload: { value: 333 } })
          }
        >
          redefine
        </button>
      </div>
    </main>
  );
}

export default ReducerPage;
