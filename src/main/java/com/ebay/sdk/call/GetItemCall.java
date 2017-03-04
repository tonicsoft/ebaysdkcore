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
 * Wrapper class of the GetItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Specifies the <b>ItemID</b> that uniquely identifies the item listing for which
 * to retrieve the data.
 * <br><br>
 * <b>ItemID</b> is a required input in most cases. <b>SKU</b> can be used instead in certain
 * cases (see the description of SKU). If both <b>ItemID</b> and <b>SKU</b> are specified for
 * items where the inventory tracking method is <b>ItemID</b>, <b>ItemID</b> takes precedence.
 * <br> <B>Input property:</B> <code>IncludeWatchCount</code> - Indicates if the caller wants to include watch count for that item in the
 * response. You must be the seller of the item to retrieve the watch count.
 * <br> <B>Input property:</B> <code>IncludeCrossPromotion</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>IncludeItemSpecifics</code> - If <code>true</code>, the response returns the <b>ItemSpecifics</b> node
 * (if the listing has custom Item Specifics).<br>
 * <br>
 * Item Specifics are well-known aspects of items in a given
 * category. For example, items in a washer and dryer category
 * might have an aspect like Type=Top-Loading; whereas
 * items in a jewelry category might have an aspect like
 * Gemstone=Amber.<br>
 * <br>
 * Including this field set to <code>true</code> also returns the <strong>UnitInfo</strong> node, which enables European Union sellers to provide the required price-per-unit information so buyers can accurately compare prices for certain types of products.
 * <br/><br/>
 * (This does not cause the response to include ID-based
 * attributes. To also retrieve ID-based attributes,
 * pass <b>DetailLevel</b> in the request with the value
 * <b>ItemReturnAttributes</b> or <b>ReturnAll</b>.)
 * <br> <B>Input property:</B> <code>IncludeTaxTable</code> - If true, an associated tax table is returned in the response.
 * If no tax table is associated with the item, then no
 * tax table is returned, even if <b>IncludeTaxTable</b> is set to true.
 * <br> <B>Input property:</B> <code>SKU</code> - Retrieves an item that was listed by the user identified
 * in AuthToken and that is being tracked by this SKU.<br>
 * <br>
 * A SKU (stock keeping unit) is an identifier defined by a seller.
 * Some sellers use SKUs to track complex flows of products
 * and information on the client side.
 * eBay preserves the SKU on the item, enabling you
 * to obtain it before and after an order line item is created.
 * (SKU is recommended as an alternative to
 * ApplicationData.)<br>
 * <br>
 * In <b>GetItem</b>, <b>SKU</b> can only be used to retrieve one of your
 * own items, where you listed the item by using <b>AddFixedPriceItem</b>
 * or <b>RelistFixedPriceItem</b>,
 * and you set <b>Item.InventoryTrackingMethod</b> to <b>SKU</b> at
 * the time the item was listed. (These criteria are necessary to
 * uniquely identify the listing by a SKU.)<br>
 * <br>
 * Either <b>ItemID</b> or <b>SKU</b> is required in the request.
 * If both are passed, they must refer to the same item,
 * and that item must have <b>InventoryTrackingMethod</b> set to <b>SKU</b>.
 * <br> <B>Input property:</B> <code>VariationSKU</code> - Variation-level SKU that uniquely identifies a Variation within
 * the listing identified by <b>ItemID</b>. Only applicable when the
 * seller listed the item with Variation-level SKU (<b>Variation.SKU</b>)
 * values. Retrieves all the usual <b>Item</b> fields, but limits the
 * <b>Variations</b> content to the specified Variation.
 * If not specified, the response includes all Variations.
 * <br> <B>Input property:</B> <code>VariationSpecifics</code> - Name-value pairs that identify one or more Variations within the
 * listing identified by <b>ItemID</b>. Only applicable when the seller
 * listed the item with Variations. Retrieves all the usual <b>Item</b>
 * fields, but limits the Variations content to the specified
 * Variation(s). If the specified pairs do not match any Variation,
 * eBay returns all Variations.<br>
 * <br>
 * To retrieve only one variation, specify the full set of
 * name/value pairs that match all the name-value pairs of one
 * Variation. <br>
 * <br>
 * To retrieve multiple variations (using a wildcard),
 * specify one or more name/value pairs that partially match the
 * desired variations. For example, if the listing contains
 * Variations for shirts in different colors and sizes, specify
 * Color as Red (and no other name/value pairs) to retrieve
 * all the red shirts in all sizes (but no other colors).
 * <br> <B>Input property:</B> <code>TransactionID</code> - A unique identifier for an order line item (transaction). An order line item is created
 * when a buyer commits to purchasing an item.
 * <br><br>
 * Since you can change active multiple-quantity fixed-price listings even
 * after one of the items has been purchased, the <b>TransactionID</b> is
 * associated with a snapshot of the item data at the time of the purchase.
 * <br><br>
 * After one item in a multi-quantity listing has been sold, sellers can not
 * change the values in the Title, Primary Category, Secondary Category,
 * Listing Duration, and Listing Type fields. However, all other fields are
 * editable.
 * <br><br>
 * Specifying a <b>TransactionID</b> in the <b>GetItem</b> request allows you to retrieve
 * a snapshot of the listing as it was when the order line item was created.
 * <br> <B>Input property:</B> <code>IncludeItemCompatibilityList</code> - This field is used to specify whether to retrieve Parts Compatibility information. If <code>true</code>, any compatible applications associated with the item will be returned in the response (<b class="con"> Item.ItemCompatibilityList</b>). If no compatible applications have been specified for the item, no item compatibilities will be returned.
 * <br><br>
 * If <code>false</code> or not specified, the response will return a compatibility count (<b>ItemCompatibilityCount</b>) when parts compatibilities have been specified for the item.
 * <br><br>
 * Parts Compatibility is supported in limited Parts & Accessories categories, for the eBay US Motors (100), UK (3), AU (15) and DE (77) sites only.
 * <br> <B>Output property:</B> <code>ReturnedItem</code> - ItemType object that contains the data for the specified item.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Boolean includeWatchCount = null;
  private Boolean includeCrossPromotion = null;
  private Boolean includeItemSpecifics = null;
  private Boolean includeTaxTable = null;
  private String sKU = null;
  private String variationSKU = null;
  private NameValueListArrayType variationSpecifics = null;
  private String transactionID = null;
  private Boolean includeItemCompatibilityList = null;
  private ItemType returnedItem=null;


  /**
   * Constructor.
   */
  public GetItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns item data (title, description, price information, seller information, and so on)
   * for the specified item ID.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ItemType object.
   */
  public ItemType getItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemRequestType req;
    req = new GetItemRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.includeWatchCount != null)
      req.setIncludeWatchCount(this.includeWatchCount);
    if (this.includeCrossPromotion != null)
      req.setIncludeCrossPromotion(this.includeCrossPromotion);
    if (this.includeItemSpecifics != null)
      req.setIncludeItemSpecifics(this.includeItemSpecifics);
    if (this.includeTaxTable != null)
      req.setIncludeTaxTable(this.includeTaxTable);
    if (this.sKU != null)
      req.setSKU(this.sKU);
    if (this.variationSKU != null)
      req.setVariationSKU(this.variationSKU);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.includeItemCompatibilityList != null)
      req.setIncludeItemCompatibilityList(this.includeItemCompatibilityList);

    GetItemResponseType resp = (GetItemResponseType) execute(req);

    this.returnedItem = resp.getItem();
    
    return this.getReturnedItem();
  }

  /**
   * Gets the GetItemRequestType.includeCrossPromotion.
   * @return Boolean
   */
  public Boolean getIncludeCrossPromotion()
  {
    return this.includeCrossPromotion;
  }

  /**
   * Sets the GetItemRequestType.includeCrossPromotion.
   * @param includeCrossPromotion Boolean
   */
  public void setIncludeCrossPromotion(Boolean includeCrossPromotion)
  {
    this.includeCrossPromotion = includeCrossPromotion;
  }

  /**
   * Gets the GetItemRequestType.includeItemCompatibilityList.
   * @return Boolean
   */
  public Boolean getIncludeItemCompatibilityList()
  {
    return this.includeItemCompatibilityList;
  }

  /**
   * Sets the GetItemRequestType.includeItemCompatibilityList.
   * @param includeItemCompatibilityList Boolean
   */
  public void setIncludeItemCompatibilityList(Boolean includeItemCompatibilityList)
  {
    this.includeItemCompatibilityList = includeItemCompatibilityList;
  }

  /**
   * Gets the GetItemRequestType.includeItemSpecifics.
   * @return Boolean
   */
  public Boolean getIncludeItemSpecifics()
  {
    return this.includeItemSpecifics;
  }

  /**
   * Sets the GetItemRequestType.includeItemSpecifics.
   * @param includeItemSpecifics Boolean
   */
  public void setIncludeItemSpecifics(Boolean includeItemSpecifics)
  {
    this.includeItemSpecifics = includeItemSpecifics;
  }

  /**
   * Gets the GetItemRequestType.includeTaxTable.
   * @return Boolean
   */
  public Boolean getIncludeTaxTable()
  {
    return this.includeTaxTable;
  }

  /**
   * Sets the GetItemRequestType.includeTaxTable.
   * @param includeTaxTable Boolean
   */
  public void setIncludeTaxTable(Boolean includeTaxTable)
  {
    this.includeTaxTable = includeTaxTable;
  }

  /**
   * Gets the GetItemRequestType.includeWatchCount.
   * @return Boolean
   */
  public Boolean getIncludeWatchCount()
  {
    return this.includeWatchCount;
  }

  /**
   * Sets the GetItemRequestType.includeWatchCount.
   * @param includeWatchCount Boolean
   */
  public void setIncludeWatchCount(Boolean includeWatchCount)
  {
    this.includeWatchCount = includeWatchCount;
  }

  /**
   * Gets the GetItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetItemRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the GetItemRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Gets the GetItemRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetItemRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Gets the GetItemRequestType.variationSKU.
   * @return String
   */
  public String getVariationSKU()
  {
    return this.variationSKU;
  }

  /**
   * Sets the GetItemRequestType.variationSKU.
   * @param variationSKU String
   */
  public void setVariationSKU(String variationSKU)
  {
    this.variationSKU = variationSKU;
  }

  /**
   * Gets the GetItemRequestType.variationSpecifics.
   * @return NameValueListArrayType
   */
  public NameValueListArrayType getVariationSpecifics()
  {
    return this.variationSpecifics;
  }

  /**
   * Sets the GetItemRequestType.variationSpecifics.
   * @param variationSpecifics NameValueListArrayType
   */
  public void setVariationSpecifics(NameValueListArrayType variationSpecifics)
  {
    this.variationSpecifics = variationSpecifics;
  }
