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
 * Wrapper class of the GetOrderTransactions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemTransactionIDArray</code> - An array of <b>ItemTransactionIDs</b>.
 * <br> <B>Input property:</B> <code>OrderIDArray</code> - An array of <b>OrderIDs</b>. You can specify, at most, twenty <b>OrderIDs</b>.
 * <br> <B>Input property:</B> <code>Platform</code> - The default behavior of <b>GetOrderTransactions</b> is to retrieve all orders originating from eBay.com and Half.com. If the user wants to retrieve only eBay.com order line items or Half.com order line items, this filter can be used to perform that function. Inserting 'eBay' into this field will restrict retrieved order line items to those originating on eBay.com, and inserting 'Half' into this field will restrict retrieved order line items to those originating on Half.com.
 * <br> <B>Input property:</B> <code>IncludeFinalValueFees</code> - Indicates whether to include Final Value Fee (FVF) in the response. For most
 * listing types, the Final Value Fee is returned in <b>Transaction.FinalValueFee</b>.
 * The Final Value Fee is returned on a transaction-by-transaction basis for
 * <b>FixedPriceItem</b> listing type. For all other listing
 * types, the Final Value Fee is returned when the listing status is Completed.
 * This value is not returned if the auction ended with Buy It Now.
 * <br> <B>Output property:</B> <code>ReturnedOrderArray</code> - An array of orders.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetOrderTransactionsCall extends com.ebay.sdk.ApiCall
{
  
  private ItemTransactionIDArrayType itemTransactionIDArray = null;
  private OrderIDArrayType orderIDArray = null;
  private TransactionPlatformCodeType platform = null;
  private Boolean includeFinalValueFees = null;
  private OrderArrayType returnedOrderArray=null;


  /**
   * Constructor.
   */
  public GetOrderTransactionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetOrderTransactionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information about one or more orders based on <b>OrderIDs</b>, <b>ItemIDs</b>, or <b>SKU</b> values.&nbsp;<b>Also for Half.com</b>.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The OrderArrayType object.
   */
  public OrderArrayType getOrderTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetOrderTransactionsRequestType req;
    req = new GetOrderTransactionsRequestType();
    if (this.itemTransactionIDArray != null)
      req.setItemTransactionIDArray(this.itemTransactionIDArray);
    if (this.orderIDArray != null)
      req.setOrderIDArray(this.orderIDArray);
    if (this.platform != null)
      req.setPlatform(this.platform);
    if (this.includeFinalValueFees != null)
      req.setIncludeFinalValueFees(this.includeFinalValueFees);

    GetOrderTransactionsResponseType resp = (GetOrderTransactionsResponseType) execute(req);

    this.returnedOrderArray = resp.getOrderArray();
    return this.getReturnedOrderArray();
  }

  /**
   * Gets the GetOrderTransactionsRequestType.includeFinalValueFees.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFees()
  {
    return this.includeFinalValueFees;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.includeFinalValueFees.
   * @param includeFinalValueFees Boolean
   */
  public void setIncludeFinalValueFees(Boolean includeFinalValueFees)
  {
    this.includeFinalValueFees = includeFinalValueFees;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.itemTransactionIDArray.
   * @return ItemTransactionIDArrayType
   */
  public ItemTransactionIDArrayType getItemTransactionIDArray()
  {
    return this.itemTransactionIDArray;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.itemTransactionIDArray.
   * @param itemTransactionIDArray ItemTransactionIDArrayType
   */
  public void setItemTransactionIDArray(ItemTransactionIDArrayType itemTransactionIDArray)
  {
    this.itemTransactionIDArray = itemTransactionIDArray;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.orderIDArray.
   * @return OrderIDArrayType
   */
  public OrderIDArrayType getOrderIDArray()
  {
    return this.orderIDArray;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.orderIDArray.
   * @param orderIDArray OrderIDArrayType
   */
  public void setOrderIDArray(OrderIDArrayType orderIDArray)
  {
    this.orderIDArray = orderIDArray;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.platform.
   * @return TransactionPlatformCodeType
   */
  public TransactionPlatformCodeType getPlatform()
  {
    return this.platform;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.platform.
   * @param platform TransactionPlatformCodeType
   */
  public void setPlatform(TransactionPlatformCodeType platform)
  {
    this.platform = platform;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrderTransactionsResponseType.returnedOrderArray.
   * 
   * @return OrderArrayType
   */
  public OrderArrayType getReturnedOrderArray()
  {
    return this.returnedOrderArray;
  }

}

