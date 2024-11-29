package labshopcontracttest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderCommand {

    private Long id;
    private String userId;
    private String productId;
    private String productName;
    private Integer qty;
}
