/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseFixedPriceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemToBeRevised</code> - Child elements hold the values for item details that you want to change.
 * The Item.ItemID must always be set to the ID of the listing being changed.
 * Only specify Item fields for the details that are changing. Unless
 * otherwise specified in the field descriptions below, the listing retains
 * its existing values for fields that you don't pass in the
 * ReviseFixedPriceItem request. Use DeletedField to remove a field from the
 * listing.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of a field to delete from a listing. The request can
 * contain zero, one, or many instances of DeletedField (one for each field
 * to be deleted). See the relevant field descriptions to determine when to
 * use DeletedField (and potential consequences).
 * <br><br>
 * You cannot delete required fields from a listing.
 * <br><br>
 * Some fields are optional when you first list an item (e.g.,
 * SecondaryCategory), but once they are set they cannot be deleted when you
 * revise an item. Some optional fields cannot be deleted if the item has
 * bids and/or ends within 12 hours. Some optional fields cannot be deleted
 * if other fields depend on them. See the eBay Trading API guide for rules
 * on removing values when revising items.
 * <br><br>
 * Some data (such as Variation nodes within Variations) can't be deleted by
 * using DeletedFields. See the relevant field descriptions for how to delete
 * such data.
 * <br><br>
 * DeletedField accepts the following path names, which delete the
 * corresponding nodes:
 * <br><br>
 * Item.ApplicationData<br>
 * Item.AttributeSetArray<br>
 * Item.ConditionID<br>
 * Item.ItemSpecifics<br>
 * Item.ListingCheckoutRedirectPreference.ProStoresStoreName<br>
 * Item.ListingCheckoutRedirectPreference.SellerThirdPartyUsername<br>
 * Item.ListingDesigner.LayoutID<br>
 * Item.ListingDesigner.ThemeID<br>
 * Item.ListingEnhancement[Value]<br>
 * Item.PayPalEmailAddress<br>
 * Item.PictureDetails.GalleryURL<br>
 * Item.PictureDetails.PictureURL<br>
 * Item.PostalCode<br>
 * Item.ProductListingDetails<br>
 * Item.SellerContactDetails<br>
 * Item.SellerContactDetails.CompanyName<br>
 * Item.SellerContactDetails.County<br>
 * Item.SellerContactDetails.InternationalStreet<br>
 * Item.SellerContactDetails.Phone2AreaOrCityCode<br>
 * Item.SellerContactDetails.Phone2CountryCode<br>
 * Item.SellerContactDetails.Phone2CountryPrefix<br>
 * Item.SellerContactDetails.Phone2LocalNumber<br>
 * Item.SellerContactDetails.PhoneAreaOrCityCode<br>
 * Item.SellerContactDetails.PhoneCountryCode<br>
 * Item.SellerContactDetails.PhoneCountryPrefix<br>
 * Item.SellerContactDetails.PhoneLocalNumber<br>
 * Item.SellerContactDetails.Street<br>
 * Item.SellerContactDetails.Street2<br>
 * Item.ShippingDetails.PaymentInstructions<br>
 * Item.ShippingServiceCostOverrideList<br>
 * Item.SKU (unless InventoryTrackingMethod is SKU)<br>
 * Item.SubTitle
 * <br><br>
 * These values are case-sensitive. Use values that match the case of the
 * schema element names (Item.PictureDetails.GalleryURL) or make the initial
 * letter of each field name lowercase (item.pictureDetails.galleryURL).
 * However, do not change the case of letters in the middle of a field name.
 * For example, item.picturedetails.galleryUrl is not allowed.
 * <br><br>
 * To delete a listing enhancement like BoldTitle, specify the value you are
 * deleting in square brackets ("[ ]"); for example,
 * Item.ListingEnhancement[BoldTitle].
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - Item ID that uniquely identifies the item listing that was revised.
 * Provided for confirmation purposes. The value returned should be the
 * same as the item ID specified in the ItemID property of the Item object
 * specified as input for the call.
 * <br> <B>Output property:</B> <code>ReturnedSKU</code> - Item-level SKU for the listing, if the seller specified
 * Item.SKU for the listing. Variation SKUs are not returned
 * (see GetItem instead).
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - Starting date and time for the listing.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Date and time when the new listing ends. This equals the starting time
 * plus the listing duration.
 * <br> <B>Output property:</B> <code>ListingFees</code> - Child elements contain the estimated listing fees for the revised item
 * listing. The fees do not include the Final Value Fee (FVF), which cannot
 * be determined until an item is sold. Revising an item does not itself
 * incur a fee. However, certain item properties are fee-based and result
 * in the return of fees in the call's response.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - ID of the primary category in which the item was listed.
 * Only returned if you set Item.CategoryMappingAllowed to true in the request
 * and the ID passed in Item.PrimaryCategory was mapped to a new ID by eBay.
 * If the primary category has not changed or it has expired with no replacement,
 * CategoryID does not return a value.
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - ID of the secondary category in which the item was listed.
 * Only returned if you set Item.CategoryMappingAllowed to true in the request
 * and the ID passed in Item.SecondaryCategory was mapped to a new ID by eBay.
 * If the secondary category has not changed or it has expired with no replacement,
 * Category2ID does not return a value.
 * <br> <B>Output property:</B> <code>ReturnedDiscountReason</code> - The nature of the discount, if a discount applied.
 * <br> <B>Output property:</B> <code>ReturnedProductSuggestions</code> - Provides a list of products recommended by eBay which match the item information
 * provided by the seller.
 * Not applicable to Half.com.
 * <br> <B>Output property:</B> <code>ReturnedListingRecommendations</code> - Container consisting of one or more <b>Recommendation</b> containers. Each <b>Recommendation</b> container provides a message to the seller on how a listing can be improved or brought up to standard in regards to top-rated seller/listing requirements, mandated or recommended Item Specifics, picture quality requirements, pricing and/or listing format recommendations, recommended keywords and/or Item Specifics in a Title, and/or a recommendation to offer fast handling (same-day handling or handling time of 1 day) and/or a free shipping option in order to qualify the listing for a Fast 'N Free badge.
 * <br><br>
 * This container is only returned if the <b>IncludeRecommendations</b>
 * flag was included and set to 'true' in the <b>ReviseFixedPriceItem</b> request, and if
 * at least one listing recommendation exists for the listing about to be revised. If
 * one or more listing recommendations are returned, it will be at the seller's
 * discretion about whether to revise the item again based on eBay's listing
 * recommendation(s).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseFixedPriceItemCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType itemToBeRevised = null;
  private String[] deletedField = null;
  private String returnedItemID=null;
  private String returnedSKU=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private FeesType listingFees=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;
  private DiscountReasonCodeType[] returnedDiscountReason=null;
  private ProductSuggestionsType returnedProductSuggestions=null;
  private ListingRecommendationsType returnedListingRecommendations=null;

  private TimeFilter listingDuration = null;
  private PictureService pictureService;


  /**
   * Constructor.
   */
  public ReviseFixedPriceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseFixedPriceItemCall(ApiContext apiContext) {
    super(apiContext);
    
    this.pictureService = eBayPictureServiceFactory.getPictureService(apiContext);       
  }

  /**
   * Enables a seller to change the properties of a currently active
   * fixed-price listing (including multi-variation listings).
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The FeesType object.
   */
  public FeesType reviseFixedPriceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseFixedPriceItemRequestType req;
    req = new ReviseFixedPriceItemRequestType();

    if( this.itemToBeRevised == null )
      throw new SdkException("ItemToBeRevised property is not set.");
 
    if (this.itemToBeRevised != null)
      req.setItem(this.itemToBeRevised);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);

    ReviseFixedPriceItemResponseType resp = (ReviseFixedPriceItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedSKU = resp.getSKU();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.listingFees = resp.getFees();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedDiscountReason = resp.getDiscountReason();
    this.returnedProductSuggestions = resp.getProductSuggestions();
    this.returnedListingRecommendations = resp.getListingRecommendations();
    Calendar startTime = resp.getStartTime();
    if (null != startTime)
    {
    	listingDuration = new TimeFilter(startTime, resp.getEndTime());
    }
    return this.getListingFees();
  }

  /**
   * Gets the ReviseFixedPriceItemRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the ReviseFixedPriceItemRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the ReviseFixedPriceItemRequestType.itemToBeRevised.
   * @return ItemType
   */
  public ItemType getItemToBeRevised()
  {
    return this.itemToBeRevised;
  }

  /**
   * Sets the ReviseFixedPriceItemRequestType.itemToBeRevised.
   * @param itemToBeRevised ItemType
   */
  public void setItemToBeRevised(ItemType itemToBeRevised)
  {
    this.itemToBeRevised = itemToBeRevised;
  }
