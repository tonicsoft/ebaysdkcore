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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellingManagerSaleRecord call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for the eBay item listing associated with the Selling
 * Manager sale record. Unless the <b>OrderID</b> or <b>OrderLineItemID</b> value is
 * specified in the request, the <b>ItemID</b> and <b>TransactionID</b> fields must be
 * used to identify the Selling Manager sale record to retrieve. You can
 * use <b>GetSellingManagerSoldListings</b> to retrieve the <b>ItemID</b>, <b>TransactionID</b>
 * or <b>OrderLineItemID</b> values that correspond to the Selling Manager sale
 * record (<b>SaleRecordID</b>). All four of these fields are returned under the
 * <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for the order line item (transaction) associated with
 * the Selling Manager sale record. Unless the <b>OrderID</b> or <b>OrderLineItemID</b>
 * value is specified in the request, the <b>ItemID</b> and <b>TransactionID</b> fields
 * must be used to identify the Selling Manager sale record to retrieve.
 * You can use <b>GetSellingManagerSoldListings</b> to retrieve the <b>ItemID</b>,
 * <b>TransactionID</b> or <b>OrderLineItemID</b> values that correspond to the Selling
 * Manager sale record (<b>SaleRecordID</b>). All four of these fields are
 * returned under the <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line item
 * (Combined Invoice) order associated with the Selling Manager sale record(s). 
 * <br><br>
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For a Combined Invoice order, the <b>OrderID</b> value is created by eBay
 * when the buyer or seller (sharing multiple, common order line items)
 * combines multiple order line items into a Combined Invoice order through
 * the eBay site (or when the seller creates Combined Invoice order through
 * <b>AddOrder</b>). If an <b>OrderID</b> is used in the request, the <b>OrderLineItemID</b> and
 * <b>ItemID</b>/<b>TransactionID</b> pair are not required.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item that is associated with
 * the Selling Manager sale record. This field is created as soon as there
 * is a commitment to buy from the seller, and its value is based upon the
 * concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a hyphen in between
 * these two IDs. You can use <b>GetSellingManagerSoldListings</b> to retrieve the
 * <b>ItemID</b>, <b>TransactionID</b> or <b>OrderLineItemID</b> values that correspond to the
 * Selling Manager sale record (<b>SaleRecordID</b>). All four of these fields are
 * returned under the <b>SellingManagerSoldTransaction</b> container of the
 * <b>GetSellingManagerSoldListings</b> request. Unless an <b>OrderID</b> or an
 * <b>ItemID</b>/<b>Transaction</b> pair is specified in the <b>GetSellingManagerSaleRecord</b>
 * request, the <b>OrderLineItemID</b> is required. 
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerSoldOrder</code> - Contains the data in a Selling Manager sale record.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerSaleRecordCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderID = null;
  private String orderLineItemID = null;
  private SellingManagerSoldOrderType returnedSellingManagerSoldOrder=null;


  /**
   * Constructor.
   */
  public GetSellingManagerSaleRecordCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerSaleRecordCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the data for one or more Selling Manager sale records. 
   * <br><br>
   * The standard Trading API
   * deprecation process is not applicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerSoldOrderType object.
   */
  public SellingManagerSoldOrderType getSellingManagerSaleRecord()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerSaleRecordRequestType req;
    req = new GetSellingManagerSaleRecordRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    GetSellingManagerSaleRecordResponseType resp = (GetSellingManagerSaleRecordResponseType) execute(req);

    this.returnedSellingManagerSoldOrder = resp.getSellingManagerSoldOrder();
    return this.getReturnedSellingManagerSoldOrder();
  }

  /**
   * Gets the GetSellingManagerSaleRecordRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetSellingManagerSaleRecordRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetSellingManagerSaleRecordRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the GetSellingManagerSaleRecordRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the GetSellingManagerSaleRecordRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the GetSellingManagerSaleRecordRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the GetSellingManagerSaleRecordRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetSellingManagerSaleRecordRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerSaleRecordResponseType.returnedSellingManagerSoldOrder.
   * 
   * @return SellingManagerSoldOrderType
   */
  public SellingManagerSoldOrderType getReturnedSellingManagerSoldOrder()
  {
    return this.returnedSellingManagerSoldOrder;
  }

}

