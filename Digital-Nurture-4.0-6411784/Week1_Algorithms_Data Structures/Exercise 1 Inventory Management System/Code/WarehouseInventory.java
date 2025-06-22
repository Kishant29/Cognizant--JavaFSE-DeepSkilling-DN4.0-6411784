import java.util.HashMap;

public class WarehouseInventory {
    private HashMap<Integer, InventoryItem> products;

    public WarehouseInventory() {
        products = new HashMap<>();
    }

    class InventoryItem {
        int productId;
        String productName;
        int quantity;
        double price;

        public InventoryItem(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
    }

  
    public void addProduct(int productId, String productName, int quantity, double price) {
        products.put(productId, new InventoryItem(productId, productName, quantity, price));
    }


    public void updateProduct(int productId, String productName, int quantity, double price) {
        if (products.containsKey(productId)) {
            products.put(productId, new InventoryItem(productId, productName, quantity, price));
        }
    }

    
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

  
    public InventoryItem getProduct(int productId) {
        return products.get(productId);
    }

 
    public static void main(String[] args) {
        WarehouseInventory inventory = new WarehouseInventory();

    
        inventory.addProduct(1, "Laptop", 10, 999.99);
        inventory.addProduct(2, "Smartphone", 25, 699.99);
        inventory.addProduct(3, "Tablet", 15, 349.99);

      
        inventory.updateProduct(2, "Smartphone Pro", 20, 799.99);

      
        WarehouseInventory.InventoryItem item = inventory.getProduct(2);
        if (item != null) {
            System.out.println("Product found: " + item.productName +
                    ", Quantity: " + item.quantity +
                    ", Price: $" + item.price);
        }


        inventory.deleteProduct(3);
    }
}