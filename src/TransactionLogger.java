import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private static final List<String> transactions = new ArrayList<>();

    public static void log(String entry) {
        transactions.add(entry);
    }

    public static String getAllLogs() {
        return String.join("\n", transactions);
    }
}
