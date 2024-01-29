import { Box, Flex, SkeletonText } from "@chakra-ui/react";
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
// import AreasService from "../../service/areas";

const center = { lat: -3.735015, lng: -38.494695 };

let PageSize = 5;

export function RelatorioDeUso() {
  // const areasService = new AreasService();
  const [dados, setDados] = useState([]);

  const navigate = useNavigate();

  const vagaService = new VagaService();

  const [buscar, setBuscar] = useState("");

  const [vagas, setVagas] = useState([]);

  const [lista, setLista] = useState([]);

  // function testaBusca(nome) {
  //   const regex = new RegExp(buscar, "i");
  //   return regex.test(nome);
  // }

  // useEffect(() => {
  //   const novaLista = vagas.filter(
  //     (item) => testaBusca(item.logradouro) || testaBusca(item.bairro)
  //   );
  //   setLista(novaLista);
  // }, [buscar]);

  useEffect(() => {
    vagaService.getVaga().then((resp) => {
      setDados(resp.data);
    });
  });

  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    vagaService.getVaga().then((resp) => {
      setVagas(resp.data);
      setLista(resp.data);
    });
  });

  const currentTableData = useMemo(() => {
    const firstPageIndex = (currentPage - 1) * PageSize;
    const lastPageIndex = firstPageIndex + PageSize;
    return lista.slice(firstPageIndex, lastPageIndex);
  }, [currentPage, lista]);

  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: "AIzaSyB9z2S91_vb2LQS6VBMm3L0oJhemvEyLlk",
    libraries: ["places"],
  });

  const [showInfoWindow] = useState(false);

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
                var x = vagas.find((p) => p.logradouro === d.logradouro);

                return (
                  <>
                    <Polygon
                      options={{
                        strokeColor:
                          x?.totalVeiculos > 2 ? "#FF5858" : "#027373",
                        strokeWeight: 2,
                      }}
                      onClick={() => {
                        navigate(`/menulogado/relatorioUsuarios/${x.id}`, {
                          state: { vaga: x },
                          replace: true,
                        });
                      }}
                      paths={[{ lat: d.latitudeInicial, lng: d.longitudeInicial }, { lat: d.latitudeFinal, lng: d.longitudeFinal }]}
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
                  <th className="th-lg">Logradouro - Bairro</th>
                  <th className="th-lg">Crédito</th>
                  <th className="th-lg">Total do veículos</th>
                  <th className="th-lg">Tempo de uso</th>
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
                      <td>{(item.credito === null || item.credito === undefined)  ? 0 : item.credito}</td>
                      <td>{(item.totalVeiculos === null || item.totalVeiculos === undefined) ? 0 : item.totalVeiculos}</td>
                      <td>{(item.tempoUso === null|| item.tempoUso === undefined) ? 0 : item.tempoUso} h</td>
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
