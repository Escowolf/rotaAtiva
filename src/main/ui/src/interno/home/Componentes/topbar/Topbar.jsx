import { Link } from "react-router-dom";
import "./Topbar.css";

export function TopBar() {

  function logout() {
    localStorage.removeItem("token")
    localStorage.removeItem("usuarioLogado")
  }

  return (
    <>
      <section id="wrapper">
        <nav className="navbar">
          <div className="cabecalho_menu-item">
            <Link to={`/`} onClick={logout}>
              <span>Deslogar</span>
              <img src="/img/right-from-bracket-solid.svg" alt="deslogar" />
            </Link>
          </div>
        </nav>
      </section>
    </>
  );
}

export default TopBar;
