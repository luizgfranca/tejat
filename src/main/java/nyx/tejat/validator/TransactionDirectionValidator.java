package nyx.tejat.validator;

import java.util.List;

public class TransactionDirectionValidator {

    private final List<String> labels = List.of("IN", "OUT");

    public boolean validate(String label) {
        return labels.contains(label);
    }

}
