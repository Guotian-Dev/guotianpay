pragma solidity ^0.4.18;


import "../token/ERC20/StandardToken.sol";


/**
 * @title GPayCoin G支付积分合约，
 * 合约内容：
 * 发行方：G支付互联网科技有限公司
 * 积分名称： GPayCoin
 * 发行总量： 2100 0000
 * 积分单位： GPC
 * 最小流通单位： 0.0001GPC
 * RMB兑换：1RMB = 1GPC
 *
 * Features:
 * 1、采用基于以太坊ERC20标准
 * 2、G支付积分，应用于G支付项目内部点对点转账、消费、投资、理财、服务等业务与黄金珠宝产业支付、结算。
 * 3、采用区块链分布式账本，信息公开透明、可追根溯源、不可篡改，具有信用的积分。
 * @dev Very simple ERC20 Token example, where all tokens are pre-assigned to the creator.
 * Note they can later distribute these tokens as they wish using `transfer` and other
 * `StandardToken` functions.
 */
contract GPayCoin is StandardToken {

  string public constant name = "GPayCoin"; // solium-disable-line uppercase
  string public constant symbol = "GPC"; // solium-disable-line uppercase
  uint8 public constant decimals = 4; // solium-disable-line uppercase

  uint256 public constant INITIAL_SUPPLY = 21000000 * (10 ** uint256(decimals));

  /**
  *  构造函数
   * @dev Constructor that gives msg.sender all of existing tokens.
   */
  function GPayCoin() public {
    totalSupply_ = INITIAL_SUPPLY;
    balances[msg.sender] = INITIAL_SUPPLY;
    Transfer(0x0, msg.sender, INITIAL_SUPPLY);
  }

}
