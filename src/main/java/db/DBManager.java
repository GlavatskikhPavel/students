package db;

import constants.Constants;
import entity.Discipline;
import entity.Group;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public static final String ID = "id";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String ID_GROUP = "id_group";
    public static final String GROUP = "group";
    public static final String DATE = "date";
    public static final String DISCIPLINE = "discipline";

    public static List<Student> getAllActiveStudent() {
        List<Student> students = new ArrayList<>();
        try {
            //драйвер
            Class.forName("com.mysql.jdbc.Driver");
            //объект подключения
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //объект запроса
            Statement statement = connection.createStatement();
            //запрос
            ResultSet resultSet = statement.executeQuery("select s.id, s.surname, s.name, s.id_group, g.group, s.date  from student as s left join groupp as g on s.id_group = g.id where status = '1'");

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(ID));
                student.setSurname(resultSet.getString(SURNAME));
                student.setName(resultSet.getString(NAME));

                Group group = new Group();
                group.setId(resultSet.getInt(ID_GROUP));
                group.setGroup(resultSet.getString(GROUP));
                student.setGroup(group);

                student.setDate(resultSet.getDate(DATE));

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return students;
    }

    public static int getGroupId(String group) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            // получаем id той группы которую ввел нам пользователь
            ResultSet resultSet = statement.executeQuery("select id from groupp as g where g.group = '" + group + "'");

            // если есть id, заходим в этот цикл возвращаем id
            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }

            // если нет, создание группы
            statement.execute("insert into `groupp` (`group`) values ('" + group + "')");

            // получаем из БД максимальный id
            resultSet = statement.executeQuery("select id from groupp order by id desc limit 1;");

            // возвращаем id
            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return -1;
    }

    public static void deleteStudents(String[] ids) {
        // update `student` set `status` = '0' where id in ('1', '3', '6');
        // 1 3 6
        String stringIds = formIdsForQuery(ids);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("update `student` set `status` = '0' where id in (" + stringIds + ");");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Преобразование строк
    private static String formIdsForQuery(String[] ids) {
        StringBuilder result = new StringBuilder();
        for (String id : ids) {
            // ('1', '3', '6', ) а нужно ('1', '3', '6')
            result.append("'").append(id).append("', ");
        }
        // установить result текущею длину + -2
        result.setLength(result.length() - 2);
        // приводим к строке
        return result.toString();
    }

    public static void creatingStudent(String surname, String name, int groupId, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("insert into `student` (`surname`, `name`, `id_group`, `date`) values ('" + surname + "', '" + name + "', '" + groupId + "', '" + date + "')");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Student getStudentById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select s.id, s.surname, s.name, s.id_group, g.group, s.date  from student as s left join groupp as g on s.id_group = g.id where s.id = '" + id + "'");

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(ID));
                student.setSurname(resultSet.getString(SURNAME));
                student.setName(resultSet.getString(NAME));

                Group group = new Group();
                group.setId(resultSet.getInt(ID_GROUP));
                group.setGroup(resultSet.getString(GROUP));
                student.setGroup(group);

                student.setDate(resultSet.getDate(DATE));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void modifyStudent(String id, String surname, String name, int groupId, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("update `student` set `surname` = '" + surname + "', `name` = '" + name + "', `id_group` = '" + groupId + "', `date` = '" + date + "' where (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<Discipline> getAllActiveDiscipline() {
        List<Discipline> disciplines = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select d.id, d.discipline from discipline as d where status = '1';");

            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt(ID));
                discipline.setDiscipline(resultSet.getString(DISCIPLINE));

                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return disciplines;
    }

    public static void creatingDiscipline(String discipline) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("insert into `discipline` ( `discipline`) values ('" + discipline + "')");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void deleteDisciplines(String[] ids) {
        String stringIds = formIdsForQuery(ids);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("update `discipline` set `status` = '0' where id in (" + stringIds + ")");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Discipline getDisciplineById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select d.id, d.discipline from discipline as d where d.id = '" + id + "'");

            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt(ID));
                discipline.setDiscipline(resultSet.getString(DISCIPLINE));
                return discipline;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void modifyDiscipline(String id, String discipline) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            statement.execute("update `discipline` set `discipline` = '" + discipline + "' where (`id` = '" + id + "')");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean canLogin(String user, String password, String idRole) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user_role as ur\n" +
                    "left join user as u on ur.id_user = u.id\n" +
                    "where u.user = '" + user + "' and u.password = '" + password + "' and ur.id_role = " + idRole);

            while (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }
}
