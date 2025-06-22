import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double price);
}

interface Stock {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

class StockMarket implements Stock {
    private String symbol;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public StockMarket(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("MobileApp: " + stockSymbol + " price updated to $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("WebApp: " + stockSymbol + " price updated to $" + price);
    }
}

public class StockObserverExample {
    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 150.50);

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        appleStock.registerObserver(mobile);
        appleStock.registerObserver(web);

        appleStock.setPrice(152.75);
        appleStock.setPrice(153.10);
    }
}