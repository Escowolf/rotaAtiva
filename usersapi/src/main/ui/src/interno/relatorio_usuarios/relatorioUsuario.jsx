import { Box, Flex, SkeletonText } from "@chakra-ui/react";
import {
  useJsApiLoader,
  GoogleMap,
  Polygon,
  Marker,
} from "@react-google-maps/api";
import { useEffect, useLayoutEffect, useMemo, useState } from "react";
import Pagination from "../../components/Paginacao/Pagination";
import "./relatorioUsuario.css";
import { Link, useLocation, useNavigate } from "react-router-dom";
import AreasService from "../../service/areas";

let PageSize = 5;

export function RelatorioUsuario() {
  const [y, setY] = useState({ path: ["", ""] });
  const location = useLocation();
  const navigate = useNavigate();
  const areasService = new AreasService();

  const [usuarios, setUsuarios] = useState([]);

  const [buscar, setBuscar] = useState("");

  const [lista, setLista] = useState([]);

  function testaBusca(nome) {
    const regex = new RegExp(buscar, "i");
    return regex.test(nome);
  }

  useEffect(() => {
    const novaLista = usuarios.filter((item) => testaBusca(item.nome));
    setLista(novaLista);
  }, [buscar]);

  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    setUsuarios(location.state.vaga.usuarios);
    setLista(location.state.vaga.usuarios);
  }, []);

  useEffect(() => {
    areasService.getAreas().then((resp) => {
      setY(
        resp.data.find((p) => p.rua_avenida == location.state.vaga.rua_avenida)
      );
    });
  }, []);

  const currentTableData = useMemo(() => {
    const firstPageIndex = (currentPage - 1) * PageSize;
    const lastPageIndex = firstPageIndex + PageSize;
    return lista.slice(firstPageIndex, lastPageIndex);
  }, [currentPage, lista]);

  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: "AIzaSyAQYGeShstIRAbsrS4lwyumbLwlG5t-sTA",
    libraries: ["places"],
  });

  if (!isLoaded) {
    return <SkeletonText />;
  }

  return (
    <>
      <Flex h="30vh" className="margem-esq">
        <Box h="100%" w="100%">
          <GoogleMap
            center={y.path[0]}
            zoom={16}
            mapContainerStyle={{ width: "100%", height: "100%" }}
          >
            <Polygon
              options={{ strokeColor: "#027373", strokeWeight: 5 }}
              onClick={() => {
                console.log(location);
              }}
              paths={y.path}
            ></Polygon>
          </GoogleMap>
        </Box>
      </Flex>

      <button
        className="btnVoltar margem-relatorio"
        onClick={() => navigate(-1)}
      >
        {" "}
        <img src="/img/btnVoltar.svg" alt="" /> Voltar
      </button>

      <div className="card margem-relatorio">
        <div className="card-body">
          <div className="row">
            <div className="col-md-12">
              <h2>
                Endereço: {location.state.vaga.rua_avenida} -{" "}
                {location.state.vaga.Bairro}
              </h2>
              <h2>
                Regra:
                {location.state.vaga.hora == undefined
                  ? ""
                  : ` ${location.state.vaga.hora} - `}
                {location.state.vaga.tipoVaga == undefined
                  ? ""
                  : `${location.state.vaga.tipoVaga} - `}
                {location.state.vaga.tempo == undefined
                  ? ""
                  : `${location.state.vaga.tempo}`}
              </h2>
              <h3 className="py-3 text-center font-bold font-up blue-text">
                Relatorio de Usuarios
              </h3>
              <div className="input-group md-form form-sm form-2 pl-0">
                <input
                  className="form-control my-0 py-1 pl-3 purple-border"
                  type="text"
                  placeholder="Pesquise o usuario aqui..."
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
            </div>
          </div>
          <table className="table table-hover table-responsive mb-0">
            <thead>
              <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Tempo de Uso</th>
                <th>Veiculo</th>
                <th>Acessibilidade</th>
              </tr>
            </thead>
            <tbody>
              {currentTableData.map((item) => {
                return (
                  <tr>
                    <td>{item.id}</td>
                    <td>
                      <Link
                        to={{ pathname: `/menulogado/dadoUsuario/${item.id}` }}
                        state={{ usuario: item }}
                      >
                        {item.nome}
                      </Link>
                    </td>
                    <td>{item.tempo_uso}</td>
                    <td>
                      {item.veiculo[0].modelo.toUpperCase()}{" "}
                      {item.veiculo[0].placa}
                    </td>
                    <td>{item.acessibilidade ? "Sim" : "Não"}</td>
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
