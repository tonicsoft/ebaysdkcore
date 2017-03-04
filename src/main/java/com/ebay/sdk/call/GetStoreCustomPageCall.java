/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStoreCustomPage call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PageID</code> - If a <b>PageID</b> is specified, then that page is returned, and the returned page
 * contains the page Content. If no <b>PageID</b> is specified, then all pages are
 * returned, without the page Content.
 * <br> <B>Output property:</B> <code>ReturnedStoreCustomPageArrayType</code> - The custom page or custom pages.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCustomPageCall extends com.ebay.sdk.ApiCall
{
  
  private Long pageID = null;
  private StoreCustomPageArrayType returnedStoreCustomPageArrayType=null;


  /**
   * Constructor.
   */
  public GetStoreCustomPageCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCustomPageCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the custom page or pages for the authenticated user's Store.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStoreCustomPage()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreCustomPageRequestType req;
    req = new GetStoreCustomPageRequestType();
    if (this.pageID != null)
      req.setPageID(this.pageID);

    GetStoreCustomPageResponseType resp = (GetStoreCustomPageResponseType) execute(req);

    this.returnedStoreCustomPageArrayType = resp.getCustomPageArray();

  }

  /**
   * Gets the GetStoreCustomPageRequestType.pageID.
   * @return Long
   */
  public Long getPageID()
  {
    return this.pageID;
  }

  /**
   * Sets the GetStoreCustomPageRequestType.pageID.
   * @param pageID Long
   */
  public void setPageID(Long pageID)
  {
    this.pageID = pageID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreCustomPageResponseType.returnedStoreCustomPageArrayType.
   * 
   * @return StoreCustomPageArrayType
   */
  public StoreCustomPageArrayType getReturnedStoreCustomPageArrayType()
  {
    return this.returnedStoreCustomPageArrayType;
  }

}

