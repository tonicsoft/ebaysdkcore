/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetShippingDiscountProfiles call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CurrencyID</code> - The three-digit code of the currency to be used for shipping cost discounts and
 * insurance for Combined Invoice orders. A discount profile can only be associated
 * with a listing if the <b>CurrencyID</b> value of the profile matches the 
 * <b>Item.Currency</b> value specified in a listing.
 * <br><br>
 * Required if the user creates flat rate shipping discount profiles, a promotional
 * discount, a packaging/handling cost profile based on a variable
 * discount rule, or if the user defines shipping insurance range/fee pairs.
 * <br><br>
 * Note: There is a currencyID attribute on many elements of SetShippingDiscountProfiles.
 * To avoid an error, be sure to use the same <b>CurrencyID</b> value 
 * in each occurrence within the same request.
 * <br> <B>Input property:</B> <code>CombinedDuration</code> - This field is used to specify the number of days after the sale of an
 * item in which the buyer or seller can combine multiple and mutual order
 * line items into one Combined Invoice order. In a Combined Invoice order,
 * the buyer makes one payment for all order line items, hence only unpaid
 * order line items can be combined into a Combined Invoice order.
 * <br> <B>Input property:</B> <code>ModifyActionCode</code> - Indicates what action to take on the specified flat shipping discount,
 * calculated shipping discount or promotional discount.
 * If the action is Delete and if a flat rate or calculated shipping discount
 * profile is specified, the discount profile identified by
 * DiscountProfile.DiscountProfileID is deleted
 * (see DiscountProfile.MappedDiscountProfileID for related details).
 * <br> <B>Input property:</B> <code>FlatShippingDiscount</code> - Details of a shipping cost discount profile for flat rate shipping.
 * If this is provided, CalculatedShippingDiscount and PromotionalShippingDiscountDetails
 * should be omitted.
 * <br> <B>Input property:</B> <code>CalculatedShippingDiscount</code> - Details of a shipping cost discount profile for calculated shipping.
 * If this is provided, FlatShippingDiscount and PromotionalShippingDiscountDetails
 * should be omitted.
 * <br> <B>Input property:</B> <code>CalculatedHandlingDiscount</code> - This container is used by the seller to specify/modify packaging and handling discounts that are applied 
 * for Combined Invoice orders.
 * <br> <B>Input property:</B> <code>PromotionalShippingDiscountDetails</code> - The data for the promotional shipping discount.
 * If this is provided, FlatShippingDiscount and CalculatedShippingDiscount
 * should be omitted.
 * <br> <B>Input property:</B> <code>ShippingInsurance</code> - Information establishing what fee to apply for domestic shipping insurance
 * for Combined Invoice depending on which range the order item-total price
 * falls into.
 * <br> <B>Input property:</B> <code>InternationalShippingInsurance</code> - Information establishing what fee to apply for international shipping
 * insurance for Combined Invoice depending on which range the order item-total
 * price falls into.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetShippingDiscountProfilesCall extends com.ebay.sdk.ApiCall
{
  
  private CurrencyCodeType currencyID = null;
  private CombinedPaymentPeriodCodeType combinedDuration = null;
  private ModifyActionCodeType modifyActionCode = null;
  private FlatShippingDiscountType flatShippingDiscount = null;
  private CalculatedShippingDiscountType calculatedShippingDiscount = null;
  private CalculatedHandlingDiscountType calculatedHandlingDiscount = null;
  private PromotionalShippingDiscountDetailsType promotionalShippingDiscountDetails = null;
  private ShippingInsuranceType shippingInsurance = null;
  private ShippingInsuranceType internationalShippingInsurance = null;


  /**
   * Constructor.
   */
  public SetShippingDiscountProfilesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetShippingDiscountProfilesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to define shipping cost discount profiles for things such as combined
   * payments for shipping and handling costs.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setShippingDiscountProfiles()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetShippingDiscountProfilesRequestType req;
    req = new SetShippingDiscountProfilesRequestType();
    if (this.currencyID != null)
      req.setCurrencyID(this.currencyID);
    if (this.combinedDuration != null)
      req.setCombinedDuration(this.combinedDuration);
    if (this.modifyActionCode != null)
      req.setModifyActionCode(this.modifyActionCode);
    if (this.flatShippingDiscount != null)
      req.setFlatShippingDiscount(this.flatShippingDiscount);
    if (this.calculatedShippingDiscount != null)
      req.setCalculatedShippingDiscount(this.calculatedShippingDiscount);
    if (this.calculatedHandlingDiscount != null)
      req.setCalculatedHandlingDiscount(this.calculatedHandlingDiscount);
    if (this.promotionalShippingDiscountDetails != null)
      req.setPromotionalShippingDiscountDetails(this.promotionalShippingDiscountDetails);
    if (this.shippingInsurance != null)
      req.setShippingInsurance(this.shippingInsurance);
    if (this.internationalShippingInsurance != null)
      req.setInternationalShippingInsurance(this.internationalShippingInsurance);

    SetShippingDiscountProfilesResponseType resp = (SetShippingDiscountProfilesResponseType) execute(req);


  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.calculatedHandlingDiscount.
   * @return CalculatedHandlingDiscountType
   */
  public CalculatedHandlingDiscountType getCalculatedHandlingDiscount()
  {
    return this.calculatedHandlingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.calculatedHandlingDiscount.
   * @param calculatedHandlingDiscount CalculatedHandlingDiscountType
   */
  public void setCalculatedHandlingDiscount(CalculatedHandlingDiscountType calculatedHandlingDiscount)
  {
    this.calculatedHandlingDiscount = calculatedHandlingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.calculatedShippingDiscount.
   * @return CalculatedShippingDiscountType
   */
  public CalculatedShippingDiscountType getCalculatedShippingDiscount()
  {
    return this.calculatedShippingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.calculatedShippingDiscount.
   * @param calculatedShippingDiscount CalculatedShippingDiscountType
   */
  public void setCalculatedShippingDiscount(CalculatedShippingDiscountType calculatedShippingDiscount)
  {
    this.calculatedShippingDiscount = calculatedShippingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.combinedDuration.
   * @return CombinedPaymentPeriodCodeType
   */
  public CombinedPaymentPeriodCodeType getCombinedDuration()
  {
    return this.combinedDuration;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.combinedDuration.
   * @param combinedDuration CombinedPaymentPeriodCodeType
   */
  public void setCombinedDuration(CombinedPaymentPeriodCodeType combinedDuration)
  {
    this.combinedDuration = combinedDuration;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.currencyID.
   * @return CurrencyCodeType
   */
  public CurrencyCodeType getCurrencyID()
  {
    return this.currencyID;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.currencyID.
   * @param currencyID CurrencyCodeType
   */
  public void setCurrencyID(CurrencyCodeType currencyID)
  {
    this.currencyID = currencyID;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.flatShippingDiscount.
   * @return FlatShippingDiscountType
   */
  public FlatShippingDiscountType getFlatShippingDiscount()
  {
    return this.flatShippingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.flatShippingDiscount.
   * @param flatShippingDiscount FlatShippingDiscountType
   */
  public void setFlatShippingDiscount(FlatShippingDiscountType flatShippingDiscount)
  {
    this.flatShippingDiscount = flatShippingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.internationalShippingInsurance.
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getInternationalShippingInsurance()
  {
    return this.internationalShippingInsurance;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.internationalShippingInsurance.
   * @param internationalShippingInsurance ShippingInsuranceType
   */
  public void setInternationalShippingInsurance(ShippingInsuranceType internationalShippingInsurance)
  {
    this.internationalShippingInsurance = internationalShippingInsurance;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.modifyActionCode.
   * @return ModifyActionCodeType
   */
  public ModifyActionCodeType getModifyActionCode()
  {
    return this.modifyActionCode;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.modifyActionCode.
   * @param modifyActionCode ModifyActionCodeType
   */
  public void setModifyActionCode(ModifyActionCodeType modifyActionCode)
  {
    this.modifyActionCode = modifyActionCode;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.promotionalShippingDiscountDetails.
   * @return PromotionalShippingDiscountDetailsType
   */
  public PromotionalShippingDiscountDetailsType getPromotionalShippingDiscountDetails()
  {
    return this.promotionalShippingDiscountDetails;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.promotionalShippingDiscountDetails.
   * @param promotionalShippingDiscountDetails PromotionalShippingDiscountDetailsType
   */
  public void setPromotionalShippingDiscountDetails(PromotionalShippingDiscountDetailsType promotionalShippingDiscountDetails)
  {
    this.promotionalShippingDiscountDetails = promotionalShippingDiscountDetails;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.shippingInsurance.
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getShippingInsurance()
  {
    return this.shippingInsurance;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.shippingInsurance.
   * @param shippingInsurance ShippingInsuranceType
   */
  public void setShippingInsurance(ShippingInsuranceType shippingInsurance)
  {
    this.shippingInsurance = shippingInsurance;
  }

}

