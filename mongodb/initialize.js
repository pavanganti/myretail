use test;
db.dropUser("myretailuser");
db.createUser({
    user: 'myretailuser',
    pwd: 'MyRetail_pwd',
    roles: [
        {
            role: 'readWrite',
            db: 'test'
        }
    ]

});

db.productsprice.insertMany([
	  {
	    "_id" : 12345,
	    "currentPrice":{
	        "current_price" : 11.00,
	        "currenycode" : "USD"
	    }
	    
	  },
	  {
	    "_id" : 12346,
	    "currentPrice":{
	        "current_price" : 12.00,
	        "currenycode" : "USD"
	    }
	  },
	  {
	    "_id" : 12347,
	    "currentPrice":{
	        "current_price" : 13.00,
	        "currenycode" : "USD"
	    }
	  },
	  {
	    "_id" : 13860428,
	    "currentPrice":{
	        "current_price" : 14.00,
	        "currenycode" : "USD"
	    }
	  }
	]);