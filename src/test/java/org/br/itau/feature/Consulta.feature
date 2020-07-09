# language: pt
Funcionalidade: consulta de veiculos

  Cenario: Crie uma consulta que retorne uma lista com pelo menos 3 carros
  usados da mesma marca modelo, os demais critérios da consulta são a sua escolha
    Dado que eu esteja na pagina incial do Icarros
    Quando eu selecionar a marca "Audi" e o modelo "TT"
    E eu clicar em buscar
    Entao eu visualizarei uma lista com os mais de "3" carros

  Cenario: Valide o modelo e o valor à vista do primeiro e do segundo carro da lista produzida pela consulta
    Dado que eu esteja na pagina incial do Icarros
    Quando eu selecionar a marca "Audi" e o modelo "TT"
    E eu clicar em buscar
    Entao eu visualizarei o valor a vista "R$ 75.900,00" do modelo "Audi TT 2.0 TFSI S Tronic" e o valor "R$ 207.800,00" a vista do modelo "Audi TT 2.0 TFSI Ambition S Tronic"

  Cenario: O script deve ler a lista de resultados e criar um arquivo de dados contendo marca modelo, ano, km, cor,
  câmbio e valor à vista de cada veiculo retornado (apenas da primeira página de retorno)
    Dado que eu esteja na pagina incial do Icarros
    Quando eu selecionar a marca "Audi" e o modelo "TT"
    E eu clicar em buscar
    Entao eu poderei ver os dados salvos em um arquivo externo "src/test/resources/carros.txt" com dados da primeira pagina
