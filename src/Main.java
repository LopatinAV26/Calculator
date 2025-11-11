public class Main {
	public static void main(String[] args) {
		try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
			if (!scanner.hasNextLine()) {
				return;
			}
			String input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				return;
			}

			java.util.regex.Matcher matcher = java.util.regex.Pattern
				.compile("^\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*$")
				.matcher(input);

			if (!matcher.matches()) {
				System.out.println("Invalid expression");
				return;
			}

			double leftOperand = Double.parseDouble(matcher.group(1));
			String operator = matcher.group(2);
			double rightOperand = Double.parseDouble(matcher.group(3));

			double result;
			switch (operator) {
				case "+":
					result = leftOperand + rightOperand;
					break;
				case "-":
					result = leftOperand - rightOperand;
					break;
				case "*":
					result = leftOperand * rightOperand;
					break;
				case "/":
					if (rightOperand == 0.0) {
						System.out.println("Division by zero");
						return;
					}
					result = leftOperand / rightOperand;
					break;
				default:
					System.out.println("Invalid operator");
					return;
			}

			if (result == Math.rint(result)) {
				System.out.println((long) result);
			} else {
				System.out.println(result);
			}
		}
	}
}
