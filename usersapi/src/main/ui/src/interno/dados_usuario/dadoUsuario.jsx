import { useLocation, useNavigate } from 'react-router-dom';
import './dadoUsuario.css'


export function DadoUsuario() {
    const location = useLocation();
    const navigate = useNavigate();

    const infos = ["Nome", "E-mail", "CPF", "Data de Nascimento"]
    const dados = [location.state.usuario.nome, location.state.usuario.email, location.state.usuario.cpf, location.state.usuario.nascimento]

    return (
        <>
            <div className="margem-esq">
                <div className="containerUser space">
                    <div className="flex w-full items-center">
                        <div className="flex items-center text-3xl">
                            {location.state.usuario.nome}
                        </div>
                        <div className="ml-auto sm:flex hidden items-center justify-end"></div>
                    </div>
                    <div className="flex items-center space-x-3 sm:mt-7 mt-4">

                    </div>
                </div>

                <div className="p-4">

                    {infos.map((info, index)=>{
                        return(
                            <div className="containerInfos formulario containerEffect bordaInferiorCor">
                                <div className="content p-3 bordaSuperior dados">
                                    <p className="mb-0 ">{info}</p>
                                    <span className="">{dados[index]}</span>
                                </div>
                            </div>        
                        )
                    })}

                   

                    <div className="containerInfos space2">
                        <div className="content rounded-3 p-3">
                            <h1 className="tituloVeiculos">Veículos</h1>
                        </div>
                    </div>

                    <section className="statistics space3">
                        <div className="row">
                            {
                                location.state.usuario.veiculos.map((item) => {
                                    return (
                                        <div className="col-lg-4 formulario">
                                            <div className="box d-flex rounded-2 align-items-center p-3">

                                                <div className="ms-3 space3">
                                                    <div className="d-flex align-items-center">
                                                        <h5 className="mb-0">{item.modelo.toUpperCase()}</h5>
                                                        <span className="d-block ms-2">{item.placa}</span>
                                                    </div>
                                                    <p className="fs-normal mb-0">{item.cor.toUpperCase()}</p>
                                                </div>

                                            </div>
                                        </div>
                                    )
                                })
                            }


                        </div>
                    </section>

                </div>
            </div>
            <div className="p-4-left">
                <button className='btnVoltar margem-relatorio' onClick={() => navigate(-1)}> <img src="/img/btnVoltar.svg" alt="voltar" /> Voltar</button>

            </div>
        </>
    )
}