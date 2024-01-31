import { Link } from 'react-router-dom';
import './cabecalho.css';

export function Cabecalho() {
    return (
        <header className="cabecalho">
            <div className='container cabecalho_caixa'>
                <div className='cabecalho_logo'>
                    <Link to="/">
                        <img src="/img/logo.png" alt="logo" />
                    </Link>
                </div>
                <div className='cabecalho_menu'>
                    <ul>
                        <li>
                            <Link to="/contato">
                                Contato
                            </Link>
                        </li>

                    </ul>
                </div>
            </div>
        </header>
    )
}