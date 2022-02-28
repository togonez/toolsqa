#language: pt
Funcionalidade: Inserir linha na tabela
	Eu como usuário quero acessar o site
	E inserir uma nova linha na tabela
	para verificar a inserção no banco de dados

@deveInserirLinhaNaTabela
Esquema do Cenário: Deve inserir uma linha na tabela
	Dado que eu acessei a página e cliquei no botão Add
	E preencho os campos com "<primeiroNome>", "<ultimoNome>", "<email>", "<idade>", "<salario>" e "<departamento>"
	Quando clicar em submit
	Então verifico na tabela a inserção dos valores "<primeiroNome>","<ultimoNome>", "<email>", "<idade>", "<salario>" e "<departamento>"
	
	Exemplos:
	| primeiroNome		    | ultimoNome | email               | idade  | salario | departamento |
	| Ipsum 							| Lorem 		 | email@email.com     | 28 	  | 5000    | master 			 |
	| Ipsum2							| Lorem2 		 | email2@email.com    | 29 	  | 8000    | master 			 |