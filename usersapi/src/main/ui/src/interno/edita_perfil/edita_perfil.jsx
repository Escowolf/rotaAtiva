import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import UserService from '../../service/users';
import './edita_perfil.css'


export function EditaPerfil() {
    const userService = new UserService();
    const [usuario, setUsuario] = useState({
        nome:""
    });
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [cpf, setCpf] = useState("");
    const [datanasc, setDatanasc] = useState("");

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
            let login = resp.data.find((p) => p.id == id);
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
        let id = localStorage.getItem("usuarioLogado");
        userService.putUsuario(id, {...usuario, nome, cpf, email, datanasc}).then(alert("cadastrado com sucesso"));
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