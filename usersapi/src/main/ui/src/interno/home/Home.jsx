import "./style.css";
import "./styleFinal.css";
import Sidebar from "./Componentes/sidebar/Sidebar";
import Topbar from "./Componentes/TopBar/Topbar";

export function Home() {
    return (<>
        <Sidebar />
        <Topbar />
        <section id="wrapper">
            <div className="p-4">
                <div className="welcome">
                    <div className="content rounded-3 p-3">
                        <h1 className="fs-3">Bem-vindo ao RotaAtiva</h1>
                        <p className="mb-0">Tudo que você precisa para administrar suas vagas está aqui!</p>
                    </div>
                </div>
                {/*<!-- ESTATÍSTICAS DE USUÁRIOS E VAGAS -->*/}
                <section className="statistics mt-4">
                    <div className="row">
                        {/*<!-- ITEM 01 -->*/}
                        <div className="col-lg-4">
                            <div className="box d-flex rounded-2 align-items-center p-3">
                                <i className="uil-users-alt fs-2 text-center bg-success rounded-circle"></i>
                                {/*<!-- LABEL -->*/}
                                <div className="ms-3">
                                    <div className="d-flex align-items-center">
                                        <h3 className="mb-0">5.273</h3>
                                        <span className="d-block ms-2">Vagas Disponíveis</span>
                                    </div>
                                   {/* <!-- NOME -->*/}
                                    <p className="fs-normal mb-0">Vagas disponíveis nas zonas azuis</p>
                                </div>
                            </div>
                        </div>
                        {/*<!-- ITEM 02 -->*/}
                        <div className="col-lg-4">
                            <div className="box d-flex rounded-2 align-items-center mb-4 mb-lg-0 p-3">
                                <i className="uil-envelope-shield fs-2 text-center bg-primary rounded-circle"></i>
                                <div className="ms-3">
                                    <div className="d-flex align-items-center">
                                        <h3 className="mb-0">53.245</h3> <span className="d-block ms-2">Usuários Ativos</span>
                                    </div>
                                    <p className="fs-normal mb-0">Usuários Ativos na plataforma</p>
                                </div>
                            </div>
                        </div>
                        {/*<!-- ITEM 03 -->*/}
                        <div className="col-lg-4">
                            <div className="box d-flex rounded-2 align-items-center mb-4 mb-lg-0 p-3">
                                <i className="uil-file fs-2 text-center bg-danger rounded-circle"></i>
                                <div className="ms-3">
                                    <div className="d-flex align-items-center">
                                        <h3 className="mb-0">1.977</h3> <span className="d-block ms-2">Novos Usuários</span>
                                    </div>
                                    <p className="fs-normal mb-0">Usuários novos cadastrados</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </section>
                {/*<!-- GRÁFICOS DE USUÁRIOS E VAGAS -->*/}
                <section className="charts mt-4">
                    <div className="row">
                        <div className="col-lg-6">
                            <div className="chart-container rounded-2 p-3">
                                <h3 className="fs-6 mb-3">Estatísticas de Usuários e Vagas</h3>
                                <canvas id="myChart"></canvas>
                            </div>
                        </div>
                        <div className="col-lg-6">
                            <div className="chart-container rounded-2 p-3">
                                <h3 className="fs-6 mb-3">Estatísticas de Usuários e Vagas</h3>
                                <canvas id="myChart2"></canvas>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </section>
        </>
    )
}

export default Home;