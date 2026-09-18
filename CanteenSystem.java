import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] menuNames = {
            "Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"
        };
        double[] menuPrices = {
            80.00, 120.00, 100.00, 70.00, 90.00
        };
        
        int totalQty = 0;
        double totalSubtotal = 0.0;
        boolean keepOrdering = true;
        
        while (keepOrdering) {
            System.out.println("\n===== MENU =====");
            for (int i = 0; i < menuNames.length; i++) {
                System.out.printf("%d. %s - $%.2f%n", 
                    (i+1), menuNames[i], menuPrices[i]);
            }
            
            System.out.print("\nEnter item number: ");
            int itemNum = input.nextInt();
            
            if (itemNum < 1 || itemNum > menuNames.length) {
                System.out.println("❌ Invalid item number! Try again.");
                continue;
            }
            
            System.out.print("Enter quantity: ");
            int qty = input.nextInt();
            
            if (qty < 1 || qty > 10) {
                System.out.println("❌ Quantity must be 1–10. Try again.");
                continue;
            }
            
            System.out.print("Are you a student? (Y/N): ");
            char isStudent = Character.toUpperCase(input.next().charAt(0));
            
            double price = menuPrices[itemNum - 1];
            double subTotal = price * qty;
            
            totalQty += qty;
            totalSubtotal += subTotal;
            
            System.out.printf("Subtotal: $%.2f%n", subTotal);
            
            System.out.print("Do you want to order again? (Y/N): ");
            char again = Character.toUpperCase(input.next().charAt(0));
            keepOrdering = (again == 'Y');
        }
        
        System.out.println("\n========== FINAL RECEIPT ==========");
        System.out.printf("Total quantity of items purchased: %d%n", totalQty);
        System.out.printf("Total amount before deductions: $%.2f%n", totalSubtotal);
        
        System.out.print("Are you a student? (Y/N): ");
        char isStudent = Character.toUpperCase(input.next().charAt(0));
        
        double discountRate = 0.0;
        
        if (isStudent == 'Y' && totalSubtotal >= 500) {
            discountRate = 0.15;
        } else if (isStudent == 'Y') {
            discountRate = 0.10;
        } else if (totalSubtotal >= 500) {
            discountRate = 0.05;
        }
        
        double totalDiscount = totalSubtotal * discountRate;
        double finalAmount = totalSubtotal - totalDiscount;
        
        System.out.printf("Total deduction: $%.2f%n", totalDiscount);
        System.out.printf("Final amount to pay: $%.2f%n", finalAmount);
        System.out.println("====================================");
        
        input.close();
    }
}
