package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UserDAO {

    private final ObjectMapper objectMapper;
    private final File file;

    public void save(User user) throws IOException {
            List<User> users =  objectMapper.readValue(file, new TypeReference<List<User>>() {
            });
            users.add(user);
            objectMapper.writeValue(file,users);
    }
    public List<User> findAll() throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
    }
}
