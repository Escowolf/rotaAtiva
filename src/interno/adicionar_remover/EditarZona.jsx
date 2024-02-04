import { Alert, Collapse } from "@mui/material";
import { useState } from "react";
import { Link } from "react-router-dom";
// import AreasService from "../../src/service/areas";
import VagaService from "../../service/vaga";
import "./editar_vaga/adicionar_remover.css";

export function EditarZona() {
  // const areasService = new AreasService();
  const vagaService = new VagaService();

  const [lat, setLat] = useState("");
  const [lng, setLng] = useState("");
  const [lat2, setLat2] = useState("");
  const [lng2, setLng2] = useState("");
  const [nome, setNome] = useState("");
  const [rua, setRua] = useState("");
  const [bairro, setBairro] = useState("");
  // const [tempo, setTempo] = useState("");
  const [tipoVaga, setTipoVaga] = useState("");
  // const [hora, setHora] = useState("");
  const [alert, setAlert] = useState(false);
  const [alertOk, setAlertOK] = useState(false);

  function salvar(e) {
    e.preventDefault();
    vagaService.postVaga({
      nome: nome,
      logradouro: rua,
      bairro: bairro,
      acessibilidade: tipoVaga,
      latitudeInicial:  Number(lat),
      longitudeInicial: Number(lng),
      latitudeFinal: Number(lat2),
      longitudeFinal:  Number(lng2)
    }).then(()=>{setAlertOK(true); setAlert(false);}).catch(function(error){
      if(error.response){
        setAlert(true)
        setAlertOK(false)
      }
    });
  }

  return (
    <>
      <div id="wrapper">
        <h1 className="tituloPag">Cadastro de Zona</h1>
        <div class="adicionar">
          <div className="alternar">
            <Link to="/menulogado/editarZona">
              <button className="alternar_cadastrar">Cadastrar</button>
            </Link>
            <Link to="/menulogado/removerZona">
              <button className="alternar_remover">Remover</button>
            </Link>
          </div>
          <form className="adicionar_form" onSubmit={salvar}>
            <label className="adicionar_titulo">Zona</label>
          <Collapse in={alert}>
              <Alert severity="error" onClose={() => {setAlert(false)}}>Ocorreu um erro, tente novamente, mais tarde!</Alert>
          </Collapse>
          <Collapse in={alertOk}>
              <Alert onClose={() => {setAlertOK(false)}}>Cadastro realizado com sucesso!</Alert>
          </Collapse>
            {/* Cadastro de Zona */}
            <fieldset className="adicionar_corpo">
              <input
                onChange={(e) => setLng(e.target.value)}
                value={lng}
                className="longitude"
                name="longitude inicial"
                type="text"
                required
                placeholder="Longitude inicial"
              />
              <input
                onChange={(e) => setLat(e.target.value)}
                value={lat}
                className="latitude"
                name="latitude inicial"
                type="text"
                required
                placeholder="Latitude inicial"
              />
            </fieldset>
            <fieldset className="adicionar_corpo">
              <input
                onChange={(e) => setLng2(e.target.value)}
                value={lng2}
                className="longitude"
                name="longitude final"
                type="text"
                required
                placeholder="Longitude final"
              />
              <input
                onChange={(e) => setLat2(e.target.value)}
                value={lat2}
                className="latitude"
                name="latitude final"
                type="text"
                required
                placeholder="Latitude final"
              />
            </fieldset>
            <fieldset className="adicionar_corpo">
              <input
                onChange={(e) => setRua(e.target.value)}
                value={rua}
                className="nomedarua"
                name="rua"
                type="text"
                required
                placeholder="Rua"
              />
              <input
                onChange={(e) => setBairro(e.target.value)}
                value={bairro}
                className="nomedobairro"
                name="bairro"
                type="text"
                required
                placeholder="Bairro"
              />
            </fieldset>
            <fieldset className="adicionar_corpo">
              <input
                onChange={(e) => setNome(e.target.value)}
                value={nome}
                className="nomedavaga"
                name="nome da vaga"
                type="text"
                required
                placeholder="Nome da vaga"
              />
            </fieldset>
            <fieldset className="adicionar_corpo">
              <label className="adicionar_titulo">Regras</label>
            </fieldset>
            <fieldset className="adicionar_corpo">
              <select
                onChange={(e) => setTipoVaga(e.target.value === "comum" ? false : true)}
                value={tipoVaga}
                className="tipodevaga"
                name="tipodevaga"
                required
              >
                <option value="selecione">Tipo de Zona</option>
                <option value="comum">Comum</option>
                <option value="prioritario">Prioritário</option>
              </select>
            </fieldset>
            {/* <fieldset className="adicionar_corpo">
              <input
                onChange={(e) => setHora(e.target.value)}
                value={hora}
                className="horadeuso"
                name="hora de uso"
                type="text"
                required
                placeholder="Horário de uso"
              />
              <select
                className="tempomaximo"
                onChange={(e) => setTempo(e.target.value)}
                value={tempo}
                name="tempomaximo"
                required
              >
                <option value="tempo">Tempo máximo - Ticket</option>
                <option value="1 Hora">1 Hora - Ticket</option>
                <option value="2 Horas">2 Horas - Ticket</option>
                <option value="5 Horas">5 Horas - Ticket</option>
              </select>
            </fieldset> */}
            <button class="botao_enviar">Cadastrar</button>
          </form>
        </div>
      </div>
    </>
  );
}
