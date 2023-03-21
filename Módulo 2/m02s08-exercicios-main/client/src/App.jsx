import './App.css';
import { Card } from './components/Card';
import { Footer } from './components/Footer';
import { Navbar } from './components/Navbar';
import { Produtos } from './pages/Produtos';

function App() {
  return (
    <div className='app'>
      <Navbar />

      <main className='main'>
        <Produtos />
      </main>

      <Footer />
    </div>
  );
}

export default App;
