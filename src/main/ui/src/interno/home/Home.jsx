import Sidebar from "./Componentes/sidebar/Sidebar";
import Topbar from "./Componentes/topbar/Topbar";
import { Navigate, Outlet,  } from "react-router-dom";

export function Home() {
  var id = localStorage.getItem("token");

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
