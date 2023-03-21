import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import { Header } from "./components/Header";
import { Footer } from "./components/Footer";
import { PageWrapper } from "./components/PageWrapper";
import { HomePage } from "./pages/Home";
import { ContactPage } from "./pages/Contact";
import { ReducerPage } from "./pages/Reducer";
import { DetailsPage } from "./pages/Details";
import { NotFoundPage } from "./pages/NotFound";

import UserInfoContext from "./UserInfoContext";

function App() {
  const [userInfo, setUserInfo] = useState({ name: "Romeu" });

  return (
    <UserInfoContext.Provider value={[userInfo, setUserInfo]}>
      <Header />
      <PageWrapper>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/contact" element={<ContactPage />} />
          <Route path="/details/:cep" element={<DetailsPage />} />
          <Route path="/reducer" element={<ReducerPage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Routes>
      </PageWrapper>
      <Footer />
    </UserInfoContext.Provider>
  );
}

export default App;
