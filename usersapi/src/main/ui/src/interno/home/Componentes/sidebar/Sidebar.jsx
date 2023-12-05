import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import UserService from "../../../../service/users";
import "./Sidebar.css";

export function NavbarLateral() {
  const userService = new UserService();

  const [usuario, setUsuario] = useState({
    nome: "",
    email: "",
    cpf: "",
    datanasc: ""
  });

  useEffect(() => {
    userService.getUsuario().then((resp) => {
      console.log(resp)
      let id = localStorage.getItem("usuarioLogado")
      let login = resp.data.find((p) => p.id === id);
      if (login) {
        setUsuario(login);
        console.log(login);
      }
    })
  }, [])




  return (
    <aside
      className="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left"
      id="show-side-navigation1"
    >
      <i
        className="uil-bars close-aside d-md-none d-lg-none"
        data-close="show-side-navigation1"
      ></i>
      {/* NAVBAR LATERAL - IMAGEM DE USER + TIPO DE USER */}
      <div className="sidebar-header d-flex justify-content-center align-items-center px-3 py-4">
        <img
          className="rounded-pill img-fluid"
          width="65"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSdfX8KOUWEGHqmYEX625RAql_k8JdAP1Rog&usqp=CAU"
          alt="Imagem do usuário"
        />
        <div>
          <h5 className="fs-6 mb-0">
            <Link className="btnSideBar" to={{ pathname: `/menulogado/perfil` }}>
              <span>
                {usuario.nome}
                Teste
              </span>
            </Link>
          </h5>
        </div>
      </div>
      {/* NAVBAR LATERAL - LINKS DE ACESSO */}
      <ul className="categories list-unstyled">
        <li className="">
          <i className="uil-estate fa-fw"></i>
          <Link className="btnSideBar" to="/menulogado/1">
            <img src="/img/dashboard.svg" alt="Dashboard" />
            <span>Dashboard</span>
          </Link>
        </li>
        <li>
          <i className="uil-map-marker"></i>
          <Link className="btnSideBar" to="/menulogado/relatorioVagas">
            <img src="/img/relatorio.svg" alt="Relatorio de Vagas" />
            <span>Relatorio de Vagas</span>
          </Link>
        </li>
        <li className="">
          <i className="uil-map-marker"></i>
          <Link className="btnSideBar" to="/menulogado/relatorioUso">
            <img src="/img/relatorio.svg" alt="Relatorio de Uso" />
            <span>Relatorio de Uso</span>
          </Link>
        </li>
        <li className="">
          <i className="uil-map-marker"></i>
          <Link className="btnSideBar" to="/menulogado/mapa">
            <img src="/img/mapa.svg" alt="Mapa" />
            <span>Mapa</span>
          </Link>
        </li>
        <li className="">
          <i className="uil-map-marker"></i>
          <Link className="btnSideBar" to="/menulogado/editarZona">
            <img src="/img/mapa.svg" alt="Mapa" />
            <span>Editar Zona</span>
          </Link>
        </li>
      </ul>
    </aside>
  );
}

export default NavbarLateral;
