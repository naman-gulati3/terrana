package com.terrana;

import io.jsonwebtoken.Jwts.SIG;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@SpringBootTest
@Disabled
class TerranaApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void gen() {
    var key = SIG.HS512.key().build();
    System.out.println(DatatypeConverter.printHexBinary(key.getEncoded()));
    ;
  }

}
