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
 * Wrapper class of the ReviseSellingManagerSaleRecord call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay item listing. A listing can have multiple
 * order line items (transactions), but only one <b>ItemID</b>. An <b>ItemID</b> can be
 * paired up with a corresponding <b>TransactionID</b> and used as an input filter
 * for <b>ReviseSellingManagerSaleRecord</b>. The <b>ItemID</b>/<b>TransactionID</b> pair
 * corresponds to a Selling Manager <b>SaleRecordID</b>, which can be retrieved
 * with the <b>GetSellingManagerSaleRecord</b> call. 
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * (Combined Invoice) order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item (Combined Invoice) order, <b>OrderID</b>
 * should be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item (transaction). An order
 * line item is created once there is a commitment from a buyer to purchase
 * an item. Since an auction listing can only have one order line item
 * during the duration of the listing, the <b>TransactionID</b> for
 * auction listings is always 0. Along with its corresponding <b>ItemID</b>, a
 * <b>TransactionID</b> is used and referenced during an order checkout flow and
 * after checkout has been completed. The <b>ItemID</b>/<b>TransactionID</b> pair can be
 * used as an input filter for <b>ReviseSellingManagerSaleRecord</b>. The
 * <b>ItemID</b>/<b>TransactionID</b> pair corresponds to a Selling Manager <b>SaleRecordID</b>,
 * which can be retrieved with the <b>GetSellingManagerSaleRecord</b> call.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * (Combined Invoice) order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item (Combined Invoice) order, <b>OrderID</b>
 * must be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line
 * item (Combined Invoice) order. 
 * <br><br> 
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For a Combined Invoice order, the <b>OrderID</b> value is created by eBay
 * when the buyer or seller (sharing multiple, common order line items)
 * combines multiple order line items into a Combined Invoice order through
 * the eBay site. A Combined Invoice order can also be created by the
 * seller through the <b>AddOrder</b> call. The <b>OrderID</b> can be used as an input
 * filter for <b>ReviseSellingManagerSaleRecord</b>. The <b>OrderID</b>
 * is linked to a Selling Manager <b>SaleRecordID</b>, and can be retrieved
 * with the <b>GetSellingManagerSaleRecord</b> call.
 * <br><br>
 * <b>OrderID</b> overrides an <b>OrderLineItemID</b> or <b>ItemID</b>/<b>TransactionID</b> pair if
 * these fields are also specified in the same request.
 * <br> <B>Input property:</B> <code>SellingManagerSoldOrder</code> - Container consisting of order costs, shipping details, order status, and
 * other information. The changes made under this container will update the
 * order in Selling Manager.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item and
 * is based upon the concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a
 * hyphen in between these two IDs. For a single line item order, the
 * <b>OrderLineItemID</b> value can be passed into the <b>OrderID</b> field to revise the
 * order in Selling Manager. 
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair is used to identify a single line
 * item order, or the <b>OrderID</b> is used to identify a single or multiple line
 * item (Combined Invoice) order, the <b>OrderLineItemID</b> must be specified.
 * For a multiple line item (Combined Invoice) order, <b>OrderID</b> should be
 * used. If <b>OrderLineItemID</b> is specified, the <b>ItemID</b>/<b>TransactionID</b> pair are
 * ignored if present in the same request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseSellingManagerSaleRecordCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderID = null;
  private SellingManagerSoldOrderType sellingManagerSoldOrder = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public ReviseSellingManagerSaleRecordCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseSellingManagerSaleRecordCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables sellers, who subscribe to Selling Manager Pro, to revise a Selling Manager sale record.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseSellingManagerSaleRecord()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseSellingManagerSaleRecordRequestType req;
    req = new ReviseSellingManagerSaleRecordRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.sellingManagerSoldOrder != null)
      req.setSellingManagerSoldOrder(this.sellingManagerSoldOrder);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    ReviseSellingManagerSaleRecordResponseType resp = (ReviseSellingManagerSaleRecordResponseType) execute(req);


  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.sellingManagerSoldOrder.
   * @return SellingManagerSoldOrderType
   */
  public SellingManagerSoldOrderType getSellingManagerSoldOrder()
  {
    return this.sellingManagerSoldOrder;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.sellingManagerSoldOrder.
   * @param sellingManagerSoldOrder SellingManagerSoldOrderType
   */
  public void setSellingManagerSoldOrder(SellingManagerSoldOrderType sellingManagerSoldOrder)
  {
    this.sellingManagerSoldOrder = sellingManagerSoldOrder;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

