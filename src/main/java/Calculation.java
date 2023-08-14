import java.util.Stack;

public class Calculation {
    public static double calcularEquacao(String equacao) {
        equacao = equacao.replaceAll("\\s", "");

        Stack<Double> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < equacao.length(); i++) {
            char c = equacao.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < equacao.length() && (Character.isDigit(equacao.charAt(i)) || equacao.charAt(i) == '.')) {
                    numBuilder.append(equacao.charAt(i));
                    i++;
                }
                i--;
                numeros.push(Double.parseDouble(numBuilder.toString()));
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (operadores.peek() != '(') {
                    double resultadoParcial = aplicarOperacao(operadores.pop(), numeros.pop(), numeros.pop());
                    numeros.push(resultadoParcial);
                }
                operadores.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operadores.empty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    double resultadoParcial = aplicarOperacao(operadores.pop(), numeros.pop(), numeros.pop());
                    numeros.push(resultadoParcial);
                }
                operadores.push(c);
            }
        }

        while (!operadores.empty()) {
            double resultadoParcial = aplicarOperacao(operadores.pop(), numeros.pop(), numeros.pop());
            numeros.push(resultadoParcial);
        }

        return numeros.pop();
    }

    public static int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0;
    }

    public static double aplicarOperacao(char operador, double b, double a) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return a / b;
        }
        return 0;
    }
}


