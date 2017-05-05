package database;

import java.sql.*;

/**
 * Created by simon on 5/4/17.
 */
public class SQLFunctions {
    private String url = "jdbc:mysql://ubuntu4.javabog.dk:53999/ludustempus?useSSL=false";
    private String SQLusername = "root";
    private String SQLpassword = "root";

    public void createUser(String StudieNr, String userName, String SkypeAccount, String DiscordAccount, String SummonerName, int LolmainRole, int LolOffRole) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO Users (StudieNr,Username,SkypeAccount,DiscordAccount,LolSummonerName,LolMainRole,LolOffRole) VALUES " +
                    "('" + StudieNr + "','" + userName + "','" + SkypeAccount + "','" + DiscordAccount + "','" + SummonerName + "'," + LolmainRole + "," + LolOffRole + ");";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserName(String StudieNr) {
        String s = null;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT Username FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getSkypeAccount(String StudieNr) {
        String s = null;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT SkypeAccount FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getDiscordAccount(String StudieNr) {
        String s = null;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT DiscordAccount FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getSummonerName(String StudieNr) {
        String s = null;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT LolSummonerName FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public int getLolMainRole(String StudieNr) {
        int s = 0;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT LolMainRole FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public int getLolOffRole(String StudieNr) {
        int s = 0;
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "SELECT LolOffRole FROM Users WHERE StudieNr ='" + StudieNr + "';";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                s = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void setUsername(String StudieNr, String username) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET Username = '" + username + "'" + "WHERE StudieNr ='" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSkypeAccount(String StudieNr, String skypeAccount) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET SkypeAccount = '" + skypeAccount + "'" + "WHERE StudieNr ='" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDiscordAccount(String StudieNr, String discordAccount) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET DiscordAccount = '" + discordAccount + "'" + "WHERE StudieNr ='" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLolSummonerName(String StudieNr, String summonerName) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET LolSummonerName = '" + summonerName + "'" + "WHERE StudieNr ='" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLolMainRole(String StudieNr, int role) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET LolMainRole = " + role + " WHERE StudieNr =" + "'" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLolOffRole(String StudieNr, int role) {
        try {
            Connection connection = DriverManager.getConnection(url, SQLusername, SQLpassword);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Users " +
                    "SET LolOffRole= " + role + " WHERE StudieNr =" + "'" + StudieNr + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
