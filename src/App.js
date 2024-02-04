
import "./reset.css";
import "./base.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Cabecalho } from "./externo/cabecalho/cabecalho";
import { Route, Routes, useLocation } from "react-router-dom";
import { Index } from "./externo/index/index";
import { Cadastro } from "./externo/cadastro/cadastro";
import { Map } from "./interno/map/map";
import { Home } from "./interno/home/Home";
import { RelatorioVagas } from "./interno/relatorio_vaga/relatorioVaga";
import { RelatorioUsuario } from "./interno/relatorio_usuarios/relatorioUsuario";
import { DadoUsuario } from "./interno/dados_usuario/dadoUsuario";
import { RelatorioDeUso } from "./interno/relatorio_uso/relatorioDeUso";
import Dashboard from "./interno/dashboard/dashboard";
import { EditaPerfil } from "./interno/edita_perfil/edita_perfil";
import { EditarZona } from "./interno/adicionar_remover/EditarZona";
import { RemoverZona } from "./interno/adicionar_remover/RemoverZona";
import { urls } from "./utils/urlUtils";
import { Contato } from "./externo/contato/contato";


function App() {
  return (
    <>
      {useLocation().pathname === "/" ? <Cabecalho /> : ""}
      <Routes>
        <Route element={<Index />} exact path={urls.index.path}></Route>
        <Route element={<Cadastro />} exact path={urls.cadastro.path}></Route>
        <Route element={<Contato/>} exact path={urls.contato.path}></Route>
        <Route element={<Home />} exact path={urls.home.path}>
          <Route element={<Dashboard />} path={urls.dashboard.path} />
          <Route element={<Map />} path={urls.mapa.path}/>
          <Route element={<RelatorioVagas />} path={urls.relatorioVagas.path} />
          <Route element={<RelatorioUsuario />} path={urls.relatorioUsuarios.path} />
          <Route element={<DadoUsuario />} path={urls.relatorioUsuarios.path} />
          <Route element={<RelatorioDeUso />} path={urls.relatorioUsuarios.path} />
          <Route element={<EditaPerfil />} path={urls.relatorioUsuarios.path} />
          <Route element={<EditarZona />} path={urls.relatorioUsuarios.path} />
          <Route element={<RemoverZona />} path={urls.relatorioUsuarios.path} />
        </Route>
      </Routes>
    </>
  );
}

export default App;