package ru.cloudinfosys.sm;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class App {
    @Value("${app.salt}")
    private String salt;

    public String getPassHash(String password) {
        return Hashing.sha256().hashString(password+salt, Charset.forName("UTF-8")).toString();
    }
}
