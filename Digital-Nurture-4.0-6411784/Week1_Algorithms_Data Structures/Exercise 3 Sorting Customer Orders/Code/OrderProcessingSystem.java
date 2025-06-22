public class OrderProcessingSystem {
    class CustomerOrder {
        int orderId;
        String customerName;
        double totalPrice;

        public CustomerOrder(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }
    }

    public void bubbleSort(CustomerOrder[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(CustomerOrder[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private int partition(CustomerOrder[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        OrderProcessingSystem ops = new OrderProcessingSystem();

        CustomerOrder[] orders = {
                ops.new CustomerOrder(101, "John Doe", 149.99),
                ops.new CustomerOrder(102, "Jane Smith", 89.99),
                ops.new CustomerOrder(103, "Bob Johnson", 199.99)
        };

        ops.bubbleSort(orders);
        System.out.println("After bubble sort:");
        for (CustomerOrder order : orders) {
            System.out.println(order.customerName + ": $" + order.totalPrice);
        }

        CustomerOrder[] orders2 = {
                ops.new CustomerOrder(101, "John Doe", 149.99),
                ops.new CustomerOrder(102, "Jane Smith", 89.99),
                ops.new CustomerOrder(103, "Bob Johnson", 199.99)
        };

        ops.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nAfter quick sort:");
        for (CustomerOrder order : orders2) {
            System.out.println(order.customerName + ": $" + order.totalPrice);
        }
    }
}