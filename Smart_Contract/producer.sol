pragma solidity ^0.4.22


//create a producer and check the address of producer's balance
//balance should display the quantity of product avaliable 
//check if producer is authrized, valid to send value in chain;

contract Producer{
	address producer_owner;
	address[100] product;
	uint8 Count = 0;
	
	constructor() public{
		require(msg.sender == producer_owner());
		balances[msg.sender] = producer_owner;
	}

	//modifier onlyProducer{
	//	require(msg.sender == producer_owner());
	//	_;
	//}

	//check if producer need more product and if product has been creat per producer  
	function check() public producer{
		require(msg.value == 1 ether, "Producer need 1 ether to post product");
		//can define as another currency later
		require(Count >= 1,"One item must be post at least");
		require(existAlready(msg.sender) == false, "New product need to be created");
		product[Count] = msg.sender;
		Count++; 
	}

	

	function existAlready(address _product) private view returns(bool){
		bool containsProduct = false;
		for(unit i = 0; i < 100; i++) {
			if (product[i] == _product){
				containsProduct = true;
			}
		}
		return containsProduct;
	}

	function getBalanceOfContract() public view returns(unit){
		return address(this).balance;
	}

	function getBalanceOfOwner() public view onlyProducer returns(unit){
		return producer_owner.balance;	
	}

	function getBalanceOfSender() public view returns(unit){
		return msg.sender.balance;	
	}

	function getAddressOfContract() public view returns(address){
		return this;	
	}

	function balanceOf(address product) public view return (unit){
		return balance[product];
	}
}