/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.ArrayList;

import java.lang.Boolean;
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UserID</code> - Specifies the seller whose items will be returned. <b>UserID</b> is an optional
 * input. If not specified, retrieves listings for the user identified by the
 * authentication token passed in the request. Note that since user
 * information is anonymous to everyone except the bidder and the seller
 * (during an active auction), only sellers looking for information about
 * their own listings and bidders who know the user IDs of their sellers will
 * be able to make this API call successfully.
 * <br> <B>Input property:</B> <code>MotorsDealerUsers</code> - Specifies the list of Motors Dealer sellers for which a special set of
 * metrics can be requested. Applies to eBay Motors Pro applications only.
 * <br> <B>Input property:</B> <code>EndTimeFilter</code> - Helper wrapper to set GetSellerListRequestType EndTimeFrom, EndTimeTo:
 * TimeFrom sets GetSellerListRequestType.EndTimeFrom: 
 * Specifies the earliest (oldest) date to use in a date range filter based on
 * item end time. 
 * <br/><br/>								
 * Specify either an end-time range or a start-time range
 * filter in every call request. Each of the time ranges must be a value less than
 * 120 days.
 * TimeTo sets GetSellerListRequestType.EndTimeTo: 
 * Specifies the latest (most recent) date to use in a date range filter based
 * on item end time. Must be specified if <b>EndTimeFrom</b> is specified.
 * <br> <B>Input property:</B> <code>Sort</code> - Specifies the order in which returned items are sorted (based on the end
 * dates of the item listings). Valid values:
 * <br>
 * 0 = No sorting<br>
 * 1 = Sort in descending order<br>
 * 2 = Sort in ascending order<br>
 * <br> <B>Input property:</B> <code>StartTimeFilter</code> - Helper wrapper to set GetSellerListRequestType StartTimeFrom, StartTimeTo:
 * TimeFrom sets GetSellerListRequestType.StartTimeFrom: 
 * Specifies the earliest (oldest) date to use in a date range filter based on
 * item start time. Each of the time ranges must be a value less than
 * 120 days. In all calls, at least one date-range filter must be specified
 * (i.e., you must specify either the end time range or start time range
 * in every request).
 * TimeTo sets GetSellerListRequestType.StartTimeTo: 
 * Specifies the latest (most recent) date to use in a date range filter based
 * on item start time. Must be specified if <b>StartTimeFrom</b> is specified.
 * <br> <B>Input property:</B> <code>Pagination</code> - Contains the data controlling the pagination of the returned values.
 * If you set a <b>DetailLevel</b> in this call, you must set pagination values.
 * The <b>Pagination</b> field contains
 * the number of items to be returned per page of data (per call),
 * and the page number to return with the current call.
 * <br> <B>Input property:</B> <code>GranularityLevel</code> - Specifies the subset of item and user fields to return. See <b>GetSellerList</b> 
 * for a list of the fields that are returned
 * for each granularity level. For <b>GetSellerLis</b>t, use <b>DetailLevel</b> or
 * <b>GranularityLevel</b> in a request, but not both. For <b>GetSellerList</b>, if
 * <b>GranularityLevel</b> is specified, <b>DetailLevel</b> is ignored.
 * <br> <B>Input property:</B> <code>SKUArray</code> - Container for a set of SKUs.
 * Filters (reduces) the response to only include active listings
 * that the seller listed with any of the specified SKUs.
 * If multiple listings include the same SKU, they are
 * all returned (assuming they also match the other criteria
 * in the <b>GetSellerList</b> request).<br>
 * <br>
 * <b>SKUArray</b> can be used to retrieve items listed by the user
 * identified in <b>AuthToken</b> or in <b>UserID</b>.<br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Listings with matching SKUs are returned regardless of their
 * <b>Item.InventoryTrackingMethod</b> settings.
 * </span>
 * <br> <B>Input property:</B> <code>IncludeWatchCount</code> - Specifies whether to include <b>WatchCount</b> in Item nodes returned.
 * <b>WatchCount</b> is only returned with <b>DetailLevel ReturnAll</b> .
 * <br> <B>Input property:</B> <code>AdminEndedItemsOnly</code> - Specifies whether to return only items that were administratively ended
 * based on a policy violation.
 * <br> <B>Input property:</B> <code>CategoryID</code> - The category ID for the items retrieved.
 * If you specify <b>CategoryID</b> in a <b>GetSellerList</b> call,
 * the response contains only items in the category you specify.
 * <br> <B>Input property:</B> <code>IncludeVariations</code> - If true, the <b>Variations</b> node is returned for all multi-variation
 * listings in the response.<br>
 * <br>
 * <b>Note:</b> If the seller includes a large number of
 * variations in many listings, using this flag may degrade the
 * call's performance. Therefore, when you use this flag, you
 * may need to reduce the total number of items you're requesting
 * at once.
 * <br/><br/>
 * For example, you may need to use shorter time ranges in the
 * <b>EndTime</b> or <b>StartTime</b> filters, fewer entries per page in
 * <b>Pagination</b>, and/or <b>SKUArray</b>.
 * <br> <B>Output property:</B> <code>PaginationResult</code> - Contains information regarding the pagination of data (if pagination is
 * used), including total number of pages and total number of entries.
 * <br> <B>Output property:</B> <code>HasMoreItems</code> - If true, there are more items yet to be retrieved. Additional
 * <b>GetSellerList</b> calls with higher page numbers or more items per page must
 * be made to retrieve these items. Not returned if no items match the
 * request.
 * <br> <B>Output property:</B> <code>ReturnedItems</code> - Contains the list of the seller's items, one <b>ItemType</b> object per item.
 * Returns empty if no items are available that match the request.
 * <br> <B>Output property:</B> <code>ReturnedItemsPerPage</code> - Indicates the number of items that are being returned per page of data
 * (i.e., per call). Will be the same as the value specified in the
 * <b>Pagination.EntriesPerPage</b> input. Only returned if items are returned.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Indicates which page of data was just returned. Will be the same as the
 * value specified in the <b>Pagination.PageNumber</b> input. (If the input is
 * higher than the total number of pages, the call fails with an error.)
 * Only returned if items are returned.
 * <br> <B>Output property:</B> <code>ReturnedItemCountActual</code> - Indicates the total number of items returned (i.e., the number of
 * ItemType objects in ItemArray).
 * <br> <B>Output property:</B> <code>Seller</code> - Indicates the seller whose items are returned. The seller is the eBay
 * member whose <b>UserID</b> was passed in the request. If <b>UserID</b> was not
 * specified, the seller is the user who made the request (identified by
 * eBayAuthToken).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerListCall extends com.ebay.sdk.ApiCall
{
  
  private String userID = null;
  private UserIDArrayType motorsDealerUsers = null;
  private TimeFilter endTimeFilter = null;
  private int sort = 0;
  private TimeFilter startTimeFilter = null;
  private PaginationType pagination = null;
  private GranularityLevelCodeType granularityLevel = null;
  private SKUArrayType sKUArray = null;
  private Boolean includeWatchCount = null;
  private Boolean adminEndedItemsOnly = null;
  private Integer categoryID = null;
  private Boolean includeVariations = null;
  private GetSellerListRequestType request=null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreItems=false;
  private ItemType[] returnedItems=null;
  private Integer returnedItemsPerPage=null;
  private Integer returnedPageNumber=null;
  private int returnedItemCountActual=0;
  private UserType seller=null;


  /**
   * Constructor.
   */
  public GetSellerListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a list of the items posted by the authenticated user, including
   * the related item data.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ItemType[] object.
   */
  public ItemType[] getSellerList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerListRequestType req;
    if (this.request != null)
    {
      req = this.request;
    } else {
      req = new GetSellerListRequestType();
      req.setDetailLevel(this.getDetailLevel());
      if (this.userID != null)
        req.setUserID(this.userID);
      if (this.motorsDealerUsers != null)
        req.setMotorsDealerUsers(this.motorsDealerUsers);
      if (this.endTimeFilter != null)
      {
        req.setEndTimeFrom(this.endTimeFilter.getTimeFrom());
        req.setEndTimeTo(this.endTimeFilter.getTimeTo());
      }
      if (this.sort != 0)
        req.setSort(new Integer(this.sort));
      if (this.startTimeFilter != null)
      {
        req.setStartTimeFrom(this.startTimeFilter.getTimeFrom());
        req.setStartTimeTo(this.startTimeFilter.getTimeTo());
      }
      if (this.pagination != null)
        req.setPagination(this.pagination);
      if (this.granularityLevel != null)
        req.setGranularityLevel(this.granularityLevel);
      if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
      if (this.includeWatchCount != null)
        req.setIncludeWatchCount(this.includeWatchCount);
      if (this.adminEndedItemsOnly != null)
        req.setAdminEndedItemsOnly(this.adminEndedItemsOnly);
      if (this.categoryID != null)
        req.setCategoryID(this.categoryID);
      if (this.includeVariations != null)
        req.setIncludeVariations(this.includeVariations);
  
    }

    GetSellerListResponseType resp = (GetSellerListResponseType) execute(req);

    this.paginationResult = resp.getPaginationResult();
    this.hasMoreItems = (resp.isHasMoreItems() == null? false: resp.isHasMoreItems().booleanValue());
    this.returnedItems = (resp.getItemArray() == null? null: resp.getItemArray().getItem());
    this.returnedItemsPerPage = resp.getItemsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedItemCountActual = (resp.getReturnedItemCountActual() == null? 0: resp.getReturnedItemCountActual().intValue());
    this.seller = resp.getSeller();
    return this.getReturnedItems();
  }

  /**
   * Gets the GetSellerListRequestType.request.
   * @return GetSellerListRequestType
   */
  public GetSellerListRequestType getRequest()
  {
    return this.request;
  }


  /**
   * Sets the GetSellerListRequestType.request.
   * @param request GetSellerListRequestType
   */
  public void setRequest(GetSellerListRequestType request)
  {
    this.request = request;
  }

  /**
   * Gets the GetSellerListRequestType.adminEndedItemsOnly.
   * @return Boolean
   */
  public Boolean getAdminEndedItemsOnly()
  {
    return this.adminEndedItemsOnly;
  }

  /**
   * Sets the GetSellerListRequestType.adminEndedItemsOnly.
   * @param adminEndedItemsOnly Boolean
   */
  public void setAdminEndedItemsOnly(Boolean adminEndedItemsOnly)
  {
    this.adminEndedItemsOnly = adminEndedItemsOnly;
  }

  /**
   * Gets the GetSellerListRequestType.categoryID.
   * @return Integer
   */
  public Integer getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetSellerListRequestType.categoryID.
   * @param categoryID Integer
   */
  public void setCategoryID(Integer categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetSellerListRequestType.endTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getEndTimeFilter()
  {
    return this.endTimeFilter;
  }

  /**
   * Sets the GetSellerListRequestType.endTimeFilter.
   * @param endTimeFilter TimeFilter
   */
  public void setEndTimeFilter(TimeFilter endTimeFilter)
  {
    this.endTimeFilter = endTimeFilter;
  }

  /**
   * Gets the GetSellerListRequestType.granularityLevel.
   * @return GranularityLevelCodeType
   */
  public GranularityLevelCodeType getGranularityLevel()
  {
    return this.granularityLevel;
  }

  /**
   * Sets the GetSellerListRequestType.granularityLevel.
   * @param granularityLevel GranularityLevelCodeType
   */
  public void setGranularityLevel(GranularityLevelCodeType granularityLevel)
  {
    this.granularityLevel = granularityLevel;
  }

  /**
   * Gets the GetSellerListRequestType.includeVariations.
   * @return Boolean
   */
  public Boolean getIncludeVariations()
  {
    return this.includeVariations;
  }

  /**
   * Sets the GetSellerListRequestType.includeVariations.
   * @param includeVariations Boolean
   */
  public void setIncludeVariations(Boolean includeVariations)
  {
    this.includeVariations = includeVariations;
  }

  /**
   * Gets the GetSellerListRequestType.includeWatchCount.
   * @return Boolean
   */
  public Boolean getIncludeWatchCount()
  {
    return this.includeWatchCount;
  }

  /**
   * Sets the GetSellerListRequestType.includeWatchCount.
   * @param includeWatchCount Boolean
   */
  public void setIncludeWatchCount(Boolean includeWatchCount)
  {
    this.includeWatchCount = includeWatchCount;
  }

  /**
   * Gets the GetSellerListRequestType.motorsDealerUsers.
   * @return UserIDArrayType
   */
  public UserIDArrayType getMotorsDealerUsers()
  {
    return this.motorsDealerUsers;
  }

  /**
   * Sets the GetSellerListRequestType.motorsDealerUsers.
   * @param motorsDealerUsers UserIDArrayType
   */
  public void setMotorsDealerUsers(UserIDArrayType motorsDealerUsers)
  {
    this.motorsDealerUsers = motorsDealerUsers;
  }

  /**
   * Gets the GetSellerListRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellerListRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellerListRequestType.sKUArray.
   * @return SKUArrayType
   */
  public SKUArrayType getSKUArray()
  {
    return this.sKUArray;
  }

  /**
   * Sets the GetSellerListRequestType.sKUArray.
   * @param sKUArray SKUArrayType
   */
  public void setSKUArray(SKUArrayType sKUArray)
  {
    this.sKUArray = sKUArray;
  }

  /**
   * Gets the GetSellerListRequestType.sort.
   * @return int
   */
  public int getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetSellerListRequestType.sort.
   * @param sort int
   */
  public void setSort(int sort)
  {
    this.sort = sort;
  }

  /**
   * Gets the GetSellerListRequestType.startTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getStartTimeFilter()
  {
    return this.startTimeFilter;
  }

  /**
   * Sets the GetSellerListRequestType.startTimeFilter.
   * @param startTimeFilter TimeFilter
   */
  public void setStartTimeFilter(TimeFilter startTimeFilter)
  {
    this.startTimeFilter = startTimeFilter;
  }

  /**
   * Gets the GetSellerListRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetSellerListRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }
/**
   * Get entire item list of the seller. Properties EndDate and Pagination
   * will be ignored. Patination related return fields (paginationResult,
   * hasMoreItems) will be ignored.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return ItemType[]
   */
  public com.ebay.soap.eBLBaseComponents.ItemType[] getEntireSellerList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerListRequestType req = new GetSellerListRequestType();

    setRequest(req);
      req.setDetailLevel(this.getDetailLevel());
      if (this.userID != null)
        req.setUserID(this.userID);
      if (this.endTimeFilter != null)
      {
        req.setEndTimeFrom(this.endTimeFilter.getTimeFrom());
        req.setEndTimeTo(this.endTimeFilter.getTimeTo());
      }
      if (this.sort != 0)
        req.setSort(new Integer(this.sort));
      if (this.startTimeFilter != null)
      {
        req.setStartTimeFrom(this.startTimeFilter.getTimeFrom());
        req.setStartTimeTo(this.startTimeFilter.getTimeTo());
      }
      if (this.granularityLevel != null)
        req.setGranularityLevel(this.granularityLevel);
      if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
      if (this.includeWatchCount != null)
        req.setIncludeWatchCount(this.includeWatchCount);

    int pageNum = 1;
    PaginationType pgn = new PaginationType();
    pgn.setEntriesPerPage(new Integer(100));
    pgn.setPageNumber(new Integer(pageNum++));

    req.setPagination(pgn);

    ArrayList items = new ArrayList();

    while(true)
    {
      GetSellerListResponseType resp = (GetSellerListResponseType)this.execute(req);
      ItemType tm[] = resp.getItemArray().getItem();
      if (tm != null) {
        for(int i = 0; i < tm.length; i ++)
          items.add(tm[i]);
      }
      if( resp.isHasMoreItems() == null || !resp.isHasMoreItems().booleanValue() )
        break;
      this.seller = resp.getSeller();
      this.returnedItemCountActual = resp.getReturnedItemCountActual() != null ? resp.getReturnedItemCountActual().intValue()
          : 0;

      // Increment page number.
      pgn.setPageNumber(new Integer(pageNum++));
    }

    // Build results.
    this.returnedItems = new ItemType[items.size()];
    for(int i = 0; i < returnedItems.length; i ++)
    {
      returnedItems[i] = (ItemType)items.get(i);
    }
    return returnedItems;
  }



  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.hasMoreItems.
   * 
   * @return boolean
   */
  public boolean getHasMoreItems()
  {
    return this.hasMoreItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItemCountActual.
   * 
   * @return int
   */
  public int getReturnedItemCountActual()
  {
    return this.returnedItemCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItems.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedItems()
  {
    return this.returnedItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItemsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedItemsPerPage()
  {
    return this.returnedItemsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.seller.
   * 
   * @return UserType
   */
  public UserType getSeller()
  {
    return this.seller;
  }

}

