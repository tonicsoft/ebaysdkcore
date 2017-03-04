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
 * Wrapper class of the GetAllBidders call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - This is the unique identifier of the auction listing for which bidders are being retrieved. This auction listing can be active or recently ended. However, to retrieve bidders for an active auction listing, the only <b>CallMode</b> enumeration value that can be used is <code>ViewAll</code>.
 * <br> <B>Input property:</B> <code>CallMode</code> - The enumeration value that is passed into this field will control the set of bidders that will be retrieved in the response. To retrieve bidders from a recently-ended auction listing, any of the three values can be used. To retrieve bidders for an active auction listing, only the <code>ViewAll</code> enumeration value can be used. These values are discussed in more detail below.
 * <br> <B>Input property:</B> <code>IncludeBiddingSummary</code> - The user must include this field and set its value to <code>true</code> if the user wishes to retrieve the  <b>BiddingSummary</b> container for each bidder. The <b>BiddingSummary</b> container consists of more detailed bidding information on each bidder.
 * <br> <B>Output property:</B> <code>ReturnedBidArray</code> - Contains a list of OfferType objects. Each
 * OfferType object represents the data for one bidder and bid.
 * <br> <B>Output property:</B> <code>ReturnedHighBidder</code> - eBay user ID for the user with the highest bid (or the earliest timestamp, in the event of a tie); a second chance offer candidate.
 * <br> <B>Output property:</B> <code>ReturnedHighestBid</code> - Bid amount offered by the HighBidder.
 * <br> <B>Output property:</B> <code>ReturnedListingStatus</code> - Specifies an active or ended listing's status in eBay's processing workflow.
 * If a listing ends with a sale (or sales), eBay needs to update the sale details (e.g., winning bidder) and other information. This processing
 * can take several minutes. If you retrieve a sold item, use this listing status information to determine whether eBay has finished processing the listing so that you can be sure the winning bidder and other details are correct and complete.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetAllBiddersCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private GetAllBiddersModeCodeType callMode = null;
  private Boolean includeBiddingSummary = null;
  private OfferType[] returnedBidArray=null;
  private String returnedHighBidder=null;
  private AmountType returnedHighestBid=null;
  private ListingStatusCodeType returnedListingStatus=null;


  /**
   * Constructor.
   */
  public GetAllBiddersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetAllBiddersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetAllBidders</b> call, which is used to retrieve bidders from an active or recently-ended auction listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The OfferType[] object.
   */
  public OfferType[] getAllBidders()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetAllBiddersRequestType req;
    req = new GetAllBiddersRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.callMode != null)
      req.setCallMode(this.callMode);
    if (this.includeBiddingSummary != null)
      req.setIncludeBiddingSummary(this.includeBiddingSummary);

    GetAllBiddersResponseType resp = (GetAllBiddersResponseType) execute(req);

    this.returnedBidArray = (resp.getBidArray() == null? null: resp.getBidArray().getOffer());
    this.returnedHighBidder = resp.getHighBidder();
    this.returnedHighestBid = resp.getHighestBid();
    this.returnedListingStatus = resp.getListingStatus();
    return this.getReturnedBidArray();
  }

  /**
   * Gets the GetAllBiddersRequestType.callMode.
   * @return GetAllBiddersModeCodeType
   */
  public GetAllBiddersModeCodeType getCallMode()
  {
    return this.callMode;
  }

  /**
   * Sets the GetAllBiddersRequestType.callMode.
   * @param callMode GetAllBiddersModeCodeType
   */
  public void setCallMode(GetAllBiddersModeCodeType callMode)
  {
    this.callMode = callMode;
  }

  /**
   * Gets the GetAllBiddersRequestType.includeBiddingSummary.
   * @return Boolean
   */
  public Boolean getIncludeBiddingSummary()
  {
    return this.includeBiddingSummary;
  }

  /**
   * Sets the GetAllBiddersRequestType.includeBiddingSummary.
   * @param includeBiddingSummary Boolean
   */
  public void setIncludeBiddingSummary(Boolean includeBiddingSummary)
  {
    this.includeBiddingSummary = includeBiddingSummary;
  }

  /**
   * Gets the GetAllBiddersRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetAllBiddersRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAllBiddersResponseType.returnedBidArray.
   * 
   * @return OfferType[]
   */
  public OfferType[] getReturnedBidArray()
  {
    return this.returnedBidArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAllBiddersResponseType.returnedHighBidder.
   * 
   * @return String
   */
  public String getReturnedHighBidder()
  {
    return this.returnedHighBidder;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAllBiddersResponseType.returnedHighestBid.
   * 
   * @return AmountType
   */
  public AmountType getReturnedHighestBid()
  {
    return this.returnedHighestBid;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAllBiddersResponseType.returnedListingStatus.
   * 
   * @return ListingStatusCodeType
   */
  public ListingStatusCodeType getReturnedListingStatus()
  {
    return this.returnedListingStatus;
  }

}

