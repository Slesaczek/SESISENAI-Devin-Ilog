# Servidor Contendo listagem de produtos para utilização nos exercícios

## Projeto React criado utilizando [Json Server](https://github.com/typicode/json-server)

## Primeiros passos

Para clonar o repositório é preciso executar o comando

```
git clone git@github.com:Devin-ilog/m02s08-exercicios.git
```

Para instalar as dependencias é preciso executar o comando **npm install**:

```
// Acessar a pasta do projeto
cd m02s08-exercicios/server

// Instalar as dependencias do projeto
npm install
```

---

## Comandos

No diretório do projeto, você pode executar:

### **start**

Executa o aplicativo.

```
npm start
```

O servidor roda a partir da **porta 8081**

http://localhost:8081

## Endpoints disponiveis

### Obter produtos:

```
GET: http://localhost:8081/produtos
```

**Resultado:**

```
[
 {
    "id": 6,
    "img": "http://localhost:8081/assets/sopa-cebola.png",
    "nome": "Sopa Gratinada de Cebola",
    "descricao": "Tradicional sopa de cebola à francesa gratinada com pão e queijo gruyerè.",
    "valor": 64,
    "tempoPreparo": "20 min",
    "secao": "Entradas"
  },
  ...
]
```
