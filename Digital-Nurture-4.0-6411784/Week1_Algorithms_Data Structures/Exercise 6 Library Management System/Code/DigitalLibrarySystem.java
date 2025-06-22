public class DigitalLibrarySystem {
    class LibraryBook {
        int bookId;
        String title;
        String author;

        public LibraryBook(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }
    }


    public LibraryBook linearSearchByTitle(LibraryBook[] books, String targetTitle) {
        for (LibraryBook book : books) {
            if (book.title.equals(targetTitle)) {
                return book;
            }
        }
        return null;
    }


    public LibraryBook binarySearchByTitle(LibraryBook[] sortedBooks, String targetTitle) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].title.compareTo(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DigitalLibrarySystem library = new DigitalLibrarySystem();

  
        LibraryBook[] books = {
                library.new LibraryBook(1, "Java Programming", "John Doe"),
                library.new LibraryBook(2, "Data Structures", "Jane Smith"),
                library.new LibraryBook(3, "Algorithms", "Bob Johnson")
        };

        DigitalLibrarySystem.LibraryBook found = library.linearSearchByTitle(books, "Data Structures");
        if (found != null) {
            System.out.println("Found via linear search: " + found.title + " by " + found.author);
        }

  
        LibraryBook[] sortedBooks = {
                library.new LibraryBook(3, "Algorithms", "Bob Johnson"),
                library.new LibraryBook(2, "Data Structures", "Jane Smith"),
                library.new LibraryBook(1, "Java Programming", "John Doe")
        };
        found = library.binarySearchByTitle(sortedBooks, "Java Programming");
        if (found != null) {
            System.out.println("Found via binary search: " + found.title + " by " + found.author);
        }
    }
}