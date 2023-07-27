package ru.agilix.workshop.legacy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class DeliveryController {

    @GetMapping("/delivery/{clientType}/{cartAmount}/")
    public Integer calculate(@PathVariable("clientType") String clientType,
                             @PathVariable("cartAmount") Integer cartAmount) throws Exception {

        String sqlQuery = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
                "where t.id = c.type and t.type_name = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DataSource d = OracleDataSource.create("admin", "p1ssword", "ORCL_PROD_DB1");
            connection = d.getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, clientType);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int b = resultSet.getInt(0);
                int p = resultSet.getInt(1);
                switch (clientType) {
                    case "VIP":
                        return cartAmount >= b ? Double.valueOf(cartAmount * (1 - p / 100.0)).intValue() : cartAmount;
                    case "Обычный":
                        return cartAmount >= 1000 ? cartAmount : cartAmount + 250;
                    case "Friends&Family":
                        return Double.valueOf(cartAmount * (1 - 2 / 100.0)).intValue();
                    default:
                        throw new Exception("Client type is not found: " + clientType);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignore) {
                //ignore.printStackTrace();
            }
        }

        return 0;
    }

    private static ResultSet openDbConnection(
            String user,
            String password,
            String instance,
            String clientType
    ) throws SQLException {
        String sqlQuery = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
                "where t.id = c.type and t.type_name = ?";

        DataSource d = OracleDataSource.create(user, password, instance);
        Connection connection = d.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, clientType);

        return preparedStatement.executeQuery();
    }

    private static void closeDbConnection(
            Connection connection,
            PreparedStatement preparedStatement,
            ResultSet resultSet
    ) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (preparedStatement != null) preparedStatement.close();
        if (connection != null) connection.close();
    }
}
