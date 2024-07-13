import java.util.*;

public class atm {
    public static void main(String[] args) {
        
    
    bankaccount user = new bankaccount(2300);
     int actual_pin = 0000 ;
     ATM_mchine atm = new ATM_mchine(user, actual_pin);
    atm.bank_process();
    }
}

class ATM_mchine{
    private bankaccount acc ;
    private int pin ;

    public ATM_mchine (bankaccount ac , int pin){
        this.acc = ac;
        this.pin = pin ;
    }
        public void menu (){
            System.out.println("ATM MACHINE INTERFACE");
            System.out.println("1. Check Balance ");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit ");
          
        }

        public boolean verifypin(int entered_pin){
            return this.pin == entered_pin;
        }

        public void bank_process(){
            Scanner sc  = new Scanner(System.in);
            int entered_pin;

            System.out.print(" enter you bank account pin   :");
            entered_pin = sc.nextInt();

            if(verifypin(entered_pin)){
             int opt = 0;
              while (opt != 4) {
                menu();
                System.out.print("Enter your choice what do you want to do   ");
                opt = sc.nextInt();
                
                switch (opt) {
                    case 1:
                    System.out.println(" The remaining balance in your account is :  "+  acc.getbalance());
                    break;

                    case 2 :
                     System.out.println(" Enter the amount you want to deposit   :");
                     double amount_to_deposit = sc.nextDouble();
                     acc.deposit_bal(amount_to_deposit);
                        break;
                    case 3 :
                    System.out.println(" Enter the amount you want to withdraw  :");
                    double amount_to_withdraw = sc.nextDouble();
                    acc.withdraw_bal(amount_to_withdraw);

                    break;
                     case 4 : 
                     System.out.println(" THANK YOU ");
                     break;

                    default:
            System.out.println("you have entered wrong choice     PLEASE RE -ENTER");

                }

            
        }
    }
    else{
        System.out.println("you have entered wrong pin ");
        
    }
    sc.close();
}
}
class bankaccount{
    private double bal ;

    public bankaccount(double initial_bal){
        this.bal = initial_bal;
    }

    public double getbalance(){
        return bal ;
    }
     public void deposit_bal(double amount){
        if(amount>0){
            bal+=amount;
            System.out.println("The amount " + amount + " is deposited in your account suceesfully ");
        }
        else{
            System.out.println(" you cannot enter amount less than 0 ");
        }
     }

     public void withdraw_bal(double amount){
        if(amount>0 && amount<= bal){
            bal -= amount;
            System.out.println("The amount "+ amount + "is withdrawn sucessfully ");
        }
         else{
            System.out.println("insufficent balance ");
         }
     }

}