import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/home";
import CreateAccountPage from "./pages/account/create";
import AccountingToolbar from "./component/accountingToolbar";
import CreateTransactionPage from "./pages/transaction/create";

function App() {
  //console.log(process.env.REACT_APP_BACKEND_PATH)
  return (
    
    
      <BrowserRouter>
        <Routes>
          <Route path="/" element={
            <div className="homeLayout">
              <AccountingToolbar />
              <Home />
            </div>
          } />
          <Route 
            path="/account/create" 
            element={
              <div className="createAccountLayout">
                <AccountingToolbar />
                <CreateAccountPage />
              </div>
            } />

          <Route 
            path="/transaction/create" 
            element={
              <div className="createAccountLayout">
                <AccountingToolbar />
                <CreateTransactionPage />
              </div>
            } />

        </Routes>
      </BrowserRouter>
    
    
  );
}

export default App;
