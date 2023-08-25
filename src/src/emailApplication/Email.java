package emailApplication;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Email {

    //creating the global variables
    //making them all private so that they cant access it directly

    private   String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private  int defaultPasswordLength=10;
    private String alternateEmail;
    private String companySuffix ="company.com ";


    //Constructor to receive the first name and the last name
//in it, I am taking two parameter  firstName and lastName
    public Email(String firstName,String lastName){
  this.firstName=firstName;
  this.lastName=lastName;

        //Call a  method asking for the department  - return the department
   this.department=setDepartment();//here i am assigning department to setDepartment


        //Now we will call a method that will generate a random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your password is :"+this.password);

        //Now we will combine elements to generate an email
    email =firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;


    }
  // Here I will create a method that will ask for the department this method will be private
    private String setDepartment(){

        System.out.println("New Worker"+firstName+" Department CODES:\n1 For Sales \n2 For Development \n3 For Accounting \n0 For none\nEnter Department Codes :");
        Scanner in=new Scanner(System.in);
       int depChoice= in.nextInt();
        if (depChoice == 1){
            return "Sales";
        }
        else if (depChoice == 2){
            return " Development";
        }
        else if (depChoice == 3) {
            return " Accounting ";
        }
        else{
            return "";
        }
    }

    //Here now we will create a method that will generate a random password
    private String randomPassword(int length){

     String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
     //we are going to generate random number  and
  char []password=new char[length];
          //now we will iterate through the value of the length
        for(int i=0;i<length;i++){
         int rand =   (int) (Math.random()*passwordSet.length());
        password[i]=passwordSet.charAt(rand);

        }
      return new String(password);
    }
    // Now here we will set mailbox capacity
    public void setMailboxCapacity(int capacity ){
        this.mailboxCapacity=capacity;
    }

    //Now here we will set the alternate email
    public void setAlternateEmail(String altEmail1){
   this.alternateEmail=altEmail1;

    }
    public void changePasssword(String password){
        this.password= password;


    }
 public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){ return password; }
    public String showInfo(){

        return "Display Name :"+firstName+" "+lastName+
                "\nCompany Email  : "+email+
                " \nMailbox  Capacity : "+mailboxCapacity+"mb";

    }
}
