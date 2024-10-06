class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBills = 0;
        int tenDollarBills = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveDollarBills++;
            } else if (bills[i] == 10) {
                if (fiveDollarBills > 0) {
                    fiveDollarBills--;
                    tenDollarBills++;
                } else {
                    return false;
                }
            } else {
                if (tenDollarBills > 0 && fiveDollarBills > 0) {
                    tenDollarBills--;
                    fiveDollarBills--;
                } else if (fiveDollarBills >= 3) {
                    fiveDollarBills -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
