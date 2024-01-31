•	Create Product microservice and Coupon microservice
•	These two services(Product and Coupon) will expose restful API which will allow the end user to create a product and in the process, the Product service will use the Coupon service to apply the “couponcode” that the client passes in and gets the discount.
•	Coupon information is maintained by the Coupon service
•	Product Service is responsible for creating the product along with its price and description details which the client passes.
•	So, the process here is 
o	Take the client’s request
o	The product service will call the coupon service
o	Get the discount for the product with the couponcode which the client would have passed.
o	 Apply the discount on the price and then save the product to the product database.
o	All the coupon details will be saved in the coupon service database.
o	Coupon Service will expose restful APIs – Create coupon, Get the Coupon details through coupon code.
