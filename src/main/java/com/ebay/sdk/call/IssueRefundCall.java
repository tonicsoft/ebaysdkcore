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
 * Wrapper class of the IssueRefund call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for the Half.com item listing. Unless an
 * <b>OrderLineItemID</b> is specified in the <b>IssueRefund</b> request, the <b>ItemID</b> is
 * required along with the corresponding <b>TransactionID</b> to identify the
 * order line item that will be refunded. You can use <b>GetSellerPayments</b> to
 * retrieve the <b>ItemID</b> and/or <b>TransactionID</b> associated with the order line
 * item.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for a Half.com order line item (transaction). An order
 * line item is created once there is a commitment from a buyer to purchase
 * an item. Along with its corresponding <b>ItemID</b>, a <b>TransactionID</b> is used to
 * identify the order line item that will be refunded. Unless an
 * <b>OrderLineItemID</b> is specified in the <b>IssueRefund</b> request, the
 * <b>TransactionID</b> is required along with the corresponding <b>ItemID</b>. You can
 * use <b>GetSellerPayments</b> to retrieve the <b>ItemID</b> and/or <b>TransactionID</b>
 * associated with the order line item.
 * <br> <B>Input property:</B> <code>RefundReason</code> - Explanation of the reason that the refund is being issued.
 * <br> <B>Input property:</B> <code>RefundType</code> - Explanation of the costs that the refund amount covers.
 * <br> <B>Input property:</B> <code>RefundAmount</code> - The amount the seller wants to refund to the buyer, in US Dollars (USD).
 * Must be greater than 0.00. Half.com allows a maximum of the original item
 * sale price (order line item price plus original shipping reimbursement) plus
 * return shipping costs (the amount the buyer paid to return the item).
 * Typically, the return shipping cost is based on the current cost of
 * shipping the individual item (not the discounted cost calculated during
 * the original checkout for a Combined Invoice order). You can also issue a
 * partial refund for the amount you want the buyer to receive. If
 * RefundType=Full or RefundType=FullPlusShipping and you do not pass
 * <b>RefundAmount</b> in the request, Half.com will calculate the refund amount for
 * you. If you pass <b>RefundAmount</b> in the request, the amount you specify will
 * override Half.com's calculated value. Required if RefundType=
 * CustomOrPartial.
 * <br> <B>Input property:</B> <code>RefundMessage</code> - Note to the buyer. Cannot include HTML.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This field is created
 * as soon as there is a commitment to buy from the seller, and its value
 * is based upon the concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a
 * hyphen in between these two IDs. The <b>OrderLineItemID</b> value is used to
 * identify the order line item that will be refunded. Unless an
 * <b>ItemID</b>/<b>TransactionID</b> pair is specified in the <b>IssueRefund</b> request, the
 * <b>OrderLineItemID</b> is required. You can use <b>GetSellerPayments</b> to retrieve
 * the <b>OrderLineItemID</b> associated with the order line item.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedRefundFromSeller</code> - Total amount that the seller asked Half.com to refund to 
 * a buyer for a Half.com order line item.
 * <br> <B>Output property:</B> <code>ReturnedTotalRefundToBuyer</code> - Total amount that Half.com refunded to the buyer (which could include the refund amount 
 * from the seller plus a refund amount from Half.com).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class IssueRefundCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private RefundReasonCodeType refundReason = null;
  private RefundTypeCodeType refundType = null;
  private AmountType refundAmount = null;
  private String refundMessage = null;
  private String orderLineItemID = null;
  private AmountType returnedRefundFromSeller=null;
  private AmountType returnedTotalRefundToBuyer=null;


  /**
   * Constructor.
   */
  public IssueRefundCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public IssueRefundCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * <b>Half.com only.</b>&nbsp;Issues a refund for a specific
   * Half.com order line item. This can only be called by a seller. Sellers do not
   * have the ability to issue a general refund (a refund not tied to an order line
   * item) to a buyer.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AmountType object.
   */
  public AmountType issueRefund()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    IssueRefundRequestType req;
    req = new IssueRefundRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.refundReason != null)
      req.setRefundReason(this.refundReason);
    if (this.refundType != null)
      req.setRefundType(this.refundType);
    if (this.refundAmount != null)
      req.setRefundAmount(this.refundAmount);
    if (this.refundMessage != null)
      req.setRefundMessage(this.refundMessage);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    IssueRefundResponseType resp = (IssueRefundResponseType) execute(req);

    this.returnedRefundFromSeller = resp.getRefundFromSeller();
    this.returnedTotalRefundToBuyer = resp.getTotalRefundToBuyer();
    return this.getReturnedRefundFromSeller();
  }

  /**
   * Gets the IssueRefundRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the IssueRefundRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the IssueRefundRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the IssueRefundRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the IssueRefundRequestType.refundAmount.
   * @return AmountType
   */
  public AmountType getRefundAmount()
  {
    return this.refundAmount;
  }

  /**
   * Sets the IssueRefundRequestType.refundAmount.
   * @param refundAmount AmountType
   */
  public void setRefundAmount(AmountType refundAmount)
  {
    this.refundAmount = refundAmount;
  }

  /**
   * Gets the IssueRefundRequestType.refundMessage.
   * @return String
   */
  public String getRefundMessage()
  {
    return this.refundMessage;
  }

  /**
   * Sets the IssueRefundRequestType.refundMessage.
   * @param refundMessage String
   */
  public void setRefundMessage(String refundMessage)
  {
    this.refundMessage = refundMessage;
  }

  /**
   * Gets the IssueRefundRequestType.refundReason.
   * @return RefundReasonCodeType
   */
  public RefundReasonCodeType getRefundReason()
  {
    return this.refundReason;
  }

  /**
   * Sets the IssueRefundRequestType.refundReason.
   * @param refundReason RefundReasonCodeType
   */
  public void setRefundReason(RefundReasonCodeType refundReason)
  {
    this.refundReason = refundReason;
  }

  /**
   * Gets the IssueRefundRequestType.refundType.
   * @return RefundTypeCodeType
   */
  public RefundTypeCodeType getRefundType()
  {
    return this.refundType;
  }

  /**
   * Sets the IssueRefundRequestType.refundType.
   * @param refundType RefundTypeCodeType
   */
  public void setRefundType(RefundTypeCodeType refundType)
  {
    this.refundType = refundType;
  }

  /**
   * Gets the IssueRefundRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the IssueRefundRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned IssueRefundResponseType.returnedRefundFromSeller.
   * 
   * @return AmountType
   */
  public AmountType getReturnedRefundFromSeller()
  {
    return this.returnedRefundFromSeller;
  }

  /**
   * Valid after executing the API.
   * Gets the returned IssueRefundResponseType.returnedTotalRefundToBuyer.
   * 
   * @return AmountType
   */
  public AmountType getReturnedTotalRefundToBuyer()
  {
    return this.returnedTotalRefundToBuyer;
  }

}

