package me.hjhng125.granularity;

import java.util.List;
import me.hjhng125.association.Study;

public class Account {

    private Long id;

    // 객체는 User Defined Type을 자유롭게 사용할 수 있지만 relation에서는 추천하지 않음
    // 이러한 커스텀한 타입을 어떻게 매핑할 것인지 ORM이 해결해준다.
    Address address;

    List<Study> studyList;
}
