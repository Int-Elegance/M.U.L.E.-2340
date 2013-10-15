import javax.swing.ImageIcon;

public class Mountain extends Property {
    public final static int TYPE_1 = 1;
    public final static int TYPE_2 = 2;     
    public final static int TYPE_3 = 3;
    
    private int type;
    
    public Mountain(int type) {
        super(1, 1, type + 1);
        if (type > 4 || type < 1)
            throw new RuntimeException("Invalid mountain type.");
        this.display = new ImageIcon(String.format("mount%d.jpg", type));
    }
}
