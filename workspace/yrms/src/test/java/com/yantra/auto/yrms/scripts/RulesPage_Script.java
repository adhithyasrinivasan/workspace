package com.yantra.auto.yrms.scripts;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.apirequest.RMSRequest;
import com.yantra.auto.yrms.apirequest.RestService;
import com.yantra.auto.yrms.apirequest.RestTransaction;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;

public class RulesPage_Script extends BaseClass
{
	@Test(priority=0,testName="NAVIGATE_TO_RULE_LIST_YES")
	public void testNavigateToRulesPage() throws InterruptedException
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
	}
	@Test(priority=1,testName="NAVIGATE_TO_ADD_RULE_PAGE_YES")
	public void testNavigateToAddRulePage() throws InterruptedException
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
	}
	@Test(priority=2,enabled=true,testName="TEST_MASTER_HOLDER_RULE_YES")
	public void testMasterHolderNameRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName="MasterHolderName"+_rulesPage.getUniqueRuleName();
		String riskScore="175";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER NAME","CUSTOM",RMSRequest.maccountInputData.get(0).get(9),riskScore);
		try{RestTransaction.initiateYrmsTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_rulesPage.disableRule(ruleName);
	}
}
