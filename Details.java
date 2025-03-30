class Library { //outer class
    static class Book { //static nested class
        private String title;
        private String author;
        private String ISBN;

        public Book(String title, String author, String ISBN) { //constructor to initialize book details
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
        }

        public void displayDetails() { //method to show book details
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + ISBN);
        }
    }

    public static void main(String[] args) {
        Library.Book book1 = new Library.Book("Introduction to OOPS", "Ritika", "500120608");
        book1.displayDetails();
    }
}
