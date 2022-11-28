import { Link } from 'react-router-dom';
import './cabecalho.css';

export function Cabecalho() {
    let id = localStorage.getItem("usuarioLogado")
    return (
        <header className="cabecalho">
            <div className='container cabecalho_caixa'>
                <div className='cabecalho_logo'>
                    <Link to="/">
                        <img src="/img/logo.png" alt="logo" />
                    </Link>
                </div>
                <nav className='cabecalho_menu'>
                    <ul>
                        {id != null
                            ?
                            <li className='cabecalho_menu-item'>
                                <Link to={`/menulogado/${id}`}>
                                    <img src="/img/right-to-bracket-solid.svg" alt="entrar" />
                                    <span>Entrar</span>
                                </Link>
                            </li>
                            :
                            <li className='cabecalho_menu-item'>
                                <Link to="/login">
                                    <img src="/img/login.svg" alt="login" />
                                    <span>Login</span>
                                </Link>
                            </li>
                        }
                    </ul>
                </nav>
            </div>
        </header>
    )
}