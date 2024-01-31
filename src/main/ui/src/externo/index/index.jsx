import "./index.css";
import CaixaFormularioLogin from "../../components/caixaFormularioLogin/caixaFormularioLogin";
import { useState } from "react";
import { log } from "../../dados/dadosFormulario";
import { Link, useNavigate } from "react-router-dom";
import Alert from '@mui/material/Alert';
import { Collapse } from "@mui/material";
import { getAuth, signInWithEmailAndPassword, getIdToken,onAuthStateChanged } from "firebase/auth";
import { app } from "../../utils/firebaseUtils";

export function Index() {
  const auth = getAuth(app);

  const navigate = useNavigate();
  const [email, setEmail] = useState();
  const [senha, setSenha] = useState();
  const [alert, setAlert] = useState(false);
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

    signInWithEmailAndPassword(auth, email, senha)
  .then((userCredential) => {
      getIdToken(auth.currentUser)
        .then((idToken) => {
          localStorage.setItem("token", JSON.stringify(idToken));
          onAuthStateChanged(auth, (user) => {
            if (user) {
              localStorage.setItem("usuarioLogado", JSON.stringify(user.uid));
              navigate(`/menulogado/${user.uid}`, { replace: true });
            }
          })
        })}).catch(function (error) {
          if (error.response) {
            setAlert(true)
          }
        })
    }

  return (
      <section className="principal">
        <div className="flex">
          <div className="principal_lado_esq">
            <div className="principal_lado_esq_texto">
              <h2>Encontre sua</h2>
              <h2>vaga aqui</h2>
              <p>
                Faça parte do grupo de motoristas que nos aprovam
                como Aplicação mais completa para quem deseja
                localizar zona azul em Fortaleza!
              </p>

              <Link to="/cadastro" className="botao_alerta">Cadastre-se</Link>
            </div>
          </div>
          <div className="principal_lado_dir">
            <div className="login_caixa">
              <h3>Inicie sua sessão</h3>
              <Collapse in={alert}>
                <Alert severity="error" onClose={() => { setAlert(false) }}>Email/senha incorreta, tente novamente!</Alert>
              </Collapse>
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

                <input
                  className="login_formulario_botao"
                  type="submit"
                  value="Logar"
                />

                <div className="login_formulario_enviar">
                  <input type="checkbox" value="" />
                  <span>Lembrar</span>
                  <Link to="/recuperarSenha">Esqueceu a senha?</Link>

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
          </div>
        </div>
      </section>
    );
  }