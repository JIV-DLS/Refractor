
public class Card {
    private CardColors colour;
    private CardValues value;

    Card(CardColors cardColors, CardValues  cardValues) {
        this.value= cardValues;
        this.colour = cardColors;
    }
    Card(String colourName, int  value) {
        this.value=CardValues.getCardValuesWithValue(value);
        this.colour = CardColors.getCardColorsWithColorName(colourName);
    }
    Card(int  value,String colourNameAbbreviated) {
        this.value=CardValues.getCardValuesWithValue(value);
        this.colour = CardColors.getCardColorsWithColorNameAbbreviated(colourNameAbbreviated);
    }

    CardColors getColour() { return colour; }

    public void setColour(CardColors colour) {
        this.colour = colour;
    }
    public void setColour(String colourName) {
        this.colour = CardColors.getCardColorsWithColorName(colourName);
    }
    public void setColourByColorNameAbbreviated(String colourNameAbbreviated) { this.colour = CardColors.getCardColorsWithColorNameAbbreviated(colourNameAbbreviated); }

    CardValues getValue() { return value; }
    int getValour() { return value.getValue(); }

    boolean superiorTo(Card c){
        return getValour()>c.getValour();
    }

    boolean inferiorTo(Card c){
        return getValour()<c.getValour();
    }

    boolean equalsTo(Card c){return value.getValue()==c.getValue().getValue(); }

    @Override
    public String toString() {
        return value.getAbbreviated()+colour.getAbbreviated();
    }
}
