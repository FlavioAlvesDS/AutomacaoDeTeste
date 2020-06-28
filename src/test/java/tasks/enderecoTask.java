package tasks;

import org.openqa.selenium.WebDriver;
import adicionarProduto.endereco;

public class enderecoTask {
	private endereco address;
	
	public enderecoTask(WebDriver driver){
		this.address = new endereco(driver);
	}
	public void proceed() {
		this.address.proceed().click();
	}
}