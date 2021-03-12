package me.hjhng125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "hjhng125";
        String password = "pass";

        // try - with - resource는 try문에 선언한 리소스를 try가 종료될때 자동으로 해제해준다. (AutoCloseable을 구현한 객체에 한해)
        // try - catch - finally를 사용하면 생성된 리소스를 finally문에서 모두 수동으로 해제해주어야 했었다.
        try(Connection connection = DriverManager.getConnection(url, username, password)) { // 커넥션을 만드는 시간적 비용이 많이 드는 문제 - pool로 관리
            // spring boot 는 Hikari Pool을 사용한다.
            System.out.println("Connection created: " + connection);

            // sql이 표준이 있긴 하지만 DB마다 다르기 때문에 DB가 바뀌면 다시 sql을 만들어야 한다.
            String sql = "INSERT INTO ACCOUNT VALUES (1, 'hjhng125', 'pass')";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.execute();
            }
        } // 전체적으로 반복되는 코드가 많기에 리팩토링 필요
        //
    }
}
