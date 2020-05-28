$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu== "Home") break;
		$('#listProducts').addClass('active');
		$('#home').addClass('active');
		break;

	}

	var table = $('#productListTable');
	// execute the below code only where we have this table
	if (table.length) { //Lib length
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}

		table.DataTable({ //Lib DataTable in DataTable Document
			
			lengthMenu: [[ 3, 5, 10, -1 ], [ '3 Records', '5 Records', '10 records', 'ALL' ] ], //Lib
			pageLength: 5,				//Lib
			ajax: {						//Lib
				url: jsonUrl,			//lib
				dataSrc: ''				//lib
			},
			columns: [ 
					  {
					  data: 'code',		//lib
					/*  mRender: function(data, type, row){  //lib
						  return '<img src="'+window,contextRoot+'/resources/images/'+ data +'.jpg" class="dataTableImg"/>'
					  }*/
				  	  }, 
					  {
						  data: 'name'	//lib
					  }, 
					  {
						  data: 'brand'  //lib
					  }, 
					  {
						  data: 'unitPrice',  //lib
						  mRender: function(data,type,row){ //lib
							  return '&#8377; ' + data
						  }
					  },
					  {
						  data: 'quantity',		//lib
						  mRender: function(data, type, row) {		//lib
							  if(data < 1){
								  return '<span sytle="color:red">Out of Stock!</span>';
							  }
							  return data;
						  }
					  },
					  {
						  data: 'id',			//lib
						  bsortable: false,			//lib
						  mRender: function(data,type,row){			//lib
							  var str='';				
							  str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">View</span></a> &#160';
							  
							  if(row.quantity<1){
								  str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart">Cart+</span></a>';
 
							  }
							  else{
								  str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Cart+</span></a>';

							  }
							  
							  
							  
							  
							  return str;
						  }
					  }
					  ]
		 
		});

	}
	
	//dismissing the alert after 3seconds
	var $alert = $('.alert');
	if($alert.length){
		
		setTimeout(function(){
			$alert.fadeOut('slow');
			
		},3000)
	}
	

});