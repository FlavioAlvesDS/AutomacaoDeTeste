package tasks;

import org.openqa.selenium.WebDriver;
import adicionarProduto.entregador;

public class entregaTask {
	private entregador shipping;
	
	public entregaTask(WebDriver driver){
		this.shipping = new entregador(driver);
	}
	public void agreeTerms() {
		this.shipping.check().click();
	}
	public void proceed() {
		this.shipping.proceed().click();
	}
}