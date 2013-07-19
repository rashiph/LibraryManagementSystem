CREATE TABLE IF NOT EXISTS products(
  orderId INTEGER SERIAL DEFAULT VALUE UNIQUE NOT NULL,
  orderDate DATE,
  vendorId INTEGER,
  productUnit VARCHAR(15)

);



 @Id
    private int orderId;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "vendorId")
    private int vendorId;

    @Column(name = "productOrder")
    private List<ProductOrder> productOrder;

    @Column(name = "orderPlaced")
    private boolean orderPlaced;
