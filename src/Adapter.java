import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Adapter {
    public static Queue<String> readTheFile() {
        Queue<String> result = new LinkedList<>();
        BufferedReader inputStream;
        try {
            inputStream = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\java-rep\\src\\resources\\deposits.txt"));
            String l;
            while((l = inputStream.readLine()) != null) {
                result.add(l);
            }
        }
        catch (IOException e){
            System.out.println("Vse ploho");
        }

        return result;
    }

    private static String readWordAndDeleteIt(StringBuffer text){


        String res = "";
        int index = text.indexOf(";");
        if (index == -1)
            index = text.length();
        for (int i = 0; i < index; i++){
            res += text.charAt(i);
        }
        text.delete(0, index + 2);
        return res;
    }
    public static void addDeposit(StringBuffer text){
        BankDeposit deposit = new BankDeposit();
        deposit.setBankName(readWordAndDeleteIt(text).toString());
        deposit.setDepositName(readWordAndDeleteIt(text).toString());
        deposit.setMinAmount(Integer.parseInt(readWordAndDeleteIt(text).toString()));
        String buf = readWordAndDeleteIt(text).toString();
        if ( buf == "ежемесячно")
            deposit.setCapType(CapitalizationType.MONTH);
        else if (buf == "поквартально")
            deposit.setCapType(CapitalizationType.QUARTAL);
        else
            deposit.setCapType(CapitalizationType.YEAR);
        deposit.setYearlyInterest(Double.parseDouble(readWordAndDeleteIt(text).toString()));
        deposit.setMaxTime(Integer.parseInt(readWordAndDeleteIt(text).toString()));
        deposit.setEntryBonus(Double.parseDouble(readWordAndDeleteIt(text).toString()));
        deposit.setMinTime(Integer.parseInt(readWordAndDeleteIt(text).toString()));
        DepositService.bankDeposits.add(deposit);
    }
}

