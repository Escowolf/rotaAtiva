import { Box, Flex, SkeletonText } from "@chakra-ui/react";
import {
  useJsApiLoader,
  GoogleMap,
  Polygon,
  Marker,
} from "@react-google-maps/api";
import { useEffect, useState } from "react";
import './map.css'
import AreasService from "../../service/areas";
import VagaService from "../../service/vaga";

const center = { lat: -3.735015, lng: -38.494695 };

export function Map() {
  const vagasService = new VagaService();
  const [dados, setDados] = useState([]);

  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: "AIzaSyB9z2S91_vb2LQS6VBMm3L0oJhemvEyLlk",
    libraries: ["places"],
  });

  useEffect(() => {
    vagasService.getVaga().then((resp) => {
      setDados(resp.data);
    })
  }, [])

  const [showInfoWindow, setShowInfoWindow] = useState(false);

  if (!isLoaded) {
    return <SkeletonText />;
  }

  return (
    <>
      <div className="margem-esq">
        <Flex className="mapa">
          <Box h="100%" w="100%">
            <GoogleMap
              center={center}
              zoom={15}
              mapContainerStyle={{ width: "100%", height: "100%" }}
            >
              {dados.map((d) => {
                return (
                  <>
                    <Polygon
                      options={{ strokeColor: "#027373", strokeWeight: 2 }}
                      onClick={() => {
                        setShowInfoWindow(true);
                      }}
                      paths={[{lat:d.latitudeInicial,lng:d.longitudeInicial},{lat:d.latitudeFinal,lng:d.longitudeFinal}]}
                    ></Polygon>
                  </>
                );
              })}
              {showInfoWindow && (
                <Marker
                  position={{ lat: -22.618827234831404, lng: -42.57636812499999 }}
                ></Marker>
              )}
            </GoogleMap>
          </Box>
        </Flex>
      </div>
    </>
  );
}
