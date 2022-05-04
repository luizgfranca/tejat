package nyx.tejat.validator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDirectionValidator {

    private final List<String> labels = List.of("IN", "OUT");

    public boolean validate(String label) {
        return labels.contains(label);
    }

}
