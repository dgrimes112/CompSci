import java.util.*;

public class Main
{
    public static void main(String args[])
    {
    // Instantiate the class BookList here ...
        BookList bookList = new BookList();

        Scanner scan = new Scanner(System.in);
        int LBCount = 0;
        int BBCount = 0;
        
        System.out.println("Welcome to the Book Program!");
        System.out.println("Would you like to create a book object? (yes or no):");
        String answer = "";
        while(answer.compareToIgnoreCase("no") != 0 && answer.compareToIgnoreCase("yes") != 0)
        {
            answer = scan.nextLine();
            if(answer.compareToIgnoreCase("no") == 0 || answer.compareToIgnoreCase("yes") == 0)
            {
                break;
            }
            else
            {
                System.out.printf("I'm sorry but \"%s\" is not a valid answer. Please enter yes or no:\n", answer);
            }

        }
        while(answer.compareToIgnoreCase("no") != 0)
        {
            System.out.println("Please enter the author, title and the isbn of the book separated by /:");
            String bookInfo = scan.nextLine();
            String[] bookInfoArray = bookInfo.split("/");
            String author = bookInfoArray[0];
            String title = bookInfoArray[1];
            String isbn = bookInfoArray[2];

            System.out.println("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book or LB for library book): ");
            String bookType = scan.nextLine();
            while(true)
            {
                if(bookType.compareToIgnoreCase("BB") == 0)
                {
                    System.out.println("Got it!");
                    System.out.printf("Please enter the price of %s by %s:", title, author);
                    float price = Float.parseFloat(scan.nextLine());
                    System.out.println("Is the book on sale? (y/n):");
                    while(true)
                    {
                        String saleCheck = scan.nextLine();
                        if(saleCheck.compareToIgnoreCase("y") == 0)
                        {
                            boolean sale = true;
                            System.out.println("What is the discount of the book?");
                            float discount = Float.parseFloat(scan.nextLine());
                            BookstoreBook book = new BookstoreBook(title, author, isbn, price, sale, discount);
                            bookList.add(book);
                            System.out.println("Got it!");
                            BBCount++;
                            System.out.println("Here is you BookstoreBook information:");
                            System.out.println(book);
                            break;
                        }
                        else if(saleCheck.compareToIgnoreCase("n") == 0)
                        {
                            BookstoreBook book = new BookstoreBook(title, author, isbn, price);
                            bookList.add(book);
                            BBCount++;
                            System.out.println("Here is you BookstoreBook information:");
                            System.out.println(book);
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid input. Please enter y or n.");
                        }
                    }
                    break;
                }
                       
                else if(bookType.compareToIgnoreCase("LB") == 0)
                {
                    LibraryBook book = new LibraryBook(title, author, isbn);
                    bookList.add(book);
                    LBCount++;
                    System.out.println("Here is you LibraryBook information:");
                    System.out.println(book);
                    break;
                }
                else
                {
                    System.out.println("Invalid book type. Please try again:");
                    bookType = scan.nextLine();
                }
            
            }
            answer = "";
            System.out.println("Would you like to create another book object? (yes or no):");
            answer = scan.nextLine();
        }

        System.out.println("Got it!");
        System.out.println("Here are all your books:");
        System.out.printf("library books(%d):\n", LBCount);
        bookList.printBooks("library");
        System.out.println("--------------------");
        System.out.printf("bookstore books(%d):\n", BBCount);
        bookList.printBooks("bookstore");
        System.out.println("--------------------");
        System.out.println("Take care now!");

        scan.close();

    }
}


//___________________________
abstract class Book
{
//code of the abstract class Book
//You may add an abstract method if you see fit...
    String title;
    String author;
    String isbn; 

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getIsbn()
    {
        return isbn;
    }


}
//___________________________
class BookstoreBook extends Book
{
// fields and specific code to the BookstoreBook class goes here
    float price;
    boolean sale;
    float discount;
    float salePrice;

    public void setPrice(float price)
    {
        this.price = price;
    }
    public void setSale(boolean sale)
    {
        this.sale = sale;

    }
    public void setDiscount(float discount)
    {
        this.discount = discount;
    }

    public void setSalePrice(float price, float discount)
    {
        this.salePrice = (price * (1-(discount/100)));
    }

    public float getPrice()
    {
        return price;
    }
    public boolean getSale()
    {
        return sale;
    }
    public float getSalePrice()
    {
        return salePrice;
    }

    public BookstoreBook(String title, String author, String isbn, float price, boolean sale, float discount)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.sale = sale;
        this.discount = discount;
        this.salePrice = (price * (1-(discount/100)));
    }

    public BookstoreBook(String title, String author, String isbn,float price)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.sale = false;
        this.discount = 0;
        this.salePrice = price;
    }

    public BookstoreBook(String title, String author, String isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = 0;
        this.sale = false;
        this.discount = 0;
        this.salePrice = 0;
    }

    @Override
    public String toString()
    {
        return "[" + isbn + "-" + title + " by " + author + ",$" + price + " listed for $" + salePrice + "]";
    }

}


//___________________________
class LibraryBook extends Book
{
// fields and specific code to the LibraryBook class goes here
    String callNumber;
    
    private String createCallNumber(String author, String isbn) {
        Random rand = new Random();
        int floor = rand.nextInt(100);
        callNumber = floor + "." + author.substring(0, 2) + "." + isbn.charAt(isbn.length()-1);
        return callNumber;
    }

    public void setCallNumber(String author, String isbn)
    {
        this.callNumber = createCallNumber(author, isbn);
    }
    
    public String getCallNumber() {
        return callNumber;
    }

    public LibraryBook(String title, String author, String isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.callNumber = createCallNumber(author, isbn);
    }

    public LibraryBook(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.callNumber = "";
    }
    public LibraryBook(String title)
    {
        this.title = title;
        this.author = "";
        this.isbn = "";
        this.callNumber = "";
    }

    @Override
    public String toString()
    {
        return "[" + isbn + "-" + title + " by " + author + "-" + callNumber + "]";
    }

}    
//___________________________
class BookList
{
    private Book[] list;

    public BookList()
    {
        list = new Book[100];
// Additional code goes here if needed...
    }

    public void add(Book book)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == null)
            {
                list[i] = book;
                break;
            }
        }
    }
    
    public int length()
    {
        int count = 0;
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null)
            {
                count++;
            }
        }
        return count;
    }

    public void printBooks(String type)
    {
        if (type.equals("library"))
        {
            for(int i = 0; i < list.length; i++)
            {
                if(list[i] instanceof LibraryBook)
                {
                    System.out.println(list[i]);
                }
            }
        }
        else if (type.equals("bookstore"))
        {
            for(int i = 0; i < list.length; i++)
            {
                if(list[i] instanceof BookstoreBook)
                {
                    System.out.println(list[i]);
                }
            }
        }
    }
}
