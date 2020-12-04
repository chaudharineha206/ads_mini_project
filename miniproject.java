package miniproject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.UUID;

public class Miniproject_01 
{
    static int total=0,order1=0;
   
    static ArrayList<String> productList = new ArrayList<String>();
    
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int choice;
        System.out.println("\n ------------------------------------- \n Tupperware Order Management System \n ------------------------------------- \n1. Buy a product \n2. Get membership \n3. Contact us \n ------------------------------------- \n\t Enter choice :  ");
        choice=sc.nextInt();
        switch(choice)
        {
            case 1: buy();
                      break;
            case 2: membership();
                      break;
            case 3: contact();
                      break;
            default:
                System.out.println("Invalid choice");
        }
    }
    static void buy() 
    {
        Scanner sc= new Scanner(System.in);
        int ch;
        do{
            System.out.println("\n1. View item \n2. Choose item \n3.Place order\n ------------------------------------ \n \t Enter choice : ");
            ch=sc.nextInt();
                switch(ch)
                {
                    case 1: view();
                              break;
                    case 2: choose();
                              break;
                    case 3: place();
                              break;    
                    default:
                        System.out.println("Invalid choice");
                }
            }while(ch!=4); 
    } 
    static void view()
    {
        System.out.println("\t *** list of item ***");
        System.out.println("1. bottle for 100 \n2. tiffin for 200 \n3. blender for 500 ");
        System.out.println("-------------------------------------");
    }
    static void choose()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println(" \t *** Make a chioce *** ");
        System.out.print("Enter quantity of product : ");
        int i=sc.nextInt();
        System.out.println("You can now enter " + i + " Product");
        System.out.println("Insert product one by one & press Enter to insert next product( 1 or 2 or 3 ) \n -------------------------------------");
        for(int x=1; x<=i; x++)
        {
            System.out.println("Product " + x);

            int a =sc.nextInt();
            if(a==1)
            {
               // for p1 100 rs
                total=total+100;
            }else if(a==2)
            {
                // System.out.println("for p2 200 rs");
                total=total+200;
            }else if(a==3)
            {
            //    System.out.println("for p3 500 rs");
                total=total+500;
            }else{
                System.out.println("You Entered Invalide Product Id");
                System.exit(0);
            }
            String a1=Integer.toString(a);
            productList.add(a1);   
        }
        Iterator itr=productList.iterator();
        {
            System.out.print("Product List : ");
            
            while(itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
            System.out.print("\n -------------------------------------");
        }
        order1++;
    }
    
    static void place()
    {   
        Scanner sc=new Scanner(System.in);
        System.out.println(" 1 To place order \n 2 to cancel order \n 3 To contact us \n------------------------------------- \n\t Enter Choice ");
        int a=sc.nextInt();
        Miniproject_01 m=new Miniproject_01();
        if(order1==1)
        {
            if(a==1)
            {
                String uniqueID = UUID.randomUUID().toString();
                System.out.println("-----------------------------------------");
                m.timeDate();
                System.out.println("Transaction Id : "+uniqueID); 
                System.out.println("\n total amount of order ="+total);
                m.membership();
                System.out.println("-----------------------------------------");

            }else if(a==2)
            {
                System.out.println("\n your order has been cancelled"); //count++;
                System.exit(0);
            }else if(a==3)
            {
                m.contact();
            }        
    
        }
    }
    void  timeDate()
	  {
                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		  LocalDateTime now = LocalDateTime.now();

		   System.out.println("Date : "+dtf.format(now));
	  } 
    static void membership()
    {
        if(total>=1000)
        {   
            System.out.println("___________Thank You___________");
            System.out.println("\n\n Congrats !!! You get the membership");
            System.out.println("\n___________ Visit Again :) ________");
            System.exit(0);
        }
        else
        {
           //System.out.println(" Not Eligible For Membership ");
            System.out.println("\n___________ Thank You Visit Again :) ________");
            System.exit(0);
        }
    }   
    static void contact()
    {
        System.out.println("Email :- xyz@gmail.com");
    }    
}