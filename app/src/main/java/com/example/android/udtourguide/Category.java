package com.example.android.udtourguide;

import java.io.Serializable;

public class Category implements Serializable {

    /** Place name of category */
    private String mPlaceName;

    /** address of place */
    private String mPlaceAddress;

    /** contact number of place */
    private String mContactNumber;

    /** image resource ID of place */
    private int mImageResourceId;

    /** description id of place */
    private int mDescriptionId;

    /**
     * Create a new Categoty object
     * @param placeName
     * @param placeAddress
     * @param contactNumber
     * @param imageResourceId
     * @param descriptionId
     */

    public Category(String placeName, String placeAddress, String contactNumber, int imageResourceId, int descriptionId){
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mContactNumber = contactNumber;
        mImageResourceId = imageResourceId;
        mDescriptionId = descriptionId;
    }

    /**
     * Get the name of place.
     */
    public String getmPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the address of place.
     */

    public String getmPlaceAddress() {
        return mPlaceAddress;
    }

    /**
     * Get the contact number of place.
     */

    public String getmContactNumber() {
        return mContactNumber;
    }

    /**
     * Get the image of place.
     */

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the description of place.
     */

    public int getmDescriptionId() {
        return mDescriptionId;
    }
}
