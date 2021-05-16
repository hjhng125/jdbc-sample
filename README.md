## JDBC 예제

Spring boot가 아닌 Maven 프로젝트로 만들어짐

간단히 jdbc에 대한 예제가 작성되어 있다.

사용 DB는 POSTGRESQL이다.
--------

##### DB 세팅
```
docker run -p 5432:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=hjhng -e POSTGRES_DB=springdata --name postgres -d postgres 
```

##### container 접속
```
docker exec -it postgres bash
```

##### postgres 접속
```
su - postgres
psql --username=hjhng --dbname=springdata
```

##### db list 조회
```
\l or \list
```

##### db table 조회
```
\dt
```

##### psql shell 종료
```
\q
```