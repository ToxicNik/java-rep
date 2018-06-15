import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


public class DepositService {
    public static ArrayList<BankDeposit> bankDeposits = new ArrayList<>();

    public static Double calculateDeposit(Integer startSum, Integer monthlyPay, Integer days, BankDeposit deposit) {
        if (startSum < deposit.getMinAmount() || (days < deposit.getMinTime()))
            return 0.;
        int capType = 0;

        if (deposit.getCapType() == CapitalizationType.MONTH)
            capType = 1;
        else if
                (deposit.getCapType() == CapitalizationType.QUARTAL)
            capType = 3;
        else if (deposit.getCapType() == CapitalizationType.YEAR)
            capType = 12;

        if (days > deposit.getMaxTime())
            days = deposit.getMaxTime();
        double sum = startSum + startSum * deposit.getEntryBonus();
        while ((days / (30 * capType)) > 0) {
            sum = sum + monthlyPay * (capType - 1);
            sum = sum + sum * deposit.getYearlyInterest() / (12 / capType);
            sum += monthlyPay;
            days -= 30*capType;
        }

        while (days/30 > 0){
            sum += monthlyPay;
            days -= 30;
        }
        return sum;
    }

    public static String determineTheBest(Integer startSum, Integer monthlyPay, Integer days) {
        ArrayList<Double> moneyFromDeposits = new ArrayList<>();
        for (BankDeposit i : bankDeposits)
            moneyFromDeposits.add(calculateDeposit(startSum, monthlyPay, days, i));

        Double max = Collections.max(moneyFromDeposits);
        int count = 0;
        for (Double i : moneyFromDeposits) {
            if (max == i)
                return bankDeposits.get(count).getDepositName();
            count++;
        }
        return "";
    }

    public static void main(String[] args){
        Queue<String> output = Adapter.readTheFile();
        int length = output.peek().length()*2;
        StringBuffer buf = new StringBuffer(length);
        for (int i = 0; i< 5; i++) {
            buf.append(output.poll());
            Adapter.addDeposit(buf);
            buf.delete(0, length - 1);
        }
//        BankDeposit dep0 = new BankDeposit();
//        dep0.setDepositName("dep0");
//        dep0.setCapType(CapitalizationType.MONTH);
//        dep0.setEntryBonus(0.05);
//        dep0.setMinTime(90);
//        dep0.setMaxTime(730);
//        dep0.setMinAmount(10000);
//        dep0.setYearlyInterest(0.12);
//
//        BankDeposit dep1 = new BankDeposit();
//        dep1.setDepositName("dep1");
//        dep1.setCapType(CapitalizationType.QUARTAL);
//        dep1.setEntryBonus(0.03);
//        dep1.setMinTime(150);
//        dep1.setMaxTime(600);
//        dep1.setMinAmount(20000);
//        dep1.setYearlyInterest(0.14);
//
//        bankDeposits.add(dep0);
//        bankDeposits.add(dep1);
//
        System.out.println(determineTheBest(130000, 4000, 220));
    }
}
