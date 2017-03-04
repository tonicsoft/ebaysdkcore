/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetTokenStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedTokenStatus</code> - Returns token status and details. For example, if revoked, whether by eBay, the user, or the application, and also when revoked.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetTokenStatusCall extends com.ebay.sdk.ApiCall
{
  
  private TokenStatusType returnedTokenStatus=null;


  /**
   * Constructor.
   */
  public GetTokenStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetTokenStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Requests current status of user token.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The TokenStatusType object.
   */
  public TokenStatusType getTokenStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetTokenStatusRequestType req;
    req = new GetTokenStatusRequestType();

    GetTokenStatusResponseType resp = (GetTokenStatusResponseType) execute(req);

    this.returnedTokenStatus = resp.getTokenStatus();
    return this.getReturnedTokenStatus();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetTokenStatusResponseType.returnedTokenStatus.
   * 
   * @return TokenStatusType
   */
  public TokenStatusType getReturnedTokenStatus()
  {
    return this.returnedTokenStatus;
  }

}

