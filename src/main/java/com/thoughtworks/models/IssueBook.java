package com.thoughtworks.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "issued_book")

public class IssueBook
{
    @Id
    private int id;

    @Column(name = "bookId")
    private int bookId;

    public int getBookId()
    {
        return bookId;
    }

    @Column(name = "issueDate")
    private Date issueDate;

    public Date getIssueDate()
    {
        return issueDate;
    }

    @Column(name = "returnedDate")
    private Date returnedDate;

    public Date getReturnedDate()
    {
        return returnedDate;
    }


    @Column(name = "employeeId")
    private int employeeId;

    public int getEmployeeId()
    {
        return employeeId;
    }

    public IssueBook()
    {

    }

    public IssueBook(int bookId, Date issueDate, Date returnedDate,int employeeId)
    {
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnedDate = returnedDate;
        this.employeeId = employeeId;
    }
}
