import { Link } from "react-router-dom";
import "./Topbar.css";

const ColoredLine = ({ color }) => (
  <hr
    style={{
      color: color,
      backgroundColor: color,
      height: 5,
    }}
  />
);

export function TopBar() {

  function logout(){
    localStorage.removeItem("usuarioLogado")
  }

  return (
    <>
      <section id="wrapper">
        <nav className="navbar navbar-expand-md">
          <div className="container-fluid mx-2">
            {/* NAVBAR - BOTÃO MENU */}
            <div className="navbar-header">
              {/* LOGO */}
              <Link className="navbar-brand" to="/">
                Rota<span className="main-color">Ativa</span>
              </Link>
            </div>

            <li className='cabecalho_menu-item'>
              <Link to={`/`} onClick={logout}>
                <img src="/img/right-from-bracket-solid.svg" alt="entrar" />
                <span>Deslogar</span>
              </Link>
            </li>
          </div>
        </nav>
      </section>
    </>
  );
}

export default TopBar;
