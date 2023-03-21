import Navbar from "./components/Navbar";
import PageWrapper from "./components/PageWrapper";
import Footer from "./components/Footer";

import HomePage from "./pages/HomePage";

function App() {
  return (
    <>
      <Navbar />
      <PageWrapper>
        <HomePage />
      </PageWrapper>
      <Footer />
    </>
  );
}

export default App;
