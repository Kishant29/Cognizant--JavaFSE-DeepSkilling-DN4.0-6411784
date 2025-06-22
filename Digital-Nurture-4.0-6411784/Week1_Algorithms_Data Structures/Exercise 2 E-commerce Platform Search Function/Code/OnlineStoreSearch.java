public class OnlineStoreSearch {
    class StoreProduct {
        int productId;
        String productName;
        String category;

        public StoreProduct(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
    }

    public StoreProduct linearSearch(StoreProduct[] products, String targetName) {
        for (StoreProduct product : products) {
            if (product.productName.equals(targetName)) {
                return product;
            }
        }
        return null;
    }

    public StoreProduct binarySearch(StoreProduct[] sortedProducts, String targetName) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].productName.compareTo(targetName);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OnlineStoreSearch store = new OnlineStoreSearch();

        StoreProduct[] products = {
                store.new StoreProduct(1, "Laptop", "Electronics"),
                store.new StoreProduct(2, "Smartphone", "Electronics"),
                store.new StoreProduct(3, "Headphones", "Accessories")
        };

        StoreProduct found = store.linearSearch(products, "Smartphone");
        if (found != null) {
            System.out.println("Found via linear search: " + found.productName);
        }

        StoreProduct[] sortedProducts = {
                store.new StoreProduct(3, "Headphones", "Accessories"),
                store.new StoreProduct(1, "Laptop", "Electronics"),
                store.new StoreProduct(2, "Smartphone", "Electronics")
        };
        found = store.binarySearch(sortedProducts, "Laptop");
        if (found != null) {
            System.out.println("Found via binary search: " + found.productName);
        }
    }
}