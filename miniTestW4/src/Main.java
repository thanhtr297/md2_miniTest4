import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryManage categoryManage = new CategoryManage();
        ProductManage productManage = new ProductManage();
        do {
            categoryManage.readFile();
            productManage.readProduct();
            System.out.println("MENU");
            System.out.println("1. Thêm danh mục sản phẩm\n" +
                    "2. Sửa danh mục \n" +
                    "3. Hiển thị danh sách danh mục \n" +
                    "4. Thêm sản phẩm \n" +
                    "5. Sửa sản phẩm \n" +
                    "6. Hiển thị danh sách sản phẩm \n" +
                    "7. Hiển thị sản phẩm có giá cao nhất và thấp nhất \n" +
                    "8. Tìm kiếm sản phẩm theo tên \n" +
                    "9. Tìm kiếm sản phẩm theo giá \n" +
                    "10. Hiển thị danh sách sản phẩm theo danh mục \n" +
                    "11. Đọc ghi 2 danh sách vào 2 file riêng biệt \n" +
                    "0. Exit.\n" +
                    "Nhập vào lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryManage.addCategory();
                    break;
                case 2:
                    categoryManage.updateCategory();
                    break;
                case 3:
                    categoryManage.display();
                    break;
                case 4:
                    productManage.addProduct();
                    break;
                case 5:
                    productManage.updateProduct();
                    break;
                case 6:
                    productManage.showProduct();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
