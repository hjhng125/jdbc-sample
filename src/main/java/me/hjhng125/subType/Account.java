package me.hjhng125.subType;

// relation에서 다형적인 성격을 띄는 다른 두테이블에 있는 키를 매핑할 수 없다.
// 이 문제또한 ORM이 지원해준다. 앞으로 알아볼 것.
public class Account {

    BillingAccount mainBillingAccount;
}
