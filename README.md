## TODO

### APIs

- <u><b>Products (/collections)</b></u>
    1. GET: collections/shop-all => paginated all products</br>
       Note: Add filter for ALL, IN_STOCK AND OUT_OF_STOCK</br>
       Note2: All filter for price LTE and GTE</br>
    2. GET: collections/<category> => Get products by category
    3. GET: collections/new-arrival => Get all new arrival products<br>
       Note: Add filter for ALL, IN_STOCK AND OUT_OF_STOCK</br>
       Note2: All filter for price LTE and GTE</br>
- <u><b>Track (/track)</b></u>
    1. GET: /track?tracking_number=123
       Note: Should not trigger page reload
    2. GET: /track?order_num=123&email=456# terrana
