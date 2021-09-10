import java.util.Scanner;

class Calculator{
    int operandA;
    int operandB;
    boolean AType = true; //True - arabic , False - roman
    boolean BType = true;
    String operator;
    String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                             "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                             "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                             "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                             "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                             "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                             "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                             "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                             "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                             "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII","XCVIII","XCIX", "C"};

    void getData(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите операцию:");
        String inputLine = sc.nextLine();
        String[] inputData = inputLine.split(" ");

        if(inputData.length > 3){
            System.out.println("Ошибка! Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }else{
            operator = inputData[1];
            setNumbers(inputData[0], inputData[2]);
        }
    }

    void setNumbers(String A, String B){
        String[] validArabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] validRoman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean exeptA = true; // Out of range
        boolean exeptB = true;

        for(int i = 0; i < 10; i++){
            if(A.equals(validArabic[i])){
                operandA = i+1;
                exeptA = false;
                break;
            }
            if(A.equals(validRoman[i])){
                operandA = i+1;
                AType = false;
                exeptA = false;
                break;
            }
        }

        for(int i = 0; i < 10; i++){
            if(B.equals(validArabic[i])){
                operandB = i+1;
                exeptB = false;
                break;
            }
            if(B.equals(validRoman[i])){
                operandB = i+1;
                BType = false;
                exeptB = false;
                break;
            }
        }

        if(AType != BType){
            System.out.println("Ошибка! Используются одновременно разные системы счисления");
        }else{
            if(!(exeptA || exeptB)){
                calculate();
            }else{
                System.out.println("Ошибка! Некорректные значения!");
            }
        }
    }

    void calculate(){
        int result = 0;

        switch (operator) {
            case "+" -> result = operandA + operandB;
            case "-" -> result = operandA - operandB;
            case "*" -> result = operandA * operandB;
            case "/" -> result = operandA / operandB;
            default -> System.out.println("Ошибка! Неизвесная операция!");
        }

        if(AType && BType) {
            if(result < 0) {
                System.out.println("Ошибка! Результат меньше нуля!");
            }else{
                System.out.println(result);
            }
        }else{
            if(result <= 0) {
                System.out.println("Ошибка! Результат меньше или равен нулю!");
            }else{
                System.out.println(romanNumbers[result-1]);
            }
        }
    }
}