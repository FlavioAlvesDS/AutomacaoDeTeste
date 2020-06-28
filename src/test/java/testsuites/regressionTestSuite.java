package testsuites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import framework.report;
import casoDeTeste.buyProductTestCase;;

@RunWith(Suite.class)
@SuiteClasses({
	buyProductTestCase.class
})
public class regressionTestSuite {
	@BeforeClass
	public static void initTest() {
		report.create("Teste de Automação ", "Teste de Automacao");
	}
	@AfterClass
	public static void endTest() {
		report.close();
	}
}