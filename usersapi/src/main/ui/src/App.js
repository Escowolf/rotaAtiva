import "./reset.css";
import "./base.css";
import  'bootstrap/dist/css/bootstrap.min.css' ;
import { Cabecalho } from "./externo/cabecalho/cabecalho";
import { Route, Routes, useLocation } from "react-router-dom";
import { Index } from "./externo/index/index";
import { Rodape } from "./externo/rodape/rodape";
import { Cadastro } from "./externo/cadastro/cadastro";
import { Login } from "./externo/login/login";
import { Map } from "./interno/map/map";
import { Home } from "./interno/home/Home";

function App() {

  return (
    <>
      <Cabecalho />
      <Routes>
        <Route element={<Index />} exact path="/"></Route>
        <Route element={<Cadastro />} exact path="/cadastro"></Route>
        <Route element={<Login />} exact path="/login"></Route>
        <Route element={<Map />} path="/menulogado/:id/mapa"></Route>
        <Route element={<Home />} path="/teste"></Route>
      </Routes>
      { useLocation().pathname == "/" 
      ? 
      <Rodape />
      :
      ""
      }
    </>
  );
}

export default App;
