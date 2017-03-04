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
 * Wrapper class of the GetMyeBaySelling call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ScheduledList</code> - Returns the list of items the user has scheduled to sell but whose
 * listings have not yet opened.
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>ActiveList</code> - Returns the list of items the user is actively selling (the currently
 * active listings).
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>SoldList</code> - Returns the list of items the user has sold.
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>UnsoldList</code> - Returns the list of items the user has listed, but whose listings
 * have ended without being sold.
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>BidList</code> - Return the list of active items on which there are bids.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>DeletedFromSoldList</code> - Returns the list of items the user sold, and then deleted from
 * their My eBay page. Allowed values for DurationInDays are 0-90.
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>DeletedFromUnsoldList</code> - Returns the list of items the user either ended or did not sell, and
 * subsequently were deleted them from their My eBay page. Allowed
 * values for DurationInDays are 0-90.
 * <br><br>
 * Set <b>Include</b> to 
 * <code>true</code> to return the default response set.
 * <br> <B>Input property:</B> <code>SellingSummary</code> - Returns a summary of the user's buying activity.
 * <br><br>
 * The <b>SellingSummary</b> is always
 * returned by default. Add a <b>SellingSummary</b> element with an <b>Include</b> field
 * set to false to exclude the <b>SellingSummary</b> from your response.
 * <br> <B>Input property:</B> <code>HideVariations</code> - If true, the <b>Variations</b> node is omitted for all multi-variation
 * listings in the response.
 * If false, the <b>Variations</b> node is returned for all
 * multi-variation listings in the response. <br>
 * <br>
 * Please note that if the seller includes a large number of
 * variations in many listings, retrieving variations (setting this
 * flag to <code>false</code>) may degrade the call's performance. Therefore,
 * when this is false, you may need to reduce the total
 * number of items you're requesting at once (by using other input
 * fields, such as <b>Pagination</b>).
 * <br> <B>Output property:</B> <code>ReturnedSellingSummary</code> - Contains summary information about the items the user is selling.
 * <br> <B>Output property:</B> <code>ReturnedScheduledList</code> - Contains the items the user has scheduled for sale, but whose listings have
 * not yet started.
 * <br> <B>Output property:</B> <code>ReturnedActiveList</code> - Contains the items the user is selling that have active listings.
 * <br> <B>Output property:</B> <code>ReturnedSoldList</code> - Contains the items the user has sold.
 * <br> <B>Output property:</B> <code>ReturnedUnsoldList</code> - Contains the items whose listings have ended but that have not sold.
 * <br> <B>Output property:</B> <code>ReturnedSummary</code> - Contains summary information about the items the user is selling.
 * <br> <B>Output property:</B> <code>ReturnedBidList</code> - This container is no longer applicable to <b>GetMyeBaySelling</b>.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromSoldList</code> - Contains the items the seller has sold and deleted from My eBay.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromUnsoldList</code> - Contains the items with listings that were ended or did not sell and have been deleted from My eBay.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyeBaySellingCall extends com.ebay.sdk.ApiCall
{
  
  private ItemListCustomizationType scheduledList = null;
  private ItemListCustomizationType activeList = null;
  private ItemListCustomizationType soldList = null;
  private ItemListCustomizationType unsoldList = null;
  private ItemListCustomizationType bidList = null;
  private ItemListCustomizationType deletedFromSoldList = null;
  private ItemListCustomizationType deletedFromUnsoldList = null;
  private ItemListCustomizationType sellingSummary = null;
  private Boolean hideVariations = null;
  private GetMyeBaySellingRequestType myeBaySellingRequest=null;
  private SellingSummaryType returnedSellingSummary=null;
  private PaginatedItemArrayType returnedScheduledList=null;
  private PaginatedItemArrayType returnedActiveList=null;
  private PaginatedOrderTransactionArrayType returnedSoldList=null;
  private PaginatedItemArrayType returnedUnsoldList=null;
  private MyeBaySellingSummaryType returnedSummary=null;
  private PaginatedItemArrayType returnedBidList=null;
  private PaginatedOrderTransactionArrayType returnedDeletedFromSoldList=null;
  private PaginatedItemArrayType returnedDeletedFromUnsoldList=null;


  /**
   * Constructor.
   */
  public GetMyeBaySellingCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyeBaySellingCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information regarding the user's selling activity,
   * such as items that the user is currently selling (the Active list),
   * items that have bids, sold items, and unsold items.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyeBaySelling()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyeBaySellingRequestType req;
    if (this.myeBaySellingRequest != null)
    {
      req = this.myeBaySellingRequest;
    } else {
      req = new GetMyeBaySellingRequestType();
      if (this.scheduledList != null)
        req.setScheduledList(this.scheduledList);
      if (this.activeList != null)
        req.setActiveList(this.activeList);
      if (this.soldList != null)
        req.setSoldList(this.soldList);
      if (this.unsoldList != null)
        req.setUnsoldList(this.unsoldList);
      if (this.bidList != null)
        req.setBidList(this.bidList);
      if (this.deletedFromSoldList != null)
        req.setDeletedFromSoldList(this.deletedFromSoldList);
      if (this.deletedFromUnsoldList != null)
        req.setDeletedFromUnsoldList(this.deletedFromUnsoldList);
      if (this.sellingSummary != null)
        req.setSellingSummary(this.sellingSummary);
      if (this.hideVariations != null)
        req.setHideVariations(this.hideVariations);
  
    }

    GetMyeBaySellingResponseType resp = (GetMyeBaySellingResponseType) execute(req);

    this.returnedSellingSummary = resp.getSellingSummary();
    this.returnedScheduledList = resp.getScheduledList();
    this.returnedActiveList = resp.getActiveList();
    this.returnedSoldList = resp.getSoldList();
    this.returnedUnsoldList = resp.getUnsoldList();
    this.returnedSummary = resp.getSummary();
    this.returnedBidList = resp.getBidList();
    this.returnedDeletedFromSoldList = resp.getDeletedFromSoldList();
    this.returnedDeletedFromUnsoldList = resp.getDeletedFromUnsoldList();

  }

  /**
   * Gets the GetMyeBaySellingRequestType.myeBaySellingRequest.
   * @return GetMyeBaySellingRequestType
   */
  public GetMyeBaySellingRequestType getMyeBaySellingRequest()
  {
    return this.myeBaySellingRequest;
  }


  /**
   * Sets the GetMyeBaySellingRequestType.myeBaySellingRequest.
   * @param myeBaySellingRequest GetMyeBaySellingRequestType
   */
  public void setMyeBaySellingRequest(GetMyeBaySellingRequestType myeBaySellingRequest)
  {
    this.myeBaySellingRequest = myeBaySellingRequest;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.activeList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getActiveList()
  {
    return this.activeList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.activeList.
   * @param activeList ItemListCustomizationType
   */
  public void setActiveList(ItemListCustomizationType activeList)
  {
    this.activeList = activeList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.bidList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBidList()
  {
    return this.bidList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.bidList.
   * @param bidList ItemListCustomizationType
   */
  public void setBidList(ItemListCustomizationType bidList)
  {
    this.bidList = bidList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.deletedFromSoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromSoldList()
  {
    return this.deletedFromSoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.deletedFromSoldList.
   * @param deletedFromSoldList ItemListCustomizationType
   */
  public void setDeletedFromSoldList(ItemListCustomizationType deletedFromSoldList)
  {
    this.deletedFromSoldList = deletedFromSoldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.deletedFromUnsoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromUnsoldList()
  {
    return this.deletedFromUnsoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.deletedFromUnsoldList.
   * @param deletedFromUnsoldList ItemListCustomizationType
   */
  public void setDeletedFromUnsoldList(ItemListCustomizationType deletedFromUnsoldList)
  {
    this.deletedFromUnsoldList = deletedFromUnsoldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.hideVariations.
   * @return Boolean
   */
  public Boolean getHideVariations()
  {
    return this.hideVariations;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.hideVariations.
   * @param hideVariations Boolean
   */
  public void setHideVariations(Boolean hideVariations)
  {
    this.hideVariations = hideVariations;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.scheduledList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getScheduledList()
  {
    return this.scheduledList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.scheduledList.
   * @param scheduledList ItemListCustomizationType
   */
  public void setScheduledList(ItemListCustomizationType scheduledList)
  {
    this.scheduledList = scheduledList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.sellingSummary.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getSellingSummary()
  {
    return this.sellingSummary;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.sellingSummary.
   * @param sellingSummary ItemListCustomizationType
   */
  public void setSellingSummary(ItemListCustomizationType sellingSummary)
  {
    this.sellingSummary = sellingSummary;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.soldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getSoldList()
  {
    return this.soldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.soldList.
   * @param soldList ItemListCustomizationType
   */
  public void setSoldList(ItemListCustomizationType soldList)
  {
    this.soldList = soldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.unsoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getUnsoldList()
  {
    return this.unsoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.unsoldList.
   * @param unsoldList ItemListCustomizationType
   */
  public void setUnsoldList(ItemListCustomizationType unsoldList)
  {
    this.unsoldList = unsoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.
   * 
   * @return GetMyeBaySellingResponseType
   */
  public GetMyeBaySellingResponseType getReturnedMyeBaySellingResponse()
  {
    return (GetMyeBaySellingResponseType) this.getResponseObject();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedActiveList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedActiveList()
  {
    return this.returnedActiveList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedBidList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBidList()
  {
    return this.returnedBidList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedDeletedFromSoldList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedDeletedFromSoldList()
  {
    return this.returnedDeletedFromSoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedDeletedFromUnsoldList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedDeletedFromUnsoldList()
  {
    return this.returnedDeletedFromUnsoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedScheduledList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedScheduledList()
  {
    return this.returnedScheduledList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSellingSummary.
   * 
   * @return SellingSummaryType
   */
  public SellingSummaryType getReturnedSellingSummary()
  {
    return this.returnedSellingSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSoldList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedSoldList()
  {
    return this.returnedSoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSummary.
   * 
   * @return MyeBaySellingSummaryType
   */
  public MyeBaySellingSummaryType getReturnedSummary()
  {
    return this.returnedSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedUnsoldList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedUnsoldList()
  {
    return this.returnedUnsoldList;
  }

}

