package items;

/**
 * An interface that is implemented on items that have multiple sizes.
 */
public interface MultiSize {
    
    Size getSize();

    void setSize(Size size);

}