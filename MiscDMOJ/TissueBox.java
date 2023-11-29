package Test.MiscDMOJ;

public class TissueBox {
    private byte tissues = 100;
    private static double price = 1.5;

    public byte getTissuesCount() {
        return tissues;
    }
    public double getPrice() {
        return price;
    }

    // Method to use a tissue
    public void useTissue() {
        if (tissues > 0) {
            tissues--;
            System.out.println("Tissue used. Remaining tissues: " + tissues);
        } else {
            System.out.println("No tissues left.");
        }
    }

    public static void main(String[] args) {
        TissueBox myTissueBox = new TissueBox();

        System.out.println("Price of a tissue box: $" + myTissueBox.getPrice());

        System.out.println("Initial number of tissues: " + myTissueBox.getTissuesCount());

        for (int i = 0; i < 5; i++) {
            myTissueBox.useTissue();
        }

        System.out.println("Remaining tissues: " + myTissueBox.getTissuesCount());
    }
}
