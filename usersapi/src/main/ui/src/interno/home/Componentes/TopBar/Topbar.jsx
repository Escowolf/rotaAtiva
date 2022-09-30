import './Topbar.css';

const ColoredLine = ({ color }) => (
  <hr
    style={{
      color: color,
      backgroundColor: color,
      height: 5
    }}
  />
);

export function TopBar() {
  return (
    <>
      <section id="wrapper">
        <nav className="navbar navbar-expand-md">
          <div className="container-fluid mx-2">
            {/* NAVBAR - BOTÃO MENU */}
            <div className="navbar-header">
              <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggle-navbar"
                aria-controls="toggle-navbar" aria-expanded="false" aria-label="Toggle navigation">
              </button>
              {/* LOGO */}
              <a className="navbar-brand" href="/#">Rota<span className="main-color">Ativa</span></a>
            </div>
            <div className="collapse navbar-collapse" id="toggle-navbar">
              <ul className="navbar-nav ms-auto">
                <li className="nav-item dropdown">

                  <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li>
                      <a className="dropdown-item" href="/#">Minha Conta</a>
                    </li>
                    <li><a className="dropdown-item" href="/#">Caixa de Entrada</a>
                    </li>
                    <li><a className="dropdown-item" href="/#">Ajuda</a>
                    </li>
                    <li>
                      <ColoredLine />
                    </li>
                    <li><a className="dropdown-item" href="/#">Deslogar</a></li>
                  </ul>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/#"><i className="uil-comments-alt"></i><span>23</span></a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/#"><i className="uil-bell"></i><span>98</span></a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/#">
                    <i data-show="show-side-navigation1" className="uil-bars show-side-btn"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </section>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
      <script
        src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
      <script src="./script.js"></script>
    </>
  )
}

export default TopBar;