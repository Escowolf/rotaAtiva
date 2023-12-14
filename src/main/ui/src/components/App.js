
import "./reset.css";
import "./base.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Cabecalho } from "../externo/cabecalho/cabecalho";
import { Route, Routes, useLocation } from "react-router-dom";
import { Index } from "../externo/index/index";
import { Cadastro } from "../externo/cadastro/cadastro";
import { Map } from "../interno/map/map";
import { Home } from "../interno/home/Home";
import { RelatorioVagas } from "../interno/relatorio_vaga/relatorioVaga";
import { RelatorioUsuario } from "../interno/relatorio_usuarios/relatorioUsuario";
import { DadoUsuario } from "../interno/dados_usuario/dadoUsuario";
import { RelatorioDeUso } from "../interno/relatorio_uso/relatorioDeUso";
import Dashboard from "../interno/dashboard/dashboard";
import { EditaPerfil } from "../interno/edita_perfil/edita_perfil";
import { EditarZona } from "../interno/adicionar_remover/EditarZona";
import { RemoverZona } from "../interno/adicionar_remover/RemoverZona";

function App() {
  return (
    <>
      {useLocation().pathname === "/" ? <Cabecalho /> : ""}
      <Routes>

        <Route element={<Index />} exact path="/"></Route>
        <Route element={<Cadastro />} exact path="/cadastro"></Route>
        <Route element={<Home />} exact path="/menulogado">
          <Route element={<Dashboard />} path=":id" />
          <Route element={<Map />} path="mapa" />
          <Route element={<RelatorioVagas />} path="relatorioVagas" />
          <Route element={<RelatorioUsuario />} path="relatorioUsuarios/:id" />
          <Route element={<DadoUsuario />} path="dadoUsuario/:id" />
          <Route element={<RelatorioDeUso />} path="relatorioUso" />
          <Route element={<EditaPerfil />} path="perfil" />
          <Route element={<EditarZona />} path="editarZona" />
          <Route element={<RemoverZona />} path="removerZona" />
        </Route>
      </Routes>
    </>
  );
}

export default App;