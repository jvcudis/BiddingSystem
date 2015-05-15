# FPTBiddingSystem
Spring 4 + Hibernate 4 + AngularJS

### Functional Requirements:
- User: can view products and current price in real time and bid a new price.
- Admin: can create new product, view-update and delete existing product.

### Non-functional Requirements:
- Database: RBDMS (Oracle, MySQL, PostgreSQL, 
- Implement 3 layer model:

### Presentation layer: 
- Deploy RESTful web service using Spring WebMVC.
- Validate user request parameters.

### Business layer: 
- Use @Service to configure Service Bean.
- Use @Transactional to control transaction.

### Persistent layer: use Hibernate.
- Log duration of each processing by using Spring AOP.
- Transaction management is implemented by Spring AOP.
- Security management is implemented by Spring AOP + Spring Security.

## Use Case
- User: can view and bid only.
- Admin: can create/read/update/delete product. Admin can’t bid.
