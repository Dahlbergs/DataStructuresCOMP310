/**
   Enumerated type representing the color of a card. Used by the card class.
   @author Robert Blood, Samuel Dahlberg, Yves Sabato 
*/

package lab.four;

public enum Color {
    RED("Red"),
    BLACK("Black");

    private String color;

    Color(String color) {
	this.color = color;
    }

    public String toString() {
	return this.color;
    }
}
