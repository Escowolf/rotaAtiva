import { Alert, Collapse } from '@mui/material';
import { useEffect, useState } from 'react';
import AdmService from '../../service/adm';
import UserService from '../../service/users';
import './edita_perfil.css'


export function EditaPerfil() {
    const userService = new UserService();
    const admService = new AdmService();
    const [usuario, setUsuario] = useState({
        nome:""
    });
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [cpf, setCpf] = useState("");
    const [datanasc, setDatanasc] = useState("");
    const [alert, setAlert] = useState(false);
    const [alertOk, setAlertOK] = useState(false);

    const dados = [
        {
            campo: nome,
            evento: setNome
        },
        {
            campo: email,
            evento: setEmail
        },
        {
            campo: cpf,
            evento: setCpf
        },
        {
            campo: datanasc,
            evento: setDatanasc
        }
    ]

    const infos = ["Nome", "E-mail", "CPF", "Data de Nascimento"]

    useEffect(() => {
        userService.getUsuario().then((resp) => {
            let id = localStorage.getItem("usuarioLogado")
            let login = resp.data.find((p) => p.id === id);
            console.log(login)
            if (login) {
                setUsuario(login)
                setNome(login.nome)
                setEmail(login.email);
                setCpf(login.cpf);
                setDatanasc(login.nascimento);
            }
            
        })
    }, [])

    function salvar(e) {
        e.preventDefault();
        admService.editar({...usuario, nome, cpf, email, datanasc}).then(()=>{setAlertOK(true); setAlert(false);}).catch(function(error){
            if(error.response){
              setAlert(true);
              setAlertOK(false);
            }
          });
    }

    return (
        <>
            <div className="margem-esq">
                <div className="containerUser space">
                    <div className="flex w-full items-center">
                        <div className="flex items-center text-3xl">
                            {usuario.nome}
                        </div>
                        <div className="ml-auto sm:flex hidden items-center justify-end"></div>
                    </div>
                    <div className="flex items-center space-x-3 sm:mt-7 mt-4">

                    </div>
                </div>
                <Collapse in={alert}>
                    <Alert severity="error" onClose={() => {setAlert(false)}}>Ocorreu um erro, tente novamente, mais tarde!</Alert>
                </Collapse>
                <Collapse in={alertOk}>
                    <Alert onClose={() => {setAlertOK(false)}}>Cadastro realizado com sucesso!</Alert>
                </Collapse>
                <form className="p-3 edita_perfil" onSubmit={salvar}>

                    {infos.map((info, index) => {
                        return (
                            <div className="containerInfos formulario bordaInferiorCor">
                                <div className="content p-3 bordaCompleta dados">
                                    <p className="mb-0 ">{info}</p>

                                    <input
                                        name={info}
                                        id={index}
                                        type="text"
                                        onChange={e => dados[index].evento(e.target.value)}
                                        value={dados[index].campo}
                                    />

                                </div>

                            </div>
                        )
                    })}
                    <div className="cadastro_formulario_enviar">
                        <input
                            className="cadastro_formulario_botao"
                            type="submit"
                            value="Salvar"
                        />
                    </div>

                </form>
            </div>
        </>
    )
}