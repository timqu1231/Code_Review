pragma solidity ^0.4.24;

contract Track {
    address public owner;  

    struct Status {
        bytes4 id;
        bytes32 name;
    }

    Status[] public status;

    constructor() public {
        owner = msg.sender;
    }

    modifier isOwner() {
        require(msg.sender == owner, "Only owner can add status");
        _;
    }

    function addStatus(
        bytes4 _id,
        bytes32 _name, 
    ) public isOwner {
        status.push(Status(_id, _name));    
    }

    function getStatusId(uint _n) public view returns(bytes4) {
        return status[_n].id;
    }

    function getStatusCount() public view returns(uint) {
        return status.length;
    }    
}