import { Box, Flex, others, SkeletonText } from "@chakra-ui/react";
import {
  useJsApiLoader,
  GoogleMap,
  Polygon,
  Marker,
} from "@react-google-maps/api";
import { useEffect, useMemo, useState } from "react";
import VagaService from "../../service/vaga";
import Pagination from "../../components/Paginacao/Pagination";
import { Link, useNavigate } from "react-router-dom";
import AreasService from "../../service/areas";

const center = { lat: -3.735015, lng: -38.494695 };

let PageSize = 5;

export function RelatorioDeUso() {
  const areasService = new AreasService();
  const [dados, setDados] = useState([]);

  const navigate = useNavigate();

  const vagaService = new VagaService();

  const [buscar, setBuscar] = useState("");

  const [vagas, setVagas] = useState([]);

  const [lista, setLista] = useState([]);

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
    areasService.getAreas().then((resp) => {
      setDados(resp.data);
    });
  }, []);

  const [currentPage, setCurrentPage] = useState(1);

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

  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: "AIzaSyAQYGeShstIRAbsrS4lwyumbLwlG5t-sTA",
    libraries: ["places"],
  });

  const [showInfoWindow, setShowInfoWindow] = useState(false);

  if (!isLoaded) {
    return <SkeletonText />;
  }

  return (
    <>
      <div>
        <Flex h="30vh" className="margem-esq">
          <Box h="100%" w="100%">
            <GoogleMap
              center={center}
              zoom={15}
              mapContainerStyle={{ width: "100%", height: "100%" }}
            >
              {dados.map((d) => {
                var x = vagas.find((p) => p.rua_avenida == d.rua_avenida);

                return (
                  <>
                    <Polygon
                      options={{
                        strokeColor:
                          x?.usuarios?.length > 2 ? "#FF5858" : "#027373",
                        strokeWeight: 2,
                      }}
                      onClick={() => {
                        navigate(`/menulogado/relatorioUsuarios/${x.id}`, {
                          state: { vaga: x },
                          replace: true,
                        });
                      }}
                      paths={d.path}
                    ></Polygon>
                  </>
                );
              })}
              {showInfoWindow && (
                <Marker
                  position={{
                    lat: -22.618827234831404,
                    lng: -42.57636812499999,
                  }}
                ></Marker>
              )}
            </GoogleMap>
          </Box>
        </Flex>

        <div className="card margem-relatorio">
          <div className="card-body">
            <h1 className="py-3 text-center font-bold font-up blue-text">
              Vagas Mais Usadas
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
      </div>
    </>
  );
}
