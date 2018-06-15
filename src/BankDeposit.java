public class BankDeposit {

    private String bankName;
    private String depositName;
    private Integer minAmount;
    private CapitalizationType capType;
    private Double yearlyInterest;
    private Integer maxTime;
    private Double entryBonus;
    private Integer minTime;

    public String getBankName() { return bankName;}

    public void setBankName(String bankName) {this.bankName = bankName;}

    public Integer getMinAmount() {
        return minAmount;
    }

    public CapitalizationType getCapType() {
        return capType;
    }

    public Double getYearlyInterest() {
        return yearlyInterest;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public String getDepositName() {
        return depositName;
    }

    public Double getEntryBonus() {
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

    public void setYearlyInterest(Double yearlyInterest) {
        this.yearlyInterest = yearlyInterest;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public void setEntryBonus(Double entryBonus) {
        this.entryBonus = entryBonus;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }
}


