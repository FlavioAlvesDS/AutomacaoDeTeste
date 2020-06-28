package casoDeTeste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import framework.drivers;
import framework.report;
import framework.screenshot;
import tasks.addProdutoAoCarrinhoTask;
import tasks.enderecoTask;
import tasks.novoUsuarioTask;
import tasks.pagamentoTask;
import tasks.entregaTask;
import verificationpoints.verificationPoint;

public class buyProductTestCase {
	private WebDriver driver;
	private addProdutoAoCarrinhoTask add;
	private enderecoTask address;
	private novoUsuarioTask newUser;
	private pagamentoTask payment;
	private entregaTask shipping;
	private verificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		report.startTest("Teste - Realizar uma compra com sucesso.");
		driver = drivers.getFirefoxDriver();
		add = new addProdutoAoCarrinhoTask(driver);
		address = new enderecoTask(driver);
		newUser = new novoUsuarioTask(driver);
		payment = new pagamentoTask(driver);
		shipping = new entregaTask(driver);
		verificationPoint = new verificationPoint(driver);
	}
	@Test
	public void testMain() {
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		report.log(Status.INFO, "O website foi carregado.", screenshot.capture(driver));
		add.addProductToCart();
		String name = add.productName();
		add.checkout();
		verificationPoint.checkProduct(name);
		String total = add.total();
		add.checkoutSummary();
		newUser.newAccount("flaviopereira@testeautomacao.com");
		String addressAccount = "Rua teste, 123";
		String cityAccount = "São Paulo";
		newUser.personalInformation("Flavio", "Pereira Alves", "teste123", addressAccount, cityAccount, "00000", "1189652389");
		newUser.submitAccount();
		verificationPoint.checkAddress(addressAccount,cityAccount);
		address.proceed();
		shipping.agreeTerms();
		shipping.proceed();
		verificationPoint.checkTotal(total);
		payment.payByBankWire();
		payment.proceed();
		verificationPoint.checkOrder();
		}
	@After
	public void tearDown() {
		driver.quit();
	}
}