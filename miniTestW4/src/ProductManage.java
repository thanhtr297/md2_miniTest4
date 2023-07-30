import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage implements Serializable {
    private final Scanner scanner = new Scanner(System.in);
    List<Product> productList = new ArrayList<>();
    CategoryManage categoryManage = new CategoryManage();

    public ProductManage() {
        readProduct();
    }

    public void addProduct() {
        System.out.println("Nhập mã sản phẩm cần thêm:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm cần thêm:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm cho " + name);
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Chọn danh mục cho " + name + " theo id");
        categoryManage.display();
        Category category = categoryManage.getID(Integer.parseInt(scanner.nextLine()));
        Product product = new Product(id, name, price, category);
        productList.add(product);
        System.out.println("Thêm thành công sản phẩm!!");
        writeProduct();
    }

    public void updateProduct() {
//        do{
            System.out.println("Nhập mã sản phẩm cần sửa: ");
            int idUpdate = Integer.parseInt(scanner.nextLine());
            for (Product a : productList) {
                if (idUpdate == a.getId()) {
                    System.out.println("Nhập tên sản phẩm để sửa: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập giá cần sửa");
                    Double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Chọn danh mục muốn sửa: ");
                    Category category = categoryManage.getID(scanner.nextInt());
                    a.setName(name);
                    a.setPrice(price);
                    a.setCategory(category);
                }
            }
//        } while (true);
    }

    public void showProduct() {
        readProduct();
        for (Product a : productList) {
            System.out.println(a);
        }
    }

    public void writeProduct() {
        try {
            FileOutputStream f = new FileOutputStream("C:\\Users\\bong\\Desktop\\MD2_btap\\miniTestW4\\miniTestW4\\src\\product");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(productList);
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readProduct() {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\bong\\Desktop\\MD2_btap\\miniTestW4\\miniTestW4\\src\\product");
            ObjectInputStream inputStream = new ObjectInputStream(in);
            productList = (List<Product>) inputStream.readObject();
            in.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
