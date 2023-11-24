import './caixaFormulario.css'

function CaixaFormularioLogin(props) {
    return (
        <>
        <label htmlFor={props.name}>{props.label}</label>
        <div className={props.class}>
            <div  className="formulario_caixa-dados flex">
                    <input
                        name={props.name}
                        id={props.id}
                        type={props.type}
                        placeholder={props.placeholder}
                        required={props.required}
                        onChange={e => props.evento(e.target.value)}
                        value={props.campo}
                    />
            
            <div  className="formulario_caixa-img">
                <img src={props.img} alt="" />
            </div>
            </div>
        </div>
        </>
    )
}

export default CaixaFormularioLogin;