class DivComTexto {    
    constructor(texto) {
        this._div = document.createElement('div');
        this._div.innerText = texto;      
    }
    getDiv() {
        return this._div;
      }    
  }
  class DivComFundo extends DivComTexto {
    constructor(texto) {
      super(texto);
    }
  
    addEstilo() {
      this._div.classList.add('um-estilo-bacana');
    }
  }
  
  class DivBotao extends DivComFundo {
    constructor(texto) {
      super(texto);
    }
  
    addEstilo() {
      this._div.classList.add('estilo-botao');
    }
  }
  
  const textoSimples = new DivComTexto('Um texto qualquer dentro da div');
  document.body.appendChild(textoSimples.getDiv());
  
  const textoComFundo = new DivComFundo('Um texto com fundo');
  document.body.appendChild(textoComFundo.getDiv());
  textoComFundo.addEstilo();
  
  const textoBotao = new DivBotao('Uma div que se parece um botão');
  document.body.appendChild(textoBotao.getDiv());
  textoBotao.addEstilo();