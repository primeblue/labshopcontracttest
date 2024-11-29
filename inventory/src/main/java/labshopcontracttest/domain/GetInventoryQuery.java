package labshopcontracttest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GetInventoryQuery {

    private Long id;
    private Integer stock;
}
