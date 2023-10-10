public class TipCalculator {
    private final int numPeople;
    private final int tipPercentage;
    private double totalBillBeforeTip;
    private final String country;
    private String items;

    private double round(double input) {
        input *= 100;
        input = (int)input;
        input /= 100.0;
        return input;
    }
    public TipCalculator(int numPeople, int tipPercentage, String country) {
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
        totalBillBeforeTip = 0.0;
        this.country = country;
    }
    public double getTotalBillBeforeTip() {
        return totalBillBeforeTip;
    }
    public int getTipPercentage() {
        return tipPercentage;
    }
    public void addMeal(String item, double cost) {
        items += item + " ";
        totalBillBeforeTip += cost;
        totalBillBeforeTip = round(totalBillBeforeTip);
    }
    public double tipAmount() {
        return round(((double)tipPercentage / 100) * totalBillBeforeTip);
    }
    public double totalBill() {
        return round(tipAmount() + totalBillBeforeTip);
    }
    public double perPersonCostBeforeTip() {
        return round(totalBillBeforeTip / numPeople);
    }
    public double perPersonTipAmount() {
        return round(tipAmount() / numPeople);
    }
    public double perPersonTotalCost() {
        return round(totalBill() / numPeople);
    }
    public boolean countryWithTip() {
        return !country.equalsIgnoreCase("Japan") &&
                !country.equalsIgnoreCase("China") &&
                !country.equalsIgnoreCase("French Polynesia") &&
                !country.equalsIgnoreCase("Korea") &&
                !country.equalsIgnoreCase("Hong Kong") &&
                !country.equalsIgnoreCase("Switzerland") &&
                !country.equalsIgnoreCase("Australia") &&
                !country.equalsIgnoreCase("Belgium") &&
                !country.equalsIgnoreCase("Brazil") &&
                !country.equalsIgnoreCase("Denmark") &&
                !country.equalsIgnoreCase("Estonia") &&
                !country.equalsIgnoreCase("New Zealand");
    }
    public String printReceipt() {
        int i;
        String letter;
        StringBuilder itemToPrint = new StringBuilder();
        int indexPrevSpace = 0;
        for (i = 0; i < items.length(); i++) {
            letter = items.substring(i, i + 1);
            if (letter.equals(" ")) {
                itemToPrint.append(items, indexPrevSpace, i).append("\n");
                indexPrevSpace = i;
            }
        }
        return ("------------------Receipt------------------" + "\n" +
        "Total Bill before tip: " + totalBillBeforeTip + "\n" +
        "Total Percentage: " + tipPercentage + "%" + "\n" +
        "Total Tip: " + tipAmount() + "\n" +
        "Total bill with tip: " + totalBill() + "\n" +
        "Per person cost before tip: " + perPersonCostBeforeTip() + "\n" +
        "Tip per person: " + perPersonTipAmount() + "\n" +
        "Per person cost after tip " + perPersonTotalCost() + "\n" +
        "-------------------------------------------" + "\n" +
        itemToPrint);
    }
}
