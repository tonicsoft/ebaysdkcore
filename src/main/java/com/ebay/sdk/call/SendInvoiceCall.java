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
 * Wrapper class of the SendInvoice call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay item listing. Unless <b>OrderID</b> or
 * <b>OrderLineItemID</b> is provided in the request, the <b>ItemID</b> (or <b>SKU</b>) is
 * required and must be paired with the corresponding <b>TransactionID</b> to
 * identify a single line item order. For a multiple line item (Combined Invoice) order, <b>OrderID</b> should be used.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item (transaction). An order
 * line item is created once there is a commitment from a buyer to purchase
 * an item. Since an auction listing can only have one order line item
 * during the duration of the listing, the <b>TransactionID</b> for
 * auction listings is always 0. Unless <b>OrderID</b> or <b>OrderLineItemID</b> is
 * provided in the request, the <b>TransactionID</b> is required and must be
 * paired with the corresponding <b>ItemID</b> to identify a single line item
 * order. For a multiple line item (Combined Invoice) order, <b>OrderID</b> should
 * be used.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line
 * item (Combined Invoice) orders.
 * <br><br>
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For a Combined Invoice order, the <b>OrderID</b> value is created by eBay
 * when the buyer or seller (sharing multiple, common order line items)
 * combines multiple order line items into a Combined Invoice order. A
 * Combined Invoice order can also be created by the seller through the
 * <b>AddOrder</b> call.
 * <br><br>
 * Unless the <b>ItemID</b> (or SKU) and corresponding <b>TransactionID</b>, or the
 * <b>OrderLineItemID</b> is provided in the request to identify a single line
 * item order, the <b>OrderID</b> must be specified. If <b>OrderID</b> is specified,
 * <b>OrderLineItemID</b>, <b>ItemID</b>, <b>TransactionID</b>, and <b>SKU</b> are ignored if present
 * in the same request.
 * <br> <B>Input property:</B> <code>InternationalShippingServiceOptions</code> - If the buyer has an International shipping address, use this container
 * to offer up to three International shipping services. If International
 * shipping services are offered, (domestic) <b>ShippingServiceOptions</b> should
 * not be included in the request.
 * <br>
 * <br> <B>Input property:</B> <code>ShippingServiceOptions</code> - If the buyer has a domestic shipping address, use this container
 * to offer up to three domestic shipping services. If domestic
 * shipping services are offered, <b>InternationalShippingServiceOptions</b> should
 * not be included in the request.
 * <br>
 * <br> <B>Input property:</B> <code>SalesTax</code> - Container consisting of sales tax details. The amount of sales tax to
 * add to the price of an order is dependent on the sales tax rate in the
 * buyer's state and whether sales tax is being applied to the cost of the
 * order only or the cost of the order plus shipping.
 * <br> <B>Input property:</B> <code>InsuranceOption</code> - Specifies whether an insurance fee is required. An <b>InsuranceOption</b> value of
 * <b>IncludedInShippingHandling</b> cannot be used if the item will use calculated
 * shipping. Some shipping carriers automatically include shipping insurance
 * for qualifying items.<br>
 * <br> <B>Input property:</B> <code>InsuranceFee</code> - Insurance cost, as set by seller, if ShippingType = 1.
 * Specify if <b>InsuranceOption</b> is optional or required. Must
 * be greater than zero value if a value of Optional or Required is passed in
 * <b>InsuranceOption</b>. Value specified should be the total cost of insuring the
 * item.<br>
 * <br> <B>Input property:</B> <code>PaymentMethods</code> - This optional field allows a US or German seller to add specific payment
 * methods that were not in the original item listing. The only valid values
 * for this field are 'PayPal' for a US listing, or
 * 'MoneyXferAcceptedInCheckout' (CIP+) for a DE listing.
 * <br> <B>Input property:</B> <code>PayPalEmailAddress</code> - If the <b>PaymentMethods</b> field is used and set to PayPal, the seller
 * provides his/her PayPal email address in this field.
 * <br> <B>Input property:</B> <code>CheckoutInstructions</code> - This field allows the seller to provide a message or instructions
 * regarding checkout/payment or the return policy.
 * <br> <B>Input property:</B> <code>EmailCopyToSeller</code> - Flag indicating whether or not the seller wishes to receive an email copy of
 * the invoice sent to the buyer.
 * <br> <B>Input property:</B> <code>CODCost</code> - This dollar value indicates the money due from the buyer upon delivery of the item.
 * <br><br>
 * This field should only be specified in the <b>SendInvoice</b> request if 'COD' 
 * (cash-on-delivery) was the payment method selected by the buyer and it is included
 * as the <b>PaymentMethods</b> value in the same request.
 * <br> <B>Input property:</B> <code>SKU</code> - The seller's unique identifier for an item that is being tracked by this
 * SKU. If <b>OrderID</b> or <b>OrderLineItemID</b> are not provided, both <b>SKU</b> (or
 * <b>ItemID</b>) and corresponding <b>TransactionID</b> must be provided to uniquely
 * identify a single line item order. For a multiple line item (Combined Invoice) order, <b>OrderID</b> must be used.
 * <br>
 * <br>
 * This field can only be used if the <b>Item.InventoryTrackingMethod</b> field
 * (set with the <b>AddFixedPriceItem</b> or <b>RelistFixedPriceItem</b> calls) is set to
 * SKU.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This field is created
 * as soon as there is a commitment to buy from the seller, and its value
 * is based upon the concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a
 * hyphen in between these two IDs.
 * <br>
 * <br>
 * Unless the <b>ItemID</b> (or <b>SKU</b>) and corresponding <b>TransactionID</b> is used to
 * identify a single line item order, or the <b>OrderID</b> is used to identify a
 * single or multiple line item (Combined Invoice) order, the
 * <b>OrderLineItemID</b> must be specified. For a multiple line item (Combined Invoice) order, <b>OrderID</b> should be used. If <b>OrderLineItemID</b> is specified,
 * <b>ItemID</b>, <b>TransactionID</b>, and <b>SKU</b> are ignored if present in the same
 * request.
 * <br> <B>Input property:</B> <code>AdjustmentAmount</code> - This field allows the seller to adjust the total cost of the order to account
 * for an extra charge or to pass down a discount to the buyer. 
 * <br><br>
 * The currency used in this field must be the same currency of the listing site.
 * A positive value in this field indicates that the amount is an extra charge
 * being paid to the seller by the buyer, and a negative value indicates that the
 * amount is a discount given to the buyer by the seller. 
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SendInvoiceCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderID = null;
  private InternationalShippingServiceOptionsType[] internationalShippingServiceOptions = null;
  private ShippingServiceOptionsType[] shippingServiceOptions = null;
  private SalesTaxType salesTax = null;
  private InsuranceOptionCodeType insuranceOption = null;
  private AmountType insuranceFee = null;
  private BuyerPaymentMethodCodeType[] paymentMethods = null;
  private String payPalEmailAddress = null;
  private String checkoutInstructions = null;
  private Boolean emailCopyToSeller = null;
  private AmountType cODCost = null;
  private String sKU = null;
  private String orderLineItemID = null;
  private AmountType adjustmentAmount = null;
  private SendInvoiceRequestType sendInvoiceRequest=null;


  /**
   * Constructor.
   */
  public SendInvoiceCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SendInvoiceCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to send an order invoice to a buyer. Where applicable, updates to shipping, payment methods, and sales tax made in this request are applied to the specified order as a whole and to the individual order line items whose data are stored in individual <b>Transaction</b> objects.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void sendInvoice()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SendInvoiceRequestType req;
    if (this.sendInvoiceRequest != null)
    {
      req = this.sendInvoiceRequest;
    } else {
      req = new SendInvoiceRequestType();
  
      if( this.sendInvoiceRequest == null )
        throw new SdkException("SendInvoiceRequest property is not set.");
  
      if (this.itemID != null)
        req.setItemID(this.itemID);
      if (this.transactionID != null)
        req.setTransactionID(this.transactionID);
      if (this.orderID != null)
        req.setOrderID(this.orderID);
      if (this.internationalShippingServiceOptions != null)
        req.setInternationalShippingServiceOptions(this.internationalShippingServiceOptions);
      if (this.shippingServiceOptions != null)
        req.setShippingServiceOptions(this.shippingServiceOptions);
      if (this.salesTax != null)
        req.setSalesTax(this.salesTax);
      if (this.insuranceOption != null)
        req.setInsuranceOption(this.insuranceOption);
      if (this.insuranceFee != null)
        req.setInsuranceFee(this.insuranceFee);
      if (this.paymentMethods != null)
        req.setPaymentMethods(this.paymentMethods);
      if (this.payPalEmailAddress != null)
        req.setPayPalEmailAddress(this.payPalEmailAddress);
      if (this.checkoutInstructions != null)
        req.setCheckoutInstructions(this.checkoutInstructions);
      if (this.emailCopyToSeller != null)
        req.setEmailCopyToSeller(this.emailCopyToSeller);
      if (this.cODCost != null)
        req.setCODCost(this.cODCost);
      if (this.sKU != null)
        req.setSKU(this.sKU);
      if (this.orderLineItemID != null)
        req.setOrderLineItemID(this.orderLineItemID);
      if (this.adjustmentAmount != null)
        req.setAdjustmentAmount(this.adjustmentAmount);
  
    }

    SendInvoiceResponseType resp = (SendInvoiceResponseType) execute(req);


  }

  /**
   * Gets the SendInvoiceRequestType.sendInvoiceRequest.
   * @return SendInvoiceRequestType
   */
  public SendInvoiceRequestType getSendInvoiceRequest()
  {
    return this.sendInvoiceRequest;
  }


  /**
   * Sets the SendInvoiceRequestType.sendInvoiceRequest.
   * @param sendInvoiceRequest SendInvoiceRequestType
   */
  public void setSendInvoiceRequest(SendInvoiceRequestType sendInvoiceRequest)
  {
    this.sendInvoiceRequest = sendInvoiceRequest;
  }

  /**
   * Gets the SendInvoiceRequestType.adjustmentAmount.
   * @return AmountType
   */
  public AmountType getAdjustmentAmount()
  {
    return this.adjustmentAmount;
  }

  /**
   * Sets the SendInvoiceRequestType.adjustmentAmount.
   * @param adjustmentAmount AmountType
   */
  public void setAdjustmentAmount(AmountType adjustmentAmount)
  {
    this.adjustmentAmount = adjustmentAmount;
  }

  /**
   * Gets the SendInvoiceRequestType.cODCost.
   * @return AmountType
   */
  public AmountType getCODCost()
  {
    return this.cODCost;
  }

  /**
   * Sets the SendInvoiceRequestType.cODCost.
   * @param cODCost AmountType
   */
  public void setCODCost(AmountType cODCost)
  {
    this.cODCost = cODCost;
  }

  /**
   * Gets the SendInvoiceRequestType.checkoutInstructions.
   * @return String
   */
  public String getCheckoutInstructions()
  {
    return this.checkoutInstructions;
  }

  /**
   * Sets the SendInvoiceRequestType.checkoutInstructions.
   * @param checkoutInstructions String
   */
  public void setCheckoutInstructions(String checkoutInstructions)
  {
    this.checkoutInstructions = checkoutInstructions;
  }

  /**
   * Gets the SendInvoiceRequestType.emailCopyToSeller.
   * @return Boolean
   */
  public Boolean getEmailCopyToSeller()
  {
    return this.emailCopyToSeller;
  }

  /**
   * Sets the SendInvoiceRequestType.emailCopyToSeller.
   * @param emailCopyToSeller Boolean
   */
  public void setEmailCopyToSeller(Boolean emailCopyToSeller)
  {
    this.emailCopyToSeller = emailCopyToSeller;
  }

  /**
   * Gets the SendInvoiceRequestType.insuranceFee.
   * @return AmountType
   */
  public AmountType getInsuranceFee()
  {
    return this.insuranceFee;
  }

  /**
   * Sets the SendInvoiceRequestType.insuranceFee.
   * @param insuranceFee AmountType
   */
  public void setInsuranceFee(AmountType insuranceFee)
  {
    this.insuranceFee = insuranceFee;
  }

  /**
   * Gets the SendInvoiceRequestType.insuranceOption.
   * @return InsuranceOptionCodeType
   */
  public InsuranceOptionCodeType getInsuranceOption()
  {
    return this.insuranceOption;
  }

  /**
   * Sets the SendInvoiceRequestType.insuranceOption.
   * @param insuranceOption InsuranceOptionCodeType
   */
  public void setInsuranceOption(InsuranceOptionCodeType insuranceOption)
  {
    this.insuranceOption = insuranceOption;
  }

  /**
   * Gets the SendInvoiceRequestType.internationalShippingServiceOptions.
   * @return InternationalShippingServiceOptionsType[]
   */
  public InternationalShippingServiceOptionsType[] getInternationalShippingServiceOptions()
  {
    return this.internationalShippingServiceOptions;
  }

  /**
   * Sets the SendInvoiceRequestType.internationalShippingServiceOptions.
   * @param internationalShippingServiceOptions InternationalShippingServiceOptionsType[]
   */
  public void setInternationalShippingServiceOptions(InternationalShippingServiceOptionsType[] internationalShippingServiceOptions)
  {
    this.internationalShippingServiceOptions = internationalShippingServiceOptions;
  }

  /**
   * Gets the SendInvoiceRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the SendInvoiceRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the SendInvoiceRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the SendInvoiceRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the SendInvoiceRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the SendInvoiceRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the SendInvoiceRequestType.payPalEmailAddress.
   * @return String
   */
  public String getPayPalEmailAddress()
  {
    return this.payPalEmailAddress;
  }

  /**
   * Sets the SendInvoiceRequestType.payPalEmailAddress.
   * @param payPalEmailAddress String
   */
  public void setPayPalEmailAddress(String payPalEmailAddress)
  {
    this.payPalEmailAddress = payPalEmailAddress;
  }

  /**
   * Gets the SendInvoiceRequestType.paymentMethods.
   * @return BuyerPaymentMethodCodeType[]
   */
  public BuyerPaymentMethodCodeType[] getPaymentMethods()
  {
    return this.paymentMethods;
  }

  /**
   * Sets the SendInvoiceRequestType.paymentMethods.
   * @param paymentMethods BuyerPaymentMethodCodeType[]
   */
  public void setPaymentMethods(BuyerPaymentMethodCodeType[] paymentMethods)
  {
    this.paymentMethods = paymentMethods;
  }

  /**
   * Gets the SendInvoiceRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the SendInvoiceRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Gets the SendInvoiceRequestType.salesTax.
   * @return SalesTaxType
   */
  public SalesTaxType getSalesTax()
  {
    return this.salesTax;
  }

  /**
   * Sets the SendInvoiceRequestType.salesTax.
   * @param salesTax SalesTaxType
   */
  public void setSalesTax(SalesTaxType salesTax)
  {
    this.salesTax = salesTax;
  }

  /**
   * Gets the SendInvoiceRequestType.shippingServiceOptions.
   * @return ShippingServiceOptionsType[]
   */
  public ShippingServiceOptionsType[] getShippingServiceOptions()
  {
    return this.shippingServiceOptions;
  }

  /**
   * Sets the SendInvoiceRequestType.shippingServiceOptions.
   * @param shippingServiceOptions ShippingServiceOptionsType[]
   */
  public void setShippingServiceOptions(ShippingServiceOptionsType[] shippingServiceOptions)
  {
    this.shippingServiceOptions = shippingServiceOptions;
  }

  /**
   * Gets the SendInvoiceRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the SendInvoiceRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

