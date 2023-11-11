package com.brilloConnectionz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Objects;

import static com.brilloConnectionz.RegistrationImpl.createToken;
import static com.brilloConnectionz.RegistrationImpl.verifyJWT;
import static org.junit.jupiter.api.Assertions.*;
public class RegistrationImplTest {
    private static String jwtToken;
    private static final String username = "COLLINS";

    @BeforeAll
    public static void setUp(){
        jwtToken =  createToken(username);
    }
    @Test
    public void testValidToken() {
        String result = Objects.equals(verifyJWT(jwtToken), username)?"verification passed":"verification failed";
        assertEquals("verification passed", result);
    }
    @Test
    public void testInvalidToken(){
        String invalidJwtToken = jwtToken+"in";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            verifyJWT(invalidJwtToken);
        });

        String expectedException = "JWT signature does not match locally computed signature.";
        String actualException  = exception.getMessage();
        assertTrue(actualException.contains(expectedException));
    }

}