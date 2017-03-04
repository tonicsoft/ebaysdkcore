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
 * Wrapper class of the GetMyeBayBuying call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>WatchList</code> - Returns the list of items being watched by the user.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>BidList</code> - Returns the list of items on which the user has bid.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>BestOfferList</code> - Returns the list of items on which the user has placed best offers.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>WonList</code> - Returns the list of items on which the use has bid.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>LostList</code> - Returns the list of items on which the user has bid on and lost.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>FavoriteSearches</code> - Returns the list of searches that the user has saved in My eBay. Returned
 * only if the user has saved searches.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>FavoriteSellers</code> - Returns the list of favorite sellers that the user has saved in My eBay.
 * Returned only if the user has saved a list of favorite sellers.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>SecondChanceOffer</code> - Returns the list of second chance offers made by the user. Returned only
 * if the user has made second chance offers.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>BidAssistantList</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>DeletedFromWonList</code> - Returns the list of items the user has won, and subsequently deleted from
 * their My eBay page.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>DeletedFromLostList</code> - Returns the list of items (auctions) the user did not win and were
 * subsequently deleted from their My eBay page.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>BuyingSummary</code> - Returns a summary of the user's buying activity.
 * <br><br>
 * <span class="tablenote"><b>Note:</b>
 * The buying summary container is
 * not included in the response by default. To include a <b>BuyingSummary</b> element, add an <b>Include</b> field set to <code>true</code> to the request.
 * </span>
 * <br> <B>Input property:</B> <code>UserDefinedLists</code> - Returns the user defined lists, which are lists created by the user in the eBay
 * UI and filled with items, or sellers, or searches using the 
 * "Add to List" feature.
 * <br><br>
 * Set Include to true to return the default response set.
 * <br> <B>Input property:</B> <code>HideVariations</code> - If true, the Variations node is omitted for all multi-variation
 * listings in the response.
 * If false, the Variations node is returned for all
 * multi-variation listings in the response. <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * If the seller includes a large number of
 * variations in many listings, retrieving variations (setting this
 * flag to false) may degrade the call's performance. Therefore,
 * when this is false, you may need to reduce the total
 * number of items you're requesting at once (by using other input
 * fields, such as Pagination).
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedBuyingSummary</code> - Contains a summary of the items the user has bid on. Returned at all detail
 * levels.
 * <br> <B>Output property:</B> <code>ReturnedWatchList</code> - Contains the items the user is watching. Only returned if items exist that
 * meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedBidList</code> - Contains all the items the buyer has bid on.
 * Only returned if items exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedBestOfferList</code> - Contains the items the user has placed Best Offers on. Only returned if
 * items exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedWonList</code> - Contains the items the user has bid on and won. Only returned if items
 * exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedLostList</code> - Contains the items the user has bid on and lost. Only returned if items
 * exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedFavoriteSearches</code> - Contains a list of the user's favorite searches. Only returned if the
 * user has Favorite Searches. The search name, search query, and search
 * elements, such as QueryKeywords, SortOrder, and Condition are returned.
 * <br><br>
 * You can paste the Search Query response, that comes back as a URL, into a browser
 * to re-play the Favorite Search.
 * <br><br>
 * The search elements that are returned by this call can be used as input
 * for the Shopping API FindItemsAdvanced request.
 * <br> <B>Output property:</B> <code>ReturnedFavoriteSellers</code> - Contains a list of the user's favorite sellers. Only returned if items
 * exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedSecondChanceOffer</code> - Contains the list of second chance offers the user has received. Only
 * returned if items exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedBidAssistantList</code> - Contains the items that were bid on using the Bid Assistant feature.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromWonList</code> - Contains the items the buyer has bid on, won, and deleted from My eBay.
 * Only returned if items exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromLostList</code> - Contains the items the buyer has bid on, lost, and deleted from My eBay.
 * Only returned if items exist that meet the request criteria.
 * <br> <B>Output property:</B> <code>ReturnedUserDefinedList</code> - Contains the items, searches, or sellers that the user has saved to this 
 * list using the "Add to list" feature.  The name of the list is given by the 
 * "Name" element. Returned only if UserDefineLists is specified in the request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyeBayBuyingCall extends com.ebay.sdk.ApiCall
{
  
  private ItemListCustomizationType watchList = null;
  private ItemListCustomizationType bidList = null;
  private ItemListCustomizationType bestOfferList = null;
  private ItemListCustomizationType wonList = null;
  private ItemListCustomizationType lostList = null;
  private MyeBaySelectionType favoriteSearches = null;
  private MyeBaySelectionType favoriteSellers = null;
  private MyeBaySelectionType secondChanceOffer = null;
  private BidAssistantListType bidAssistantList = null;
  private ItemListCustomizationType deletedFromWonList = null;
  private ItemListCustomizationType deletedFromLostList = null;
  private ItemListCustomizationType buyingSummary = null;
  private MyeBaySelectionType userDefinedLists = null;
  private Boolean hideVariations = null;
  private GetMyeBayBuyingRequestType myeBayBuyingRequest=null;
  private BuyingSummaryType returnedBuyingSummary=null;
  private PaginatedItemArrayType returnedWatchList=null;
  private PaginatedItemArrayType returnedBidList=null;
  private PaginatedItemArrayType returnedBestOfferList=null;
  private PaginatedOrderTransactionArrayType returnedWonList=null;
  private PaginatedItemArrayType returnedLostList=null;
  private MyeBayFavoriteSearchListType returnedFavoriteSearches=null;
  private MyeBayFavoriteSellerListType returnedFavoriteSellers=null;
  private ItemType[] returnedSecondChanceOffer=null;
  private BidGroupArrayType returnedBidAssistantList=null;
  private PaginatedOrderTransactionArrayType returnedDeletedFromWonList=null;
  private PaginatedItemArrayType returnedDeletedFromLostList=null;
  private UserDefinedListType[] returnedUserDefinedList=null;


  /**
   * Constructor.
   */
  public GetMyeBayBuyingCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyeBayBuyingCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information regarding a user's buying activity, such as items they are watching, bidding on, have
   * won, did not win, and have made Best Offers on.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyeBayBuying()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyeBayBuyingRequestType req;
    if (this.myeBayBuyingRequest != null)
    {
      req = this.myeBayBuyingRequest;
    } else {
      req = new GetMyeBayBuyingRequestType();
      if (this.watchList != null)
        req.setWatchList(this.watchList);
      if (this.bidList != null)
        req.setBidList(this.bidList);
      if (this.bestOfferList != null)
        req.setBestOfferList(this.bestOfferList);
      if (this.wonList != null)
        req.setWonList(this.wonList);
      if (this.lostList != null)
        req.setLostList(this.lostList);
      if (this.favoriteSearches != null)
        req.setFavoriteSearches(this.favoriteSearches);
      if (this.favoriteSellers != null)
        req.setFavoriteSellers(this.favoriteSellers);
      if (this.secondChanceOffer != null)
        req.setSecondChanceOffer(this.secondChanceOffer);
      if (this.bidAssistantList != null)
        req.setBidAssistantList(this.bidAssistantList);
      if (this.deletedFromWonList != null)
        req.setDeletedFromWonList(this.deletedFromWonList);
      if (this.deletedFromLostList != null)
        req.setDeletedFromLostList(this.deletedFromLostList);
      if (this.buyingSummary != null)
        req.setBuyingSummary(this.buyingSummary);
      if (this.userDefinedLists != null)
        req.setUserDefinedLists(this.userDefinedLists);
      if (this.hideVariations != null)
        req.setHideVariations(this.hideVariations);
  
    }

    GetMyeBayBuyingResponseType resp = (GetMyeBayBuyingResponseType) execute(req);

    this.returnedBuyingSummary = resp.getBuyingSummary();
    this.returnedWatchList = resp.getWatchList();
    this.returnedBidList = resp.getBidList();
    this.returnedBestOfferList = resp.getBestOfferList();
    this.returnedWonList = resp.getWonList();
    this.returnedLostList = resp.getLostList();
    this.returnedFavoriteSearches = resp.getFavoriteSearches();
    this.returnedFavoriteSellers = resp.getFavoriteSellers();
    this.returnedSecondChanceOffer = resp.getSecondChanceOffer();
    this.returnedBidAssistantList = resp.getBidAssistantList();
    this.returnedDeletedFromWonList = resp.getDeletedFromWonList();
    this.returnedDeletedFromLostList = resp.getDeletedFromLostList();
    this.returnedUserDefinedList = resp.getUserDefinedList();

  }

  /**
   * Gets the GetMyeBayBuyingRequestType.myeBayBuyingRequest.
   * @return GetMyeBayBuyingRequestType
   */
  public GetMyeBayBuyingRequestType getMyeBayBuyingRequest()
  {
    return this.myeBayBuyingRequest;
  }


  /**
   * Sets the GetMyeBayBuyingRequestType.myeBayBuyingRequest.
   * @param myeBayBuyingRequest GetMyeBayBuyingRequestType
   */
  public void setMyeBayBuyingRequest(GetMyeBayBuyingRequestType myeBayBuyingRequest)
  {
    this.myeBayBuyingRequest = myeBayBuyingRequest;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bestOfferList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBestOfferList()
  {
    return this.bestOfferList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bestOfferList.
   * @param bestOfferList ItemListCustomizationType
   */
  public void setBestOfferList(ItemListCustomizationType bestOfferList)
  {
    this.bestOfferList = bestOfferList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bidAssistantList.
   * @return BidAssistantListType
   */
  public BidAssistantListType getBidAssistantList()
  {
    return this.bidAssistantList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bidAssistantList.
   * @param bidAssistantList BidAssistantListType
   */
  public void setBidAssistantList(BidAssistantListType bidAssistantList)
  {
    this.bidAssistantList = bidAssistantList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bidList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBidList()
  {
    return this.bidList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bidList.
   * @param bidList ItemListCustomizationType
   */
  public void setBidList(ItemListCustomizationType bidList)
  {
    this.bidList = bidList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.buyingSummary.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBuyingSummary()
  {
    return this.buyingSummary;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.buyingSummary.
   * @param buyingSummary ItemListCustomizationType
   */
  public void setBuyingSummary(ItemListCustomizationType buyingSummary)
  {
    this.buyingSummary = buyingSummary;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.deletedFromLostList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromLostList()
  {
    return this.deletedFromLostList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.deletedFromLostList.
   * @param deletedFromLostList ItemListCustomizationType
   */
  public void setDeletedFromLostList(ItemListCustomizationType deletedFromLostList)
  {
    this.deletedFromLostList = deletedFromLostList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.deletedFromWonList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromWonList()
  {
    return this.deletedFromWonList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.deletedFromWonList.
   * @param deletedFromWonList ItemListCustomizationType
   */
  public void setDeletedFromWonList(ItemListCustomizationType deletedFromWonList)
  {
    this.deletedFromWonList = deletedFromWonList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.favoriteSearches.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getFavoriteSearches()
  {
    return this.favoriteSearches;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.favoriteSearches.
   * @param favoriteSearches MyeBaySelectionType
   */
  public void setFavoriteSearches(MyeBaySelectionType favoriteSearches)
  {
    this.favoriteSearches = favoriteSearches;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.favoriteSellers.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getFavoriteSellers()
  {
    return this.favoriteSellers;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.favoriteSellers.
   * @param favoriteSellers MyeBaySelectionType
   */
  public void setFavoriteSellers(MyeBaySelectionType favoriteSellers)
  {
    this.favoriteSellers = favoriteSellers;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.hideVariations.
   * @return Boolean
   */
  public Boolean getHideVariations()
  {
    return this.hideVariations;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.hideVariations.
   * @param hideVariations Boolean
   */
  public void setHideVariations(Boolean hideVariations)
  {
    this.hideVariations = hideVariations;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.lostList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getLostList()
  {
    return this.lostList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.lostList.
   * @param lostList ItemListCustomizationType
   */
  public void setLostList(ItemListCustomizationType lostList)
  {
    this.lostList = lostList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.secondChanceOffer.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getSecondChanceOffer()
  {
    return this.secondChanceOffer;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.secondChanceOffer.
   * @param secondChanceOffer MyeBaySelectionType
   */
  public void setSecondChanceOffer(MyeBaySelectionType secondChanceOffer)
  {
    this.secondChanceOffer = secondChanceOffer;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.userDefinedLists.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getUserDefinedLists()
  {
    return this.userDefinedLists;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.userDefinedLists.
   * @param userDefinedLists MyeBaySelectionType
   */
  public void setUserDefinedLists(MyeBaySelectionType userDefinedLists)
  {
    this.userDefinedLists = userDefinedLists;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.watchList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getWatchList()
  {
    return this.watchList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.watchList.
   * @param watchList ItemListCustomizationType
   */
  public void setWatchList(ItemListCustomizationType watchList)
  {
    this.watchList = watchList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.wonList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getWonList()
  {
    return this.wonList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.wonList.
   * @param wonList ItemListCustomizationType
   */
  public void setWonList(ItemListCustomizationType wonList)
  {
    this.wonList = wonList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.
   * 
   * @return GetMyeBayBuyingResponseType
   */
  public GetMyeBayBuyingResponseType getReturnedGetMyeBayBuyingResponse()
  {
    return (GetMyeBayBuyingResponseType) this.getResponseObject();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBestOfferList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBestOfferList()
  {
    return this.returnedBestOfferList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBidAssistantList.
   * 
   * @return BidGroupArrayType
   */
  public BidGroupArrayType getReturnedBidAssistantList()
  {
    return this.returnedBidAssistantList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBidList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBidList()
  {
    return this.returnedBidList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBuyingSummary.
   * 
   * @return BuyingSummaryType
   */
  public BuyingSummaryType getReturnedBuyingSummary()
  {
    return this.returnedBuyingSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedDeletedFromLostList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedDeletedFromLostList()
  {
    return this.returnedDeletedFromLostList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedDeletedFromWonList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedDeletedFromWonList()
  {
    return this.returnedDeletedFromWonList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedFavoriteSearches.
   * 
   * @return MyeBayFavoriteSearchListType
   */
  public MyeBayFavoriteSearchListType getReturnedFavoriteSearches()
  {
    return this.returnedFavoriteSearches;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedFavoriteSellers.
   * 
   * @return MyeBayFavoriteSellerListType
   */
  public MyeBayFavoriteSellerListType getReturnedFavoriteSellers()
  {
    return this.returnedFavoriteSellers;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedLostList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedLostList()
  {
    return this.returnedLostList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedSecondChanceOffer.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedSecondChanceOffer()
  {
    return this.returnedSecondChanceOffer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedUserDefinedList.
   * 
   * @return UserDefinedListType[]
   */
  public UserDefinedListType[] getReturnedUserDefinedList()
  {
    return this.returnedUserDefinedList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedWatchList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedWatchList()
  {
    return this.returnedWatchList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedWonList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedWonList()
  {
    return this.returnedWonList;
  }

}

