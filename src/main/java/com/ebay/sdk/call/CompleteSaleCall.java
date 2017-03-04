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
 * Wrapper class of the CompleteSale call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay item listing. An <b>ItemID</b> can be paired up
 * with a corresponding <b>TransactionID</b> and used in the <b>CompleteSale</b> request
 * to identify a single line item order.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item order, <b>OrderID</b>
 * must be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item (transaction). The
 * <b>TransactionID</b> can be paired up with the corresponding <b>ItemID</b> and used in
 * the <b>CompleteSale</b> request to identify a single line item order.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify a single line item order,
 * or the <b>OrderID</b> is used to identify a single or multiple line item
 * order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item order, <b>OrderID</b>
 * must be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>FeedbackInfo</code> - This container is used by the seller to leave feedback for the buyer for the
 * order line item identified in the call request. The seller must include and
 * specify all fields of this type, including the buyer's eBay User ID, the
 * Feedback rating (a seller can only leave a buyer a "Positive" rating), and a
 * comment, which helps justify the Feedback rating. The eBay User ID must match 
 * the buyer who bought the order line item, or an error will occur. An error will 
 * also occur if Feedback has already been left for the buyer (either through API 
 * or the Web flow).
 * <br><br>
 * To determine if Feedback has already been left for an order line item, you can 
 * call <b class="con">GetFeedback</b>, passing in the 
 * <b class="con">OrderLineItemID</b> value in the call request.
 * <br> <B>Input property:</B> <code>Shipped</code> - The seller includes and sets this field to true if the order has been
 * shipped. If the call is successful, the order line item(s) are marked as
 * Shipped in My eBay.
 * <br><br>
 * If the seller includes and sets this field to false, the order line item(s)
 * are marked (or remain) as Not Shipped in My eBay.
 * <br><br>
 * If this field is not included, the shipped status of the order line
 * item(s) remain unchanged in My eBay.
 * <br><br>
 * If shipment tracking information is provided for an order line item through
 * the Shipment container in the same request, the order line item is marked as
 * shipped automatically and the <b>Shipped</b> field is not
 * required.
 * <br> <B>Input property:</B> <code>Paid</code> - The seller includes and sets this field to true if the buyer has paid for
 * the order. If the call is successful, the
 * order line item(s) are marked as Paid in My eBay.
 * <br><br>
 * If the seller includes and sets this field to false, the order line item(s)
 * are marked (or remain) as Not Paid in My eBay.
 * <br><br>
 * If this field is not included, the paid status of the order line
 * item(s) remain unchanged in My eBay.
 * <br> <B>Input property:</B> <code>ListingType</code> - This field is required if <b>CompleteSale</b> is being used for a Half.com
 * order. The value should be set to <i>Half</i>, which is the only applicable
 * <b>ListingType</b> value for this call.
 * <br> <B>Input property:</B> <code>Shipment</code> - Container consisting of shipment tracking information, shipped time, and an
 * optional text field to provide additional details to the buyer. Setting the
 * tracking number and shipping carrier automatically marks the item as shipped
 * and the <b>Shipped</b> field is not required.
 * <br><br>
 * (If you supply <b>ShipmentTrackingNumber</b> you must also supply 
 * <b>ShippingCarrierUsed</b>, otherwise you will get an error.
 * <br><br>
 * To modify the shipping tracking number and/or carrier, supply the new number
 * in <b>ShipmentTrackingNumber</b> or supply the value for
 * <b>ShippingCarrierUsed</b> or both. The old number and carrier
 * are deleted and the new ones are added.
 * <br><br>
 * To simply delete the current tracking details altogether, supply empty
 * <b>Shipment</b> tags.
 * <br> 
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Top-Rated sellers must have a record of uploading shipment tracking
 * information (through site or through API) for at least 90 percent of their order line
 * items (purchased by U.S. buyers) to keep their status as Top-Rated sellers. For more
 * information on the requirements to becoming a Top-Rated Seller, see the 
 * <a href="http://pages.ebay.com/help/sell/top-rated.html">Becoming a Top-Rated Seller and qualifying for Top-Rated Plus</a> 
 * customer support page.
 * </span>
 * <br>
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line
 * item order. 
 * <br><br> 
 * For a single line item order, the <b>OrderID</b> value is identical to the
 * <b>OrderLineItemID</b> value that is generated upon creation of the order line
 * item. For multiple line item orders, the <b>OrderID</b> value is created by eBay
 * when the buyer is purchasing multiple order line items from the same seller at the same time.
 * For multiple line item orders not going through the eBay Cart flow, a Combined Invoice order can be created by the seller
 * through the <b>AddOrder</b> call. The <b>OrderID</b> can be used in the <b>CompleteSale</b>
 * request to identify a single or multiple line item order.
 * <br><br>
 * <b>OrderID</b> overrides an <b>OrderLineItemID</b> or <b>ItemID</b>/<b>TransactionID</b> pair if
 * these fields are also specified in the same request.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item and
 * is based upon the concatenation of <b>ItemID</b> and <b>TransactionID</b>, with a
 * hyphen in between these two IDs. For a single line item order, the
 * <b>OrderLineItemID</b> value can be passed into the <b>OrderID</b> field in the
 * <b>CompleteSale</b> request.
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair is used to identify a single line
 * item order, or the <b>OrderID</b> is used to identify a single or multiple line
 * item order, the <b>OrderLineItemID</b> must be specified.
 * For a multiple line item order, <b>OrderID</b> must be
 * used. If <b>OrderLineItemID</b> is specified, the <b>ItemID</b>/<b>TransactionID</b> pair are
 * ignored if present in the same request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class CompleteSaleCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private FeedbackInfoType feedbackInfo = null;
  private Boolean shipped = null;
  private Boolean paid = null;
  private ListingTypeCodeType listingType = null;
  private ShipmentType shipment = null;
  private String orderID = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public CompleteSaleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public CompleteSaleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to do various tasks after the creation of a single line item or
   * multiple line item order. Typically, this call is used after the
   * buyer has paid for the order, but it can be called by the
   * seller beforehand. Typical post-payment tasks available to this call include
   * marking the order as paid, marking the order as shipped, providing shipment tracking
   * details, and leaving feedback for the buyer.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void completeSale()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    CompleteSaleRequestType req;
    req = new CompleteSaleRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.feedbackInfo != null)
      req.setFeedbackInfo(this.feedbackInfo);
    if (this.shipped != null)
      req.setShipped(this.shipped);
    if (this.paid != null)
      req.setPaid(this.paid);
    if (this.listingType != null)
      req.setListingType(this.listingType);
    if (this.shipment != null)
      req.setShipment(this.shipment);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    CompleteSaleResponseType resp = (CompleteSaleResponseType) execute(req);


  }

  /**
   * Gets the CompleteSaleRequestType.feedbackInfo.
   * @return FeedbackInfoType
   */
  public FeedbackInfoType getFeedbackInfo()
  {
    return this.feedbackInfo;
  }

  /**
   * Sets the CompleteSaleRequestType.feedbackInfo.
   * @param feedbackInfo FeedbackInfoType
   */
  public void setFeedbackInfo(FeedbackInfoType feedbackInfo)
  {
    this.feedbackInfo = feedbackInfo;
  }

  /**
   * Gets the CompleteSaleRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the CompleteSaleRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the CompleteSaleRequestType.listingType.
   * @return ListingTypeCodeType
   */
  public ListingTypeCodeType getListingType()
  {
    return this.listingType;
  }

  /**
   * Sets the CompleteSaleRequestType.listingType.
   * @param listingType ListingTypeCodeType
   */
  public void setListingType(ListingTypeCodeType listingType)
  {
    this.listingType = listingType;
  }

  /**
   * Gets the CompleteSaleRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the CompleteSaleRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the CompleteSaleRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the CompleteSaleRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the CompleteSaleRequestType.paid.
   * @return Boolean
   */
  public Boolean getPaid()
  {
    return this.paid;
  }

  /**
   * Sets the CompleteSaleRequestType.paid.
   * @param paid Boolean
   */
  public void setPaid(Boolean paid)
  {
    this.paid = paid;
  }

  /**
   * Gets the CompleteSaleRequestType.shipment.
   * @return ShipmentType
   */
  public ShipmentType getShipment()
  {
    return this.shipment;
  }

  /**
   * Sets the CompleteSaleRequestType.shipment.
   * @param shipment ShipmentType
   */
  public void setShipment(ShipmentType shipment)
  {
    this.shipment = shipment;
  }

  /**
   * Gets the CompleteSaleRequestType.shipped.
   * @return Boolean
   */
  public Boolean getShipped()
  {
    return this.shipped;
  }

  /**
   * Sets the CompleteSaleRequestType.shipped.
   * @param shipped Boolean
   */
  public void setShipped(Boolean shipped)
  {
    this.shipped = shipped;
  }

  /**
   * Gets the CompleteSaleRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the CompleteSaleRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

