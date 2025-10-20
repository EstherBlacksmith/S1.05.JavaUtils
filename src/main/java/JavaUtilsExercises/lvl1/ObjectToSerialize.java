package JavaUtilsExercises.lvl1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ObjectToSerialize implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int quantity;
    private String rollNo;

    public ObjectToSerialize(String name, int quantity) {
        this.name = Objects.requireNonNull(name, "Name can't be null");
        if (quantity < 0) {
            throw new RuntimeException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
