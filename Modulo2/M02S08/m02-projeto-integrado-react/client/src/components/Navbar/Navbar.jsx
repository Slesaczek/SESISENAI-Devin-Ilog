import logo from '../../assets/logo.png';

import './Navbar.css';

export const Navbar = () => {
  return (
    <header className='container'>
      <div className='logo'>
        <img width={50} src={logo} alt='Logotipo' />
        <h1>DevInFood</h1>
      </div>
      <a href='#'>Menu</a>
    </header>
  );
};
