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
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetBidderList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ActiveItemsOnly</code> - Indicates whether or not to limit the result set to active items. If true, only
 * active items are returned and the EndTimeFrom and EndTimeTo filters are
 * ignored. If false (or not sent), both active and ended items are returned.
 * <br> <B>Input property:</B> <code>EndTimeFrom</code> - Used in conjunction with EndTimeTo. Limits returned items to only those for
 * which the item's end date is on or after the date-time specified. Specify an
 * end date within 30 days prior to today. Items that ended more than 30 days
 * ago are omitted from the results. If specified, EndTimeTo must also be
 * specified. Express date-time in the format YYYY-MM-DD HH:MM:SS, and in GMT.
 * (For information on how to convert between your local time zone and GMT, see
 * Time Values Note.) This field is ignored if ActiveItemsOnly is true.
 * <br> <B>Input property:</B> <code>EndTimeTo</code> - Used in conjunction with EndTimeFrom. Limits returned items to only those for
 * which the item's end date is on or before the date-time specified. If
 * specified, EndTimeFrom must also be specified. Express date-time in the format
 * YYYY-MM-DD HH:MM:SS, and in GMT. This field is ignored if ActiveItemsOnly is
 * true. Note that for GTC items, whose end times automatically increment by 30
 * days every 30 days, an EndTimeTo within in the first 30 days of a listing will
 * refer to the listing's initial end time.
 * <br> <B>Input property:</B> <code>UserID</code> - The user for whom information should be returned. If
 * provided, overrides user defined via RequesterCredentials
 * in header.
 * <br> <B>Input property:</B> <code>granularityLevel</code> - You can control some of the fields returned in the response by specifying one
 * of two values in the GranularityLevel field: Fine or Medium. Fine returns
 * more fields than the default, while setting this field to Medium returns an
 * abbreviated set of results.
 * <br> <B>Output property:</B> <code>ReturnedBidder</code> - Data for one eBay bidder.
 * <br> <B>Output property:</B> <code>ReturnedBidItemArray</code> - Array of items the bidder has bid on, has won or has lost.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetBidderListCall extends com.ebay.sdk.ApiCall
{
  
  private Boolean activeItemsOnly = null;
  private Calendar endTimeFrom = null;
  private Calendar endTimeTo = null;
  private String userID = null;
  private GranularityLevelCodeType granularityLevel = null;
  private UserType returnedBidder=null;
  private ItemType[] returnedBidItemArray=null;


  /**
   * Constructor.
   */
  public GetBidderListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetBidderListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves all items the user is currently bidding on, and the ones they have won
   * or purchased.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getBidderList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetBidderListRequestType req;
    req = new GetBidderListRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.activeItemsOnly != null)
      req.setActiveItemsOnly(this.activeItemsOnly);
    if (this.endTimeFrom != null)
      req.setEndTimeFrom(this.endTimeFrom);
    if (this.endTimeTo != null)
      req.setEndTimeTo(this.endTimeTo);
    if (this.userID != null)
      req.setUserID(this.userID);
    if (this.granularityLevel != null)
      req.setGranularityLevel(this.granularityLevel);

    GetBidderListResponseType resp = (GetBidderListResponseType) execute(req);

    this.returnedBidder = resp.getBidder();
    this.returnedBidItemArray = (resp.getBidItemArray() == null? null: resp.getBidItemArray().getItem());

  }

  /**
   * Gets the GetBidderListRequestType.activeItemsOnly.
   * @return Boolean
   */
  public Boolean getActiveItemsOnly()
  {
    return this.activeItemsOnly;
  }

  /**
   * Sets the GetBidderListRequestType.activeItemsOnly.
   * @param activeItemsOnly Boolean
   */
  public void setActiveItemsOnly(Boolean activeItemsOnly)
  {
    this.activeItemsOnly = activeItemsOnly;
  }

  /**
   * Gets the GetBidderListRequestType.endTimeFrom.
   * @return Calendar
   */
  public Calendar getEndTimeFrom()
  {
    return this.endTimeFrom;
  }

  /**
   * Sets the GetBidderListRequestType.endTimeFrom.
   * @param endTimeFrom Calendar
   */
  public void setEndTimeFrom(Calendar endTimeFrom)
  {
    this.endTimeFrom = endTimeFrom;
  }

  /**
   * Gets the GetBidderListRequestType.endTimeTo.
   * @return Calendar
   */
  public Calendar getEndTimeTo()
  {
    return this.endTimeTo;
  }

  /**
   * Sets the GetBidderListRequestType.endTimeTo.
   * @param endTimeTo Calendar
   */
  public void setEndTimeTo(Calendar endTimeTo)
  {
    this.endTimeTo = endTimeTo;
  }

  /**
   * Gets the GetBidderListRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetBidderListRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBidderListResponseType.returnedBidItemArray.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedBidItemArray()
  {
    return this.returnedBidItemArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBidderListResponseType.returnedBidder.
   * 
   * @return UserType
   */
  public UserType getReturnedBidder()
  {
    return this.returnedBidder;
  }

  /**
   * Gets the GetBidderListRequestType.granularityLevel.
   * @return GranularityLevelCodeType
   */
  public GranularityLevelCodeType getgranularityLevel()
  {
    return this.granularityLevel;
  }

  /**
   * Sets the GetBidderListRequestType.granularityLevel.
   * @param granularityLevel GranularityLevelCodeType
   */
  public void setgranularityLevel(GranularityLevelCodeType granularityLevel)
  {
    this.granularityLevel = granularityLevel;
  }

}

