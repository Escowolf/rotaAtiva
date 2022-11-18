import { useState } from 'react';
import { Link } from 'react-router-dom';
import AreasService from '../../service/areas';
import VagaService from '../../service/vaga';
import './editar_vaga/adicionar_remover.css';

export function EditarVaga() {
    const areasService = new AreasService();
    const vagaService = new VagaService();

    const [lat, setLat] = useState("");
    const [lng, setLng] = useState("");
    const [lat2, setLat2] = useState("");
    const [lng2, setLng2] = useState("");
    const [nome, setNome] = useState("");

    function salvar(e) {
        e.preventDefault();
        vagaService.postVaga({
            "rua_avenida": nome,
            "Bairro": nome,
            "usuarios": []
        })

        areasService.postAreas({
            "rua_avenida": nome,
            "Bairro": nome,
            "path": [
                {
                    "lat": Number(lat),
                    "lng": Number(lng)
                },
                {
                    "lat": Number(lat2),
                    "lng": Number(lng2)
                }
            ]
        }).then(alert("cadastrado com sucesso"));
    }


    return (
        <>
            <div id='wrapper'>

                <h1 className="tituloPag">Cadastro de Vaga</h1>
                <div class="adicionar">
                    <div className="alternar">
                        <Link to="/menulogado/editarVaga">
                            <button className="alternar_cadastrar">Cadastrar</button>
                        </Link>
                        <Link to="/menulogado/removerVaga">
                            <button className="alternar_remover">Remover</button>
                        </Link>
                    </div>
                    <form className='adicionar_form' onSubmit={salvar}>
                        <label className="adicionar_titulo">Vaga</label> {/* Cadastro de Vaga */}
                        <fieldset className="adicionar_corpo">
                            <input
                                onChange={e => setLng(e.target.value)}
                                value={lng}
                                className="longitude"
                                name="longitude inicial"
                                type="text"
                                required placeholder="Longitude inicial" />
                            <input
                                onChange={e => setLat(e.target.value)}
                                value={lat}
                                className="longitude"
                                name="longitude final"
                                type="text"
                                required placeholder="Longitude final" />
                        </fieldset>
                        <fieldset className="adicionar_corpo">
                            <input
                                onChange={e => setLng2(e.target.value)}
                                value={lng2}
                                className="longitude"
                                name="longitude inicial"
                                type="text"
                                required placeholder="Longitude inicial" />
                            <input
                                onChange={e => setLat2(e.target.value)}
                                value={lat2}
                                className="longitude"
                                name="longitude final"
                                type="text"
                                required placeholder="Longitude final" />
                        </fieldset>
                        <fieldset className="adicionar_corpo">
                            <input
                                onChange={e => setNome(e.target.value)}
                                value={nome}
                                className="nomedavaga"
                                name="nome da vaga"
                                type="text"
                                required placeholder="Nome da vaga" />
                        </fieldset>
                        <fieldset className="adicionar_corpo">
                            <label className="adicionar_titulo">
                                Regras
                            </label>
                        </fieldset>
                        <fieldset className="adicionar_corpo">
                            <select className="tipodevaga" name="tipodevaga" required>
                                <option value="selecione">Tipo de vaga</option>
                                <option value="comum">Comum</option>
                                <option value="prioritario">Prioritário</option>
                            </select>
                        </fieldset>
                        <fieldset className="adicionar_corpo">
                            <input className="horadeuso" name="hora de uso" type="text" required placeholder="Horário de uso" />
                            <select className="tempomaximo" name="tempomaximo" required>
                                <option value="tempo">Tempo máximo</option>
                                <option value="tempo">1 Hora</option>
                                <option value="tempo">2 Horas</option>
                                <option value="tempo">5 Horas</option>
                            </select>
                        </fieldset>
                        <button class="botao_enviar">Cadastrar</button>
                    </form>
                </div>
            </div>
        </>
    );
}

