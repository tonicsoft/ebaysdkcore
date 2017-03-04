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
import java.lang.Integer;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the RemoveFromWatchList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemIDs</code> - The ID of the item to be removed from the
 * watch list. Either ItemID, RemoveAllItems, or VariationKey must
 * be specified, but NOT more than one of these.
 * Multiple ItemID fields can be specified in the same request.
 * <br> <B>Input property:</B> <code>RemoveAllItems</code> - If true, then all the items in the user's
 * watch list are removed. Either ItemID, RemoveAllItems, or VariationKey must be specified, but NOT more than one of these.
 * <br> <B>Input property:</B> <code>VariationKey</code> - A variation (or set of variations) that you want to remove
 * from the watch list. Either ItemID, RemoveAllItems, or VariationKey must be specified, but NOT more than one of these.
 * <br> <B>Output property:</B> <code>ReturnedWatchListCount</code> - The current number of items in the user's watch list (after those
 * specified in the call request have been removed)
 * <br> <B>Output property:</B> <code>ReturnedWatchListMaximum</code> - The maximum number of items allowed in watch lists. Currently this value
 * is 200, and is the same for all sites and all users.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RemoveFromWatchListCall extends com.ebay.sdk.ApiCall
{
  
  private String[] itemIDs = null;
  private Boolean removeAllItems = null;
  private VariationKeyType[] variationKey = null;
  private int returnedWatchListCount=0;
  private int returnedWatchListMaximum=0;


  /**
   * Constructor.
   */
  public RemoveFromWatchListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RemoveFromWatchListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a user to remove one or more items from their My eBay watch list.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void removeFromWatchList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RemoveFromWatchListRequestType req;
    req = new RemoveFromWatchListRequestType();
    if (this.itemIDs != null)
      req.setItemID(this.itemIDs);
    if (this.removeAllItems != null)
      req.setRemoveAllItems(this.removeAllItems);
    if (this.variationKey != null)
      req.setVariationKey(this.variationKey);

    RemoveFromWatchListResponseType resp = (RemoveFromWatchListResponseType) execute(req);

    this.returnedWatchListCount = (resp.getWatchListCount() == null? 0: resp.getWatchListCount().intValue());
    this.returnedWatchListMaximum = (resp.getWatchListMaximum() == null? 0: resp.getWatchListMaximum().intValue());

  }

  /**
   * Gets the RemoveFromWatchListRequestType.itemIDs.
   * @return String[]
   */
  public String[] getItemIDs()
  {
    return this.itemIDs;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.itemIDs.
   * @param itemIDs String[]
   */
  public void setItemIDs(String[] itemIDs)
  {
    this.itemIDs = itemIDs;
  }

  /**
   * Gets the RemoveFromWatchListRequestType.removeAllItems.
   * @return Boolean
   */
  public Boolean getRemoveAllItems()
  {
    return this.removeAllItems;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.removeAllItems.
   * @param removeAllItems Boolean
   */
  public void setRemoveAllItems(Boolean removeAllItems)
  {
    this.removeAllItems = removeAllItems;
  }

  /**
   * Gets the RemoveFromWatchListRequestType.variationKey.
   * @return VariationKeyType[]
   */
  public VariationKeyType[] getVariationKey()
  {
    return this.variationKey;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.variationKey.
   * @param variationKey VariationKeyType[]
   */
  public void setVariationKey(VariationKeyType[] variationKey)
  {
    this.variationKey = variationKey;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RemoveFromWatchListResponseType.returnedWatchListCount.
   * 
   * @return int
   */
  public int getReturnedWatchListCount()
  {
    return this.returnedWatchListCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RemoveFromWatchListResponseType.returnedWatchListMaximum.
   * 
   * @return int
   */
  public int getReturnedWatchListMaximum()
  {
    return this.returnedWatchListMaximum;
  }

}

