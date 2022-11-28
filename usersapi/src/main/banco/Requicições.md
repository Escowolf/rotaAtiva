#GET Relatorio de Vagas
http://localhost:8080/vaga/relatorio

#GET Relatorio de Usuarios
http://localhost:8080/vaga/relatorioPorVaga?nome=a

#GET Vagas Mais Usadas
http://localhost:8080/vaga/relatorioRank

#GET Buscar Adm
http://localhost:8080/administrador/buscar?email=Rahor@gmail.com&senha=3432543

#POST Cadastrar Adm
http://localhost:8080/administrador/cadastrar
Paremtro:
{
    "idadministrador": 6,
    "nome": "Buffy Cooley",
    "cpf": "409.178.650-22",
    "email": "Buffy@gmail.com",
    "datanasc": "1975-07-24",
    "senha": 4532134
  }

#GET Buscar Vaga
http://localhost:8080/vaga/buscar?nome=A

#Post Cadastar Vaga?
http://localhost:8080/vaga
Paremtro:
{
    "idvaga": 6,
    "rua_avenida": "Cundinamarca",
    "bairro": "Messejana",
    "acessibilidade": "1",
    "tempoticket": 2,
    "nomeVaga": "A",
    "longitudeFinal": 698435,
    "latitudeInicial": 238663,
    "latitudeFinal": 1670784,
    "horarioUsoInica": "08:00:00",
    "horarioUsoFinal": "18:00:00",
    "estadoVaga": true,
    "longitudeInicial": 582512
  }

#Get Verificar se a vaga está ativa?