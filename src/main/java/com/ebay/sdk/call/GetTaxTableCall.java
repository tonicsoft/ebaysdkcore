/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetTaxTable call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedLastUpdateTime</code> - The last time (in GMT) that the tax table was updated.
 * Only returned if the user previously created a tax table
 * and if the site has jurisdictions.
 * <b>LastUpdateTime</b> is useful for synchronization. If you cache the user's
 * tax table, you can use <b>GetTaxTable</b> to check if it has changed and
 * whether you need to update the cached tax table.
 * <br> <B>Output property:</B> <code>ReturnedTaxTable</code> - A container of tax jurisdiction information unique to
 * a user/site combination. Empty if not set for user.
 * If <b>DetailLevel</b> is not specified, information is only
 * returned for the jurisdictions for which the user provided tax
 * information. If <b>DetailLevel</b> is <b>ReturnAll</b>, tax information
 * is returned for all possible jurisdictions, whether
 * specified by the user or not. <b>ShippingIncludedInTax</b> and
 * <b>SalesTaxPercent</b> are returned but are empty.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetTaxTableCall extends com.ebay.sdk.ApiCall
{
  
  private Calendar returnedLastUpdateTime=null;
  private TaxTableType returnedTaxTable=null;


  /**
   * Constructor.
   */
  public GetTaxTableCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetTaxTableCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the tax table for a user on a given site or retrieves the valid
   * jurisdictions (if any) for a given site.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getTaxTable()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetTaxTableRequestType req;
    req = new GetTaxTableRequestType();
    req.setDetailLevel(this.getDetailLevel());

    GetTaxTableResponseType resp = (GetTaxTableResponseType) execute(req);

    this.returnedLastUpdateTime = resp.getLastUpdateTime();
    this.returnedTaxTable = resp.getTaxTable();

  }

  /**
   * Valid after executing the API.
   * Gets the returned GetTaxTableResponseType.returnedLastUpdateTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedLastUpdateTime()
  {
    return this.returnedLastUpdateTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetTaxTableResponseType.returnedTaxTable.
   * 
   * @return TaxTableType
   */
  public TaxTableType getReturnedTaxTable()
  {
    return this.returnedTaxTable;
  }

}

