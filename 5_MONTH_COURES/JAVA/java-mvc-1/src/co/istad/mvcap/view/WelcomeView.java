package co.istad.mvcap.view;

import co.istad.mvcap.controller.ProductController;
import co.istad.mvcap.dto.CreateProductDto;
import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.dto.UpdateProductDto;
import java.util.Scanner;
import java.util.UUID;

public class WelcomeView {
    public static void welcome(Scanner scanner) {
        label: do {
            System.out.println("-------------------------");
            System.out.println("Welcome to My Application");
            System.out.println("-------------------------");
            System.out.println("1. Create new product");
            System.out.println("2. List all products");
            System.out.println("3. Remove product");
            System.out.println("4. Update Product");
            System.out.println("5. Exit");
            System.out.print("Choose option -> ");
            int option = InputView.getInputNumber(new Scanner(System.in));
            ProductController controller = new ProductController();
            switch (option) {
                case 1 -> {
                    CreateProductDto createProductDto = new CreateProductDto(100101, "Sting", 0.5);
                    ProductDto productDto = controller.handleCreateNewProduct(createProductDto);
                    System.out.println("Product is created successfully");
                    System.out.println(productDto);
                    ProductListView.productListView(controller.handleProductList());
                }
                case 2 -> {
                    ProductListView.productListView(controller.handleProductList());
                }
                case 3->{
                    controller.handleRemoveByID(UUID.randomUUID());
                    ProductListView.productListView(controller.handleProductList());
                }
                case 4->{
                    controller.handleUpdateById(UUID.randomUUID(),new UpdateProductDto("coca",200.0));
                    ProductListView.productListView(controller.handleProductList());
                }
                case 5->{
                    break label;
                }
                default -> System.out.println("Invalid option..!");
            }
        }while (true);
    }
}
