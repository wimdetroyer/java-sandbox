package be.wimdetroyer.javasandbox.visitor.dop.books;


// Make abstract classes interfaces, and leaf nodes records.
// What about concrete classes with concrete subimplementations? for instance BannedFictionBook and BannedBestSellingFictionBook
public interface Book {

     String isbn();
     String title();
     String author();
     String summary();
}
