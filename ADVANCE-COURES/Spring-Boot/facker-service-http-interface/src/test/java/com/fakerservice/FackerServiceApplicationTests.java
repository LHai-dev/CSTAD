package com.fakerservice;

import com.fakerservice.client.FakerPublicClient;
import com.fakerservice.client.JsonPlaceholderClient;
import com.fakerservice.config.HttpClientGenerator;
import com.fakerservice.request.PostRequest;
import com.fakerservice.response.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FackerServiceApplicationTests {
//
//    @Test
//    void fakerGetAll() {
//        FakerPublicClient fakerPublicClient = HttpClientGenerator.createService(FakerPublicClient.class);
//        System.out.println(fakerPublicClient.allProducts());
//
//    }
//    @Test
//    void fakerGetById(){
//        FakerPublicClient fakerPublicClient = HttpClientGenerator.createService(FakerPublicClient.class);
//        System.out.println(fakerPublicClient.getProductById(1));
//    }
//    @Test
//    void fakerCreateProduct(){
//        FakerPublicClient fakerPublicClient = HttpClientGenerator.createService(FakerPublicClient.class);
//        System.out.println(fakerPublicClient.createProduct(PostRequest.builder().description("hello bong").title("limhai").userId(2).build()));
//    }
//
//    @Test
//    void fakerUpdateProduct(){
//        FakerPublicClient fakerPublicClient = HttpClientGenerator.createService(FakerPublicClient.class);
//        System.out.println(fakerPublicClient.updateProduct(1,PostRequest.builder().description("hello bong").title("limhai").userId(2).build()));
//    }
//    @Test
//    void fakerDeleteProduct(){
//        FakerPublicClient  fakerPublicClient = HttpClientGenerator.createService(FakerPublicClient.class);
//        System.out.println(fakerPublicClient.deleteById(1));
//    }
//
//    //JsonPlaceholder
//
//    @Test
//    void JsonFindAll(){
//        JsonPlaceholderClient jsonPlaceholderClient = HttpClientGenerator.createService(JsonPlaceholderClient.class);
//        System.out.println(jsonPlaceholderClient.allPosts());
//    }
//    @Test
//    void JsonFindById(){
//        JsonPlaceholderClient jsonPlaceholderClient = HttpClientGenerator.createService(JsonPlaceholderClient.class);
//        System.out.println(jsonPlaceholderClient.onePost(1));
//    }
//    @Test
//    void JsonUpdateById()
//    {
//        JsonPlaceholderClient jsonPlaceholderClient = HttpClientGenerator.createService(JsonPlaceholderClient.class);
//        System.out.println(jsonPlaceholderClient.updatePost(1,PostRequest.builder().description("gdfgfdgdfg").name("limhai").title("jashf;sohgoshg;u").userId(12).build()));
//    }
//    @Test
//    void JsonCreateById(){
//        JsonPlaceholderClient jsonPlaceholderClient = HttpClientGenerator.createService(JsonPlaceholderClient.class);
//        System.out.println(jsonPlaceholderClient.savePost(PostRequest.builder().name("askhlf;sdhlfkhsa;jkdhf").title("sajlfhsahfljkdsahflhsaj").build()));
//    }
//    @Test
//    void JsonDeleteById(){
//        JsonPlaceholderClient jsonPlaceholderClient = HttpClientGenerator.createService(JsonPlaceholderClient.class);
//    jsonPlaceholderClient.deletePost(1);
//        System.out.println();
//    }
}
