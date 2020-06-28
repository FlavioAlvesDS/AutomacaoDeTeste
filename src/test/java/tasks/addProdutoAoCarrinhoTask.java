package tasks;

import org.openqa.selenium.WebDriver;
import adicionarProduto.addProdutoAoCarrinho;

public class addProdutoAoCarrinhoTask {
	private addProdutoAoCarrinho product;
	
	public addProdutoAoCarrinhoTask(WebDriver driver){
		this.product = new addProdutoAoCarrinho(driver);
	}
	public void addProductToCart() {
		product.addToCart().click();
	}
	public String total() {
		return product.total().getText();//$18.51
	}
	public void checkout() {
		product.proceedToCheckout().click();
	}
	public void checkoutSummary() {
		product.proceedToCheckoutSummary().click();
	}
	public String productName() {
		return product.productNameCheck().getText();
	}
}