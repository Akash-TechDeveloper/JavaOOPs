package Smart_City_Resource_Management;

 class Water extends Resource{
     public Water(){super("Water");}

     @Override
     public void allocate(double amount){
         Usage+=amount;
         System.out.println("Supplied "+amount+" of Litres");
     }

     @Override
     public void release(double amount){
         Usage-=amount;
         System.out.println("Reduced "+ amount + " of Litres");
     }
}
