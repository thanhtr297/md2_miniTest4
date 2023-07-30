import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage implements Serializable {
    int id = 0;
    public List<Category> categoryList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
//    Category category1 = new Category(1,"phone");
//    Category category2 = new Category(2,"laptop");

    public CategoryManage() {
        readFile();
    }
    public void addCategory(){

        System.out.println("Nhập vào tên danh mục muốn thêm: ");
        String name = scanner.nextLine();
        categoryList.add(new Category(++id,name));
        System.out.println("Thêm thành công!");
        writeFile("C:\\Users\\bong\\Desktop\\MD2_btap\\miniTestW4\\miniTestW4\\src\\catagory");

    }
    public void updateCategory(){
        if (checkEmpty()) {
            display();
            System.out.println("Nhập tên sản phẩm muốn sửa");
            String nameUpdate = scanner.nextLine();
            for (Category category : categoryList) {
                if (category.getNameCategory().equals(nameUpdate)) {
                    System.out.println("Nhập tên danh mục mới: ");
                    String newName = scanner.nextLine();
                    category.setNameCategory(newName);
                    System.out.println("Sửa thành công!");
                }
            }         writeFile("C:\\Users\\bong\\Desktop\\MD2_btap\\miniTestW4\\miniTestW4\\src\\catagory");

        } else {
            System.out.println("Danh mục trống!");
        }
    }
    public void display(){
       if (checkEmpty()) {
           System.out.println("Danh sách danh mục: ");
           for (Category value : categoryList) {
               System.out.println(value);
           }

       } else {
           System.out.println("Danh mục trống!");
       }
    }
    public void writeFile(String path){
        try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(categoryList);
            f.close();
            o.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void readFile() {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\bong\\Desktop\\MD2_btap\\miniTestW4\\miniTestW4\\src\\catagory");
            ObjectInputStream oin = new ObjectInputStream(in);
            categoryList = (List<Category>) oin.readObject();
            in.close();
            oin.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public Category getID(int id){
        return categoryList.get(id-1);
    }
    public boolean checkEmpty(){
        return !categoryList.isEmpty();
    }
}
