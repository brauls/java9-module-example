package de.brauls.example.j9modex.usermanagement.dto;

import java.util.Objects;
import java.util.Optional;

public class UserDto {
    private final String name;
    private final String mailAddress;

    public UserDto(final String name) {
        this.name = name;
        mailAddress = null;
    }

    public UserDto(final String name, final String mailAddress) {
        this.name = name;
        this.mailAddress = mailAddress;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getMailAddress() {
        return Optional.ofNullable(mailAddress);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserDto userDto = (UserDto) o;
        return name.equals(userDto.name) &&
               Objects.equals(mailAddress, userDto.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mailAddress);
    }

    @Override
    public String toString() {
        return "UserDto{" +
               "name='" + name + '\'' +
               ", mailAddress='" + mailAddress + '\'' +
               '}';
    }
}