/**
   * Executing the API call.
   * @param itemID eBay itemID that uniquely identifies the item.
   * @throws ApiException
   * @return The ItemType object if the call succeeded.
   */
  public ItemType getItem(String itemID)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {

    GetItemRequestType req = new GetItemRequestType();
    req.setItemID(itemID);
    req.setDetailLevel(this.getDetailLevel());
    if (this.includeWatchCount != null)
      req.setIncludeWatchCount(this.includeWatchCount);
    if (this.includeCrossPromotion != null)
      req.setIncludeCrossPromotion(this.includeCrossPromotion);
    if (this.includeItemSpecifics != null)
      req.setIncludeItemSpecifics(this.includeItemSpecifics);
    if (this.includeTaxTable != null)
      req.setIncludeTaxTable(this.includeTaxTable);
    if (this.sKU != null)
      req.setSKU(this.sKU);
    if (this.variationSKU != null)
      req.setVariationSKU(this.variationSKU);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.includeItemCompatibilityList != null)
      req.setIncludeItemCompatibilityList(this.includeItemCompatibilityList);

    GetItemResponseType resp = (GetItemResponseType) execute(req);

    this.returnedItem = resp.getItem();
    
    return this.getReturnedItem();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemResponseType.returnedItem.
   * 
   * @return ItemType
   */
  public ItemType getReturnedItem()
  {
    return this.returnedItem;
  }

}

