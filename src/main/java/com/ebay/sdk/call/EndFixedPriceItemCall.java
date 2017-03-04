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
 * Wrapper class of the EndFixedPriceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique item ID that identifies the item listing that you want to end.
 * <br><br>
 * In the EndFixedPriceItem request, either ItemID or SKU is required.
 * If both are passed in and they don't refer to the same listing, eBay
 * ignores SKU and considers only the ItemID.
 * <br> <B>Input property:</B> <code>EndingReason</code> - Indicates the seller's reason for ending the listing early. This field
 * is required if the seller is ending the item early and the item did
 * not successfully sell.
 * <br> <B>Input property:</B> <code>SKU</code> - The unique SKU of the item being ended. A SKU (stock keeping unit) is
 * an identifier defined by a seller. SKU can only be used to end an
 * item if you listed the item by using AddFixedPriceItem or
 * RelistFixedPriceItem, and you set Item.InventoryTrackingMethod to SKU
 * at the time the item was listed. (These criteria are necessary to
 * uniquely identify the listing by a SKU.)
 * <br><br>
 * In the EndFixedPriceItem request, either ItemID or SKU is required. If
 * both are passed in and they don't refer to the same listing, eBay
 * ignores SKU and considers only the ItemID.
 * <br><br>
 * To remove a SKU when you revise or relist an item, use DeletedField in
 * the revision or relist call.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Timestamp that indicates the date and time (GMT) that the specified item listing
 * was ended.
 * <br> <B>Output property:</B> <code>ReturnedSKU</code> - If a SKU (stock-keeping unit) exists for the item listing, it is returned in
 * the response.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class EndFixedPriceItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private EndReasonCodeType endingReason = null;
  private String sKU = null;
  private Calendar returnedEndTime=null;
  private String returnedSKU=null;


  /**
   * Constructor.
   */
  public EndFixedPriceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public EndFixedPriceItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Ends the specified fixed-price listing before the date and time at which
   * it would normally end (per the listing duration).
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Calendar object.
   */
  public Calendar endFixedPriceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    EndFixedPriceItemRequestType req;
    req = new EndFixedPriceItemRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.endingReason != null)
      req.setEndingReason(this.endingReason);
    if (this.sKU != null)
      req.setSKU(this.sKU);

    EndFixedPriceItemResponseType resp = (EndFixedPriceItemResponseType) execute(req);

    this.returnedEndTime = resp.getEndTime();
    this.returnedSKU = resp.getSKU();
    return this.getReturnedEndTime();
  }

  /**
   * Gets the EndFixedPriceItemRequestType.endingReason.
   * @return EndReasonCodeType
   */
  public EndReasonCodeType getEndingReason()
  {
    return this.endingReason;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.endingReason.
   * @param endingReason EndReasonCodeType
   */
  public void setEndingReason(EndReasonCodeType endingReason)
  {
    this.endingReason = endingReason;
  }

  /**
   * Gets the EndFixedPriceItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the EndFixedPriceItemRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndFixedPriceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndFixedPriceItemResponseType.returnedSKU.
   * 
   * @return String
   */
  public String getReturnedSKU()
  {
    return this.returnedSKU;
  }

}

