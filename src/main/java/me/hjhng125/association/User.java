package me.hjhng125.association;

import java.util.List;

public class User {

    // 객체는 아래와 같이 다대다 관계를 정의할 수 있지만 relation에서는 다대다 관계를 표현하지 못한다.
    // ORM은 @ManyToMany annotation을 통해 다대다 관계를 매핑해준다.
    private List<Study> myStudy;

    public List<Study> getMyStudy() {
        return myStudy;
    }

    public void setMyStudy(List<Study> myStudy) {
        this.myStudy = myStudy;
    }
}
