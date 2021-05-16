package me.hjhng125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExerciseJDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "hjhng";
        String password = "pass";

        // try - with - resource는 try문에 선언한 리소스를 try가 종료될때 자동으로 해제해준다. (AutoCloseable을 구현한 객체에 한해)
        // try - catch - finally를 사용하면 생성된 리소스를 finally문에서 모두 수동으로 해제해주어야 했었다.
        // Connection은 매번 만들면 안되고 pool로 관리해야한다. ex) Hikari DBCP
            // 커넥션을 미리 만들어 두고 필요할때마다 꺼내 사용한 후 다 사용하면 반납한다.
            // 미리 만들어두기에 런타임 시 생성하는 비용은 들지 않음.
        try (Connection connection = DriverManager.getConnection(url, username, password)) { // 커넥션을 만드는 시간적 비용이 많이 드는 문제 - pool로 관리
            // spring boot 는 Hikari Pool을 사용한다.
            System.out.println("Connection created: " + connection);

            // 초기 테이블 생성 한번 실행하고나면 사용하지 않음
//            String ddl = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255))";
//            try(PreparedStatement statement = connection.prepareStatement(ddl)) {
//                statement.execute();
//            }
            // sql이 표준이 있긴 하지만 DB마다 다르기 때문에 DB가 바뀌면 다시 sql을 만들어야 한다.
            String dml = "INSERT INTO ACCOUNT VALUES (1, 'hjhng125', 'pass')";

            try (PreparedStatement preparedStatement = connection.prepareStatement(dml)) {
                preparedStatement.execute();
            }
        } // 전체적으로 반복되는 코드가 많기에 리팩토링 필요
        //
    }
}
