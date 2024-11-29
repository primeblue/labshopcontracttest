package labshopcontracttest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshopcontracttest.OrderApplication;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String productId;

    private String productName;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void order(OrderCommand orderCommand) {
        //implement business logic here:

        labshopcontracttest.external.GetInventoryQuery getInventoryQuery = new labshopcontracttest.external.GetInventoryQuery();
        // getInventoryQuery.set??()
        Inventory inventory = OrderApplication.applicationContext
            .getBean(labshopcontracttest.external.InventoryService.class)
            .getInventory(getInventoryQuery);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
