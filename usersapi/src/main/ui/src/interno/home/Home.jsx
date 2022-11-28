import Sidebar from "./Componentes/sidebar/Sidebar";
import Topbar from "./Componentes/topbar/Topbar";
import { Navigate, Outlet,  } from "react-router-dom";
{
  /* https://fisqmr.csb.app/login */
}

export function Home() {
  var id = localStorage.getItem("usuarioLogado");

  return (
    <>
      {id != null 
        ?
        <>
          <Sidebar />
          <Topbar />
          <Outlet />
        </>
        :
        <Navigate to="/" replace={true} />
      }

    </>
  );
}

export default Home;
