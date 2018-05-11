public class BankDeposit {

    private Integer minAmount;
    private CapitalizationType capType;
    private double yearlyInterest;
    private Integer maxTime;
    private String name;
    private double entryBonus;
    private Integer minTime;

    public Integer getMinAmount() {
        return minAmount;
    }

    public CapitalizationType getCapType() {
        return capType;
    }

    public double getYearlyInterest() {
        return yearlyInterest;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public String getName() {
        return name;
    }

    public double getEntryBonus() {
        return entryBonus;
    }

    public Integer getMinTime() {
        return minTime;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public void setCapType(CapitalizationType capType) {
        this.capType = capType;
    }

    public void setYearlyInterest(double yearlyInterest) {
        this.yearlyInterest = yearlyInterest;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntryBonus(double entryBonus) {
        this.entryBonus = entryBonus;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }
}


