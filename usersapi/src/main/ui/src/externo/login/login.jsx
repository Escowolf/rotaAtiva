import { useState } from "react";
import CaixaFormularioLogin from "../../components/caixaFormularioLogin/caixaFormularioLogin";
import "./login.css";
import { log } from "../../dados/dadosFormulario";
import { Link, useNavigate } from "react-router-dom";
import UserService from "../../service/users";
import { Cabecalho } from "../cabecalho/cabecalho";
import { login } from "../../service/autenticacao";
import API from "../../service/api";

export function Login() {
  const userService = new UserService();

  const navigate = useNavigate();
  const [email, setEmail] = useState();
  const [senha, setSenha] = useState();

  const dados = [
    {
      campo: email,
      evento: setEmail,
    },
    {
      campo: senha,
      evento: setSenha,
    },
  ];

  function logar(e) {
    e.preventDefault();

    // login.then((resp) => {
    //   API.defaults.headers.authorization = `Bearer ${resp.token}`
    //   localStorage.setItem("Token", JSON.stringify(resp.token));
    //   localStorage.setItem("usuarioLogado", JSON.stringify(resp.id));
    //   navigate(`/menulogado/${resp.id}`, { replace: true });
    // })
    
    userService.getUsuario().then((resp) => {
      let login = resp.data.find((p) => p.email == email && p.senha == senha);
      if (login) {
        console.log(resp)
        API.defaults.headers.authorization = `Bearer ${resp.token}`
        localStorage.setItem("Token", JSON.stringify(login.token));
        localStorage.setItem("usuarioLogado", JSON.stringify(login.id));
        JSON.parse(localStorage.getItem("usuarioLogado"));
        navigate(`/menulogado/${login.id}`, { replace: true });
      }
    })

    // userService.getUsuario().then((resp) => {
    //   let login = resp.data.find((p) => p.email == email && p.senha == senha);
    //   if (login) {
    //     console.log(login);
    //     localStorage.setItem("usuarioLogado", JSON.stringify(login.id));
    //     JSON.parse(localStorage.getItem("usuarioLogado"));
    //     navigate(`/menulogado/${login.id}`, { replace: true });
    //   }
    // });
  }

  return (
    <>
      <Cabecalho />
      <section className="login">
        <div className="container login_caixa">
          <h3>Inicie sua sessão</h3>

          <form onSubmit={logar} className="login_formulario">
            {log().map((item) => {
              return (
                <CaixaFormularioLogin
                  key={item.position}
                  name={item.name}
                  id={item.id}
                  type={item.type}
                  placeholder={item.placeholder}
                  required={item.required}
                  class={item.class}
                  label={item.label}
                  campo={dados[item.position].campo}
                  evento={(v) => dados[item.position].evento(v)}
                  img={item.img}
                />
              );
            })}

            <div className="login_formulario_enviar">
              <Link to="/recuperarSenha">
                <span>Esqueceu a senha?</span>
              </Link>
              <input
                className="login_formulario_botao"
                type="submit"
                value="Logar"
              />
            </div>
            <br />
            <div className="login_formulario_info">
              <p>
                <span>Não tem cadastro?</span>
                <Link to="/cadastro">Cadastre-se</Link>
              </p>
            </div>
          </form>
        </div>
      </section>
    </>
  );
}
