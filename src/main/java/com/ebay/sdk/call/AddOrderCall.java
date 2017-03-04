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
 * Wrapper class of the AddOrder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Order</code> - The root container of the <b>AddOrder</b> request. In this
 * call, the seller identifies two or more unpaid order line items from the same buyer
 * through the <b>TransactionArray</b> container, specifies one or
 * more accepted payment methods through the <b>PaymentMethods</b>
 * field(s), and specifies available shipping services and other shipping details
 * through the <b>ShippingDetails</b> container.
 * <br> <B>Output property:</B> <code>ReturnedOrderID</code> - The unique identifier for the Combined Invoice order. This value is created by eBay upon a successful <b>AddOrder</b> call. This value can be used as an input filter in <a href="GetOrders.html">GetOrders</a> and <a href="GetOrderTransactions.html">GetOrderTransactions</a> to retrieve the order.
 * <br> <B>Output property:</B> <code>ReturnedCreatedTime</code> - Timestamp that indicates the date and time that the Combined Invoice order was created.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddOrderCall extends com.ebay.sdk.ApiCall
{
  
  private OrderType order = null;
  private String returnedOrderID=null;
  private Calendar returnedCreatedTime=null;


  /**
   * Constructor.
   */
  public AddOrderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddOrderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The <b>AddOrder</b> call can be used by a seller to combine two or more unpaid, single line item orders from the same buyer into one 'Combined Invoice' order with multiple line items. Once multiple line items are combined into one order, the buyer can make one single payment for each line item in the order. If possible and agreed to, the seller can then ship multiple line items in the same shipping package, saving on shipping costs, and possibly passing that savings down to the buyer through Combined Shipping Discount rules set up in My eBay.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AddOrderResponseType object.
   */
  public AddOrderResponseType addOrder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddOrderRequestType req;
    req = new AddOrderRequestType();
    if (this.order != null)
      req.setOrder(this.order);

    AddOrderResponseType resp = (AddOrderResponseType) execute(req);

    this.returnedOrderID = resp.getOrderID();
    this.returnedCreatedTime = resp.getCreatedTime();
    return resp;
  }

  /**
   * Gets the AddOrderRequestType.order.
   * @return OrderType
   */
  public OrderType getOrder()
  {
    return this.order;
  }

  /**
   * Sets the AddOrderRequestType.order.
   * @param order OrderType
   */
  public void setOrder(OrderType order)
  {
    this.order = order;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddOrderResponseType.returnedCreatedTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedCreatedTime()
  {
    return this.returnedCreatedTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddOrderResponseType.returnedOrderID.
   * 
   * @return String
   */
  public String getReturnedOrderID()
  {
    return this.returnedOrderID;
  }

}

