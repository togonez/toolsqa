package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.FormularioPage;

public class FormularioSteps {
	FormularioPage formularioPage = new FormularioPage();
	
	@Dado("que eu acessei a página e cliquei no botão Add")
	public void queEuAcesseiAPáginaECliqueiNoBotãoAdd() throws Throwable {
		formularioPage.inicializa();
		formularioPage.clicarBotaoAdd();
	}
	@E("preencho os campos com {string}, {string}, {string}, {string}, {string} e {string}")
	public void preenchoOsCamposComE(String primeiroNome, String ultimoNome, String email, String idade, String salario, String departamento) throws Throwable {
		formularioPage.preencherInputPrimeiroNome(primeiroNome);
		formularioPage.preencherInputUltimoNome(ultimoNome);
		formularioPage.preencherEmail(email);
		formularioPage.preencherIdade(idade);
		formularioPage.preencherSalario(salario);
		formularioPage.preencherDepartamento(departamento);
	}
	@Quando("clicar em submit")
	public void clicarEmSubmit() throws Throwable {
		formularioPage.clicarBotaoSubmit();
	}
	@Então("verifico na tabela a inserção dos valores {string},{string}, {string}, {string}, {string} e {string}")
	public void verificoNaTabelaAInserçãoDosValores(String primeiroNome, String ultimoNome, String email, String idade, String salario, String departamento) throws Throwable {
		formularioPage.validarTabela(primeiroNome, ultimoNome, email, idade, salario, departamento);
		formularioPage.finaliza();
	}
	
	
}
