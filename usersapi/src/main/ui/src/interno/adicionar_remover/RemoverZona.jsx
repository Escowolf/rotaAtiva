import "./editar_vaga/adicionar_remover.css";
import { useEffect, useMemo, useState } from "react";
import VagaService from "../../service/vaga";
import Pagination from "../../components/Paginacao/Pagination";
import { Link } from "react-router-dom";
import AreasService from "../../service/areas";
import { Alert, Collapse } from "@mui/material";

let PageSize = 6;

export function RemoverZona() {
  const areasService = new AreasService();

  const vagaService = new VagaService();

  const [buscar, setBuscar] = useState("");

  const [vagas, setVagas] = useState([]);

  const [lista, setLista] = useState([]);

  const [alert, setAlert] = useState(false);
  const [alertOk, setAlertOK] = useState(false);

  function testaBusca(nome) {
    const regex = new RegExp(buscar, "i");
    return regex.test(nome);
  }

  useEffect(() => {
    const novaLista = vagas.filter(
      (item) => testaBusca(item.rua_avenida) || testaBusca(item.Bairro)
    );
    setLista(novaLista);
  }, [buscar]);

  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    vagaService.getVaga().then((resp) => {
      console.log(resp)
      setVagas(resp.data);
      setLista(resp.data);
    });
  }, []);

  function excluir(id) {
    vagaService.deleteVaga(id).then(()=>{setAlertOK(true); setAlert(false);}).catch(function(error){
      if(error.response){
        setAlert(true)
        setAlertOK(false)
      }
    });;
  }

  const currentTableData = useMemo(() => {
    const firstPageIndex = (currentPage - 1) * PageSize;
    const lastPageIndex = firstPageIndex + PageSize;
    return lista.slice(firstPageIndex, lastPageIndex);
  }, [currentPage, lista]);

  return (
    <>
      <div id="wrapper">
        <h1 className="tituloPag">Remover Zona</h1>
        <div class="adicionar">
          <div className="alternar">
            <Link to="/menulogado/editarZona">
              <button className="alternar_cadastrar">Cadastrar</button>
            </Link>
            <Link to="/menulogado/removerZona">
              <button className="alternar_remover">Remover</button>
            </Link>
          </div>

          <div className="card">
            <div className="card-body">
              <div className="input-group md-form form-sm form-2 pl-0">
                <input
                  className="form-control my-0 py-1 pl-3 purple-border"
                  type="text"
                  placeholder="Pesquise o endereço ou bairro aqui..."
                  aria-label="Search"
                  value={buscar}
                  onChange={(evento) => setBuscar(evento.target.value)}
                />
                <span
                  className="input-group-addon waves-effect purple lighten-2"
                  id="basic-addon1"
                >
                  <a>
                    <i
                      className="fa fa-search white-text"
                      aria-hidden="true"
                    ></i>
                  </a>
                </span>
              </div>
              <Collapse in={alert}>
                  <Alert severity="error" onClose={() => {setAlert(false)}}>Ocorreu um erro, tente novamente, mais tarde!</Alert>
              </Collapse>
              <Collapse in={alertOk}>
                  <Alert onClose={() => {setAlertOK(false)}}>Cadastro realizado com sucesso!</Alert>
              </Collapse>
              <table className="table table-hover table-responsive mb-0">
                <thead>
                  <tr>
                    <th scope="row">Nome</th>
                    <th className="th-lg">Rua/Avenida - Bairro</th>
                    <th className="th-lg">Crédito</th>
                    <th className="th-lg">Total do veículos</th>
                    <th className="th-lg">Tempo de uso</th>
                    <th className="th-lg">Remover</th>
                  </tr>
                </thead>
                <tbody>
                  {currentTableData.map((item) => {
                    return (
                      <tr>
                        <td>{item.nome}</td>
                        <td>
                          <Link
                            to={{
                              pathname: `/menulogado/relatorioUsuarios/${item.id}`,
                            }}
                            state={{ vaga: item }}
                          >
                            {item.logradouro} - {item.bairro}
                          </Link>
                        </td>
                        <td>{(item.credito == null || item.credito == undefined)  ? 0 : item.credito}</td>
                        <td>{(item.totalVeiculos == null || item.totalVeiculos == undefined) ? 0 : item.totalVeiculos}</td>
                        <td>{(item.tempoUso == null|| item.tempoUso == undefined) ? 0 : item.tempoUso} h</td>
                        <td
                          className="remover"
                          onClick={() => excluir(item.id)}
                        >
                          <span>remover</span>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
              <Pagination
                currentPage={currentPage}
                totalCount={lista.length}
                pageSize={PageSize}
                onPageChange={(page) => setCurrentPage(page)}
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
