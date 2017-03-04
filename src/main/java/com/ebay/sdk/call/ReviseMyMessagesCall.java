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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseMyMessages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>MessageIDs</code> - Contains a list of up to 10 <b>MessageIDs</b>
 * <b>MessageIDs</b> values must be included in
 * the request. Messages in the Sent box cannot be moved, marked as read, or flagged.
 * <br> <B>Input property:</B> <code>AlertIDs</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>Read</code> - Changes the read states of all messages specified in a request. At least one of the <b>Read</b>, <b>Flagged</b>, or <b>FolderID</b> fields must be specified in the request. Messages in the Sent box cannot be moved, marked as read, or flagged. <br><br>
 * Note that messages retrieved with the API are not automatically marked read, and must be marked read with this call.
 * <br> <B>Input property:</B> <code>Flagged</code> - Changes the flagged states of all messages specified in
 * a request by their <b>MessageID</b> values. At least one of
 * the <b>Read</b>, <b>Flagged</b>, or <b>FolderID</b> fields must be specified in the
 * request. Messages in the Sent box cannot be moved,
 * marked as read, or flagged.
 * <br> <B>Input property:</B> <code>FolderID</code> - An ID that uniquely identifies the My Messages folder to
 * move messages into. At least one of
 * the <b>Read</b>, <b>Flagged</b>, or <b>FolderID</b> fields must be specified in the
 * request. Messages in the Sent box cannot be moved,
 * marked as read, or flagged.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseMyMessagesCall extends com.ebay.sdk.ApiCall
{
  
  private String[] messageIDs = null;
  private String[] alertIDs = null;
  private Boolean read = null;
  private Boolean flagged = null;
  private Long folderID = null;


  /**
   * Constructor.
   */
  public ReviseMyMessagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseMyMessagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Sets the read state for messages, sets the flagged state of messages,
   * and moves messages into and out of folders.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseMyMessages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseMyMessagesRequestType req;
    req = new ReviseMyMessagesRequestType();
    if (this.messageIDs != null)
    {
      MyMessagesMessageIDArrayType ary = new MyMessagesMessageIDArrayType();
      ary.setMessageID(this.messageIDs);
      req.setMessageIDs(ary);
    }
    if (this.alertIDs != null)
    {
      MyMessagesAlertIDArrayType ary = new MyMessagesAlertIDArrayType();
      ary.setAlertID(this.alertIDs);
      req.setAlertIDs(ary);
    }
    if (this.read != null)
      req.setRead(this.read);
    if (this.flagged != null)
      req.setFlagged(this.flagged);
    if (this.folderID != null)
      req.setFolderID(this.folderID);

    ReviseMyMessagesResponseType resp = (ReviseMyMessagesResponseType) execute(req);


  }

  /**
   * Gets the ReviseMyMessagesRequestType.alertIDs.
   * @return String[]
   */
  public String[] getAlertIDs()
  {
    return this.alertIDs;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.alertIDs.
   * @param alertIDs String[]
   */
  public void setAlertIDs(String[] alertIDs)
  {
    this.alertIDs = alertIDs;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.flagged.
   * @return Boolean
   */
  public Boolean getFlagged()
  {
    return this.flagged;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.flagged.
   * @param flagged Boolean
   */
  public void setFlagged(Boolean flagged)
  {
    this.flagged = flagged;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.messageIDs.
   * @return String[]
   */
  public String[] getMessageIDs()
  {
    return this.messageIDs;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.messageIDs.
   * @param messageIDs String[]
   */
  public void setMessageIDs(String[] messageIDs)
  {
    this.messageIDs = messageIDs;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.read.
   * @return Boolean
   */
  public Boolean getRead()
  {
    return this.read;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.read.
   * @param read Boolean
   */
  public void setRead(Boolean read)
  {
    this.read = read;
  }

}

