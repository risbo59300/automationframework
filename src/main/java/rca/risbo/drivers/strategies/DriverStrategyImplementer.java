package rca.risbo.drivers.strategies;

import rca.risbo.utils.Constants;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case Constants.CHROME:
                return new Chrome();

            case Constants.PHANTOMJS:
                return new PhantomsJs();

            case Constants.FIREFOX:
                return new Firefox();

            default:
                return null;
        }
    }
}
