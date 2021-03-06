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
	if (table.length) { // Lib length
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}

		table.DataTable({ // Lib DataTable in DataTable Document
			
			lengthMenu: [[ 3, 5, 10, -1 ], [ '3 Records', '5 Records', '10 records', 'ALL' ] ], // Lib
			pageLength: 5,				// Lib
			ajax: {						// Lib
				url: jsonUrl,			// lib
				dataSrc: ''				// lib
			},
			columns: [ 
					  {
					  data: 'code',		// lib
					  mRender: function(data, type, row){  // lib
						  return '<img src="'+window.	contextRoot+'/resources/images/'+ data +'.jpg" class="dataTableImg"/>'
					  }
				  	  }, 
					  {
						  data: 'name'	// lib
					  }, 
					  {
						  data: 'brand'  // lib
					  }, 
					  {
						  data: 'unitPrice',  // lib
						  mRender: function(data,type,row){ // lib
							  return '&#8358; ' + data
						  }
					  },
					  {
						  data: 'quantity',		// lib
						  mRender: function(data, type, row) {		// lib
							  if(data < 1){
								  return '<span sytle="color:red">Out of Stock!</span>';
							  }
							  return data;
						  }
					  },
					  {
						  data: 'id',			// lib
						  bsortable: false,			// lib
						  mRender: function(data,type,row){			// lib
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
	
	// dismissing the alert after 3seconds
	var $alert = $('.alert');
	if($alert.length){
		
		setTimeout(function(){
			$alert.fadeOut('slow');
			
		},3000)
	}
	// ----------------------------------------
	
	
	
	// ---------------------------------------------
	// datatable administrator
	// ---------------------------------------------
	var adminProductsTable = $('#adminProductsTable');
	// execute the below code only where we have this table
	if (adminProductsTable.length) { // Lib length
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		console.log(jsonUrl);
		
		adminProductsTable.DataTable({ // Lib DataTable in DataTable Document
			
			lengthMenu: [[ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 records', 'ALL' ] ], // Lib
			pageLength: 30,				// Lib
			ajax: {						// Lib
				url: jsonUrl,			// lib
				dataSrc: ''				// lib
			},
			columns: [ {
				data: 'id'  // variable mapping with the json/productDAO
							// variables
			},
					  {
					  data: 'code',		// lib
					  bSortable: false,
					  mRender: function(data, type, row){  // lib
						  return '<img src="'+window.contextRoot+'/resources/images/'+ data +'.jpg" class="adminDataTableImg"/>'
					  }
				  	  }, 
					  {
						  data: 'name'	// lib
					  }, 
					  {
						  data: 'brand'  // lib
					  }, 
					  
					  {
						  data: 'quantity',		// lib
						  mRender: function(data, type, row) {		// lib
							  if(data < 1){
								  return '<span sytle="color:red">Out of Stock!</span>';
							  }
							  return data;
						  }
					  },
					  {
						  data: 'unitPrice',  // lib
						  mRender: function(data,type,row){ // lib
							  return '&#8358; ' + data;
						  }
					  },
					  {
						  data: 'active',			// lib
						  bSortable: false,
						  mRender: function(data,type,row){
							  var str= '';
if(data){							  
 str += '<label class="switch"><input type="checkbox" checked="checked" value="' + row.id + '"/><div class="slider"></div></label>';
}
else{
 str += '<label class="switch"><input type="checkbox" value="' + row.id + '"/><div class="slider"></div></label>';
}
		return str;
						  }
							  
					
					  },
					  {
						  data: 'id',
						  bSortable: false,
					  	  mRender: function(data, type, row){
					  		  var str='';
str += '<a href="'+	window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil">Edit</span> </a>'
					  		  		 return str;
					  	  }
					  }
					  
					  ],
			
		initComplete: function(){
			var api=this.api();
			api.$('.switch input[type="checkbox"]').on('change',function(){
				var checkbox= $(this);
				var checked = checkbox.prop('checked');
				var dMsg = (checked)? 'You want to activate the product?':
									 'You want to deactivate the product?';
				var value = checkbox.prop('value');
				
				bootbox.confirm({
					size: 'small',
					title: 'Product Activation & Deactivation',
					message: dMsg,
					callback: function(confirmed){
						if(confirmed){
							console.log(value);
							
							var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';

							$.post(activationUrl, function(data){
							
								bootbox.alert({
								size: 'medium',
								title: 'Information',
								message: data
							});
								
							});
							
						}
						else {
							checkbox.prop('checked', !checked);
					}
					}
				})
			});
			
		}
		 
		});

	}
	
	
	// ---------------------------------------------
	//validtion code for category modal dialog
	var categoryForm = $('#categoryForm');
	if(categoryForm.length){
		categoryForm.validate({
			
			rules: {
				
				name: {
					required: true,
					minlength: 2
					
				},
				
				description: {
					required: true,
				}
			},
			
			messages: {
				name: {
					required: 'Please add the category name!',
					minlength: 'The category name should not be less than 2 characters'
				},
				description: {
					required: 'Please add a descriptin for this category'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				//add the class of help block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
				
			}
			
		});
		
		
	}
	//----------------------------------
	
	
	
	
	
});