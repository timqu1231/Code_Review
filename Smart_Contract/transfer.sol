pragma solidity ^0.4.22


//trasfer product

contract Transfer{
	unit public product;


	mapping(address=>unit) balances;
	
	constructor(unit _product) public{
		product = _product;
		balances[msg.sender] = _product;
	}

	
	//transfer 
	function transfer(address receiver, unit quantity) public {
		require(balance[msg.sender] >= quantity, "Please add a product first");
		//can define as another (amount of)currency later
		require(reciver != msg.sender, "shouldn't send product to self");
		require(balance[reveiver] + quantity > balance[receiver]);//overflow check
		balance[msg.sender] -= product;
		balance[receiver] += product;
	}


	function balanceOf(address owner) public view returns(unit){
		return balances[owner];	
	}

	
}