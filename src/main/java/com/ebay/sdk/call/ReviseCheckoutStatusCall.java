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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseCheckoutStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay item listing. A listing can have multiple
 * order line items (transactions), but only one <b>ItemID</b>. An <b>ItemID</b> can be
 * paired up with a corresponding <b>TransactionID</b> and used as an input filter
 * for <b>ReviseCheckoutStatus</b>.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * (Combined Invoice) order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item (Combined Invoice) order, <b>OrderID</b>
 * should be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br />
 * <br />
 * It is also possible to identify a single line item order with a
 * <b>ItemID</b>/<b>BuyerID</b> combination, but this is not the most ideal
 * approach since an error is returned if there are multiple
 * order line items for that combination.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item (transaction). An order
 * line item is created once there is a commitment from a buyer to purchase
 * an item. Since an auction listing can only have one order line item
 * during the duration of the listing, the <b>TransactionID</b> for
 * auction listings is always 0. Along with its corresponding <b>ItemID</b>, a
 * <b>TransactionID</b> is used and referenced during an order checkout flow and
 * after checkout has been completed. The <b>ItemID</b>/<b>TransactionID</b> pair can be
 * used as an input filter for <b>ReviseCheckoutStatus</b>.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * (Combined Invoice) order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item (Combined Invoice) order, <b>OrderID</b>
 * must be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>OrderId</code> - A unique identifier that identifies a single line item or multiple line
 * item (Combined Invoice) order.
 * <br><br>
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For a Combined Invoice order, the <b>OrderID</b> value is created by eBay
 * when the buyer or seller (sharing multiple, common order line items)
 * combines multiple order line items into a Combined Invoice order through
 * the eBay site. A Combined Invoice order can also be created by the
 * seller through the <b>AddOrder</b> call. The <b>OrderID</b> can be used as an input
 * filter for <b>ReviseCheckoutStatus</b>.
 * <br><br>
 * <b>OrderID</b> overrides an <b>OrderLineItemID</b> or <b>ItemID</b>/<b>TransactionID</b> pair if
 * these fields are also specified in the same request.
 * <br> <B>Input property:</B> <code>AmountPaid</code> - The total amount paid by the buyer. For a motor vehicle purchased on eBay Motors,
 * <b>AmountPaid</b> is the total amount paid by the buyer for the deposit.
 * <b>AmountPaid</b> is optional if <b>CheckoutStatus</b> is Incomplete and required if it
 * is Complete.
 * <br> <B>Input property:</B> <code>PaymentMethodUsed</code> - Payment method used by the buyer. This field is required if <b>
 * CheckoutStatus</b> is Complete and the payment method is a trusted
 * payment method other than PayPal. See eBay's
 * <a href="http://pages.ebay.com/help/policies/accepted-payments-policy.html">Accepted Payments Policy</a>.
 * If the payment method is PayPal, this field should not be used since only PayPal can set this field's
 * value to "PayPal". ReviseCheckoutStatus cannot be used for a non-trusted
 * payment method.
 * <b>Note:</b>Required or allowed payment methods vary by site and category.
 * <br> <B>Input property:</B> <code>CheckoutStatus</code> - The current checkout status of the order. Often, the seller or
 * application will mark this value as 'Complete' if payment has been made. 
 * <br> <B>Input property:</B> <code>ShippingService</code> - The shipping service selected by the buyer from among the shipping services
 * offered by the seller (such as UPS Ground). For a list of valid values, call
 * GeteBayDetails with DetailName set to ShippingServiceDetails. The
 * ShippingServiceDetails.ValidForSellingFlow flag must also be present.
 * Otherwise, that particular shipping service option is no longer valid and
 * cannot be offered to buyers through a listing.
 * <br/><br/>
 * <span class="tablenote">
 * <strong>Note:</strong> <strong>ReviseCheckoutStatus</strong> is not available for the Global Shipping program; specifying InternationalPriorityShipping as a value for this field will produce an error.
 * </span>
 * <br> <B>Input property:</B> <code>ShippingIncludedInTax</code> - An indicator of whether shipping costs were included in the
 * taxable amount. .
 * <br> <B>Input property:</B> <code>CheckoutMethod</code> - <br> <B>Input property:</B> <code>InsuranceType</code> - Enumeration value that indicates whether shipping insurance was offered to and
 * selected by the buyer.
 * <br> <B>Input property:</B> <code>PaymentStatus</code> - This field is used to mark the order as paid or awaiting payment in My eBay. If you specify 'Paid', My eBay displays an icon for each line item in the order to indicate that the order status is Paid. If you specify 'Pending', this indicates that the order is awaiting payment (some applications may use 'Pending' when the buyer has paid, but the funds have not yet been sent to the seller's financial institution).
 * <br>
 * <br>
 * <b>ReviseCheckoutStatus</b> cannot be used to update payment and checkout
 * status for a non-trusted payment method. See eBay's <a href="
 * http://pages.ebay.com/help/policies/accepted-payments-policy.html">
 * Accepted Payments Policy</a> for more information on trusted
 * payment methods. If the payment method is PayPal, this field should not
 * be used since PayPal automatically set this field's value to "Paid" upon
 * receiving the buyer's payment.
 * <br> <B>Input property:</B> <code>AdjustmentAmount</code> - Discount or charge agreed to by the buyer and seller. A positive value
 * indicates that the amount is an extra charge being paid to the seller by
 * the buyer. A negative value indicates that the amount is a discount given
 * to the buyer by the seller.
 * <br> <B>Input property:</B> <code>ShippingAddress</code> - For internal use.
 * <br> <B>Input property:</B> <code>BuyerID</code> - eBay user ID for the order's buyer. A single line item order can
 * actually be identified by a <b>BuyerID</b>/<b>ItemID</b> pair, but this approach is
 * not recommended since an error is returned if there are multiple
 * order line items for that combination. <b>BuyerID</b> is ignored if any other valid
 * filter or filter combination is used in the same request.
 * <br> <B>Input property:</B> <code>ShippingInsuranceCost</code> - The amount of money paid for shipping insurance.
 * <br> <B>Input property:</B> <code>SalesTax</code> - The sales tax amount for the order. This field should be used if sales tax
 * was applied to the order.
 * <br> <B>Input property:</B> <code>ShippingCost</code> - The amount of money paid for shipping.
 * <br> <B>Input property:</B> <code>EncryptedID</code> - Not supported.
 * <br> <B>Input property:</B> <code>ExternalTransaction</code> - This container is used to identify the electronic payment (other than Paypal) of an order. 
 * <br> <B>Input property:</B> <code>MultipleSellerPaymentID</code> - Not supported.
 * <br> <B>Input property:</B> <code>CODCost</code> - This dollar value indicates the money due from the buyer upon delivery of the item.
 * <br><br>
 * This field should only be specified in the <b>ReviseCheckoutStatus</b>
 * request if 'COD' (cash-on-delivery) was the payment method selected by the buyer
 * and it is included as the <b>PaymentMethodUsed</b> value in the same
 * request.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item and
 * is based upon the concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a
 * hyphen in between these two IDs. For a single line item order, the
 * <b>OrderLineItemID</b> value can be passed into the <b>OrderID</b> field to revise the
 * checkout status of the order.
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

public class ReviseCheckoutStatusCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderId = null;
  private AmountType amountPaid = null;
  private BuyerPaymentMethodCodeType paymentMethodUsed = null;
  private CompleteStatusCodeType checkoutStatus = null;
  private String shippingService = null;
  private Boolean shippingIncludedInTax = null;
  private CheckoutMethodCodeType checkoutMethod = null;
  private InsuranceSelectedCodeType insuranceType = null;
  private RCSPaymentStatusCodeType paymentStatus = null;
  private AmountType adjustmentAmount = null;
  private AddressType shippingAddress = null;
  private String buyerID = null;
  private AmountType shippingInsuranceCost = null;
  private AmountType salesTax = null;
  private AmountType shippingCost = null;
  private String encryptedID = null;
  private ExternalTransactionType externalTransaction = null;
  private String multipleSellerPaymentID = null;
  private AmountType cODCost = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public ReviseCheckoutStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseCheckoutStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to update the payment details, the shipping details,
   * and the status of an order.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ReviseCheckoutStatusResponseType object.
   */
  public ReviseCheckoutStatusResponseType reviseCheckoutStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseCheckoutStatusRequestType req;
    req = new ReviseCheckoutStatusRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderId != null)
      req.setOrderID(this.orderId);
    if (this.amountPaid != null)
      req.setAmountPaid(this.amountPaid);
    if (this.paymentMethodUsed != null)
      req.setPaymentMethodUsed(this.paymentMethodUsed);
    if (this.checkoutStatus != null)
      req.setCheckoutStatus(this.checkoutStatus);
    if (this.shippingService != null)
      req.setShippingService(this.shippingService);
    if (this.shippingIncludedInTax != null)
      req.setShippingIncludedInTax(this.shippingIncludedInTax);
    if (this.checkoutMethod != null)
      req.setCheckoutMethod(this.checkoutMethod);
    if (this.insuranceType != null)
      req.setInsuranceType(this.insuranceType);
    if (this.paymentStatus != null)
      req.setPaymentStatus(this.paymentStatus);
    if (this.adjustmentAmount != null)
      req.setAdjustmentAmount(this.adjustmentAmount);
    if (this.shippingAddress != null)
      req.setShippingAddress(this.shippingAddress);
    if (this.buyerID != null)
      req.setBuyerID(this.buyerID);
    if (this.shippingInsuranceCost != null)
      req.setShippingInsuranceCost(this.shippingInsuranceCost);
    if (this.salesTax != null)
      req.setSalesTax(this.salesTax);
    if (this.shippingCost != null)
      req.setShippingCost(this.shippingCost);
    if (this.encryptedID != null)
      req.setEncryptedID(this.encryptedID);
    if (this.externalTransaction != null)
      req.setExternalTransaction(this.externalTransaction);
    if (this.multipleSellerPaymentID != null)
      req.setMultipleSellerPaymentID(this.multipleSellerPaymentID);
    if (this.cODCost != null)
      req.setCODCost(this.cODCost);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    ReviseCheckoutStatusResponseType resp = (ReviseCheckoutStatusResponseType) execute(req);

    return resp;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.adjustmentAmount.
   * @return AmountType
   */
  public AmountType getAdjustmentAmount()
  {
    return this.adjustmentAmount;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.adjustmentAmount.
   * @param adjustmentAmount AmountType
   */
  public void setAdjustmentAmount(AmountType adjustmentAmount)
  {
    this.adjustmentAmount = adjustmentAmount;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.amountPaid.
   * @return AmountType
   */
  public AmountType getAmountPaid()
  {
    return this.amountPaid;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.amountPaid.
   * @param amountPaid AmountType
   */
  public void setAmountPaid(AmountType amountPaid)
  {
    this.amountPaid = amountPaid;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.buyerID.
   * @return String
   */
  public String getBuyerID()
  {
    return this.buyerID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.buyerID.
   * @param buyerID String
   */
  public void setBuyerID(String buyerID)
  {
    this.buyerID = buyerID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.cODCost.
   * @return AmountType
   */
  public AmountType getCODCost()
  {
    return this.cODCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.cODCost.
   * @param cODCost AmountType
   */
  public void setCODCost(AmountType cODCost)
  {
    this.cODCost = cODCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.checkoutMethod.
   * @return CheckoutMethodCodeType
   */
  public CheckoutMethodCodeType getCheckoutMethod()
  {
    return this.checkoutMethod;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.checkoutMethod.
   * @param checkoutMethod CheckoutMethodCodeType
   */
  public void setCheckoutMethod(CheckoutMethodCodeType checkoutMethod)
  {
    this.checkoutMethod = checkoutMethod;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.checkoutStatus.
   * @return CompleteStatusCodeType
   */
  public CompleteStatusCodeType getCheckoutStatus()
  {
    return this.checkoutStatus;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.checkoutStatus.
   * @param checkoutStatus CompleteStatusCodeType
   */
  public void setCheckoutStatus(CompleteStatusCodeType checkoutStatus)
  {
    this.checkoutStatus = checkoutStatus;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.encryptedID.
   * @return String
   */
  public String getEncryptedID()
  {
    return this.encryptedID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.encryptedID.
   * @param encryptedID String
   */
  public void setEncryptedID(String encryptedID)
  {
    this.encryptedID = encryptedID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.externalTransaction.
   * @return ExternalTransactionType
   */
  public ExternalTransactionType getExternalTransaction()
  {
    return this.externalTransaction;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.externalTransaction.
   * @param externalTransaction ExternalTransactionType
   */
  public void setExternalTransaction(ExternalTransactionType externalTransaction)
  {
    this.externalTransaction = externalTransaction;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.insuranceType.
   * @return InsuranceSelectedCodeType
   */
  public InsuranceSelectedCodeType getInsuranceType()
  {
    return this.insuranceType;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.insuranceType.
   * @param insuranceType InsuranceSelectedCodeType
   */
  public void setInsuranceType(InsuranceSelectedCodeType insuranceType)
  {
    this.insuranceType = insuranceType;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.multipleSellerPaymentID.
   * @return String
   */
  public String getMultipleSellerPaymentID()
  {
    return this.multipleSellerPaymentID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.multipleSellerPaymentID.
   * @param multipleSellerPaymentID String
   */
  public void setMultipleSellerPaymentID(String multipleSellerPaymentID)
  {
    this.multipleSellerPaymentID = multipleSellerPaymentID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.orderId.
   * @return String
   */
  public String getOrderId()
  {
    return this.orderId;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.orderId.
   * @param orderId String
   */
  public void setOrderId(String orderId)
  {
    this.orderId = orderId;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.paymentMethodUsed.
   * @return BuyerPaymentMethodCodeType
   */
  public BuyerPaymentMethodCodeType getPaymentMethodUsed()
  {
    return this.paymentMethodUsed;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.paymentMethodUsed.
   * @param paymentMethodUsed BuyerPaymentMethodCodeType
   */
  public void setPaymentMethodUsed(BuyerPaymentMethodCodeType paymentMethodUsed)
  {
    this.paymentMethodUsed = paymentMethodUsed;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.paymentStatus.
   * @return RCSPaymentStatusCodeType
   */
  public RCSPaymentStatusCodeType getPaymentStatus()
  {
    return this.paymentStatus;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.paymentStatus.
   * @param paymentStatus RCSPaymentStatusCodeType
   */
  public void setPaymentStatus(RCSPaymentStatusCodeType paymentStatus)
  {
    this.paymentStatus = paymentStatus;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.salesTax.
   * @return AmountType
   */
  public AmountType getSalesTax()
  {
    return this.salesTax;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.salesTax.
   * @param salesTax AmountType
   */
  public void setSalesTax(AmountType salesTax)
  {
    this.salesTax = salesTax;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingAddress.
   * @return AddressType
   */
  public AddressType getShippingAddress()
  {
    return this.shippingAddress;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingAddress.
   * @param shippingAddress AddressType
   */
  public void setShippingAddress(AddressType shippingAddress)
  {
    this.shippingAddress = shippingAddress;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingCost.
   * @return AmountType
   */
  public AmountType getShippingCost()
  {
    return this.shippingCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingCost.
   * @param shippingCost AmountType
   */
  public void setShippingCost(AmountType shippingCost)
  {
    this.shippingCost = shippingCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingIncludedInTax.
   * @return Boolean
   */
  public Boolean getShippingIncludedInTax()
  {
    return this.shippingIncludedInTax;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingIncludedInTax.
   * @param shippingIncludedInTax Boolean
   */
  public void setShippingIncludedInTax(Boolean shippingIncludedInTax)
  {
    this.shippingIncludedInTax = shippingIncludedInTax;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingInsuranceCost.
   * @return AmountType
   */
  public AmountType getShippingInsuranceCost()
  {
    return this.shippingInsuranceCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingInsuranceCost.
   * @param shippingInsuranceCost AmountType
   */
  public void setShippingInsuranceCost(AmountType shippingInsuranceCost)
  {
    this.shippingInsuranceCost = shippingInsuranceCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingService.
   * @return String
   */
  public String getShippingService()
  {
    return this.shippingService;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingService.
   * @param shippingService String
   */
  public void setShippingService(String shippingService)
  {
    this.shippingService = shippingService;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }
/**
   * Backward compatible function - sets shipping service using a shipping service code type value.
   * @param shippingService ShippingServiceCodeType
   */
  public void setShippingService(com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType shippingService) {
      this.shippingService = (shippingService == null? null: shippingService.value());
  }

}

