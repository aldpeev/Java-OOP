package L04InterfacesAndAbstraction.Exercise.P03Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {

            boolean isNumber = false;

            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isNumber  = true;
                    break;
                }
            }

            if (!isNumber){
                sb.append("Browsing: " + url + "!").append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {

            boolean isLetter = false;

            for (char c : number.toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isLetter  = true;
                    break;
                }
            }

            if (!isLetter){
                sb.append("Calling... " + number).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
