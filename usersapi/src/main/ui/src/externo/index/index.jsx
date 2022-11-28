import "./index.css";
export function Index() {
  return (
    <section className="principal">
      <div className="container principal_caixa">
        <div className="principal_texto">
          <h2>Encontre sua vaga aqui</h2>
          <span>
            Faça parte do grupo de motoristas que nos aprovam como Aplicação
            mais completa para quem deseja localizar zona azul em Fortaleza!
          </span>
        </div>

        <img src="/img/maps.png" alt="mapa da zona azul" />
      </div>
    </section>
  );
}
