import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class Library
{
	static RequestSpecification requestSpecification=RestAssured.given();
	public static void callToken()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		//requestSpecification.baseUri("https://account.sonyentertainmentnetwork.com/liquid/cam/account/giftcard/redeem-gift-card-flow.action?execution=e1s1&f=");
		Map parametersMap=new HashMap();
		parametersMap.put("captcha_provider","google:recaptcha-v2");
		parametersMap.put("client_id","71a7beb8-f21a-47d9-a604-2e71bee24fe0");
		parametersMap.put("client_secret","xSk2YI8qJqZfeLQv");
		parametersMap.put("grant_type","captcha");
		parametersMap.put("valid_for","adhithyasrinivasan@outlook.in");
		parametersMap.put("scope","oauth:authenticate");
		parametersMap.put("response_token","03ADlfD198rlA9pFjxUhIqfkoN60Xo1mCOU-phIZ888D9LQ-3tMEoUna7heMg-0gnaLx4aZSPN88ayGEm1olXq0ZgjwxD6PWMtF-b36W9aRZQ0PZNabXmam4ZrjGOQPWCUiTkPEN8N5dL1GtD9qUcjhluIB8WQrhthjy2mGCh2zfFgm0qjM02vWbcReEJT6tryle5Z7WwBsDG4P1u9NhESYFjM0GyI3KxAQZgscW-E1hPdrnt3MSOVQYsAUtkfl0f82ZuC6RMlzJ_PpLMIqV5AtwglStK7IjPUfIqwZrmDY0IXsFOfMlme4mI");
		Response response = requestSpecification.formParameters(parametersMap).post("https://auth.api.sonyentertainmentnetwork.com/2.0/oauth/token");
		System.out.println(response.asString());
	}
	public static void callSSO()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		//requestSpecification.baseUri("https://account.sonyentertainmentnetwork.com/liquid/cam/account/giftcard/redeem-gift-card-flow.action?execution=e1s1&f=");
		Map parametersMap=new HashMap();
		parametersMap.put("authentication_type","password");
		parametersMap.put("client_id","71a7beb8-f21a-47d9-a604-2e71bee24fe0");
		parametersMap.put("password","Adhithya12");
		parametersMap.put("username","adhithyasrinivasan@outlook.in");
		//
		requestSpecification.header("Authorization","Bearer 935641fb-6515-4b4d-b8e5-0dda3833cc79");
		Response response = requestSpecification.formParameters(parametersMap).post("https://auth.api.sonyentertainmentnetwork.com/2.0/ssocookie");
		System.out.println(response.asString());
	}
	
	
	public static void callCaptcha()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		//requestSpecification.baseUri("https://account.sonyentertainmentnetwork.com/liquid/cam/account/giftcard/redeem-gift-card-flow.action?execution=e1s1&f=");
		Map parametersMap=new HashMap();
		parametersMap.put("bcr", "[1414387131,265236967,-1677877899,-51175749,-2137867084,-1097710699,-1782447518]");
		parametersMap.put("bg","!PDqgOhtHvSV2S8Q4DRVBAqIc1ZNoD74HAAAAe1cAAABxnAchNj_qDJttjPNOJOd14l7YtKHw5oBevMSBQYtbC3rbYs3XkiksJ-hMh3h1WvzrHkFbDxUWD7hefAeK3k5FMdhf4ujr_khu75-YdS9c0RG7NLsCFEEDDR__AkCe5tFT88B_XW4myNidNa2KylSx3DmTsq0fhpVtLkxNqaZ-e959MCMaqZV2IcV1zL9C0a5NzwapKwmIhBpoBTgCO5GWCZE3raSu8IDdCrI7f0detjz7C87flRvrBgcKlWveTeAmMIfA5YkZUfnD3c073F99d42llccVGbOwxn_8Tm9esrPL6B_EoVLgRCpkwgGwgdKMUHuLxBQdVuupFTyN3USG8TnoihHjWQQW89cw-0RkW2V7oqddK1A3kn511ckVw9RDuyGKwsMgYOh1_m9RWM2NgSD9H1rW6gbLn4iQxvf6tPEys5BvMG1r8s6tXKrGGRDnox-QoXqMIwkr186dVkU…6ImkMYMeLGOlkAtC7Sis2d-f29i1EoKCFMMRPqp7FFH_BfdiONv5dmZx5CWXrhuv_OwuthR3FkRRVCiA7jYmCWt0-cJgD_YlwV6rf-rSjH2jUgzNgbyXhe8g10mrNqVESlNuS6c7ZNhkYFub2wd44cRe9TVjkwtit7m_ebPyE-krcJkbarWceZiWmhvhg91_7TclNQjyUAflUF5W7Mqr0FoK0lx7LdIHC5l92dFfBCDJbsl60UrGxbO7qEY5VAZ8-2v2q2vCdcqQgpSGF5t1BiWZvMRgEoy9a-OUjpC72yDrFCCS6U5bVs3pYH7ZLKWyWzp3gcz4OroBGSnhHrG5qyWXfALbhCVGxTAAoLfWm-x0hUmIwezDxAOGckXlz0RvBPu2dRxmQIa82lR2oMjyDAB6zTZ-U8LpB-B05aYVyO1NCjz2pdFxwRsRdWFsrWfoFxV0m_LtQkTM4v6RzjEKxBD9rdByDrxEBRaFuUKP9RK7V7Ph-KlFKGrwU3AzIqg");
		parametersMap.put("c","03ADlfD18j3shwqtOY2KKD8tVMMhFqzTAi999XoywZ2HDixUQHjgtq8ux9bVMp4-Ol8Q9wWtyAa7sPfEZXWpfRFaRQpxzy2LLMAzjxQFOhaFWkuZAHY9fY-hxI3vUg6229XETAqqIpPmPTkShltrozkHDHBOOOER0t0ak8bc3kx98hk--xMGAIb_5dnKBhCzmGykImv47kfUlfvmMgNW7lIarHGBGxRJnnuChAt7fnstp9VFYo2437UGEDwCXNMnF8K3c_br5Zf53VwpCjBxrRfcrZao0A5ppxW3D_4unH4yetu0jMljjE7UTexncoZ0f3Z0MnyvoA7CNx0J4fkZBjtjiWkLp_ULPdph8PVZkZa5o0oyj9f57STP-7wrNlx5l5O8jb8N5uWueDD3fuk3vXxFjOEfREaYIahGZ9HH8b2PNkjfEc_1FHRGAE5iNgvzMWXsy5DwIStySN");
		parametersMap.put("chr","[22,80,31]");
		parametersMap.put("reason","fi");
		parametersMap.put("v","v1540794797339");
		parametersMap.put("vh","1720072450");
		parametersMap.put("z", "05ADB0q3elHTYVE5nhxOn2ZAZYwlATjjvqEGJmY9FK201ktm84diV8oPtCM4gDkNZ0VNaVDIC3P57RB_dfWhhLI7i9mKQAaiDi2LLvorpGk8ehbNWo5E9YNWJjBnmM-F3yze1okkoiR9H8hBBG7MivCKrHK_4QdUqa14rTkFVEyf5FnT2qFjCx3boTaN40z85T5OB3eZurSm_GgHEa0mrKBiZAw_w8UPbYMqRRXycnAMPx5YxiE0BHqlnMIIKi-wvO2uzgs9Se6diW7qtAgIk9Fxuw9n1jnzrZUv6-rhC9ECmPkks5JtHmwt8mLYaDQzfmWaXa6w-4ciMUWmTHDelimDT1L-dBHVxrFIZiPvyvAccK-w");
		requestSpecification.queryParam("k", "6LdSoRkTAAAAAAhKr1g2Zy4cCtE4hrgwIBdMYhXL");
		requestSpecification.formParameters(parametersMap);
		Map parameterssMap=new HashMap();
		parameterssMap.put("bg", "!nJqgmrtHHQXUUhwnXjFBWqIFl-fod7wHAAAAbVcAAACKnAPtggi7GyCIvdVmGzCMNDnY5oy0M4bpOb3ETmoRgfpJpbBfEQ4swQOS6xLPUtHX4lo5eLUL6l0s3BUJdse50Gt0rQDvNZISJQa4l3SoJ73NYYmrxvRkhNh6KBPlCr6LqDsRbwMXfuwfuJlo_zD4vShczBb85GngQ4uBPF_fSP9gPcqvNls5_2L3PQFrd-T6dBxdb2tl0EN5K8OAHY5mfIhc-a_eZ0gfeixqMI3_BOpyI6weJSdwBzmUPkqvJXctiHGRuDiskSFrrEEoxxVWF4-6hLIZ4uHVpTDy3OZrtqN-HXaVY9I1Ecioh3fiu20WcNX6RnnkSXaN7JE1Rp_at6JdtfKq2H9zeMycouTr7OL3iGvT_kAktbWiFWbhlI0ypRjkCueolxZH7-dcFUbBhiULMinoNyNvozb4Mmxhqvvk3i5hnLwu56EeS0KuS6C7lw6qXCDUPB0YRfwDv0d…QToATLZBol9oogjaWKYl4T0MFOmlXOVcK5MkUR0R_Vfe2qVbTz5VtWH1JRlrZq97_e6GMCdb7jNRnviY8E1ti0uItzL8LySOQTE8GvehK9xseNbDfT4L1nPbuZEZ5F65W81NoTLh5pHpPhGQfw_5Mvx_VMUZOA_2z6ZYug54bCOEtjhgrEMA5OTi0VelDTk5QmljY4vb_c05BSGwtNML45HcIVxyQQ7fvme9xEgILUsJosBCtvXcG3daYTQO58rhDypBgzqTwvf2d7JcaOrZHYvTU3cy_g8Rtlw3heaRkHBZKxQyH-o8PrYflVMD4HYton88m1l_yaSI_PkooEL2J9uh3J6iNvmtea9godXKWtrufjGoOkr8qli7XWHv2dXEBORoerW-GwWXV_pO-jP3DfNm-FCfFpPA9VGCw359SPjujVyzQHzMcptS60ItrTy9bIXQCWwGYRZnOTIzibKJ4JCxow278Sgrx3hiSofdSbrtqteWez-SazKSzC4tl6u");
		parameterssMap.put("c","03ADlfD1-IQBQ8n8y7y5HCweeBxQIJAs2fiOEyzyF3NMItgSHAaxeza3JXHBOAlcSHawDk0p-x-2HGHdI2lG0LxuO3TkamyRr5IjOEtLz2sLGxWeUKdCPeAbaLdO0iukQQYSsUaELt35k9BFlqvtQr7GpWXE1puTqrLg6KujD90vUGlSQW5s2NzJw5Vvfpfr5m0oGrCPc6ifwY_C_ToM2a8qZsgh9wIdWv09aHHcjj8d0tYwSi2kfUITT2BziWluBlk-sQ8Zmc31gPxHoFcIMkiN_M3XeTiuniBtiMmG8oG5WCecui_Pq0c4s4LqM1A7SOFAeVU94LPoQY-5USO0ywE8jJS4gOD0hm-2ddHfq3Z1HzYQTtCLc-Y9ROxkc4J9KUO0TxHA_g6bYpsWgYIzwEa2rtGWBza3w-nTBwTA2vX9XwnFNE4tVS1cXqBjD4PU93ju1m3YZ-OxbqvYJuiYZ0LIqcSYe69HeJTSfcxAUq7RZ4V4yioRpOkdjSJRFAmP…nn0en_Rpe6eNdHXqgwthxFXaFxCuzUnoXNq60PtnO7aCMzEqO1GTk1_k2Xm3lAx3Q3e24bjYTMBmHwd-JoP7zCTujKeVn0IfbRleeUiud5Y1PhbhBVgl47Ovu4ZEyW2Fqc5HHEz7TdUwEY3urCLwykrn4EOGAawbSucbDuAh5JZgOyyEhQCSTwi_KN3q0trd-NMkOLqN_yw5xROGMKxUFw-MMeWwrAZ0-k1aw4_uhBCsdwUfVsBQe4hJpvz600h2imoV7PoHoYnGP4_N9MNb_CnpZ05zuTkkB54fwskuQM0dwq5ZPZ5ogmBd03MMUrdFKh_tJjHB1hkmj8cki5T1IOH7184U6jobbIqOXJeu6bhjCRHSMqTXOmrPXLN0RFcP1j5dGja5yrSPu9kSlPhN2t8bItETr1DrA9ysb7tQq80mYV0lgCybxBbozsaTcOi7VjANsQhTlCKE046P3fkEHLU_R6i2wgei3KRchb8d6cLCD-fy_0BRlr-v2cKlhdw");
		parameterssMap.put("ct","802");
		parameterssMap.put("response","eyJyZXNwb25zZSI6IiIsInMiOiI3ODVlIn0.");
		parameterssMap.put("t","802");
		parameterssMap.put("v","v1540794797339");
		Response response = requestSpecification.post("https://www.google.com/recaptcha/api2/reload");
		RequestSpecification requestSpecification2=RestAssured.given();
		Response response2 = requestSpecification2.formParameters(parameterssMap).request(Method.POST,"https://www.google.com/recaptcha/api2/userverify");
		
		
		
		System.out.println(response2.asString());
	}
	public static void main(String[] args) {
		callSSO();
		
	}
}