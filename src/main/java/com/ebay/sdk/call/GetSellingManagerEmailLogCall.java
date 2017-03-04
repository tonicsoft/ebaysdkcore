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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellingManagerEmailLog call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for the eBay item listing associated with the Selling
 * Manager email log. Unless the <b>OrderID</b> or <b>OrderLineItemID</b> value is
 * specified in the request, the <b>ItemID</b> and <b>TransactionID</b> fields must be
 * used to identify the Selling Manager email log to retrieve. You can
 * use <b>GetSellingManagerSoldListings</b> to retrieve the <b>ItemID</b>, <b>TransactionID</b>
 * or <b>OrderLineItemID</b> values that correspond to the Selling Manager sale
 * record (<b>SaleRecordID</b>). All four of these fields are returned under the
 * <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for the order line item (transaction) associated with
 * the Selling Manager email log. Unless the <b>OrderID</b> or <b>OrderLineItemID</b>
 * value is specified in the request, the <b>ItemID</b> and <b>TransactionID</b> fields
 * must be used to identify the Selling Manager email log to retrieve.
 * You can use <b>GetSellingManagerSoldListings</b> to retrieve the <b>ItemID</b>,
 * <b>TransactionID</b> or <b>OrderLineItemID</b> values that correspond to the Selling
 * Manager sale record (<b>SaleRecordID</b>). All four of these fields are
 * returned under the <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line item
 * (Combined Invoice) order associated with the Selling Manager email log. 
 * <br><br>
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For a Combined Invoice order, the <b>OrderID</b> value is created by eBay
 * when the buyer or seller (sharing multiple, common order line items)
 * combines multiple order line items into a Combined Invoice order through
 * the eBay site (or when the seller creates Combined Invoice order through
 * <b>AddOrder</b>). If an <b>OrderID</b> is used in the request, the <b>OrderLineItemID</b> and
 * <b>ItemID</b>/<b>TransactionID</b> pair are not required.
 * <br> <B>Input property:</B> <code>EmailDateRange</code> - Specifies the earliest (oldest) and latest (most recent) dates to use in a
 * date range filter based on email sent date. Each of the time ranges can be
 * up to 90 days.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item that is associated with
 * the Selling Manager email log. This field is created as soon as there
 * is a commitment to buy from the seller, and its value is based upon the
 * concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a hyphen in between
 * these two IDs. You can use <b>GetSellingManagerSoldListings</b> to retrieve the
 * <b>ItemID</b>, <b>TransactionID</b> or <b>OrderLineItemID</b> values that correspond to the
 * Selling Manager sale record (<b>SaleRecordID</b>). All four of these fields are
 * returned under the <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request. Unless an <b>OrderID</b> or an
 * <b>ItemID</b>/<b>TransactionID</b> pair is specified in the <b>GetSellingManagerSaleRecord</b>
 * request, the <b>OrderLineItemID</b> is required. 
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedEmailLog</code> - Email logs associated with this order.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerEmailLogCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Long transactionID = null;
  private String orderID = null;
  private TimeRangeType emailDateRange = null;
  private String orderLineItemID = null;
  private SellingManagerEmailLogType[] returnedEmailLog=null;


  /**
   * Constructor.
   */
  public GetSellingManagerEmailLogCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerEmailLogCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a log of emails sent, or scheduled to be sent, to buyers.
   * <br><br>
   * The standard Trading API
   * deprecation process is not applicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerEmailLogType[] object.
   */
  public SellingManagerEmailLogType[] getSellingManagerEmailLog()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerEmailLogRequestType req;
    req = new GetSellingManagerEmailLogRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.emailDateRange != null)
      req.setEmailDateRange(this.emailDateRange);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    GetSellingManagerEmailLogResponseType resp = (GetSellingManagerEmailLogResponseType) execute(req);

    this.returnedEmailLog = resp.getEmailLog();
    return this.getReturnedEmailLog();
  }

  /**
   * Gets the GetSellingManagerEmailLogRequestType.emailDateRange.
   * @return TimeRangeType
   */
  public TimeRangeType getEmailDateRange()
  {
    return this.emailDateRange;
  }

  /**
   * Sets the GetSellingManagerEmailLogRequestType.emailDateRange.
   * @param emailDateRange TimeRangeType
   */
  public void setEmailDateRange(TimeRangeType emailDateRange)
  {
    this.emailDateRange = emailDateRange;
  }

  /**
   * Gets the GetSellingManagerEmailLogRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetSellingManagerEmailLogRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetSellingManagerEmailLogRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the GetSellingManagerEmailLogRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the GetSellingManagerEmailLogRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the GetSellingManagerEmailLogRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the GetSellingManagerEmailLogRequestType.transactionID.
   * @return Long
   */
  public Long getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetSellingManagerEmailLogRequestType.transactionID.
   * @param transactionID Long
   */
  public void setTransactionID(Long transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerEmailLogResponseType.returnedEmailLog.
   * 
   * @return SellingManagerEmailLogType[]
   */
  public SellingManagerEmailLogType[] getReturnedEmailLog()
  {
    return this.returnedEmailLog;
  }

}

