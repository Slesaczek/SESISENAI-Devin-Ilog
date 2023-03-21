import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import PageWrapper from "./components/PageWrapper";
import Footer from "./components/Footer";

import { GlobalStateProvider } from "./hooks/useGlobalState";

import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import CourseDetailsPage from "./pages/CourseDetailsPage";
import NotFoundPage from "./pages/NotFoundPage";

function App() {
  const [globalState, setGlobalState] = useState();

  return (
    <GlobalStateProvider value={[globalState, setGlobalState]}>
      <BrowserRouter>
        <Navbar />

        <PageWrapper>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/course/:id" element={<CourseDetailsPage />} />
            <Route path="*" element={<NotFoundPage />} />
          </Routes>
        </PageWrapper>

        <Footer />
      </BrowserRouter>
    </GlobalStateProvider>
  );
}

export default App;
