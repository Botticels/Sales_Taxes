import java.io.FileNotFoundException;

public interface BillServiceInterface {
    public Bill createBill(String fileName) throws FileNotFoundException;
}
