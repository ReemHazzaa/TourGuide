package adapters;

/**
 * Created by Reem on 16,Nov,2018
 */

public class ModernPlace {
    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Constant value that represents no phoneNumber was provided for this place */
    private static final String NO_PHONE_PROVIDED = "";

    /** Constant value that represents no type was provided for this place */
    private static final String NO_TYPE_PROVIDED = "";

    /** ModernPlace or element name*/
    private String mPlaceName;

    /** ModernPlace or element address*/
    private String mPlaceAddress;

    /** ModernPlace or element rating*/
    private Double mPlaceRating;

    /** ModernPlace or element location from Luxor center*/
    private String mPlaceLocation;

    /** ModernPlace or element price*/
    private int mPlacePrice;

    /** ModernPlace or element phone*/
    private String mPlacePhone = NO_PHONE_PROVIDED;

    /** Image resource id for the place or element */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Modern place type*/
    private String mPlaceType = NO_TYPE_PROVIDED;
    /**
     * Create a new ModernPlace
     *
     * @param mPlaceName is the hotel or restaurant name
     * @param mPlaceAddress is the hotel or restaurant address
     * @param mPlaceRating is the hotel or restaurant Double value of rating
     * @param mPlaceLocation is the hotel or restaurant location from Luxor center
     * @param mPlacePrice is the hotel or restaurant integer value of its price
     * @param mImageResourceId is the resource id for the place image
     */
    public ModernPlace(String mPlaceName, String mPlaceAddress, Double mPlaceRating, String mPlaceLocation, int mPlacePrice, int mImageResourceId) {
        this.mPlaceName = mPlaceName;
        this.mPlaceAddress = mPlaceAddress;
        this.mPlaceRating = mPlaceRating;
        this.mPlaceLocation = mPlaceLocation;
        this.mPlacePrice = mPlacePrice;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * Create a new ModernPlace object that does not have an image resource
     *
     * @param mPlaceName is the hotel or restaurant name
     * @param mPlaceAddress is the hotel or restaurant address
     * @param mPlaceRating is the hotel or restaurant Double value of rating
     * @param mPlaceLocation is the hotel or restaurant location from Luxor center
     * @param mPlacePrice is the hotel or restaurant integer value of its price
     */
    public ModernPlace(String mPlaceName, String mPlaceAddress, Double mPlaceRating, String mPlaceLocation, int mPlacePrice) {
        this.mPlaceName = mPlaceName;
        this.mPlaceAddress = mPlaceAddress;
        this.mPlaceRating = mPlaceRating;
        this.mPlaceLocation = mPlaceLocation;
        this.mPlacePrice = mPlacePrice;
    }

    /**
     * Create a ModernPlace object for a restaurant
     *
     * @param mPlaceName
     * @param mPlaceRating
     * @param mPlaceAddress
     * @param mPhone
     */
    public ModernPlace(String mPlaceName,  Double mPlaceRating, String mPlaceAddress, String mPhone) {
        this.mPlaceName = mPlaceName;
        this.mPlaceRating = mPlaceRating;
        this.mPlaceAddress = mPlaceAddress;
        this.mPlacePhone = mPhone;
    }

    /**
     *
     * @param mPlaceName
     * @param mPlaceType
     * @param mPlaceRating
     * @param mPlaceAddress
     * @param mPhone
     */
    public ModernPlace(String mPlaceName, String mPlaceType,  Double mPlaceRating, String mPlaceAddress, String mPhone) {
        this.mPlaceName = mPlaceName;
        this.mPlaceType = mPlaceType;
        this.mPlaceRating = mPlaceRating;
        this.mPlaceAddress = mPlaceAddress;
        this.mPlacePhone = mPhone;
    }


    /**
     * Get the place name.
     */
    public String getmPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the place address.
     */
    public String getmPlaceAddress() {
        return mPlaceAddress;
    }

    /**
     * Get the place rating.
     */
    public Double getmPlaceRating() {
        return mPlaceRating;
    }

    /**
     * Get the place location from Luxor center.
     */
    public String getmPlaceLocation() {
        return mPlaceLocation;
    }

    /**
     * Get the place price.
     */
    public int getmPlacePrice() {
        return mPlacePrice;
    }

    /**
     * Get the place image resource id
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Get the place phone.
     */
    public String getmPlacePhone() {
        return mPlacePhone;
    }
    /**
     * Get the place type.
     */
    public String getmPlaceType() {
        return mPlaceType;
    }


    /**
     * Returns whether or not there is an image for this Place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Returns whether or not there is a phone for this place.
     */
    public boolean hasPhone(){
        return !mPlacePhone.equals("");
    }
    /**
     * Returns whether or not there is a type for this place.
     */
    public boolean hasType(){
        return !mPlaceType.equals("");
    }
}
