import { useEffect, useMemo, useState } from "react";
import Pagination from "../../components/Paginacao/Pagination";
import Topbar from "../home/Componentes/topbar/Topbar";
import Sidebar from "../home/Componentes/sidebar/Sidebar";
import "./relatorioVaga.css";
import VagaService from "../../service/vaga";
import { Link } from "react-router-dom";

let PageSize = 10;

export function RelatorioVagas() {
  const vagaService = new VagaService();

  const [buscar, setBuscar] = useState("");

  const [lista, setLista] = useState([]);

  const [vagas, setVagas] = useState([]);

  const [currentPage, setCurrentPage] = useState(1);

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

  useEffect(() => {
    vagaService.getVaga().then((resp) => {
      setVagas(resp.data);
      setLista(resp.data);
    });
  }, []);

  const currentTableData = useMemo(() => {
    const firstPageIndex = (currentPage - 1) * PageSize;
    const lastPageIndex = firstPageIndex + PageSize;
    return lista.slice(firstPageIndex, lastPageIndex);
  }, [currentPage, lista]);

  return (
    <>
      <div className="card margem-relatorio">
        <div className="card-body">
          <h1 className="py-3 text-center font-bold font-up blue-text">
            Relatorio de Vagas
          </h1>

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
                <i className="fa fa-search white-text" aria-hidden="true"></i>
              </a>
            </span>
          </div>

          <table className="table table-hover table-responsive mb-0">
            <thead>
              <tr>
                <th scope="row">Nome</th>
                <th className="th-lg">Rua/Avenida - Bairro</th>
                <th className="th-lg">Crédito</th>
                <th className="th-lg">Total do veículos</th>
                <th className="th-lg">Tempo de uso</th>
              </tr>
            </thead>
            <tbody>
              {currentTableData.map((item) => {
                var tempo = 0;
                var credito = 0;
                var veiculos = 0;
                item.usuarios.forEach((element) => {
                  tempo += element.tempo_uso;
                  credito += element.credito;
                  veiculos += element.veiculo.length;
                });
                return (
                  <tr>
                    <td>{item.nome_vaga}</td>
                    <td>
                      <Link
                        to={{
                          pathname: `/menulogado/relatorioUsuarios/${item.id}`,
                        }}
                        state={{ vaga: item }}
                      >
                        {item.rua_avenida} - {item.Bairro}
                      </Link>
                    </td>
                    <td>{credito}</td>
                    <td>{veiculos}</td>
                    <td>{tempo} h</td>
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
    </>
  );
}
