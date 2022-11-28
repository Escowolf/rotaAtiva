use rotaativa;
select v.rua_avenida, v.bairro  from vaga v;
select v.nome, v.entrada,v.saida  from vaga v order by nome;

select count(v.entrada) as quantidade_uso from vaga v where v.saida > "2022-06-11";

select timediff( v.saida,v.entrada) as horario_vaga from vaga v;#vai usar esse
select  sec_to_time((sum(time_to_sec(timediff( v.saida,v.entrada))))) as horario_total from vaga v;



select nome,email from usuario;
select * from telefone;
select modelo from veiculo;

select u.nome,u.email ,t.telefone,v.cor, v.placa, v.modelo from usuario u 
join usuario_has_veiculo h
on u.idusuario = h.usuario_idusuario
join veiculo v
on v.idveiculo = h.veiculo_idveiculo
join telefone t
on u.idusuario = t.usuario_idusuario
order by nome ;

select * from usuario_has_veiculo;



select v.rua_avenida, v.bairro  from vaga v;

select v.bairro,u.nome as nome_usuario,v.nome as nome_vaga,p.valor,p.dataCompra from vaga v
join usuario_has_vaga h
on v.idvaga = h.vaga_idvaga
join usuario u
on u.idusuario = h.usuario_idusuario
join pagamento p
on u.idusuario = p.usuario_idusuario
#where p.dataCompra >= "2022-05-01" and p.dataCompra <= "2022-10-01"
order by p.dataCompra;

select sum(p.valor) as valor_total from vaga v
join usuario_has_vaga h
on v.idvaga = h.vaga_idvaga
join usuario u
on u.idusuario = h.usuario_idusuario
join pagamento p
on u.idusuario = p.usuario_idusuario
order by u.nome;



#total recebido por vagas
select * from pagamento;
select * from vaga;
select * from usuario_has_vaga;

select u.idusuario, u.nome, p.quantidadeTicket,p.valor  from pagamento p
join usuario u
on u.idusuario = p.usuario_idusuario;

select v.nome as nome_vaga,sum(p.valor) from vaga v
join usuario_has_vaga h
on v.idvaga = h.vaga_idvaga
join usuario u
on u.idusuario = h.usuario_idusuario
join pagamento p
on u.idusuario = p.usuario_idusuario
#where p.dataCompra >= "2022-05-01" and p.dataCompra <= "2022-10-01"  
group by v.nome# u.nome
order by v.nome;     

############################################
select * from vaga order by nomeVaga;
select * from usuario order by nome;
select * from pagamento order by usuario_idusuario;
select * from transacao;

##########Ultima atualização
select t.idtransacao,t.usuario_idusuario,t.vaga_idvaga ,v.nome,u.nome,t.ticketsUsados,t.entrada,t.saida,timediff(t.saida,t.entrada) as tempoUso from usuario u
join transacao t
on u.idusuario = t.usuario_idusuario
join vaga v
on v.idvaga = t.vaga_idvaga
join usuario_has_veiculo hv
on u.idusuario = hv.usuario_idusuario
join veiculo ve
on ve.idveiculo = hv.veiculo_idveiculo
order by v.nome;
########Requisição 01
select v.nomeVaga,sum(t.ticketsUsados) as ticketsUsados ,count(ve.placa) as total_veiculos,sec_to_time((sum(time_to_sec(timediff( t.saida,t.entrada))))) as tempoUso from usuario u
join transacao as t
on u.idusuario = t.usuario_idusuario
join vaga v
on v.idvaga = t.vaga_idvaga
join usuario_has_veiculo hv
on u.idusuario = hv.usuario_idusuario
join veiculo ve
on ve.idveiculo = hv.veiculo_idveiculo
group by v.nomeVaga
order by v.nomeVaga;

########Requisição 02

select v.nomeVaga,u.nome,timediff( t.saida,t.entrada) as tempoUso,t.ticketsUsados as ticketsUsados ,ve.modelo,ve.placa,u.acessibilidade from usuario u
join transacao t
on u.idusuario = t.usuario_idusuario
join vaga v
on v.idvaga = t.vaga_idvaga
join usuario_has_veiculo hv
on u.idusuario = hv.usuario_idusuario
join veiculo ve
on ve.idveiculo = hv.veiculo_idveiculo 
where v.nomeVaga = "B"
order by v.nomeVaga;

########Requisição 03
select v.nomeVaga,sum(t.ticketsUsados) as ticketsUsados ,count(ve.placa) as total_veiculos,sec_to_time((sum(time_to_sec(timediff( t.saida,t.entrada))))) as tempoUso from usuario u
join transacao t
on u.idusuario = t.usuario_idusuario
join vaga v
on v.idvaga = t.vaga_idvaga
join usuario_has_veiculo hv
on u.idusuario = hv.usuario_idusuario
join veiculo ve
on ve.idveiculo = hv.veiculo_idveiculo
group by v.nomeVaga
order by tempoUso desc;

########BuscarAdm
select * from administrador where email = "Rahor@gmail.com" and senha = 3432543;

########BuscarVagaCompleta
select idvaga,nomeVaga,rua_avenida,bairro,acessibilidade,longitudeInicial,longitudeFinal,latitudeInicial,latitudeFinal,horarioUsoInica,horarioUsoFinal,tipoVaga,tempoTicket,estadoVaga from vaga v
join tipoVaga tv
on tv.idtipovaga = v.tipoVaga_idtipoVaga
join tempoTicket tt
on tt.idtempoTicket = v.tempoTicket_idtempoTicket
where nomeVaga = "A";

select * from vaga;

########BuscarVagaUnica
select nomeVaga,estadoVaga from vaga where nomeVaga = "A";

########CadastarVaga
select * from vaga;
 



select va.nome as nome_vaga,sum(p.quantidadeTicket) as credito,count(ve.placa) as total_veiculos ,sec_to_time((sum(time_to_sec(timediff( t.saida,t.entrada))))) as tempo_uso from usuario u 
join usuario_has_veiculo h
on u.idusuario = h.usuario_idusuario
join veiculo ve
on ve.idveiculo = h.veiculo_idveiculo
join telefone t
on u.idusuario = t.usuario_idusuario
join usuario_has_vaga hv
on u.idusuario = hv.usuario_idusuario
join vaga va
on va.idvaga = hv.vaga_idvaga
join pagamento p
on u.idusuario = p.usuario_idusuario
group by va.nome,tempo_uso
order by va.nome ; 

###########Postegres

select * from usuario u;

INSERT INTO USUARIO  (idUsuario, acessibilidade, cpf,email,nome,senha,ticket,datanasc) 
VALUES(6,1,'566-555-666-78','aluno@email.com', 'jose',321,10,"2002-05-06")  ;
select idUsuario, acessibilidade, cpf,email,nome,senha,ticket,datanasc from usuario where idUsuario = 7  ;

UPDATE usuario 
set 
nome = "fernanda"
where idUsuario = 1;

###########Tela cadastro
select * from usuario;

select v.nomevaga,tv.tipoVaga,tt.tempoTicket from vaga v 
join tipoVaga tv
on tv.idtipoVaga = v.tipoVaga_idtipoVaga
join tempoTicket tt
on tt.idtempoTicket = v.tempoTicket_idtempoTicket;

DELETE FROM usuario
WHERE idusuario = 5;


  