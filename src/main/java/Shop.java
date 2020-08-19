import java.io.FileNotFoundException;

public class Shop {

    public void printBill(String fileName) throws FileNotFoundException {
        BillService billService = new BillService();
        Bill bill = billService.createBill(fileName);
        System.out.print(bill.toString());
    }

}

