package pages;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormularioPage {
	private WebDriver driver = new ChromeDriver();
	private String url = "https://demoqa.com/webtables";
	private String path = "./target/tests/passed/";
	private Date dataHoraAtual = new Date();
	private String data = new SimpleDateFormat("ddMMyyyy HHmmss").format(dataHoraAtual);
	private String name = data + ".txt";

	public void gravarLogs(String descricao) throws IOException {
		FileWriter arq = new FileWriter(path + name, true);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("## LOG: " + descricao + "%n");
		arq.close();
	}

	public void inicializa() throws Exception {
		try {
			driver.get(url);
			gravarLogs("Navegação bem sucedida para a url:  " + url);
			driver.manage().window().maximize();
			gravarLogs("Janela maximizada");
		} catch (Exception ex) {
			String exceptionData = ex.getCause().getMessage();
			gravarLogs("Erro ao acessar a url : " + url + " with the error as: " + exceptionData);
			finaliza();
		}
	}

	public void finaliza() throws Exception {
		driver.close();
		gravarLogs("Driver fechado");
		driver.quit();
		gravarLogs("Browser fechado");
	}

	private WebElement getBotaoAdd() {
		return driver.findElement(By.id("addNewRecordButton"));
	}

	public void clicarBotaoAdd() throws Throwable {
		getBotaoAdd().click();
		gravarLogs("Botão clicado: Add");
	}
	
	private WebElement getBotaoSubmit() {
		return driver.findElement(By.id("submit"));
	}

	public void clicarBotaoSubmit() throws Throwable {
		getBotaoSubmit().click();
		gravarLogs("Botão clicado: Submit");
	}

	private void getPrimeiroNome(String primeiroNome) throws Throwable {
		try {
			driver.findElement(By.id("firstName")).sendKeys(primeiroNome);
			gravarLogs("Primeiro Nome digitado: " + primeiroNome);
		} catch (Exception e) {
			String exceptionData = e.getCause().getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}

	public void preencherInputPrimeiroNome(String primeiroNome) throws Throwable {
		getPrimeiroNome(primeiroNome);
	}
	
	private void getUltimoNome(String ultimoNome) throws Throwable {
		try {
			driver.findElement(By.id("lastName")).sendKeys(ultimoNome);
			gravarLogs("Último Nome digitado: " + ultimoNome);
		} catch (Exception e) {
			String exceptionData = e.getCause().getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void preencherInputUltimoNome(String ultimoNome) throws Throwable {
		getUltimoNome(ultimoNome);
	}
	
	private void getEmail(String email) throws Throwable {
		try {
			driver.findElement(By.id("userEmail")).sendKeys(email);
			gravarLogs("Email digitado: " + email);
		} catch (Exception e) {
			String exceptionData = e.getCause().getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void preencherEmail(String email) throws Throwable {
		getEmail(email);
	}
	
	private void getIdade(String idade) throws Throwable {
		try {
			driver.findElement(By.id("age")).sendKeys(idade);
			gravarLogs("Idade digitada: " + idade);
		} catch (Exception e) {
			String exceptionData = e.getCause().getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void preencherIdade(String idade) throws Throwable {
		getIdade(idade);
	}
	
	private void getSalario(String salario) throws Throwable {
		try {
			driver.findElement(By.id("salary")).sendKeys(salario);
			gravarLogs("Salário digitado: " + salario);
		} catch (Exception e) {
			String exceptionData = e.getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void preencherSalario(String salario) throws Throwable {
		getSalario(salario);
	}
	
	private void getDepartamento(String departamento) throws Throwable {
		try {
			driver.findElement(By.id("department")).sendKeys(departamento);
			gravarLogs("Departamento digitado: " + departamento);
		} catch (Exception e) {
			String exceptionData = e.getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void preencherDepartamento(String departamento) throws Throwable {
		getDepartamento(departamento);
	}
	
	private void getTabelaPreenchida(String primeiroNome, String ultimoNome, String email, String idade, String salario, String departamento) throws Throwable {
		try {
			String firstName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][1][text()='" + primeiroNome + "']")).getText();
			assertEquals(firstName, primeiroNome);
			gravarLogs("Primeiro nome validado: Digitado: " + primeiroNome + " Encontrado: " + firstName);
			
			String lastName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][2][text()='" + ultimoNome + "']")).getText();
			assertEquals(lastName, ultimoNome);
			gravarLogs("Último nome validado: Digitado: " + ultimoNome + " Encontrado: " + lastName);
			
			String email1 = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][4][text()='" + email + "']")).getText();
			assertEquals(email1, email);
			gravarLogs("E-mail validado: Digitado: " + email + " Encontrado: " + email1);
			
			String age = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][3][text()='" + idade + "']")).getText();
			assertEquals(email1, email);
			gravarLogs("Idade validado: Digitado: " + age + " Encontrado: " + idade);
			
			String salary = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][5][text()='" + salario + "']")).getText();
			assertEquals(salary, salario);
			gravarLogs("Salário validado: Digitado: " + salary + " Encontrado: " + salario);
			
			String department = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][6][text()='" + departamento + "']")).getText();
			assertEquals(department, departamento);
			gravarLogs("Departamento validado: Digitado: " + department + " Encontrado: " + departamento);
			
		} catch (Exception e) {
			String exceptionData = e.getMessage();
			gravarLogs("Erro : " + exceptionData);
			finaliza();
		}
	}
	
	public void validarTabela(String primeiroNome, String ultimoNome, String email, String idade, String salario, String departamento) throws Throwable {
		getTabelaPreenchida(primeiroNome, ultimoNome, email, idade, salario, departamento);
	}
	
}
