import LineClasses.CompareLines;

public class CheckingInput {
    public static void main(String[] args) {
        String ask = "7\n" +
                "C 1.1 8.15.1 P 15.10.2012 83\n" +
                "C 1 10.1 P 01.12.2012 65\n" +
                "C 1.1 5.5.1 P 01.11.2012 117\n" +
                "C 1.1 5.5.1 P 01.11.2012 144\n" +
                "D 1.1 8 P 01.01.2012-01.12.2012\n" +
                "C 3 10.2 N 02.10.2012 100\n" +
                "D 1 * P 8.10.2012-20.11.2012\n" +
                "D 3 10 P 01.12.2012\n" +
                "D 1 * P 8.10.2012-20.11.2012\n" +
                "C 1.1 8.15.1 P 15.10.2012 44\n" +
                "C 1.1 8.15.1 P 15.10.2012 83\n" +
                "C 1 10.1 P 01.12.2012 65\n" +
                "C 1.1 5.5.1 P 01.11.2012 117\n" +
                "D 1.1 8 P 01.01.2012-01.12.2012\n" +
                "C 3 10.2 N 02.10.2012 100\n" +
                "D 1 * P 8.10.2012-20.11.2012\n" +
                "D 3 10 P 01.12.2012";

        CompareLines compareLines = new CompareLines();

        compareLines.showAverageTime(ask);

    }
}
