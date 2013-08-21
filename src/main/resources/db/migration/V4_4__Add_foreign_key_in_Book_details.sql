ALTER TABLE book_details
  ADD CONSTRAINT FK_book_details_Books_book_id FOREIGN KEY (book_id) REFERENCES books (id);