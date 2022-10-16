package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String user;
    private String password;
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(int id, String user, String password, List<Role> roles) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.roles = roles;
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return id == user1.id && Objects.equals(user, user1.user) && Objects.equals(password, user1.password) && Objects.equals(roles, user1.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
