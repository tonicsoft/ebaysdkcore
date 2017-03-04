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
 * Wrapper class of the ReviseInventoryStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>InventoryStatus</code> - Contains the updated quantity and/or price of a listing
 * being revised. You should not modify the same listing twice
 * (by using a duplicate ItemID or SKU) in the same request;
 * otherwise, you may get an error or unexpected results.
 * (For example, you should not use one InventoryStatus node to
 * update the quantity and another InventoryStatus node to update
 * the price of the same item.) You can pass up to 4 InventoryStatus nodes in a single request.
 * <br> <B>Output property:</B> <code>ReturnedInventoryStatus</code> - Confirms the quantity and price associated with a listing 
 * or variation that was revised.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Child elements contain the estimated listing fees for a 
 * listing that was revised. Use the ItemID to correlate the 
 * Fees data with the InventoryStatus data in the response. 
 * The fees do not include the Final Value Fee (FVF), 
 * which can't be determined until the listing has sales.<br>
 * <br>
 * If you revise a variation in a multi-variation listing, 
 * the fees are for the entire listing. The insertion fee and
 * listing fee are affected by the highest priced variation 
 * in the listing (which is not necessarily the variation that
 * you passed in the request).<br>
 * <br>
 * Also note that the call returns only one Fees node per listing.
 * For example, if you revise 4 variations from the same 
 * multi-variation listing, the response includes 4 
 * InventoryStatus nodes and 1 Fees node.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseInventoryStatusCall extends com.ebay.sdk.ApiCall
{
  
  private InventoryStatusType[] inventoryStatus = null;
  private InventoryStatusType[] returnedInventoryStatus=null;
  private InventoryFeesType[] returnedFees=null;


  /**
   * Constructor.
   */
  public ReviseInventoryStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseInventoryStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to change the price and quantity of a currently-
   * active, fixed-price listing. Using ReviseInventoryStatus to modify
   * data qualifies as revising the listing.
   * <br><br>
   * Inputs are the item IDs or SKUs of the listings being revised,
   * and the price and quantity that are
   * being changed for each revision. Only applicable to fixed-price listings.<br>
   * <br><br>
   * Changing the price or quantity of a currently-
   * active, fixed-price listing does not reset the Best Match performance score.
   * For Best Match information related to multi-variation listings, see the Best
   * Match information at the following topic:
   * <a href="http://pages.ebay.com/sell/variation/">Multi-quantity Fixed Price
   * listings with variations</a>.<br>
   * <br><br>
   * As with all listing calls, the site you specify in the request URL
   * (for SOAP) or the X-EBAY-API-SITEID HTTP header (for XML)
   * should match the original listing's <b>Item.Site</b> value.
   * In particular, this is a best practice when you submit new and
   * revised listings.<br>
   * <br><b>
   * For Large Merchant Services users:</b> When you use ReviseInventoryStatus within a Merchant Data file,
   * it must be enclosed within two BulkDataExchangeRequest tags.
   * A namespace is returned in the BulkDataExchangeResponseType
   * (top level) of the response. The BulkDataExchange tags are not shown in the call input/output descriptions.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The InventoryStatusType[] object.
   */
  public InventoryStatusType[] reviseInventoryStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseInventoryStatusRequestType req;
    req = new ReviseInventoryStatusRequestType();
    if (this.inventoryStatus != null)
      req.setInventoryStatus(this.inventoryStatus);

    ReviseInventoryStatusResponseType resp = (ReviseInventoryStatusResponseType) execute(req);

    this.returnedInventoryStatus = resp.getInventoryStatus();
    this.returnedFees = resp.getFees();
    return this.getReturnedInventoryStatus();
  }

  /**
   * Gets the ReviseInventoryStatusRequestType.inventoryStatus.
   * @return InventoryStatusType[]
   */
  public InventoryStatusType[] getInventoryStatus()
  {
    return this.inventoryStatus;
  }

  /**
   * Sets the ReviseInventoryStatusRequestType.inventoryStatus.
   * @param inventoryStatus InventoryStatusType[]
   */
  public void setInventoryStatus(InventoryStatusType[] inventoryStatus)
  {
    this.inventoryStatus = inventoryStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseInventoryStatusResponseType.returnedFees.
   * 
   * @return InventoryFeesType[]
   */
  public InventoryFeesType[] getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseInventoryStatusResponseType.returnedInventoryStatus.
   * 
   * @return InventoryStatusType[]
   */
  public InventoryStatusType[] getReturnedInventoryStatus()
  {
    return this.returnedInventoryStatus;
  }

}

