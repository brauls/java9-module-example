package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.Objects;

public class UserEntity {
    private final String name;
    private final String mailAddress;

    public UserEntity(final String name) {
        this.name = name;
        mailAddress = null;
    }

    public UserEntity(final String name, final String mailAddress) {
        this.name = name;
        this.mailAddress = mailAddress;
    }

    public String getName() {
        return name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserEntity that = (UserEntity) o;
        return name.equals(that.name) &&
               mailAddress.equals(that.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mailAddress);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
               "name='" + name + '\'' +
               ", mailAddress='" + mailAddress + '\'' +
               '}';
    }
}
