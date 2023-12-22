package co.istad.demo.api.order;

import co.istad.demo.api.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties({"dataReceived", "dataDelivered"})
public class Order extends RepresentationModel<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_received")
//    @CreatedDate
    private LocalDateTime dataReceived;
    @Column(name = "data_delivered")
//    @LastModifiedDate
    private LocalDateTime dataDelivered;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product products;

}
