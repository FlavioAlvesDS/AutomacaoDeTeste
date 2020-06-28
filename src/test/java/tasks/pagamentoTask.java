package tasks;

import org.openqa.selenium.WebDriver;
import adicionarProduto.pagamento;

public class pagamentoTask {
	private pagamento payment;
	
	public pagamentoTask(WebDriver driver){
		this.payment = new pagamento(driver);
	}
	public void payByBankWire() {
		this.payment.payByBankWire().click();
	}
	public void proceed() {
		this.payment.proceed().click();
	}
}