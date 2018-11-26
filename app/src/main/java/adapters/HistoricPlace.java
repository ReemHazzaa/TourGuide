package adapters;

/**
 * Created by Reem on 15,Nov,2018
 */

public class HistoricPlace {
    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** HistoricPlace or element header*/
    private String mPlaceHeader;

    /** HistoricPlace or element information*/
    private String mPlaceInfo;

    /** Image resource id for the place or element */
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Create new HistoricPlace object.
     *
     * @param placeHeader is the name or header for the place or element
     * @param placeInfo is the actual full information about the the place or element
     * @param placeImageId is the resource id for the place image
     * */
    public HistoricPlace(String placeHeader, String placeInfo, int placeImageId) {
        mPlaceHeader = placeHeader;
        mPlaceInfo = placeInfo;
        mImageResourceId = placeImageId;
    }

    /**
     * Get the header of the place object
     */
    public String getmPlaceHeader() {
        return mPlaceHeader;
    }

    /**
     * Get full info of the place object
     */
    public String getmPlaceInfo() {
        return mPlaceInfo;
    }

    /**
     * Get the image resource id of the place object
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Returns whether or not there is an image for this object.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
