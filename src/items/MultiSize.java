package items;

/**
 * An interface that is implemented on items that have multiple sizes.
 *  
 * @author Ryan Stewart Apr 2022
 */
public interface MultiSize {
    
    Size getSize();

    void setSize(Size size);

}