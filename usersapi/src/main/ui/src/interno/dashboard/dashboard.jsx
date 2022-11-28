import "./styleFinal.css";

export function Dashboard() {
  return (
    <>
      <section id="wrapper">
        <div className="p-4">
          <div className="welcome">
            <div className="content rounded-3 p-3">
              <h1 className="fs-3">Bem-vindo ao RotaAtiva</h1>
              <p className="mb-0">
                Tudo que você precisa para administrar suas vagas está aqui!
              </p>
            </div>
          </div>
          {/*<!-- ESTATÍSTICAS DE USUÁRIOS E VAGAS -->*/}
          <section className="statistics mt-4">
            <div className="row">
              {/*<!-- ITEM 01 -->*/}
              <div className="col-lg-4">
                <div className="box d-flex rounded-2 align-items-center p-3 ">
                  <i className="uil-users-alt fs-2 text-center rounded-circle">
                    <img  className="icons" src="/img/location-dot-solid.svg" alt="" />
                  </i>
                  {/*<!-- LABEL -->*/}
                  <div className="ms-3">
                    <div className="d-flex align-items-center">
                      <h3 className="mb-0">5.273</h3>
                      <span className="d-block ms-2">Vagas Disponíveis</span>
                    </div>
                  </div>
                </div>
              </div>
              {/*<!-- ITEM 02 -->*/}
              <div className="col-lg-4">
                <div className="box d-flex rounded-2 align-items-center mb-lg-0 p-3">
                  <i className="uil-envelope-shield fs-2 text-center rounded-circle">
                    <img className="icons" src="/img/user-solid.svg" alt="" />
                  </i>
                  <div className="ms-3">
                    <div className="d-flex align-items-center">
                      <h3 className="mb-0">53.245</h3>{" "}
                      <span className="d-block ms-2">Usuários Ativos</span>
                    </div>
                  </div>
                </div>
              </div>
              {/*<!-- ITEM 03 -->*/}
              <div className="col-lg-4">
                <div className="box d-flex rounded-2 align-items-center mb-lg-0 p-3">
                  <i className="uil-file fs-2 text-center rounded-circle">
                    <img className="icons" src="/img/users-solid.svg" alt="" />
                  </i>
                  <div className="ms-3">
                    <div className="d-flex align-items-center">
                      <h3 className="mb-0">1.977</h3>{" "}
                      <span className="d-block ms-2">Novos Usuários</span>
                    </div>
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
                  <h3 className="fs-6 mb-3">
                    Estatísticas de Usuários e Vagas
                  </h3>
                  <canvas id="myChart"></canvas>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="chart-container rounded-2 p-3">
                  <h3 className="fs-6 mb-3">
                    Estatísticas de Usuários e Vagas
                  </h3>
                  <canvas id="myChart2"></canvas>
                </div>
              </div>
            </div>
          </section>
        </div>
      </section>

    </>
  );
}

export default Dashboard;
