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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetPromotionalSaleDetails call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PromotionalSaleID</code> - The ID of the promotional sale about which you want information. If you do
 * not specify this field, then all promotional sales for the seller making
 * the call are returned or only those promotional sales matching the
 * specified promotional sale status filter, <b>PromotionalSaleStatus</b>.
 * <br><br>
 * If <b>PromotionalSaleID</b> and <b>PromotionalSaleStatus</b> are both specified, the
 * single promotional sale specified by ID is returned only if its status
 * matches the specified status filter.
 * <br> <B>Input property:</B> <code>PromotionalSaleStatus</code> - Specifies the promotional sales to return, based upon their status. For
 * example, specify <b>Scheduled</b> to retrieve only promotional sales with a
 * Status of Scheduled. If you want to retrieve promotional sales for more
 * than one status, you can repeat the field with an additional status value,
 * such as Active.
 * <br><br>
 * If this field is used together with <b>PromotionalSaleID</b>, the single
 * promotional sale specified by ID is returned only if its status
 * matches the specified status filter.
 * <br><br>
 * If neither field is used, all of the seller's promotional sales are
 * returned, regardless of status.
 * <br> <B>Output property:</B> <code>ReturnedPromotionalSaleDetails</code> - Contains information about a promotional sale or sales. If you did not 
 * specify a <b>PromotionalSaleID</b> in the request, then all promotional sales
 * for the seller are returned. Promotional sales enable sellers to add 
 * discounts and/or free shipping to items. 
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetPromotionalSaleDetailsCall extends com.ebay.sdk.ApiCall
{
  
  private Long promotionalSaleID = null;
  private PromotionalSaleStatusCodeType[] promotionalSaleStatus = null;
  private PromotionalSaleArrayType returnedPromotionalSaleDetails=null;


  /**
   * Constructor.
   */
  public GetPromotionalSaleDetailsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetPromotionalSaleDetailsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information about promotional sales set up by an eBay store owner
   * (the authenticated caller).
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The PromotionalSaleArrayType object.
   */
  public PromotionalSaleArrayType getPromotionalSaleDetails()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetPromotionalSaleDetailsRequestType req;
    req = new GetPromotionalSaleDetailsRequestType();
    if (this.promotionalSaleID != null)
      req.setPromotionalSaleID(this.promotionalSaleID);
    if (this.promotionalSaleStatus != null)
      req.setPromotionalSaleStatus(this.promotionalSaleStatus);

    GetPromotionalSaleDetailsResponseType resp = (GetPromotionalSaleDetailsResponseType) execute(req);

    this.returnedPromotionalSaleDetails = resp.getPromotionalSaleDetails();
    return this.getReturnedPromotionalSaleDetails();
  }

  /**
   * Gets the GetPromotionalSaleDetailsRequestType.promotionalSaleID.
   * @return Long
   */
  public Long getPromotionalSaleID()
  {
    return this.promotionalSaleID;
  }

  /**
   * Sets the GetPromotionalSaleDetailsRequestType.promotionalSaleID.
   * @param promotionalSaleID Long
   */
  public void setPromotionalSaleID(Long promotionalSaleID)
  {
    this.promotionalSaleID = promotionalSaleID;
  }

  /**
   * Gets the GetPromotionalSaleDetailsRequestType.promotionalSaleStatus.
   * @return PromotionalSaleStatusCodeType[]
   */
  public PromotionalSaleStatusCodeType[] getPromotionalSaleStatus()
  {
    return this.promotionalSaleStatus;
  }

  /**
   * Sets the GetPromotionalSaleDetailsRequestType.promotionalSaleStatus.
   * @param promotionalSaleStatus PromotionalSaleStatusCodeType[]
   */
  public void setPromotionalSaleStatus(PromotionalSaleStatusCodeType[] promotionalSaleStatus)
  {
    this.promotionalSaleStatus = promotionalSaleStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetPromotionalSaleDetailsResponseType.returnedPromotionalSaleDetails.
   * 
   * @return PromotionalSaleArrayType
   */
  public PromotionalSaleArrayType getReturnedPromotionalSaleDetails()
  {
    return this.returnedPromotionalSaleDetails;
  }

}

