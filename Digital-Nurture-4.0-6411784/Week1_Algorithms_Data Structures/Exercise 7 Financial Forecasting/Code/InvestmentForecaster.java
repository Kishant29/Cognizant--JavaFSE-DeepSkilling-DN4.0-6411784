public class InvestmentForecaster {

    public double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public double calculateFutureValueMemo(double currentValue, double growthRate, int years) {
        Double[] memo = new Double[years + 1];
        return calculateFutureValueMemoHelper(currentValue, growthRate, years, memo);
    }

    private double calculateFutureValueMemoHelper(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemoHelper(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        InvestmentForecaster forecaster = new InvestmentForecaster();

        double initialInvestment = 10000;
        double annualGrowthRate = 0.07;
        int years = 10;

        double futureValue = forecaster.calculateFutureValue(initialInvestment, annualGrowthRate, years);
        System.out.printf("Future value (recursive): $%.2f after %d years\n", futureValue, years);

        double futureValueMemo = forecaster.calculateFutureValueMemo(initialInvestment, annualGrowthRate, years);
        System.out.printf("Future value (memoized): $%.2f after %d years\n", futureValueMemo, years);
    }
}