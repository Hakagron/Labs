
interface QueryBuilder {
    QueryBuilder select(String... columns);
    QueryBuilder where(String condition);
    QueryBuilder limit(int limit);
    String getSQL();
}

class PostgreSQLQueryBuilder implements QueryBuilder {
    private StringBuilder query;

    public PostgreSQLQueryBuilder() {
        query = new StringBuilder();
    }

    @Override
    public QueryBuilder select(String... columns) {
        query.append("SELECT ");
        if (columns.length == 0) {
            query.append("*");
        } else {
            query.append(String.join(", ", columns));
        }
        return this;
    }

    @Override
    public QueryBuilder where(String condition) {
        query.append(" WHERE ").append(condition);
        return this;
    }

    @Override
    public QueryBuilder limit(int limit) {
        query.append(" LIMIT ").append(limit);
        return this;
    }

    @Override
    public String getSQL() {
        return query.toString();
    }
}

class MySQLQueryBuilder implements QueryBuilder {
    private StringBuilder query;

    public MySQLQueryBuilder() {
        query = new StringBuilder();
    }

    @Override
    public QueryBuilder select(String... columns) {
        query.append("SELECT ");
        if (columns.length == 0) {
            query.append("*");
        } else {
            query.append(String.join(", ", columns));
        }
        return this;
    }

    @Override
    public QueryBuilder where(String condition) {
        query.append(" WHERE ").append(condition);
        return this;
    }

    @Override
    public QueryBuilder limit(int limit) {
        query.append(" LIMIT ").append(limit);
        return this;
    }

    @Override
    public String getSQL() {
        return query.toString();
    }
}

class Main {
    public static void main(String[] args) {
        QueryBuilder postgresBuilder = new PostgreSQLQueryBuilder();
        String postgresQuery = postgresBuilder
                .select("id", "name", "email")
                .where("age > 18")
                .limit(10)
                .getSQL();
        System.out.println("PostgreSQL Query: " + postgresQuery);

        QueryBuilder mysqlBuilder = new MySQLQueryBuilder();
        String mysqlQuery = mysqlBuilder
                .select("id", "name", "email")
                .where("age > 18")
                .limit(10)
                .getSQL();
        System.out.println("MySQL Query: " + mysqlQuery);
    }
}