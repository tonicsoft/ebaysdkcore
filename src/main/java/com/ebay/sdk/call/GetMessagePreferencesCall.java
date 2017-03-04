/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Boolean;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetMessagePreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SellerID</code> - The ID of the user to retrieve ASQ subjects for. This
 * value must be specified in the request, but does not
 * need to be the same user as the user making the
 * request.
 * <br> <B>Input property:</B> <code>IncludeASQPreferences</code> - If true, indicates that the ASQ subjects for the
 * specified user should be returned.
 * <br> <B>Output property:</B> <code>ReturnedASQPreferences</code> - Returns a seller's ASQ subjects, each in its own Subject
 * node. If the seller has not customized the ASQ subjects
 * using SetMessagePreferences, the call will return the
 * current default values. Returned if
 * IncludeASQPreferences = true was specified in the
 * request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMessagePreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private String sellerID = null;
  private Boolean includeASQPreferences = null;
  private ASQPreferencesType returnedASQPreferences=null;


  /**
   * Constructor.
   */
  public GetMessagePreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMessagePreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns a seller's Ask Seller a Question (ASQ) subjects, each in
   * its own Subject node.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ASQPreferencesType object.
   */
  public ASQPreferencesType getMessagePreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMessagePreferencesRequestType req;
    req = new GetMessagePreferencesRequestType();
    if (this.sellerID != null)
      req.setSellerID(this.sellerID);
    if (this.includeASQPreferences != null)
      req.setIncludeASQPreferences(this.includeASQPreferences);

    GetMessagePreferencesResponseType resp = (GetMessagePreferencesResponseType) execute(req);

    this.returnedASQPreferences = resp.getASQPreferences();
    return this.getReturnedASQPreferences();
  }

  /**
   * Gets the GetMessagePreferencesRequestType.includeASQPreferences.
   * @return Boolean
   */
  public Boolean getIncludeASQPreferences()
  {
    return this.includeASQPreferences;
  }

  /**
   * Sets the GetMessagePreferencesRequestType.includeASQPreferences.
   * @param includeASQPreferences Boolean
   */
  public void setIncludeASQPreferences(Boolean includeASQPreferences)
  {
    this.includeASQPreferences = includeASQPreferences;
  }

  /**
   * Gets the GetMessagePreferencesRequestType.sellerID.
   * @return String
   */
  public String getSellerID()
  {
    return this.sellerID;
  }

  /**
   * Sets the GetMessagePreferencesRequestType.sellerID.
   * @param sellerID String
   */
  public void setSellerID(String sellerID)
  {
    this.sellerID = sellerID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMessagePreferencesResponseType.returnedASQPreferences.
   * 
   * @return ASQPreferencesType
   */
  public ASQPreferencesType getReturnedASQPreferences()
  {
    return this.returnedASQPreferences;
  }

}