/**
   * 
   * @return the listing duration.
   */
  public TimeFilter getListingDuration() {
  	return listingDuration;
  }

  public void uploadPictures(String[] pictureFiles, PictureDetailsType pictureDetails) throws SdkException {
	  if(pictureFiles == null) {
		  return;
	  }
      PictureInfo[] pictureInfoArray = new PictureInfo[pictureFiles.length];
      for(int i = 0; i < pictureFiles.length; i ++) {
    	  pictureInfoArray[i] = new PictureInfo();
    	  pictureInfoArray[i].setPictureFilePath(pictureFiles[i]);
      }
      uploadPictures(pictureInfoArray, pictureDetails);
  }
  
  public void uploadPictures(PictureInfo[] pictureInfoArray, PictureDetailsType pictureDetails) throws SdkException  {
	    String epsUrl = getApiContext().getEpsServerUrl();
	    if(pictureInfoArray == null || epsUrl == null) {
	    	return;
	    }
	    if(pictureDetails == null) {
	    	pictureDetails = new PictureDetailsType();
	    }
	    if(pictureDetails.getPhotoDisplay() == null) {
	    	pictureDetails.setPhotoDisplay(PhotoDisplayCodeType.NONE);
	    }
	    if(pictureDetails.getGalleryType() == null) {
	    	pictureDetails.setGalleryType(GalleryTypeCodeType.NONE);
	    }
	    if(pictureDetails.getPictureSource() == null) {
	    	pictureDetails.setPictureSource(PictureSourceCodeType.VENDOR);
	    }
        itemToBeRevised.setPictureDetails(pictureDetails);

        int uploads = pictureService.uploadPictures(pictureDetails.getPhotoDisplay(), pictureInfoArray);
        if(uploads != pictureInfoArray.length ) {
          // Build error message.
          StringBuffer sb = new StringBuffer();
          for(int i = 0; i < pictureInfoArray.length; i ++ ) {
            if (pictureInfoArray[i].hasError())
              sb.append(pictureInfoArray[i].getErrorType() + " : " +
            		   pictureInfoArray[i].getErrorMessage() + "\n");
          }
          throw new SdkException(sb.toString());
        }

        // Save urls back to item object.
        String[] uris = new String[pictureInfoArray.length];
	for(int i = 0; i < pictureInfoArray.length; i ++) {
		uris[i] = pictureInfoArray[i].getURL();
	}
	itemToBeRevised.getPictureDetails().setPictureURL(uris);
  }


  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.listingFees.
   * 
   * @return FeesType
   */
  public FeesType getListingFees()
  {
    return this.listingFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedDiscountReason.
   * 
   * @return DiscountReasonCodeType[]
   */
  public DiscountReasonCodeType[] getReturnedDiscountReason()
  {
    return this.returnedDiscountReason;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedListingRecommendations.
   * 
   * @return ListingRecommendationsType
   */
  public ListingRecommendationsType getReturnedListingRecommendations()
  {
    return this.returnedListingRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedProductSuggestions.
   * 
   * @return ProductSuggestionsType
   */
  public ProductSuggestionsType getReturnedProductSuggestions()
  {
    return this.returnedProductSuggestions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedSKU.
   * 
   * @return String
   */
  public String getReturnedSKU()
  {
    return this.returnedSKU;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseFixedPriceItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

