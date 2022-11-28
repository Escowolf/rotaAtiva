Start transaction;
use rotaativa;
  
INSERT INTO `administrador` (`idadministrador`,`nome`,`cpf`,`email`,`datanasc`,`senha`)
VALUES
(1,"Buffy Cooley","409.178.650-22","Buffy@gmail.com","1975-07-24","4532134"),
(2,"Rahor","029.683.090-99","Rahor@gmail.com","1980-05-09","3432543"),
(3,"Teibieza","369.294.690-25","Teibieza@gmail.com","1995-06-15","342342345");
  

INSERT INTO `usuario` (`idusuario`,`cpf`,`nome`,`acessibilidade`,`email`,`senha`,`datanasc`,`ticket`)
VALUES
  (1,"172.495.494-87","Miriam Valenzuela","1","suscipit.est@hotmail.ca","TVG67VPB6MS","2003-07-11",4),
  (2,"377.148.018-76","Maxwell Thornton","1","eros.proin.ultrices@aol.ca","MSY92HCJ6TY","2009-07-27",6),
  (3,"422.039.759-53","Brett Keith","1","turpis.nulla.aliquet@google.ca","SVY82APS5DD","2022-04-30",7),
  (4,"297.769.650-34","Raja Montoya","0","gravida.praesent.eu@google.org","UXV22YTM3GX","2022-03-18",0),
  (5,"415.651.414-38","Jasmine Horne","0","est.mauris@protonmail.net","YFU68ILT1KQ","2009-02-8",6);


INSERT INTO `vaga` (`idvaga`,`rua_avenida`,`bairro`,`acessibilidade`,`nomeVaga`,`longitudeInicial`,`longitudeFinal`,`latitudeInicial`,`latitudeFinal`,`horarioUsoInica`,`horarioUsoFinal`,`estadoVaga`,`tempoTicket`)
VALUES
  (1,"Cundinamarca","Messejana","1","A",582512,698435,238663,1670784,"08:00:00","18:00:00","1",2),
  (2,"Saskatchewan","Pedras","1","B",605023,247620,773261,78026,"08:00:00","18:00:00","1",5),
  (3,"Heredia","Jabuti","1","C",482111,1026024,816287,1100786,"08:00:00","18:00:00","1",2),
  (4,"Wielkopolskie","Aldeota","1","D",689873,1075199,201218,1304796,"08:00:00","18:00:00","1",2),
  (5,"Vestfold og Telemark","Itaitinga","1","E",673375,425530,590523,695340,"08:00:00","18:00:00","1",5);


  
INSERT INTO `pagamento` (`idpagamento`,`dataCompra`,`valor`,`quantidadeTicket`,`usuario_idusuario`)
VALUES
  (1,"2022-01-16, ",7,1,1),
  (2,"2022-05-1, ",86,8,2),
  (3,"2022-06-15, ",75,12,3),
  (4,"2023-01-12, ",71,7,4),
  (5,"2023-08-23, ",23,1,5);
  
  INSERT INTO `tipopagamento` (`idTipoPagamento`,`tipopagamento`,`DescPagamento`,`pagamento_idpagamento`,`pagamento_usuario_idusuario`)
VALUES
  (1,"credito","sem molestie sodales.",1,1),
  (2,"debito","pretium neque. ",1,1),
  (3,"debito","commodo auctor velit.",1,1),
  (4,"credito","Integer tincidunt ",1,1),
  (5,"credito","per conubia nostral",1,1);
  
INSERT INTO `veiculo` values

  (1,"azul","MOA-2877","corola"),
  (2,"vermelhor","HPC-9087","uno"),
  (3,"rosa","NEY-5840","camaro"),
  (4,"azul","JUW-5533","fiesta"),
  (5,"vermelhor","NAK-1275","polo");
  
INSERT INTO `telefone` (`idtelefone`,`usuario_idusuario`,`telefone`)
VALUES
  (1,1,"(95)3489-4683"),
  (2,2,"(92)2444-7743"),
  (3,3,"(84)3515-4566"),
  (4,4,"(61)2058-7217"),
  (5,5,"(97)3735-4126");
  
INSERT INTO `transacao` (`idtransacao`,`vaga_idvaga`,`usuario_idusuario`,`ticketsUsados`,`entrada`,`saida`)
VALUES
  (1,1,1,7,"2022-07-11 13:41:14","2022-07-11 16:51:13"),
  (2,2,2,8,"2022-07-27 12:55:46","2022-07-27 17:48:01"),
  (3,3,3,10,"2022-03-18 13:23:08","2022-03-18 16:34:19"),
  (4,4,4,5,"2009-02-8 12:51:34","2009-02-8 16:09:07"),
  (5,5,5,4,"2003-07-11 12:21:59","2003-07-11 14:25:31");


  
INSERT INTO `usuario_has_veiculo` (`usuario_idusuario`,`veiculo_idveiculo`)
VALUES
	
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (5,5);
  
  
  commit;






