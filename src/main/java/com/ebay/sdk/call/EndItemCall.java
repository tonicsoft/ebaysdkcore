/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the EndItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique item ID that identifies the item listing to end.
 * <br><br>
 * For Half.com listings, you can either specify ItemID or
 * SellerInventoryID.
 * <br><br>
 * Applicable to Half.com.
 * <br> <B>Input property:</B> <code>EndingReason</code> - Indicates the seller's reason for ending the listing early.
 * This field is required if the seller is ending the item early and
 * the item did not successfully sell.
 * <br><br>
 * Applicable to Half.com.
 * <br> <B>Input property:</B> <code>SellerInventoryID</code> - Unique identifier that the seller specified when they listed the
 * Half.com item. For Half.com items, you can either specify ItemID or
 * SellerInventoryID. If you specify both ItemID and SellerInventoryID,
 * they must be for the same item (otherwise an error will occur).
 * <br><br>
 * Applicable only to Half.com.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Indicates the date and time (returned in GMT) the specified item listing
 * was ended.
 * Also applicable to Half.com.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class EndItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private EndReasonCodeType endingReason = null;
  private String sellerInventoryID = null;
  private Calendar returnedEndTime=null;


  /**
   * Constructor.
   */
  public EndItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public EndItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Ends the specified item listing before the date and time at which it would normally end per the listing duration.&nbsp;<b>Also for Half.com</b>.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Calendar object.
   */
  public Calendar endItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    EndItemRequestType req;
    req = new EndItemRequestType();

	if( this.itemID == null && this.sellerInventoryID == null)
	  throw new SdkException("Please set ItemID or sellerInventoryID (for Half items) to be ended.");
	if( this.itemID != null && this.sellerInventoryID != null)
	  throw new SdkException("Please set either an ItemID or a sellerInventoryID (for Half items) to be ended.");

    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.endingReason != null)
      req.setEndingReason(this.endingReason);
    if (this.sellerInventoryID != null)
      req.setSellerInventoryID(this.sellerInventoryID);

    EndItemResponseType resp = (EndItemResponseType) execute(req);

    this.returnedEndTime = resp.getEndTime();
    return this.getReturnedEndTime();
  }

  /**
   * Gets the EndItemRequestType.endingReason.
   * @return EndReasonCodeType
   */
  public EndReasonCodeType getEndingReason()
  {
    return this.endingReason;
  }

  /**
   * Sets the EndItemRequestType.endingReason.
   * @param endingReason EndReasonCodeType
   */
  public void setEndingReason(EndReasonCodeType endingReason)
  {
    this.endingReason = endingReason;
  }

  /**
   * Gets the EndItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the EndItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the EndItemRequestType.sellerInventoryID.
   * @return String
   */
  public String getSellerInventoryID()
  {
    return this.sellerInventoryID;
  }

  /**
   * Sets the EndItemRequestType.sellerInventoryID.
   * @param sellerInventoryID String
   */
  public void setSellerInventoryID(String sellerInventoryID)
  {
    this.sellerInventoryID = sellerInventoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

}

