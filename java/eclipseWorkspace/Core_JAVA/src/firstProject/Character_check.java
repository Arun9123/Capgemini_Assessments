package firstProject;

public class Character_check {
	public static void main(String[] args) {
		char c = '1';
		if(Character.isLetterOrDigit(c)) {
			if(Character.isUpperCase(c)) {
				System.out.println("Uppercase");
			}
			else if(Character.isLowerCase(c)) {
				System.out.println("Lowercase");
			}
			else {
				System.out.println("Number");
			}
		}
		else if(Character.isWhitespace(c)) {
			System.out.println("Whitespace");
		}
		else {
			System.out.println("Special character");
		}
		
    }
}
