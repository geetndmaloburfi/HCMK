
function add_to_cart(pid,pname,price,pMC,pPhoto)
{
	let cart=localStorage.getItem("cart");
	if(cart==null)
	{
		//no cart
		let products=[];
		let product = {productId : pid , productName : pname , productQuantity : 1 , productPrice : price , productMC:pMC , productPhoto : pPhoto};
		products.push(product);
		localStorage.setItem("cart",JSON.stringify(products));
		//console.log("product added first time");
		showToast("Product added to cart");
	}
	else{
		//present
		let pcart=JSON.parse(cart);
		let oldproduct=pcart.find((item)=>item.productId==pid)
		if(oldproduct)
		{
			oldproduct.productQuantity=oldproduct.productQuantity+1;
			pcart.map((item)=>{
				if(item.productId==oldproduct.productId)
				{
					item.productQuantity=oldproduct.productQuantity;
				}
				
			})
				localStorage.setItem("cart",JSON.stringify(pcart));
				//console.log("product quantity increased");
				showToast(oldproduct.productName + " Product quantity increased");
		
			
		}else{
			let product = {productId : pid , productName : pname , productQuantity : 1,productPrice : price , productMC:pMC,prodcutPhoto : pPhoto};
	pcart.push(product);
			localStorage.setItem("cart",JSON.stringify(pcart));
			//console.log("new  product added");
			showToast("Product added to cart");
		
		}
	}
	
	
	
	updateCart();
}

//update cart
function updateCart(){
	let cartString =localStorage.getItem("cart");
	let cart=JSON.parse(cartString);
	console.log("in update");
	if(cart==null||cart.length==0)
	{
		console.log("cart is empty");
		$(".cart-items").html("(0)");
		$(".cart-body").html("<p>Your Cart is empty !!<i class=\"far fa-frown-open\"></i></p>");
		$(".checkout-btn").attr('disabled',true);
	}else{
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);
		let table=`
		<table class='table'>
		<thead class='thread-dark'>
		<tr>
		<th> Product Name </th>
		<th> Price </th>
		<th> Making Charges</th>
		<th> Quantity </th>
		<th> Total Price</th>
		<th>Action</th>
		</tr>
		</thead>
		`;
		let totalprice=0;
		cart.map((item)=>{
			var p=parseFloat(item.productPrice);
			var mc=parseFloat(item.productMC);
			var price=p+mc;
			//let imagepath="../";
			table+=`
			<tr>
			<td> ${item.productName}</td>
			<td> ${item.productPrice}</td>
			<td> ${item.productMC}</td>
			<td> ${item.productQuantity}</td>
			<td> ${item.productQuantity*(price)}</td>
			<td> <button onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Remove</button></td>	
			</tr>
			`
			totalprice+=item.productQuantity*price;
			//console.log(imagepath+item.productPhoto);
		})
		
		table=table+`
		<tr><td colspan='6' class='text-right font-weight-bold m-5'> Total Price :${totalprice}</td></tr>
		</table>`;
		$(".cart-body").html(table);
		$(".checkout-btn").attr('disabled',false);
		
	}
}


function deleteItemFromCart(pid)
{
	let cart=JSON.parse(localStorage.getItem('cart'));
	let newcart=cart.filter((item)=>item.productId!=pid);
	localStorage.setItem('cart',JSON.stringify(newcart));
	updateCart();
	showToast("Product removed from cart");
}

$(document).ready(function(){
	updateCart()
})

function showToast(content){
	$("#toast").addClass("display");
	$("#toast").html(content);
	setTimeout(()=>{
		$("#toast").removeClass("display");
	},2000);
}