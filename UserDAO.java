package nodejs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // INSERT
    public void insertUser(User user) {
        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getRollnumber());
            ps.setString(3, user.getBranch());
            ps.setInt(4, user.getMarks());

            ps.executeUpdate();
            System.out.println("Inserted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User(
                        rs.getString("Name"),
                        rs.getString("Rollnumber"),
                        rs.getString("Branch"),
                        rs.getInt("Marks")
                );
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    public void updateUser(User user) {
        String sql = "UPDATE Student SET Name=?, Branch=?, Marks=? WHERE Rollnumber=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getBranch());
            ps.setInt(3, user.getMarks());
            ps.setString(4, user.getRollnumber());

            ps.executeUpdate();
            System.out.println("Updated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteUser(String rollnumber) {
        String sql = "DELETE FROM Student WHERE Rollnumber=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, rollnumber);
            ps.executeUpdate();

            System.out.println("Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
