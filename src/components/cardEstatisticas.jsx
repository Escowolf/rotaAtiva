function cardsEstatisticas(props) {
    return (
        <div>
            <label className="#" htmlFor={props.name}>{props.label}</label>
            <div className={props.class}>
                <input
                    name={props.name}
                    id={props.id}
                    type={props.type}
                    placeholder={props.placeholder}
                    required={props.required}
                    onChange={e => props.evento(e.target.value)}
                />
            </div>
        </div>
    )
}

export default cardsEstatisticas;