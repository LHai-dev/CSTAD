package com.aggregatorgradle.aggregatorgradle.compositcontroller;

import com.aggregatorgradle.aggregatorgradle.httpinterface.client.OrderClient;
import com.aggregatorgradle.aggregatorgradle.httpinterface.client.PaymentClient;
import com.aggregatorgradle.aggregatorgradle.httpinterface.client.UserClient;
import com.aggregatorgradle.aggregatorgradle.httpinterface.config.HttpClientGenerator;
import com.aggregatorgradle.aggregatorgradle.model.Aggregator;
import com.aggregatorgradle.aggregatorgradle.model.AggregatorById;
import com.aggregatorgradle.aggregatorgradle.response.OrderResponse;
import com.aggregatorgradle.aggregatorgradle.response.PaymentResponse;
import com.aggregatorgradle.aggregatorgradle.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
public class HttpInterfaceComposit {
    private final UserClient userClient;
    private final PaymentClient paymentClient;
    private final OrderClient orderClient;


//    private final com.aggregatorgradle.aggregatorgradle.openfeign.client.OrderClient getOhfdgrderClient;
//    private final com.aggregatorgradle.aggregatorgradle.openfeign.client.OrderClient getGetOrdhdferClient;
//    private final com.aggregatorgradle.aggregatorgradle.openfeign.client.OrderClient hgf;




    public HttpInterfaceComposit() {
        userClient = HttpClientGenerator
                .createService(UserClient.class);

        orderClient = HttpClientGenerator
                .createService(OrderClient.class);

        paymentClient = HttpClientGenerator
                .createService(PaymentClient.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/aggregatorService")
    public Aggregator aggregatorService() {

        Iterable<UserResponse> posts = userClient.getAllUsers();
        Iterable<OrderResponse> orderClients = orderClient.getAllOrders();
        Iterable<PaymentResponse> paymentResponses = paymentClient.getAllPayments();


        Aggregator aggregator = Aggregator.builder()
                .id(1L)
                .orderClients(orderClients)
                .paymentClients(paymentResponses)
                .userClients(posts)
                .localDate(LocalDate.now())
                .build();

        return aggregator;
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/aggregatorService/{id}")
    public AggregatorById aggregatorServiceById(@PathVariable Long id) {


        UserResponse posts1 = userClient.getUserById(id);
        OrderResponse orderClients1 = orderClient.getOrderById(id);
        PaymentResponse paymentResponses1 = paymentClient.getPaymentById(id);


       AggregatorById aggregator =AggregatorById.builder()
               .id(id)
               .orderClients(orderClients1)
               .paymentClients(paymentResponses1)
               .userClients(posts1)
               .localDate(LocalDate.now())
               .build();

        return aggregator ;
    }



}
